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
    <title>상품 수정</title>
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

        .category1, .category2 {
            width: 200px;
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
            <h2>상품수정 <span class="test">테스트</span></h2>
            <div class="write">
                <form action="/admin/product/modify" method="post" enctype="multipart/form-data">
                    <div class="product">
					<input type="hidden" name="no" value="${product.no}"  readonly>

                       <div class="box1">
                           <div class="box2">
                               <p>대분류</p>
                           </div>
                           <div class="box3">
                               <select class="category1">
                                   <option selected value="none">선택하기</option>
                                   
                               </select>
                           </div>                      
                       </div>
                       <br>


                       <div class="box1">
                           <div class="box2">
                               <p>중분류</p>
                           </div>
                           <div class="box3">
                               <select name="category" class="category2">
                                   <option selected value="none">선택하기</option>
       
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
                               <input type="text"  name="name" id="info" value="${product.name}">
                           </div>                      
                       </div>
                       <br>
                       
                       <div class="box1">
                           <div class="box2">
                               <p>타이틀-레시피('사과, 오렌지' 처럼 과일 명만 적기)</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="title" id="info" value="${product.title}">
                           </div>                      
                       </div>
                       <br>
                       
   
                       <div class="box1">
                           <div class="box2">
                               <p>상품 가격</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="price"  id="price" value="${product.price}">
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>할인(%)</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="discount" maxlength="2" id="discount" value="${product.discount}">
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
                        <p name="discount_price" id="discount_price" class="discount_price" value="${product.discount_price}"></p>
                        <input type="hidden" name="discount_price"  id="discount_price" value="${product.discount_price}" class="discount_price">
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>중량</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="weight"  id="info" value="${product.weight}">
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>원산지</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="origin"  id="info" value="${product.origin}">
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>재고수량</p>
                           </div>
                           <div class="box3">
                               <input type="text"  name="stock"  id="info" value="${product.stock}">
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
                           <input type="file" id="main_image" name="files" />
                        <div class="select_main_image"><img src="${product.main_image}" id="main_image" /></div>
                                     
                           <script>
                              $("#main_image").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_main_image img").attr("src", data.target.result).width(200);        
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
                           <input type="file" id="sub_image1" name="files" />
                        <div class="select_sub_image1"><img src="${product.sub_image1}" id="sub_image1" /></div>
                                     
                           <script>
                              $("#sub_image1").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image1 img").attr("src", data.target.result).width(200);        
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
                           <input type="file" id="sub_image2" name="files" />
                        <div class="select_sub_image2"><img src="${product.sub_image2}" id="sub_image2" /></div>
                                     
                           <script>
                              $("#sub_image2").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image2 img").attr("src", data.target.result).width(200);        
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
                           </div>
                           <div class="box3">
                           <input type="file" id="sub_image3" name="files" />
                        <div class="select_sub_image3"><img src="${product.sub_image3}" id="sub_image3" /></div>
                                     
                           <script>
                              $("#sub_image3").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image3 img").attr("src", data.target.result).width(200);        
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
                               <p>서브 이미지4</p>
                           </div>
                           <div class="box3">
                           <input type="file" id="sub_image4" name="files" />
                        <div class="select_sub_image4"><img src="${product.sub_image4}" id="sub_image4" /></div>
                                     
                           <script>
                              $("#sub_image4").change(function(){
                                 if(this.files && this.files[0]) {
                                                  
                                    var reader = new FileReader;
                                                     
                                    reader.onload = function(data) {
                                       $(".select_sub_image4 img").attr("src", data.target.result).width(200);        
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
                               <textarea name="content" id="info_textarea">${product.content}</textarea>
                           </div>         
                       </div>
                       <br>
   
                       <div class="box1">
                           <div class="box2">
                               <p>상세정보내용 이미지</p>
                           </div>
                           <div class="box3">
                           <input type="file" id="content_image" name="files" />
                        <div class="select_content_image"><img src="${product.content_image}" id="content_image" /></div>
                                     
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
                           <button type="submit" id="modifyBtn">수정</button>
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
//  ================== 1. 버튼을 클릭하면 이동함. =============================
   
	var listBtn = document.querySelector('#listBtn');
	var removeBtn = document.querySelector('#removeBtn');
	
	//목록 버튼을 눌러 목록으로 돌아가기
	listBtn.addEventListener('click', function() {
		console.log('listBtn clicked');
		location.href='/admin/product/list';
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

$("#discount").on("propertychange change keyup paste input", function(){

   let userInput = $("#discount"); 
   let discountInput = $("input[name='calc']"); 
   
   let discountRate = userInput.val();               // 사용자가 입력할 할인값
   let sendDiscountRate = discountRate / 100;               // 서버에 전송할 할인값
   let goodsPrice = $("input[name='price']").val();         // 원가
   let discountPrice = goodsPrice * (1 - sendDiscountRate);      // 할인가격

   // 총 할인 가격을 10원 단위까지만 표시
   discountPrice = Math.floor(discountPrice / 10) * 10; 

   $(".discount_price").html(discountPrice);
   discountInput.val(sendDiscountRate);

   $("input[name='discount_price']").attr('value',discountPrice);

});





// 입력 후 상품 가격을 수정했을 때
$("input[name='price']").on("change", function(){
   
   let userInput = $("#discount");
   let discountInput = $("input[name='calc']");
   
   let discountRate = userInput.val();                     // 사용자가 입력한 할인값
   let sendDiscountRate = discountRate / 100;               // 서버에 전송할 할인값
   let goodsPrice = $("input[name='price']").val();         // 원가
   let discountPrice = goodsPrice * (1 - sendDiscountRate);   // 할인가격
   
   // 총 할인 가격을 10원 단위까지만 표시
   discountPrice = Math.floor(discountPrice / 10) * 10; 

   $(".discount_price").html(discountPrice);
   discountInput.val(sendDiscountRate);

   $("input[name='discount_price']").attr('value',discountPrice);

});
   
</script>
<script>
   /* 카테고리 구현 */
/*    $(document).ready(function() {
      console.log('${cateList}');
      
   }); */
   
   /* 카테고리 */
   let cateList = JSON.parse('${cateList}');
   
   let cate1Array = new Array();
   let cate2Array = new Array();
   let cate1Obj = new Object();
   let cate2Obj = new Object();
   
   let cateSelect1 = $(".category1");
   let cateSelect2 = $(".category2");
   
   /* 카테고리 배열 초기화 메서드 */
   function makeCateArray(obj, array, cateList, tier) {
      
      for(let i = 0; i <cateList.length; i++) {
         if(cateList[i].tier === tier) {
            obj = new Object();
            
            obj.name = cateList[i].name;
            obj.code = cateList[i].code;
            obj.parent = cateList[i].parent;
            
            array.push(obj);
            
         } //if
         
      }// for
      
   } // end function
   
   /* 배열 초기화 */
   makeCateArray(cate1Obj, cate1Array, cateList, 1);
   makeCateArray(cate2Obj, cate2Array, cateList, 2);
   
/*    $(document).ready(function() {
      
      console.log(cate1Array);
      console.log(cate2Array);
   }); */
   
   /* 대분류 태그 */
   for(let i = 0; i < cate1Array.length; i++){
      cateSelect1.append("<option value='"+cate1Array[i].code+"'>" + cate1Array[i].name + "</option>");
   }
   
   
   /* 중분류 <option> 태그 */
   $(cateSelect1).on("change",function(){
      
      let selectVal1 = $(this).find("option:selected").val();   
      
      cateSelect2.children().remove();
      
      cateSelect2.append("<option value='none'>선택하기</option>");
      
      for(let i = 0; i < cate2Array.length; i++){
         if(selectVal1 === cate2Array[i].parent){
            cateSelect2.append("<option value='"+cate2Array[i].code+"'>" + cate2Array[i].name + "</option>");   
         }
      }// for
      
   });

</script>
</html>