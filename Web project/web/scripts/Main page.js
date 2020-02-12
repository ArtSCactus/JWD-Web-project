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
                $(specialtiesArray[index]).animate({opacity: 1}, 400);
            } else {
                $(specialtiesArray[index]).hide(400);
                $(specialtiesArray[index]).animate({opacity: 0});
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

