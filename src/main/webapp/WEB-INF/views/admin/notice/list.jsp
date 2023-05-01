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
    <!-- <link href="/admin_page/css/notice/notice_list.css" type="text/css" rel="stylesheet" /> -->
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
            <table id="list">
                <h2>공지사항 <span class="test">테스트</span></h2>
                <!-- <a href="javascript:all_del()">전체선택 / 전체해제</a> -->
                <thead>
	                <tr>
	                    <th><input type="checkbox" name="selectall" value="selectall" onclick="selectAll(this)"></th>
	                    <th>번호</th>
	                    <th>제목</th>
	                    <th>작성날짜</th>
	                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="NoticeVO">
                        <tr>
                        	<td><input type="checkbox" name="item" onclick="checkSelectAll()" /></td>
                            <td>${NoticeVO.no}</td>
                            <td><a href="/admin/notice/get?no=${NoticeVO.no}">${NoticeVO.title}</a></td>
                            <td>${NoticeVO.reg_date}</td>
                        </tr>       
                    </c:forEach>    
                </tbody>
            </table>
            
            
	 		<div class="pageInfo_wrap" >
			  <form id=moveForm method="get">
			    <div class="pageInfo_area">
			    	<ul id="pageInfo" class="pageInfo">
			    	
			    		<!-- 이전페이지 버튼 -->
			            <c:if test="${pageMaker.prev}">
			                <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
			            </c:if>
			            
		            	<!-- 각 번호 페이지 버튼 -->
		                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		                    <li class="pageInfo_btn "><a href="/admin/notice/list?currPage=${num}&amount=${pageMaker.cri.amount}">${num}</a></li>
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
		        </form>
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
    
//  ================== 3. 삭제 버튼 클릭 이벤트 처리 =============================

    document.getElementById("removeBtn").addEventListener("click", function() {
        const checkboxes = document.querySelectorAll('input[name="item"]:checked');
        const noticeNos = [];

        // 체크된 체크박스의 값을 배열에 추가
        checkboxes.forEach((checkbox) => {
            noticeNos.push(checkbox.parentNode.nextElementSibling.textContent);
        });

        // 컨트롤러에 전달할 파라미터 생성
        const formData = new FormData();
        formData.append("noticeNos", JSON.stringify(noticeNos));

        // AJAX 요청 보내기
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/admin/notice/remove");
        xhr.onload = function() {
            if (xhr.status === 200 || xhr.status === 201) {
                // 처리 결과에 따라 페이지 이동
                const response = JSON.parse(xhr.response);
                if (response.success) {
                    alert("게시글이 삭제되었습니다.");
                    location.reload();
                } else {
                    alert("게시글 삭제에 실패하였습니다.");
                }
            }
        }
        xhr.send(formData);
    });    

</script>
<script>
    // 삭제 버튼 클릭 시
    document.getElementById('removeBtn').addEventListener('click', function() {
        // 체크된 체크박스를 모두 가져옴
        const checkboxes = document.querySelectorAll('input[name="item"]:checked');

        // 체크된 체크박스의 값을 배열로 저장
        const checkedValues = Array.from(checkboxes).map(checkbox => checkbox.value);

        // 체크된 체크박스가 없을 경우
        if (checkedValues.length === 0) {
            alert('삭제할 게시글을 선택해주세요.');
            return;
        }

        // 게시글 삭제 요청을 보낼 URL
        const url = '/admin/product/remove';

        // POST 방식으로 데이터 전송을 위한 폼 생성
        const form = document.createElement('form');
        form.setAttribute('method', 'post');
        form.setAttribute('action', url);

        // 체크된 게시글 번호를 각각의 hidden input으로 추가
        checkedValues.forEach(function(value) {
            const input = document.createElement('input');
            input.setAttribute('type', 'hidden');
            input.setAttribute('name', 'no');
            input.setAttribute('value', value);
            form.appendChild(input);
        });

        // 전체 선택 체크박스의 상태를 저장
        const selectAllCheckbox = document.querySelector('input[name="selectall"]');
        const selectAllChecked = selectAllCheckbox.checked;

        // criteria 값 추가
        const criteria = {
            page: 1,
            perPageNum: 10,
            type: '',
            keyword: ''
        };

        for (const key in criteria) {
            const input = document.createElement('input');
            input.setAttribute('type', 'hidden');
            input.setAttribute('name', 'criteria.' + key);
            input.setAttribute('value', criteria[key]);
            form.appendChild(input);
        }

        // 전체 선택 체크박스의 상태를 폼에 추가
        const selectAllInput = document.createElement('input');
        selectAllInput.setAttribute('type', 'hidden');
        selectAllInput.setAttribute('name', 'selectAll');
        selectAllInput.setAttribute('value', selectAllChecked);
        form.appendChild(selectAllInput);

        // 폼을 body에 추가하고 전송
        document.body.appendChild(form);
        form.submit();
    });
</script>
<script>	
//  ================== 5. 버튼을 클릭하면 이동함. =============================

	
		// 글 작성!!
        var registerBtn = document.querySelector('#registerBtn');

        registerBtn.addEventListener('click', function () {
            location = '/admin/notice/register';
        }); // registerBtn

      //만약 결과값에 어떤 값이든 들어왔다면(null이 아니라면) -> 결과값을 alert창으로 띄운다.
      
        var result = "${param.result}";
        if(result != null && result != "") {        
            alert('result: ' + result);
        } // if
        
        
 </script>
</html>