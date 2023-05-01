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
    <title>공지사항 목록</title>
    <!-- <link href="/admin_page/css/product/product_list.css" type="text/css" rel="stylesheet" /> -->
    <link rel="stylesheet" href="/resources/css/admin/common.css">

    <style>

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

	.button1 {
		margin-top : 5px;
	}
	
    table {
        display: table;
        width: 780px;
        margin-bottom: 0px;
        border-top: 4px solid #ceced2;
    }

    table th {
        border-bottom: 1px solid #ceced2;
        padding : 8px;
    }

    table td {
        padding: 14px 10px 13px 10px;
        border-bottom: 1px solid #ceced2;
        text-align: center;
        
    }

    .title {
        text-align: left;
    }

    /* ====================== 페이지 이동 ======================= */
    .page {
        margin-left: 250px;
    }

    .pagenation {
        /* display: inline-block; */
        text-align: center;
        margin-right: 20%;
        margin-bottom: 15px;
    }

    .pagenation ul {
        text-align: center;
        vertical-align: middle;
        padding: 0px;
        margin:0px;
    }

    .pagenation li {
        /* border: 1px black solid; */
        display: inline-block;
        min-width: 30px;
        vertical-align: middle;
        text-decoration: none;
        border: 1px solid #ceced2;
        margin-bottom: 20px;
    }

    /* ======================수정,삭제======================= */  
     
 
	  .pageInfo{
	    list-style : none;
	    display: inline-block;
	    margin: 50px 0 0 100px;      
	  }
	  .pageInfo li{
	    float: left;
	    font-size: 20px;
	    margin-left: 18px;
	    padding: 7px;
	    font-weight: 500;
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
        <form>
            <table>
                <h2>상품목록 <span class="test">테스트</span></h2>
                <thead>
	                <tr>
	                    <th><input type="checkbox" name="selectall" value="selectall" onclick="selectAll(this)"></th>
	                    <th>번호</th>
	                    <th>제목</th>
	                    <th>작성날짜</th>
	                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="ProductDTO">
                        <tr>
                        	<td><input type="checkbox" name="item" onclick="checkSelectAll()" /></td>
                            <td>${ProductDTO.no}</td>
                            <td><a href="/admin/product/get?no=${ProductDTO.no}">${ProductDTO.name}</a></td>
                            <td>${ProductDTO.reg_date}</td>
                            <td><input type="hidden" name="no" value="${ProductDTO.no}"></td>
                        </tr>       
                    </c:forEach>    
                </tbody>
            </table>
		</form>
            
		 		<div class="pageInfo_wrap" >
					    <div class="pageInfo_area">
					    	<ul id="pageInfo" class="pageInfo">
					    	
					    		<!-- 이전페이지 버튼 -->
					            <c:if test="${pageMaker.prev}">
					                <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
					            </c:if>
					            
				            	<!-- 각 번호 페이지 버튼 -->
				                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				                    <li class="pageInfo_btn "><a href="/admin/product/list?currPage=${num}&amount=${pageMaker.cri.amount}">${num}</a></li>
				                </c:forEach>
				             
					            <!-- 다음페이지 버튼 -->
					            <c:if test="${pageMaker.next}">
					                <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
					            </c:if>  
				             </ul>
				            
		            	</div>
		            
		            
			            <div class="button1">
			 				<button type="button" id="registerBtn">등록</button>
			                <button type="button" id="removeBtn">삭제</button>
			            </div>
		
					        <input type="hidden" name="currPage" value="${pageMaker.cri.currPage }">
					        <input type="hidden" name="amount" value="${pageMaker.cri.amount }">
	           </div>
        </div>
    </div>
</main>

    
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

<script>

//  ================= 공지사항 목록 전체선택 / 전체해제 / 체크 삭제 ========================= 
//  ================== 1. 전체선택, 전체해제 체크박스 =============================

    function selectAll(selectAll)  {
        const checkboxes 
        = document.getElementsByName("item");

        checkboxes.forEach((checkbox) => {
            checkbox.checked = selectAll.checked;
        })

    }

//  ================== 2. 하나라도 선택해제 될 경우 전체선택 해제 =============================

    function checkSelectAll()   {
        // 전체 체크박스
        const checkboxes 
            = document.querySelectorAll('input[name="item"]');
        // 선택된 체크박스
        const checked 
            = document.querySelectorAll('input[name="item"]:checked');
        // select all 체크박스
        const selectAll 
            = document.querySelector('input[name="selectall"]');

        // 만약 체크박스가 하나라도 선택해제되면 전체선택 해제 
        if(checkboxes.length === checked.length)  {
            selectAll.checked = true;
        }else {
            selectAll.checked = false;
        }

    }

</script>

<script>	
//  ================== 5. 버튼을 클릭하면 이동함. =============================

	
		// 글 작성!!
        var registerBtn = document.querySelector('#registerBtn');

        registerBtn.addEventListener('click', function () {
            location = '/admin/product/register';
        }); // registerBtn

      //만약 결과값에 어떤 값이든 들어왔다면(null이 아니라면) -> 결과값을 alert창으로 띄운다.
      
        var result = "${param.result}";
        if(result != null && result != "") {        
            alert('result: ' + result);
        } // if
        

        // 상품 삭제!!
        var removeBtn = document.querySelector('#removeBtn');
        
        removeBtn.addEventListener('click', function(){
            console.log('removeBtn clicked ㅇ_<');
            
            const checkedItems = document.querySelectorAll('input[name="item"]:checked');

            // 체크된 상품의 번호를 배열로 저장
            const checkedItemNos = Array.from(checkedItems).map((item) => item.parentElement.nextElementSibling.textContent);          
            const checkedItemNoValues = Array.from(checkedItems).map((item) => item.parentElement.nextElementSibling.querySelector('input[name="no"]').value);
            
            // 체크된 체크박스가 없는 경우 경고 메시지 출력 후 종료
            if (checkedItems.length === 0) {
                alert("삭제할 상품을 선택해주세요.");
                return;
            }
            
            //form 태그를 조작해서 삭제요청을 전송! 
            var form = document.querySelector('form');
            console.log(form.constructor.prototype);
            
            if (checkedItems.length > 0) {
                
                if(confirm('선택한 상품을 삭제하시겠습니까?')) {
                    
                    // 선택한 상품의 번호를 hidden input 태그에 추가하여 form 요청 전송
                    checkedItemNoValues.forEach((no) => {
                        const hiddenInput = document.createElement('input');
                        hiddenInput.type = 'hidden';
                        hiddenInput.name = 'no';
                        hiddenInput.value = no;
                        form.appendChild(hiddenInput);
                    });
                    
                    form.setAttribute('method', 'POST');
                    form.setAttribute('action', '/admin/product/remove');
                    form.submit();
                    
                    alert("상품이 삭제되었습니다.");
                    location.reload();  // 삭제 후 목록을 새로고침하여 삭제된 상품이 표시되지 않도록 함
                }
            } else {
                alert("상품 삭제에 실패하였습니다.");
            }
        });
 </script>

</html>