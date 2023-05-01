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
            padding-bottom: 15px;
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
        
        #discount_price, #category2 {
           margin : 0;
           margin-left : 20px;
           padding: 0;
           width: 550;
           height: 30px;
           border : 1px solid #767676;
           background-color: white;
        }
        
	        
 		#info_textarea {
			margin-top: 20px;
		    margin-left: 20px;
		    padding: 0;
		    width: 550px;
		    min-height: 170px;
		    border: 1px solid #767676;
		    background-color: white;
		} 
     
    a:link {color:black; text-decoration: none;}
    a:visited {color:black; text-decoration: none;}
/*     a:hover {color:black; text-decoration: underline;} */


/* --------------------- 이미지 크기 조정 및 삭제 --------------------------------- */
   
   #result_card img {
      max-width: 200px;
      height:auto;
      display:block;
      padding:5px;
      margin-top:10px;
      margin:auto;
   }
   
   #result_card {
      position : relative;
   }
   
   .imgDeleteBtn {
      position : absolute;
      top: 0;
      right:5%;
       background-color: #ef7d7d;
       color: wheat;
       font-weight: 900;
       width: 30px;
       height: 30px;
       border-radius: 50%;
       line-height: 26px;
       text-align: center;
       border: none;
       display: block;
       cursor: pointer;
   }
   
   #result_card img{
      max-width : 100%;
      height : auto;
      display : block;
      padding: 5px;
      margin-top: 10px;
      margin : auto;
   }
        

    </style>
    
</head>

<body>

<!-- 헤더 - 로그인/로그아웃 로고, 관리자페이지 메인글씨 -->
<%@include file= "/WEB-INF/views/admin/common/header.jsp" %> 

<!-- 메인 - 보라색 가로줄(메인페이지글자), 왼쪽 메뉴 -->
<main>
    <div class="sub_content">        
<!-- 메인 - 공지사항 글 목록 테이블, 이동페이지, 수정, 삭제 -->            
                
        <div class="content">
            <h2>상품상세 <span class="test">테스트</span></h2>
            <div class="write">
            	<form>
            	<div class="product">
          		<input type="hidden" name="no" value="${product.no}">
                       <div class="box1">
                           <div class="box2">
                               <p>카테고리</p>
                           </div>
                           <div class="box3">
								<p name="category2" id="category2">${product.category}</p>
                           </div>                      
                       </div>
                       <br>
                       
                       
                       <div class="box1">
                           <div class="box2">
                               <p>농장 업체</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="product_no" value="1" id="info" readonly>
                           </div>                      
                       </div>
                       <br>
   
   
                       <div class="box1">
                           <div class="box2">
                               <p>상품이름</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="name" id="info" value="${product.name}" readonly>
                           </div>                      
                       </div>
                       <br>
                       
                       <div class="box1">
                           <div class="box2">
                               <p>타이틀-레시피('사과, 오렌지' 처럼 과일 명만 적기)</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="title" id="info" value="${product.title}" readonly>
                           </div>                      
                       </div>
                       <br>
                       
                       
   
                       <div class="box1">
                           <div class="box2">
                               <p>상품 가격</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="price"  id="price" value="${product.price}" readonly>
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>할인(%)</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="discount" maxlength="2" id="discount" value="${product.discount}" readonly>
                               <input type="hidden" name="calc"  value="${product.discount}">
                           </div>        
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>할인된 가격</p>
                           </div>
                           <div class="box3">
                              <!--  <input type="text" name="discount_price"  id="discount_price" class="discount_price"> -->
                        <p name="discount_price" id="discount_price" class="discount_price" >${product.discount_price}</p>
                        <input type="hidden" name="discount_price"  id="discount_price" value="${product.discount_price}" class="discount_price">
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>중량</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="weight"  id="info" value="${product.weight}" readonly>
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>원산지</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="origin"  id="info" value="${product.origin}" readonly>
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>재고수량</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="stock"  id="info" value="${product.stock}" readonly>
                           </div>         
                       </div>
                       <br>
   
                       <!-- <p>농가업체</p> -->
                       <input type="hidden"  name="product_no"  id="info" >
                       
                       
                       	<div class="box1">
                       	 	<div class="box2">
                               <p>메인 이미지</p>
		                    </div>
                           <div class="box3">
	                        <div class="select_main_image"><img src="/resources/product/${product.main_image}" id="main_image" /></div>
	                                     
	                           <script>
	                              $("#main_image").change(function(){
	                                 if(this.files && this.files[0]) {
	                                                  
	                                    var reader = new FileReader;
	                                                     
	                                    reader.onload = function(data) {
	                                       $(".select_main_image img").attr("src", data.target.result).width(100);        
	                                    }
	                                    reader.readAsDataURL(this.files[0]);
	                                 }
	                              });
	                           </script>
                             </div>
						</div>
                     	<br>
                     
   
                       <div class="box1">
                           <div class="box2">
                               <p>서브 이미지1</p>
                           </div>
                           <div class="box3">
                        	<div class="select_sub_image1"><img src="/resources/product/${product.sub_image1}" id="sub_image1" /></div>
                                     
	                           <script>
	                              $("#sub_image1").change(function(){
	                                 if(this.files && this.files[0]) {
	                                                  
	                                    var reader = new FileReader;
	                                                     
	                                    reader.onload = function(data) {
	                                       $(".select_sub_image1 img").attr("src", data.target.result).width(100);       
	                                    }
	                                    reader.readAsDataURL(this.files[0]);
	                                 }
	                              });
	                           </script>
                           </div>
                       </div>
                       <br>
                   
                   
                       <div class="box1">
                           <div class="box2">
                               <p>서브 이미지2</p>
                           </div>
                           <div class="box3">
                        <div class="select_sub_image2"><img src="/resources/product/${product.sub_image2}" id="sub_image2" /></div>
                                     
                           <script>
                              $("#sub_image2").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image2 img").attr("src", data.target.result).width(100);        
                                    }
                                    reader.readAsDataURL(this.files[0]);
                                 }
                              });
                           </script>
                             </div>             
                       </div>
                       <br>
                       
                       
                       <div class="box1">
                           <div class="box2">
                               <p>서브 이미지3</p>
                           <div class="box3">
                        <div class="select_sub_image3"><img src="/resources/product/${product.sub_image3}" id="sub_image3" /></div>
                                     
                           <script>
                              $("#sub_image3").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image3 img").attr("src", data.target.result).width(100);        
                                    }
                                    reader.readAsDataURL(this.files[0]);
                                 }
                              });
                           </script>
                             </div>           
                       </div>
                       </div>
                       <br>
   
   
                       <div class="box1">
                           <div class="box2">
                               <p>서브 이미지4</p>
                           </div>
                           <div class="box3">
                        <div class="select_sub_image4"><img src="/resources/product/${product.sub_image4}" id="sub_image4" /></div>
                                     
                           <script>
                              $("#sub_image4").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image4 img").attr("src", data.target.result).width(100);        
                                    }
                                    reader.readAsDataURL(this.files[0]);
                                 }
                              });
                           </script>
                             </div>
                       </div>
                       <br>
   
   
                       <div class="box4">
                           <div class="box2">
                               <p>상세정보내용</p>
                           </div>
                           <div class="box41">
                               <textarea name="content" id="info_textarea"  readonly>${product.content}</textarea>
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>상세정보내용 이미지</p>
                           </div>
                           <div class="box3">
                        <div class="select_content_image"><img src="/resources/product/${product.content_image}" id="content_image" /></div>
                                     
                           <script>
                              $("#content_image").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_content_image img").attr("src", data.target.result).width(200);        
                                    }
                                    reader.readAsDataURL(this.files[0]);
                                 }
                              });
                           </script>
                             </div>
                       </div>
                       <br>


                    <div class="product_button">
                        <button type="button" id="modifyBtn">수정</button>
                        <button type="button" id="removeBtn">삭제</button>
                        <button type="button" id="listBtn">목록</button>
                    </div>
                    </div>
                 </form>
            </div>
            
        </div>
        

    </div>
</main>

    
</body>
<script>
	var listBtn = document.querySelector('#listBtn');
	var modifyBtn = document.querySelector('#modifyBtn');
	var removeBtn = document.querySelector('#removeBtn');
	
	//목록 버튼을 눌러 목록으로 돌아가기
	listBtn.addEventListener('click', function() {
		console.log('listBtn clicked');
		location.href='/admin/product/list';
	});
	
	// 수정 버튼을 눌러 수정페이지로 가기
	modifyBtn.addEventListener('click', function() {
		console.log('modifyBtn clicked');
		self.location="/admin/product/modify?no=${product.no}";
	});
	
	
	// 삭제 버튼을 눌러 목록으로 돌아가기
    removeBtn.addEventListener('click', function(){
        console.log('removeBtn clicked ㅇ_<');

        //form 태그를 조작해서 삭제요청을 전송! 
        var form = document.querySelector('form');
        console.log(form.constructor.prototype);


        form.setAttribute('method', 'POST');
        form.setAttribute('action', '/admin/product/remove');
        form.submit();


});
    
    
</script>
</html>