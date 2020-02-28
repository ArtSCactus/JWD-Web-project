/**
 * @author ArtSCactus
 */
function updateSpecialtiesBlock() {
    var checkBoxStatus = document.querySelector('input[type=checkbox]');
    if (checkBoxStatus.checked) {
        var specialtiesArray = document.getElementsByClassName("specialty-item");
        for (var index = 0; index < specialtiesArray.length; index++) {
            if(specialtiesArray[index].id!=0) {
                $(specialtiesArray[index]).show(400);
                $(specialtiesArray[index]).fadeIn(400);
            } else {
                $(specialtiesArray[index]).hide(400);
                $(specialtiesArray[index]).fadeOut(400);
            }
        }
    } else {
        var specialtiesArray = document.getElementsByClassName("specialty-item");
        for (var index = 0; index < specialtiesArray.length; index++){
            $(specialtiesArray[index]).show(400);
            $(specialtiesArray[index]).animate({opacity: 1}, 200);
        }
    }
};

$(function () {
    $('.apply-btn').click(function () {
        var admissionId = $(this).parent('form').parent('div').attr('id');
        if (admissionId == 0){
            $('.popup').show(500, function () {
                setTimeout(function () {
                    $('.popup').hide(500)
                }, 5000);
            });
            return false;
        }
    });
});

var array = $('.specialty_item_title').map(function(){
    return $.trim($(this).text());
}).get();
$('.search-input-field').autocomplete({source:array, messages:{

    }});

$('.find-btn').click(function () {
    var checkBoxStatus = document.querySelector('input[type=checkbox]');
    if (checkBoxStatus.checked){
        updateSpecialtiesBlock();
    } else {
        var targetName = $('.search-input-field').val();
        var specialtiesTitles = $('.specialty_item_title').toArray();
        for (var index=0; index<specialtiesTitles.length; index++){
            if (specialtiesTitles[index].textContent === targetName){
                // Scroll
                $('html,body').animate({
                        scrollTop: $(specialtiesTitles[index]).offset().top - $(this).height() / 2},
                    'slow');
                
            }
        }
    }
});


