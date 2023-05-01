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

    <!-- include favicon -->
    <%@include file="/WEB-INF/views/common/favicon.jsp" %>
    
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
   
	<!-- header -->
	<%@include file= "../views/common/header.jsp" %>

    <main>
        <div class="cartmain">			
            <div class="carttitleset">
                <div class="carttitle">장바구니</div>
                <div class="carttitle2">일반배송</div>
            </div>
			<div>
				<!-- 체크박스 전체 여부 -->
				<div class="allcheckbox">
					<input type="checkbox" class="allcheckboxInput" checked="checked">
                    <!-- <label for="check1"></label>	  -->
                    <span>전체선택</span>
                </div>			
                	
				<table class="cart_table">		
					<tbody>
						<c:forEach items="${cartInfo}" var="cartInfo">
							<tr>
								<td class="td_1 cartinfo_td">
									<input type="checkbox" class="cartCheckbox checkboxInput" checked="checked">
									<input type="hidden" class="cartNo" value="${cartInfo.no}">
									<input type="hidden" class="productPriceInput" value="${cartInfo.price}">
									<input type="hidden" class="discountPriceInput" value="${cartInfo.discount_price}">
									<input type="hidden" class="cartCountInput" value="${cartInfo.count}">
									<input type="hidden" class="cartTotalPriceInput" value="${cartInfo.discount_price * cartInfo.count}">
									<input type="hidden" class="productNameInput" value="${cartInfo.name}">
									<input type="hidden" class="cartProductNoInput" value="${cartInfo.product_No}">									
								</td>

								<td class="td_2">
									<div class="image_wrap" data-product_no="${cartInfo.imageList[0].product_No}" data-path="${cartInfo.imageList[0].uploadPath}" data-uuid="${cartInfo.imageList[0].uuid}" data-filename="${cartInfo.imageList[0].fileName}">
										<img>
									</div>								
								</td>

								<td class="td_3">${cartInfo.name}</td>        

								<td class="td_4 tablecenter">
                                    <div class="tablecenter quantity_div">
                                        <input type="text" value="${cartInfo.count}" class="quantity_input">	
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
                                    <a class="quantity_modify_btn" data-no="${cartInfo.no}">변경</a>
								</td>

                                <td class="td_4 price_td">
                                    상품금액 : <del><fmt:formatNumber value="${cartInfo.price}" pattern="#,### 원" /></del><br>
                                    할인금액 : <span class="red_color"><fmt:formatNumber value="${cartInfo.discount_price}" pattern="#,### 원" /></span><br>
                                </td>

								<td class="td_4 tablecenter">
									최종가격 : <fmt:formatNumber value="${cartInfo.discount_price * cartInfo.count}" pattern="#,### 원" />
								</td>

								<td class="td_4 tablecenter">
									<button class="delete_btn" data-no="${cartInfo.no}">X</button>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<table class="list_table">
				</table>
			</div>

			<!-- 가격 종합 -->
			<div class="contenttotal_section">
				<table class="pricetotalwrap">
					<tr>
                        <td><span>상품금액</span></td>
						<td><span class="totalPrice_span">10000</span> 원</td>  
						                    
                        <td><strong>+ &nbsp;&nbsp;&nbsp;</strong></td>
                        
                        <td><span>배송비</span></td>
						<td><span class="delivery_price">3000</span> 원</td>
						
                        <td><strong>= &nbsp;&nbsp;&nbsp;</strong></td>
                        
                        <td><span>총 주문 금액</span></td>
                        <td><span class="finalTotalPrice_span">10000</span> 원</td>
					</tr>                                  							
				</table>
			</div>

			<!-- 구매 버튼 영역 -->
			<div class="contentbtn_section">
				<a class="order_btn">선택상품 주문하기</a>
                <a href="/main" class="shop_btn">쇼핑 계속하기</a>
			</div>
			
			<!-- 수량 조정 form -->
			<form action="/cart/update" method="post" class="quantity_update_form">
				<input type="hidden" name="no" class="update_cartId">
				<input type="hidden" name="count" class="update_cartCount">
				<input type="hidden" name="member_id" value="${member.id}">
			</form>
			
			<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="no" class="delete_cartNo">
				<input type="hidden" name="member_id" value="${member.id}">
			</form>

			<!-- 주문 form -->
			<form action="/order/${member.id}" method="post" class="order_form">
			</form>													
		</div>
    </main>
<!-- ==========================footer========================= -->
   <%@include file= "../views/common/footer.jsp" %>
   
    <!-- 세인이..비동기식 로그아웃 js 불러오려면 여기다 넣어야지만 불러와짐 흑흑,, -->
    <script src="/resources/js/main.js"></script>

</body>
</html>