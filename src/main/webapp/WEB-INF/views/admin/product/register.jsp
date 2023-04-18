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
    <title>상품 목록</title>
    <link rel="stylesheet" href="/resources/css/admin/common.css">
	<script src="https://cdn.ckeditor.com/ckeditor5/37.0.1/classic/ckeditor.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
    <style>
        
	span, li {
            font-size: 16px;
        }


        .content {
            font-size: 13px;
            font-weight: 600;
            font-family: "맑은 고딕",AppleGothic,Dotum,"돋움",sans-serif;
            /* color: #000; */
            padding: 0;
            width : 650px;
            height: 900px;
            margin : auto;
        }
        .content h1 {
            padding-top : 20px;
        }

        .write {
            margin-bottom: 20px;
        }

        h3 {
            height: 30px;
            font-size: 22px;
        }

        .product_detail {
            height: 500px;
            font-size: 20px;
            font-weight: 700;
        }

        form {
            width: 650px;
            margin-top: 40px;
        }

        button {
            float: right;
            margin-left : 5px;
            margin-bottom : 100px;
            font-weight: 800;
            width: 75px;
            height: 35px;
            background-color: rgb(175, 124, 213);
            border: 1px solid #ceced2;
            font-size: 16px;
        }
        
        .product_button {
     		margin-top : 20px;
     	}

        .reg_date {
            float: right;
        }


/* --------------------- 농가 상세 페이지 --------------------------------- */

        .product {
            background-color: #f7f7f7;
            padding: 30px;

        }


        .box1 {
            border: 1px solid rgb(195, 195, 195);
            padding: 0;
            width: 590px;
            height:120px;
            /* display : flex; */
            /* justify-content: center; */
            /* align-items: center; */
            /* vertical-align: middle; */
        }

        .box2 {
            border-bottom: 1px solid rgb(195, 195, 195);
        }

        .box3 {
            padding-top: 15px;
        }
        
        .box4 {
            border: 1px solid rgb(195, 195, 195);
            padding: 0;
            width: 590px;
            height:255px;
        }
        


        p {
            padding-left: 20px;
            font-size: 16;
        }


        #info {
        	padding:0px;
            width: 550px;
            height: 30px;
            font-size: 20px;
            margin-left: 20px;
        }
        
        
        #price, #discount, #discount_price{
        	padding:0px;
            width: 550px;
            height: 30px;
            font-size: 20px;
            margin-left: 20px;
        }

        select {
            width: 150px;
            height: 30px;
            margin-left: 20px;
        }
        
        #discount_price {
        	margin : 0;
        	margin-left : 20px;
        	padding: 0;
        	width: 550;
        	height: 30px;
        	border : 1px solid #767676;
        	background-color: white;
        }
        
        
        /* 위지윅 에디터 높이*/
		.ck-content {					

		    height: 170px;
		}
        
	  
	 a:link {color:black; text-decoration: none;}
	 a:visited {color:black; text-decoration: none;}
/* 	 a:hover {color:black; text-decoration: underline;} */
        

    </style>
    
</head>

<body>

<!-- 헤더 - 로그인/로그아웃 로고, 관리자페이지 메인글씨 -->
<header>
    <div class="state">
        <span class="login">admin님 로그인하였습니다</span>
        <span class="login">Ι</span>
        <span class="login"><a href="/main">홈페이지</a></span>
        <span class="login">Ι</span>
        <span class="login"><a href="#">로그아웃</a></span>
    </div>
    <div>
        <h1><a href="/admin/main"><img src="/resources/css/admin/logo.png" id="logo" width="200"><a/></h1> 
    </div>
    <h2 class="admin">관리자 페이지</h2>
    
</header>

<!-- 메인 - 보라색 가로줄(메인페이지글자), 왼쪽 메뉴 -->
<main>
    <div class="sub_content">
        <nav> 메인페이지 </nav>
        <div class="menu1">
            <ul id="menu2">
                    <li><a href="/admin/product/register">상품등록</a></li>
                    <li><a href="/admin/product/list">상품목록</a></li>
                    <li><a href="/admin/notice/list">공지사항</a></li>
                    <li><a href="/admin/faq/list">FAQ</a></li>
                    <li><a href="/admin/member/list">회원관리</a></li>
                    <li><a href="/admin/farm/list">거래처관리</a></li>
            </ul>
        </div>   
        
<!-- 메인 - 공지사항 글 목록 테이블, 이동페이지, 수정, 삭제 -->            
                
        <div class="content">
            <h2>상품등록 <span class="test">테스트</span></h2>
            <div class="write">
                <form action="/admin/product/register" method="POST">
                    <div class="product">

	                    <div class="box1">
	                        <div class="box2">
	                            <p>카테고리1</p>
	                        </div>
	                        <div class="box3">
	                            <select name="category1">
	                                <option value="">선택하기</option>
	                                <option value="${product.category1}">농가</option>
	                            </select>
	                        </div>                      
	                    </div>
                    	<br>


	                    <div class="box1">
	                        <div class="box2">
	                            <p>카테고리2</p>
	                        </div>
	                        <div class="box3">
	                            <select name="category2">
	                                <option value="">선택하기</option>
	                                <option value="${product.category2}">오늘의과일채소</option>
	                                <option value="${product.category2}">국내외과일</option>
	                                <option value="${product.category2}">친환경유기농채소</option>
	                                <option value="${product.category2}">우리땅채소</option>
	                                <option value="${product.category2}">채소/샐러드</option>
	                                <option value="${product.category2}">주곡/잡곡</option>
	                                <option value="${product.category2}">오늘의특가</option>
	                                <option value="${product.category2}">신상품</option>
	    
	                            </select>
	                        </div>                      
	                    </div>
	                    <br>
	                    
	                    
	                    <div class="box1">
	                        <div class="box2">
	                            <p>농장 업체</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="farm_no" value="1" id="info" readonly>
	                        </div>                      
	                    </div>
	                    <br>
	
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>상품이름</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="name" id="info">
	                        </div>                      
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>상품 가격</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="price"  id="price">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>할인(%)</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="discount" maxlength="2" id="discount" value="0">
	                            <input type="hidden" name="calc"  value="0">
	                        </div>        
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>할인된 가격</p>
	                        </div>
	                        <div class="box3">
	                           <!--  <input type="text" name="discount_price"  id="discount_price" class="discount_price"> -->
								<p name="discount_price" id="discount_price" class="discount_price"></p>
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>중량</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="weight"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>원산지</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="origin"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>재고수량</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="stock"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <!-- <p>농가업체</p> -->
	                    <input type="hidden"  name="farm_no"  id="info">
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>메인 이미지</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="main_image"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>서브 이미지1</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="sub_image1"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	                
	                    <div class="box1">
	                        <div class="box2">
	                            <p>서브 이미지2</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="sub_image2"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	                    
	                    <div class="box1">
	                        <div class="box2">
	                            <p>서브 이미지3</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="sub_image3"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>서브 이미지4</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="sub_image4"  id="info">
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box4">
	                        <div class="box2">
	                            <p>상세정보내용</p>
	                        </div>
	                        <div class="box41">
	                            <textarea name="content" id="info_textarea"></textarea>
	                        </div>         
	                    </div>
	                    <br>
	
	                    <div class="box1">
	                        <div class="box2">
	                            <p>상세정보내용 이미지</p>
	                        </div>
	                        <div class="box3">
	                            <input type="text"  name="content_image"  id="info">
	                        </div>         
	                    </div>
	                    <br>


	                    <div class="product_button">
	                        <button type="submit" id="modifyBtn">등록</button>
	                        <button type="button" id="listBtn">목록</button>
	                    </div>
                    </div>
                 </form>
            </div>
            
        </div>
        

    </div>
</main>

    
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>



<script>	
//  ================== 1. 버튼을 클릭하면 이동함. =============================

	
		// 글 작성!!
        var registerBtn = document.querySelector('#registerBtn');

        registerBtn.addEventListener('click', function () {
            location = '/admin/farm/register';
        }); // registerBtn

      //만약 결과값에 어떤 값이든 들어왔다면(null이 아니라면) -> 결과값을 alert창으로 띄운다.
      
        var result = "${param.result}";
        if(result != null && result != "") {        
            alert('result: ' + result);
        } // if
        
        
        
		// 글 삭제!!
        removeBtn.addEventListener('click', function(){
            console.log('removeBtn clicked ㅇ_<');

            //form 태그를 조작해서 삭제요청을 전송! 
            var form = document.querySelector('form');
            console.log(form.constructor.prototype);


            form.setAttribute('method', 'POST');
            form.setAttribute('action', '/admin/farm/remove');
            form.submit();

        }); // removeBtn
        
</script>
<script>
//================== 2. 위지윅 편집기 적용 =============================

/* 상세 정보 내용 */
 	ClassicEditor
	.create(document.querySelector('#info_textarea'))
	.catch(error=>{
		console.error(error);
	});

	
</script>
<script>
//================== 3. 상품 할인율 설정 =============================

	// 상품 가격-할인 순으로 입력했을 때
	$("#discount").on("propertychange change keyup paste input", function(){
		
		let userInput = $("#discount"); 10
		let discountInput = $("input[name='calc']"); 10
		
		let discountRate = userInput.val();					// 사용자가 입력할 할인값
		let sendDiscountRate = discountRate / 100;					// 서버에 전송할 할인값
		let goodsPrice = $("input[name='price']").val();			// 원가
		let discountPrice = goodsPrice * (1 - sendDiscountRate);		// 할인가격
        
		$(".discount_price").html(discountPrice);
		discountInput.val(sendDiscountRate);	
		
	});
	
	
	
	// 입력 후 상품 가격을 수정했을 때
	$("input[name='price']").on("change", function(){
		
		let userInput = $("#discount");
		let discountInput = $("input[name='calc']");
		
		let discountRate = userInput.val();					// 사용자가 입력한 할인값
		let sendDiscountRate = discountRate / 100;			// 서버에 전송할 할인값
		let goodsPrice = $("input[name='price']").val();			// 원가
		let discountPrice = goodsPrice * (1 - sendDiscountRate);		// 할인가격
		
		$(".discount_price").html(discountPrice);
		
	});
	
	
</script>


</html>