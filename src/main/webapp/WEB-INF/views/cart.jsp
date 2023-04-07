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
    
    <link rel="stylesheet" href="/resources/css/cart.css">
 	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    
    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
    
    <script src="/resources/js/cart.js"></script>
</head>
<body>
    <!-- ======================== Header ========================== -->
    <header class="header">
        <ul class="container2">
            <li><a href="#">로그인</a></li>
            <li><a href="#">회원가입</a></li>
            <li><a href="#">장바구니</a></li>
        </ul>

        <!-- 검색창 -->
        <div class="container3">
            <img id="logo" src="imgs/logo.png" alt="로고">

            <input type="text" value="검색어를 입력해주세요"></input>
        </div>
    </header>

    <nav class="nav">
        <div id="menu">
            <ul class="container4">
                <li><a href="#">전체 카테고리</a></li>
                <li><a href="#">오늘의 특가</a></li>
                <li><a href="#">신상품</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </div>
    </nav>
<!-- ======================== Main ========================== -->
<main>
    <div class="out_wapper">
        <div class="basket">
            <p><strong>장바구니</strong></p>
                <div class="input">
                    <p class="StandardDelivery">일반배송</p>
                    <hr class="up_hr">
                    <!-- 전체선택 뒤에 (1/4)를 내가 박아놨는데 장바구니에 담기는 수량대로 변경되게끔 해야함. -->
                    <label for="check_btn"><input type="checkbox" id="check_all" onclick="selectAllCheckboxes()" class="checkboxAll"/> 전체선택(1/4)</label>  
                    <a href="#" class="Delete" id="Delete_selected" onclick="deleteSelectedProducts()">선택삭제</a>
                    <hr class="down_hr">
                    
                    <!-- 상품 1 -->
                    <div class="product">
                        <input type="checkbox" id="check_btn1" value="1" class="checkbox"/>
                        <!-- 링크 필요 -->
                        <a href="#" class="prodcut_name">상품명 : 감자</a>    
                        <!-- 이미지 입력 필요 -->
                            <div class="product_img">
                                <img src="https://picsum.photos/id/598/110/110" class="product_img1">
                            </div>
                    <!-- 상품 추가 될때마다 onclick에 숫자 & id=result 숫자 & Delete 숫자를 변경해줘야함.(Delete는 정확하지않음...) -->        
                        <div class="num">
                            <div class="button_all">
                                <input type='button' onclick='count("plus",1)' value='+' class="button_plus"/>
                                <div id='result1'>1</div>
                                <input type='button' onclick='count("minus",1)' value='-' class="button_minus"/>
                            </div>
                            <div class="DisCountAndPrice">
                                <p class="DisCount">할인율</p>
                                <p class="price">상품가격</p>
                                <!-- X 버튼 클릭시 삭제가 안됨...ㅠ.ㅠ 모르겠음.. 왜그러는지... 하지만, 체크박스 선택 삭제는 가능 -->
                                <a href="#" class="Delete_1" id="Delete_1" onclick="removeProduct(1)">X</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <!-- 상품 2 -->
                    <div class="product">
                        <input type="checkbox" id="check_btn1" value="1" class="checkbox"/>
                        <a href="#" class="prodcut_name">상품명 : 고구마</a>    
                            <div class="product_img">
                                <img src="https://picsum.photos/id/598/110/110" class="product_img1">
                                
                            </div>
                    <!-- 상품 추가 될때마다 onclick에 숫자 & id=result 숫자 & Delete 숫자를 변경해줘야함. -->        
                        <div class="num">
                            <div class="button_all">
                                <input type='button' onclick='count("plus",2)' value='+' class="button_plus"/>
                                <div id='result2'>1</div>
                                <input type='button' onclick='count("minus",2)' value='-' class="button_minus"/>
                            </div>
                            <div class="DisCountAndPrice">
                                <p class="DisCount">할인율</p>
                                <p class="price">상품가격</p>
                                <a href="#" class="Delete_1" id="Delete_1" onclick="removeProduct(1)">X</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <!-- 상품 3 -->
                    <div class="product">
                        <input type="checkbox" id="check_btn1" value="1" class="checkbox"/>
                        <a href="#" class="prodcut_name">상품명 : 토마토</a>    
                            <div class="product_img">
                                <img src="https://picsum.photos/id/598/110/110" class="product_img1">
                                
                            </div>
                    <!-- 상품 추가 될때마다 onclick에 숫자 & id=result 숫자 & Delete 숫자를 변경해줘야함. -->        
                        <div class="num">
                            <div class="button_all">
                                <input type='button' onclick='count("plus",3)' value='+' class="button_plus"/>
                                <div id='result3'>1</div>
                                <input type='button' onclick='count("minus",3)' value='-' class="button_minus"/>
                            </div>
                            <div class="DisCountAndPrice">
                                <p class="DisCount">할인율</p>
                                <p class="price">상품가격</p>
                                <a href="#" class="Delete_1">X</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <!-- 상품 4 -->
                    <div class="product">
                        <input type="checkbox" id="check_btn1" value="1" class="checkbox"/>
                        <a href="#" class="prodcut_name">상품명 : 복숭아</a>    
                            <div class="product_img">
                                <img src="https://picsum.photos/id/598/110/110" class="product_img1">
                                
                            </div>
                    <!-- 상품 추가 될때마다 onclick에 숫자 & id=result 숫자 & Delete 숫자를 변경해줘야함. -->        
                        <div class="num">
                            <div class="button_all">
                                <input type='button' onclick='count("plus",4)' value='+' class="button_plus"/>
                                <div id='result4'>1</div>
                                <input type='button' onclick='count("minus",4)' value='-' class="button_minus"/>
                            </div>
                            <div class="DisCountAndPrice">
                                <p class="DisCount">할인율</p>
                                <p class="price">상품가격</p>
                                <a href="#" class="Delete_1">X</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    
                    <div class="final_price">
                        <p>상품금액 <strong class="price_1">5,000</strong>원 - 할인금액 <strong class="price_1">500</strong>원 + 배송비 <strong class="price_1">2,500</strong>원 = 주문금액 <strong class="price_2">10,400</strong>원 </p>
                    </div>
                    <hr>
                    <input type="button" value="선택상품 주문하기" class="order"/>
                    <input type="button" value="계속 쇼핑하기" class="continue"/>                    
                </div>

        </div>
    </div>
</main>

<!-- ======================== Footer ========================== -->
<footer class="footer">
    <div class="yakgwan">
        <li><a href="#">고객센터</a></li>
        <li><a href="#">약관 및 정책</a></li>
        <li><a id="gaein" href="#">개인정보 취급방침</a></li>
    </div>

    <div class="bottom">
        <div id="com_address">
            <p id="jusik">(주)모야모과</p>
            <p>강남지원 1관 : 서울특별시 강남구 테헤란로14길 6 남도빌딩<br>
                상호: 주식회사 모야모과 대표자:요셉킴 사업자등록번호: 123-45-67891<br>
                통신판매업신고번호: 제2023-서울강남-0208</p>
            <p></p>
            <p>Copyright ⓒ MOYAMOGA Corp. All Rights Reserved.</p>
        </div>
        <div id="custom_notice">
            <p id="gogaek">고객센터 <span id="phnum">1588-1234</span></p>
            <p></p>
            <p>평일 07:00~18:00 / 토, 일요일 09:00~12:00<br>
                점심시간 12:00~13:00</p>
            <a href="#">고객센터 바로가기 </a>
        </div>
    </div>
</footer>

</body>
</html>