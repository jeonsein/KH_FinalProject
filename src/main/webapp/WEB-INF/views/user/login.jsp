<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MOYAMOGA</title>

    <link rel="stylesheet" href="/resources/css/Login_Main.css">

    <link rel="shortcut icon" href="/resources/ico/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/resources/ico/favicon.ico" type="image/x-icon">

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" /> -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,0,-25" /> -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>

    <!-- slick: cdn 방식으로 css, js 가져오기 -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>			
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    
    <!-- js가 위 jquery, slick script코드 보다 위에 나오면 적용이 안됨 -->
    <script src="/resources//js/main1.js"></script>

</head>

<body>
    <header>    
            <ul class="container2">
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
                <li><a href="#">장바구니</a></li>
            </ul>

            <div class="container3">
                <a href="main1.html"><img id="logo" src="/resources//imgs/logo.png" alt="로고"></a>
            <!-- action에는 jsp 파일인듯?/ GET방식 /  -->
                <form class="search1" action="#" method="GET">
                    <input class="search-txt" type="text" placeholder=" 검색어를 입력해주세요!">    
                    <button class="search-btn" type="submit"><img id="btn" src="/resources//imgs/search.png" alt="메인검색버튼"></button>
                    <!-- <input type="submit" value="fab fa-sistrix"></input> -->
                    <!-- <button type="button" class="btm_image" id="img_btn"><img  src="이미지경로"></button> -->
                </form>    
            </div>
    </header>

    <nav> 
        <div class="menu">
            <ul class="container4">
                <!-- <div class="dropdown"> -->

                <li><a href="#"><i class="fas fa-bars"> 전체 카테고리</i></a>
                    <div class="dropdown-content">
                        <ul>
                            <li>
                                <!-- 마우스 가져다 댔을 떄 strong -->
                                <strong><a href="#">농산 &nbsp &nbsp &nbsp &nbsp &nbsp > </a></strong>
                                <div class="dropdown-content2">
                                    <ul>
                                        <li><a href="#">전체보기</a></li>
                                        <li><a href="#">오늘과일채소</a></li>
                                        <li><a href="#">국내외과일</a></li>
                                        <li><a href="#">친환경유기농채소</a></li>
                                        <li><a href="#">우리땅채소</a></li>
                                        <li><a href="#">채소/샐러드</a></li>  
                                        <li><a href="#">주곡/잡곡</a></li> 
                                    </ul>
                                </div>
                            </li>
                        </ul>    
                    </div>

                </li>
                <!-- </div> -->
                
                <li><a href="#">오늘의 특가</a></li>
                <li><a href="#">신상품</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </div>
    </nav>

    <!-- ---------------------------------------------------------------------------- -->
    <main>

        <div class="login_wrapper">

            <form action="/login" id="login_form" method="post">
                <div class="login_title">로그인</div>

                <!-- 아이디 입력창 -->
                <div class="id_class">
                    <label for="userId"></label>
                    <input id="userId" type="text" name="MEMBER_ID" placeholder="아이디" required>
                </div>

                <!-- 비밀번호 입력창 -->
                <div class="password_class">
                    <label for="password"></label>
                    <input id="password" type="password" name="MEMBER_PW" placeholder="비밀번호" required>
                </div>

                <!-- 아이디 저장, 자동 로그인, 아이디 찾기, 비밀번호 찾기 -->
                <div class="login_box">

                    <!-- 아이디 저장 체크박스 -->
                    <div class="rememberId">
                        <input type="checkbox" id="rememberId" name="rememberId" value="off">
                        <label for="rememberId2">아이디 저장</label>
                    </div>

                    <!-- 자동 로그인 체크박스 -->
                    <div class="autoLogin">
                        <input type="checkbox" id="autoLogin" name="autoLogin" value="off">
                        <label for="autoLogin2">자동 로그인</label>
                    </div>
                    
                    <!-- 아이디 비밀번호 찾기 -->
                    <span class="finding">
                        <li>
                            <a href="#" class="find_id">아이디 찾기</a><span>|</span> <a href="#" class="find_pw">비밀번호 찾기</a>
                        </li>
                    </span>

                </div>

                <div class="signIn"> <!-- 로그인 버튼 -->
                    <button type="button" id="signInButton">로그인</button>
                </div>
        
                <div class="naverLogin"> <!-- 네이버로 로그인 -->
                    <button type="button" id="naverLoginButton">
                        <img src="/resources//imgs/btnG_완성형.png" class="nimg"></button>
                </div>

                <div class="kakaoLogin"> <!-- 카카오로 로그인 -->
                    <button type="button" id="kakaoLoginButton">
                        <img src="/resources//imgs/kakao_login_large_narrow.png" class="kimg"></button>
                </div>
        
            </div>
        </form>
    </main>

<!-- -------------------------------------------------------- -->

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