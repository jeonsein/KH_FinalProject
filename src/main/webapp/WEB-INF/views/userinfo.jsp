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

    <link rel="stylesheet" href="css/userInfo.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>

    <script src="js/userInfo.js"></script>
</head>
<body>
    <header>    
            <ul class="container2">
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
                <li><a href="#">장바구니</a></li>
            </ul>

            <div class="container3">
                <a href="main1.html"><img id="logo" src="imgs/logo.png" alt="로고"></a>
            <!-- action에는 jsp 파일인듯?/ GET방식 /  -->
                <form class="search1" action="#" method="GET">
                    <input class="search-txt" type="text" placeholder=" 검색어를 입력해주세요!">    
                    <button class="search-btn" type="submit"><img id="btn" src="imgs/search.png" alt="메인검색버튼"></button>
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

<!-- --------------위에는 헤더----------- -->

<main>
    <aside>
        <ul class="box1">
            <img src="imgs/profileimg.jpg" alt="프로필 사진">
            <li class="small1"><a href="#">'최귤이'님</a></li>
            <li class="small1"><a href="#"><i class="fab fa-whmcs"></i>
           회원정보관리</a></li>
        </ul>

        <ul class="box2">
            <li class="small2 small3"><a href="#">정보수정</a></li>
            <li class="small2 small3"><a href="#">주문내역</a></li>
            <li class="small2"><a href="#">배송현황</a></li>
        </ul>
    </aside>
    
    <div class="huiwon">
        <div class="sujeong1">
            <h2 id="sujeong2">회원정보수정</h2>
            <h6 id="sujeong3"><span class="red">*</span>필수 입력</h6>
        </div>
        <table>
            <tr>
                <th>&nbsp;아이디</th>
                <td>dhcksehf</td>
            </tr>
            <tr>
                <th>&nbsp;현재 비밀번호</th>
                <td><input type="text"></td>
                <td class="sletter">&nbsp;*비밀번호를 입력해 주세요.</td>
            </tr>
            <tr>
                <th>&nbsp;신규 비밀번호<span class="red">*</span></th>
                <td><input type="text"></td>
                <td class="sletter" colspan="2">&nbsp;*영문, 숫자 조합 6~15자리로 비밀번호를 입력해주세요.</td>
            </tr>
            <tr>
                <th>&nbsp;신규 비밀번호 확인<span class="red">*</span></th>
                <td><input type="text"></td>
                <td class="sletter" colspan="2">&nbsp;*비밀번호 확인을 위해 한 번 더 입력해 주세요.</td>
            </tr>
            <tr>
                <th>&nbsp;성명<span class="red">*</span></th>
                <td><input type="text"></td>
            </tr>
            <tr class="specialtr">
                <th class="th_height" rowspan="2">&nbsp;휴대전화<span class="red">*</span></th>
                <td><input type="text"></td>
                <td><input type="button" value="휴대폰 인증" class="btntr">&nbsp;<input type="button" value="재발송" class="btntr"></td>
            </tr>
            <tr>
                <td><input type="text"></td>
                <td><input type="button" value="확인" class="btntr"></td>
            </tr>
            <tr class="specialtr">
                <th class="th_height" rowspan="2">&nbsp;주소<span class="red">*</span></th>
                <td><input type="text" class="addrtr"></td>
                <td><input type="button" value="우편번호 찾기" class="btntr"></td>
            </tr>
            <tr>
                <td><input type="text" class="addrtr"></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <th>&nbsp;이메일<span class="red">*</span></th>
                <td><input type="text"></td>
            </tr>
            <tr>
                <!-- 성별 변경 불가능 -->
                <th><form action="#" method="get">&nbsp;성별</form></th>
                <td class="radio">
                    <input type="radio" name="성별" value="남자">남자&nbsp;
                    <input type="radio" name="성별" value="여자">여자&nbsp;
                    <input type="radio" name="성별" value="선택안함" checked>선택안함
                </td>
                </form>
            </tr>
            <tr>
                <!-- 생년월일 변경 불가능 -->
                <th>&nbsp;생년원일</th>
                <td>YYYY/MM/DD</td>
            </tr>
        </table>

        <div class="btnset">
            <input class="userbtn1" type="button" value="정보수정">
            <input class="userbtn2" type="button" value="메인으로">
            <input class="userbtn2" type="button" value="회원탈퇴">
        </div>    
    </div>    
</main>

    <!-- ---------------footer---------------- -->
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