<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ang="ko">
<head>

	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>MOYAMOGA</title>

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" /> -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,0,-25" /> -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

 	<link rel="stylesheet" href="/resources/css/paycss.css">

	<link rel="shortcut icon" href="/resources/ico/favicon.ico" type="image/x-icon">
	<link rel="icon" href="/resources/ico/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>

    <!-- slick: cdn 방식으로 css, js 가져오기 -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>			
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    
    <script src="/resources/js/main1.js"></script>
    
    <!-- 결제 API -->
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	    
	<!-- 다음주소 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
        var IMP = window.IMP; 
        IMP.init("imp35647012"); 
    
        function requestPay() {
            IMP.request_pay({
                pg : 'kcp.{INIBillTst}',
                pay_method : 'card',
                merchant_uid: "57008833-33004", 
                name : '당근 10kg',
                amount : 1004,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : '포트원 기술지원팀',
                buyer_tel : '010-1234-5678',
                buyer_addr : '서울특별시 강남구 삼성동',
                buyer_postcode : '123-456'
            }, function (rsp) { // callback
                if (rsp.success) {
                    console.log(rsp);
                } else {
                    console.log(rsp);
                }
            });
        }
    </script>

<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('address_input_r').value = data.zonecode; // 우편 번호
                document.getElementById("address_input2_r").value = roadAddr; // 도로명 주소
                document.getElementById("address_input3_r").value = data.jibunAddress; //지번주소
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
	    
</head>
<body>

    <!--------------------------- 헤더!!!!!!!!!!!---------------- -->
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
	
<div class="wrapper">

        <div class="주문결제">
            주문결제
        </div>

        <!-- 주문 상품 정보 -->
        <div class="주문상품">

            <!-- <div class="buyer_info">주문상품 X건</div> -->

            <!-- 구분선 -->
            <hr class="separator">

            <div class="주문상품정보">
				<!-- 상품 종류 -->
				<div class="products_kind_div">
					주문상품 <span class="products_kind_div_kind"></span>종<span class="products_kind_div_count"></span>개
				</div>
				
				<!-- 상품 테이블 -->
				<table class="products_subject_table">
					<colgroup>
						<col width="15%">
						<col width="45%"> <!-- <col> 태그는 각 열의 너비를 지정하는 데 사용 -->
						<col width="40%">
					</colgroup>
					<tbody>
						<tr>
							<th>이미지</th>
							<th>상품 정보</th> 
							<th>판매가</th>
						</tr>
					</tbody>
				</table> <!-- 상품테이블 -->
				<table class="products_table">
					<colgroup>
						<col width="15%">
						<col width="45%">
						<col width="40%">
					</colgroup>
					<tbody>
						<c:forEach items="${orderList}" var="ol">
							<tr>
								<td>
									<!-- 이미지 <td>-->
								</td>
								<td class="상품정보">${ol.productName}</td>
								<td class="products_table_price_td">
									<fmt:formatNumber value="${ol.salePrice}" pattern="#,### 원" /> | 수량 ${ol.productCount}개
									<br><fmt:formatNumber value="${ol.totalPrice}" pattern="#,### 원" />
									<br>[<fmt:formatNumber value="${ol.totalPoint}" pattern="#,### 원" />P]
									<input type="hidden" class="individual_productPrice_input" value="${ol.bookPrice}">
									<input type="hidden" class="individual_salePrice_input" value="${ol.salePrice}">
									<input type="hidden" class="individual_productCount_input" value="${ol.productCount}">
									<input type="hidden" class="individual_totalPrice_input" value="${ol.salePrice * ol.productCount}">
								<!--	<input type="hidden" class="individual_point_input" value="${ol.point}">   포인트는 없음  -->
									<input type="hidden" class="individual_totalPoint_input" value="${ol.totalPoint}">
									<input type="hidden" class="individual_productId_input" value="${ol.productId}">
								</td>
							</tr>			
						</c:forEach>
					</tbody>
				</table>
				
            </div>

        </div>

        <!-- 구매자 정보 -->
        <div class="구매자정보">

            <div class="buyer_info">구매자 정보</div>

            <!-- 구매자 정보 아래 구분선 -->
            <hr class="separator">

            <!-- 이름, 핸드폰 번호, 이메일 위치 한 번에 조정하기 위해서 묶음 -->
            <div class="locate">

                <!-- 이름 + 입력창 + 수정 버튼 -->
                <div class="input_row">
                    <label for="name_title">이름</label>
                    <input type="text" id="name_input" name="name" placeholder="이름을 입력해주세요">
                    <button class="edit_button">수정</button>
                </div>

                <!-- 핸드폰 번호 + 입력창 + 수정 버튼 -->
                <div class="input_row">
                    <label for="phone_title">핸드폰 번호</label>
                    <input type="tel" id="phone_input" name="phone" placeholder="핸드폰 번호를 입력해주세요">
                    <button class="edit_button">수정</button>
                </div>

                <!-- 이메일 + 입력창 -->
                <div class="input_row">
                    <label for="email_title">이메일</label>
                    <input type="email" id="email_input" name="email" placeholder="이메일을 입력해주세요">
                </div>

            </div>
        </div>

            <!-- 받는사람 정보 -->
        <div class="받는사람 정보">

            <div class="receiver_info">받는사람 정보</div>

            <!-- 구매자 정보 아래 구분선 -->
            <hr class="separator">

            <!-- 이름, 주소, 연락처, 배송요청사항 한 번에 조정하기 위해서 묶음 -->
            <div class="locate">

                <!-- 이름 + 입력창 + 수정 버튼 -->
                <div class="input_row2">
                    <label for="name_title_r">이름</label>
                    <input type="text" id="name_input_r" name="name" placeholder="이름을 입력해주세요">
                </div>

                <!-- 주소 + 입력창 + 수정 버튼 -->
                <div class="input_row2">
                    <label for="address_title_r">주소</label>

					<input type="text" id="address_input_r" placeholder="우편번호">
              <!-- <input type="address" id="address_input_r" name="address" placeholder="주소를 입력해주세요"> --> 
                    <input type="button" onclick="sample4_execDaumPostcode()" value="주소입력" class="address_button" ><br>
                    <!--<button class="address_button" >주소입력</button>-->
                    <div></div>
                    <input type="text" id="address_input2_r" placeholder="도로명주소">
                  <!-- <input type="address" id="address_input2_r" name="address"> -->
                  	<div></div>
                  	<input type="text" id="address_input3_r"" placeholder="지번주소">
                    <div></div>
                  <input type="text" id="address_input3_r" placeholder="상세주소">
                <!--  <input type="address" id="address_input3_r" name="address"> <!-- 상세주소 -->
                </div>

                <!-- 연락처 + 입력창 -->
                <div class="input_row2">
                    <label for="phone_title_r">연락처</label>
                    <input type="phone" id="phone_input_r" name="phone" placeholder="연락처를 입력해주세요">
                </div>

                <!-- 배송 요청사항 선택창 -->
                <div class="input_row2">
                    <label for="request_title_r">배송 요청사항</label>
                    <!-- 선택창으로 변경 필요! -->
                    <select name='selbox' id="배송요청사항" onchange="selectMemo(this)">
                        <option value='' selected id="선택">--------------------- 선택 ---------------------</option>
                        <option value='부재시, 연락 바랍니다.'>부재시, 연락 바랍니다.</option>
                        <option value='부재시, 무인 택배함 보관 후 연락바랍니다.'>부재시, 무인 택배함 보관 후 연락바랍니다.</option>
                        <option value='부재시, 경비실에 맡겨주세요.'>부재시, 경비실에 맡겨주세요.</option>
                        <option value="직접입력">직접입력</option>
                    </select>
                    <br>
                 <!-- 상단의 select box에서 '직접입력'을 선택하면 나타날 인풋박스 -->
                <input id="selboxDirect" type="text" placeholder="직접 입력하세요" style="display: none;">     
                </div>           

            </div>
            
        </div> <!-- 받는사람 정보 -->

        <!-- 결제 금액 -->
        <div class="결제금액정보">

            <div class="pay_info">결제 금액</div>
        
            <!-- 구매자 정보 아래 구분선 -->
            <hr class="separator">
        
            <!-- 이름, 핸드폰 번호, 이메일 위치 한 번에 조정하기 위해서 묶음 -->
            <div class="locate">
                <!-- 총 상품 가격  -->
                <div class="input_row">
                    <label for=name_title_r" id="정보">총 상품 가격 </label>
                    <input type="text" id="총상품가격" name="총상품가격" placeholder="">

                </div>

                <!-- 할인금액 -->
                <div class="input_row">
                    <label for="name_title_r" id="정보">할인금액</label>
                    <input type="text" id="할인금액" name="할인금액" placeholder="">

                </div>

                <!-- 배송비  -->
                <div class="input_row">
                    <label for="name_title_r" id="정보">배송비</label>
                    <input type="text" id="배송비1" name="배송비1" placeholder="">
                </div>
                
                <!-- 총결제금액 -->
                <div class="input_row">
                    <label for="name_title_r">총결제금액</label>
                    <input type="text" id="총결제금액" name="총결제금액" placeholder="">
                </div>
        
            </div>
        </div> <!-- 결제 금액-->

         <button onclick="requestPay()" class="결제팝업">결제하기</button> 

    </div> <!-- wrapper -->


    <!-- -------------------최근 본 상품!!!!!!!------------------ -->

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

<!-------------------- 푸터!!!!!!!!!!!!!!!!----------------- -->

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