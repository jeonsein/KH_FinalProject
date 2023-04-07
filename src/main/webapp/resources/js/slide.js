// 배너 slick js

$(document).ready(function(){// 'html문서가 준비되면 할 일' 이라는 의미임 !
  $('.slides').slick({
      //slick에서 제공하는 화살표 끄기
      arrows:false,

      centerMode: true,
      centerPadding: '60px',
      slidesToShow: 3,
      // autoplay        
      slidesToScroll: 1,
      autoplay: true,
      autoplaySpeed: 2000,

      responsive: [
          {
          breakpoint: 768,
          settings: {
              arrows: false,
              centerMode: true,
              centerPadding: '40px',
              slidesToShow: 3
          }
          },
          {
          breakpoint: 480,
          settings: {
              arrows: false,
              centerMode: true,
              centerPadding: '40px',
              slidesToShow: 1
          }
          }
      ]
  });

    // Manually refresh positioning of slick
    //화살표를 눌렀을 때 이전, 다음으로 넘어가게!!
    // 제이쿼리에서 요소를 선택할 때는-> $(css선택자)
    // 여기서 선택한거에 click이라는 이벤트를 연결함
    // -> 이 이벤트가 생기면 할 일을 function에 집어넣음
  $('.prev-btn').click(function(){
    $('.slides').slick('slickPrev');
  });

  $('.pause-btn').click(function(){
    $('.slides').slick('slickPause');
  });

  $('.play-btn').click(function(){
    $('.slides').slick('slickPlay');
  });

  $('.next-btn').click(function(){
    $('.slides').slick('slickNext');
  });

});