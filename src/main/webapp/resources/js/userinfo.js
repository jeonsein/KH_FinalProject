//상단 nav 메뉴 고정

$(document).ready(function(){
    var menuOffset = $('.menu').offset();
    $(window).scroll(function(){
      if($(document).scrollTop() > menuOffset.top){
        $('.menu').addClass('fixedmenu');
      } else{
        $('.menu').removeClass('fixedmenu');
      }
    });
  });
  