$('.close-btn').click(function(){
    $('menu').toggle(1000);
    $('.open-btn').toggle(1000);
    $('.main-content').animate({marginLeft: '0%'}, 1000);
    $('.university-title').animate({marginLeft: '5%'}, 1000);
});

$('.open-btn').click(function(){
    $('menu').toggle(1000);
    $('.open-btn').toggle(1000);
    $('.main-content').animate({marginLeft: '25%'}, 1000);
    $('.university-title').animate({marginLeft: '25%'}, 1000);
});


