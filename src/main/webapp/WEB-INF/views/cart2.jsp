<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MOYAMOGA</title>

    <link rel="stylesheet" href="/resources/css/cart.css">

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>

    
    <!-- js가 위 jquery, slick코드 보다 위에 나오면 적용이 안됨 -->
    <script src="/resources/js/cart.js"></script>

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
<!--======================= 메인 부분 ========================-->
    <main>
        <div class="cartmain">			
            <div class="carttitleset">
                <div class="carttitle">장바구니</div>
                <div class="carttitle2">일반배송</div>
            </div>
			<div>
				<!-- 체크박스 전체 여부 -->
				<div class="allcheckbox">
					<input type="checkbox" class="checkboxinput" checked="checked"><span>전체선택</span>	   
                </div>				
				<table class="cart_table">		
					<tbody>
						<c:forEach items="${cartInfo}" var="ci">
							<tr>
								<td class="td_width_1 cart_info_td">
									<input type="checkbox" class="individual_cart_checkbox checkboxinput" checked="checked">
									<input type="hidden" class="individual_bookPrice_input" value="${ci.bookPrice}">
									<input type="hidden" class="individual_salePrice_input" value="${ci.salePrice}">
									<input type="hidden" class="individual_bookCount_input" value="${ci.bookCount}">
									<input type="hidden" class="individual_totalPrice_input" value="${ci.salePrice * ci.bookCount}">
									<input type="hidden" class="individual_point_input" value="${ci.point}">
									<input type="hidden" class="individual_totalPoint_input" value="${ci.totalPoint}">
									<input type="hidden" class="individual_bookId_input" value="${ci.bookId}">								
								</td>
								<td class="td_width_2">
									<div class="image_wrap" data-bookid="${ci.imageList[0].bookId}" data-path="${ci.imageList[0].uploadPath}" data-uuid="${ci.imageList[0].uuid}" data-filename="${ci.imageList[0].fileName}">
										<img>
									</div>								
								</td>
								<td class="td_width_3">${ci.bookName}</td>                               
								<td class="td_width_4 tablecenter">
                                    <div class="tablecenter quantity_div">
                                        <input type="text" value="${ci.bookCount}" class="quantity_input">	
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
									<a class="quantity_modify_btn" data-cartId="${ci.cartId}">변경</a>
								</td>

                                <td class="td_width_4 price_td">
                                    할인금액 : <span class="red_color"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원" /></span><br>
                                    상품금액 : <fmt:formatNumber value="${ci.bookPrice}" pattern="#,### 원" /><br>
                                    최종가격:  <fmt:formatNumber value="${ci.bookPrice} - ${ci.salePrice}" pattern="#,### 원" />
                                    <!-- 마일리지 : <span class="green_color"><fmt:formatNumber value="${ci.point}" pattern="#,###" /></span> -->
                                </td>

								<td class="td_width_4 tablecenter">
									<fmt:formatNumber value="${ci.salePrice * ci.bookCount}" pattern="#,### 원" />
								</td>

								<td class="td_width_4 tablecenter">
									<button class="delete_btn" data-cartid="${ci.cartId}">X</button>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<table class="list_table">
				</table>
			</div>
			<!-- 가격 종합 -->
			<div class="content_total_section">
				<table class="pricetotalwrap">
					<tr>
						<td>
                            <span>상품금액</span>
							<span class="totalPrice_span">70000</span> 원
						</td>                      
                        <td><strong>ㅡ &nbsp;&nbsp;&nbsp;</strong></td>
                        <td>
                            <span>할인금액</span>
                            <span class="totalCount_span">1000</span> 원
                        </td>                                      
                        <td><strong>+ &nbsp;&nbsp;&nbsp;</strong></td>
						<td>
                            <span>배송비</span>
							<span class="delivery_price">3000</span>원
						</td>
                        <td><strong>= &nbsp;&nbsp;&nbsp;</strong></td>
                        <td>
                            <span><strong>총 주문 금액</strong></span>
                            <span class="finalTotalPrice_span">70000</span> 원
                        </td>
					</tr>                                  							
				</table>
			</div>
			<!-- 구매 버튼 영역 -->
			<div class="content_btn_section">
				<a class="order_btn">선택상품 주문하기</a>
                <a class="shop_btn">쇼핑 계속하기</a>
			</div>
			
			<!-- 수량 조정 form -->
			<form action="/cart/update" method="post" class="quantity_update_form">
				<input type="hidden" name="cartId" class="update_cartId">
				<input type="hidden" name="bookCount" class="update_bookCount">
				<input type="hidden" name="memberId" value="${member.memberId}">
			</form>	
			
			<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="cartId" class="delete_cartId">
				<input type="hidden" name="memberId" value="${member.memberId}">
			</form>		
			<!-- 주문 form -->
			<form action="/order/${member.memberId}" method="get" class="order_form">
			</form>													
		</div>
    </main>
<!-- ==========================footer========================= -->
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