<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MOYAMOGA</title>
    
    <!-- include favicon -->
    <%@include file="/WEB-INF/views/common/favicon.jsp" %>

    <link rel="stylesheet" href="/resources/css/main.css">

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>

    <!-- slick: cdn 방식으로 css, js 가져오기 -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    
    <!-- js가 위 jquery, slick코드 보다 위에 나오면 적용이 안됨 -->
    <script src="/resources/js/main.js"></script>

</head>

<body>

    <div class="topBanner">
        <div class="topbox">
            <div class="topcontent">
                    모두의 야채, 모두의 과일<br>
                    싱싱한 농산물을 합리적인 가격에 제공하는 직거래 유통 마켓
            </div>
            <button type="button" class="topBannerBtn">X</button>
        </div>
    </div>

    <header>    
            <ul class="container2">
            
            	<!--로그인 x--><!--로그인 성공하면 세션에 사용자 정보를 저장하는 model상자의 이름 뭐지? 우선 member로 기재-->
                <c:if test = "${member == null}">
                    <li><a href="/login">로그인</a></li>
                    <li><a href="/signup/main">회원가입</a></li>
                    <li><a href="/cart">장바구니</a></li>
                    <!-- <li><a href="/cart/${member.member_id}">장바구니</a></li> -->
                </c:if> 
                
                <!--로그인 O -->
                <c:if test = "${member != null}">

                        <!-- 관리자 계정 -->
                        <c:if test="${member.adminCk = 1}">
                            <li><a href="/admin/main">관리자 페이지</a></li>
                        </c:if> 
                        
               		<li>${member.name}님 환영합니다.</li>
                    <!-- <li><a href="/logout">로그아웃</a></li> -->
                    <!-- => 비동기 방식 로그아웃으로 변경 -->
                    <li><a id="logout_button">로그아웃</a></li>
                    <li><a href="/mypage">마이페이지</a></li>
                    <li><a href="/cart">장바구니</a></li>
                    
                    <!-- 로그인이 되야 아래가 적용될듯? -->
                    <!-- <li><a href="/cart/${member.member_id}">장바구니</a></li> -->
                    
                </c:if>       
            </ul>

            <div class="container3">
                <a href="/main"><img id="logo" src="/resources/imgs/logo.png" alt="로고"></a>
            <!-- action에는 jsp 파일인듯?/ GET방식 /  -->
                <form class="search1" action="#" method="GET">
                    <input class="search-txt" type="text" placeholder=" 검색어를 입력해주세요!">    
                    <button class="search-btn" type="submit"><img id="btn" src="/resources/imgs/search.png" alt="메인검색버튼"></button>
                    <!-- <input type="submit" value="fab fa-sistrix"></input> -->
                    <!-- <button type="button" class="btm_image" id="img_btn"><img  src="이미지경로"></button> -->
                </form>    
            </div>
    </header>

    <nav> 
        <div class="menu">
            <ul class="container4">
                <li><a href="#"><i class="fas fa-bars"> 전체 카테고리</i></a>
                    <ul class="menu2">
                        <li><a href="#">농산 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; > </a>
                            <ul class="menu3">
                                <li><a href="#">전체보기</a></li>
                                <li><a href="#">오늘과일채소</a></li>
                                <li><a href="#">국내외과일</a></li>
                                <li><a href="#">친환경유기농채소</a></li>
                                <li><a href="#">우리땅채소</a></li>
                                <li><a href="#">채소/샐러드</a></li>
                                <li><a href="#">주곡/잡곡</a></li>
                                <li><a href="#">오늘의 특가</a></li>
                                <li><a href="#">신상품</a></li>
                            </ul>
                        </li>
                    </ul>
                <li><a href="#">오늘의 특가</a></li>
                <li><a href="#">신상품</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </div>
    </nav>

    <main>
        <!-- 메인 배너 이미지 -->
        <section class="slideShow">
            <div class="slides">
                <div class="banner-img"><img src="/resources/imgs/banner1.png" alt="배너1"></div>
                <div class="banner-img"><img src="/resources/imgs/banner2.png" alt="배너2"></div>
                <div class="banner-img"><img src="/resources/imgs/banner3.png" alt="배너3"></div>
                <div class="banner-img"><img src="/resources/imgs/banner4.png" alt="배너4"></div>
                <div class="banner-img"><img src="/resources/imgs/banner5.png" alt="배너5"></div>
                <div class="banner-img"><img src="/resources/imgs/banner6.png" alt="배너6"></div>
                <div class="banner-img"><img src="/resources/imgs/banner7.png" alt="배너7"></div>
                <div class="banner-img"><img src="/resources/imgs/banner8.png" alt="배너8"></div>
                <div class="banner-img"><img src="/resources/imgs/banner9.png" alt="배너9"></div>
                <div class="banner-img"><img src="/resources/imgs/banner10.png" alt="배너10"></div>
            </div>
    
            <div class="banner-btn">
                <div class="btnradius">
                    <span class="material-symbols-outlined prev-btn">
                        chevron_left
                    </span>
                    <span class="material-symbols-outlined pause-btn">
                        pause
                    </span>
                    <span class="material-symbols-outlined play-btn">
                        resume
                    </span>
                    <span class="material-symbols-outlined next-btn">
                        chevron_right
                    </span>
                </div>
            </div>
        </section>

            <div class="minibanner1">
                <a href="#">
                    <img src="/resources/imgs/minibanner.png" alt="미니배너">
                </a>
            </div>

        <div class="minititle">오늘의 특가</div>
        <div class="container5">
            <div class="thumbnail">
                <a href="#"><img src="imgs/tangerine.jpg" alt="특가1"></a>
                <a href="#">[금주의 특가] 유어스펙 귤이네 귤</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
                
            </div>
            <div class="thumbnail">
                <a href="#"><img src="imgs/spinach.jpg" alt="특가2"></a>
                <a href="#">[금주의 특가] 찬돌이네 시금치</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
            <div class="thumbnail">
                <a href="#"><img src="imgs/tomato.jpg" alt="특가3"></a>
                <a href="#">[금주의 특가] 유기농 토마토</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
            <div class="thumbnail">
                <a href="#"><img src="imgs/green_bean.jpg" alt="특가4"></a>
                <a href="#">[금주의 특가] 갓 수확한 그린빈</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
        </div>


        <div class="minititle">모야모과의 레시피</div>
        <div class="recipe">
            <img src="/resources/imgs/recipe_potato.png" alt="레시피1">
            <div class="recipe2">
                <span><u><i>MOYAMOGA's Recipe</i></u></span><br>
                <span><i>에어프라이어로 버터 감자구이 만들기</i></span><br>
                <br>
                <span><i>STEPS</i></span><br>
                1. 감자는 껍질채 씻어 준비합니다 <br>
                2. 취향껏 자른 뒤 녹인 버터를 속까지 바르고 <br>
                3. 허브솔트를 알맞게 뿌리고 <br>
                4. 에어프라이어에 넣고 200도 온도에서 20분간 구워요 <br>
                5. 노릇노릇하니 잘 구워진 감자~ <br>
                6. 껍질째 먹어도 맛있어요! <br>
                <br>
                <a href="https://www.10000recipe.com/recipe/6961911"><i> 레시피 자세히 보기 &nbsp;&nbsp; > </i></a>
            </div>    
        </div>

        <div class="minititle">신상품</div>
        <div class="container6">
            <div class="thumbnail">
                <a href="#"><img src="imgs/kiwi.jpg" alt="신상품1"></a>
                <a href="#">[금주의 신상품] 제주 참다래 키위</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
            <div class="thumbnail">
                <a href="#"><img src="imgs/potato.jpg" alt="신상품2"></a>
                <a href="#">[금주의 신상품] 맛있는 햇감자</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
            <div class="thumbnail">
                <a href="#"><img src="imgs/rice.jpg" alt="신상품3"></a>
                <a href="#">[금주의 신상품] 올해 수확한 햅쌀</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
            <div class="thumbnail">
                <a href="#"><img src="imgs/onion.jpg" alt="신상품4"></a>
                <a href="#">[금주의 신상품] 튼실한 양파</a>
                <span><span class="dis_Green">28%</span>&nbsp; 12,600원</span>
            </div>
        </div>
    </main>

    <aside>
        <div class="container7">
            <div id="choikun1">
                <div id="choikun2">
                    <div>최근 본 상품</div>
                        <img src="imgs/sample.jpg" alt="최근1">
                        <img src="imgs/sample.jpg" alt="최근2">
                        <img src="imgs/sample.jpg" alt="최근3">
                </div>    
                <input id="topbtn" type="button" name="TOP" value="TOP">
            </div> 
        </div>
    </aside>

    <footer>
        <div class="yakgwan1">
            <div class="yakgwan2">
                <li><a href="#">고객센터</a></li>
                <li><a href="#">약관 및 정책</a></li>
                <li><a id="gaein" href="#">개인정보 취급방침</a></li>
            </div>
        </div>

        <div class="bottom1">
            <div class="bottom2">
                <div id="com_address">
                    <p id="jusik">(주)모야모과</p>
                    <p class="gray">강남지원 1관 : 서울특별시 강남구 테헤란로14길 6 남도빌딩<br>
                        상호: 주식회사 모야모과 대표자:요셉킴 사업자등록번호: 123-45-67891<br>
                        통신판매업신고번호: 제2023-서울강남-0208</p>
                    <p></p>
                    <p class="gray">Copyright ⓒ MOYAMOGA Corp. All Rights Reserved.</p>
                </div>
                <div id="custom_notice">
                    <p id="gogaek">고객센터 <span id="phnum">1588-1234</span></p>
                    <p></p>
                    <p class="gray">평일 07:00~18:00 / 토, 일요일 09:00~12:00<br>
                        점심시간 12:00~13:00</p>
                    <a href="#">고객센터 바로가기 ></a>
                </div>
            </div>
        </div>
    </footer>
</body>

</html>