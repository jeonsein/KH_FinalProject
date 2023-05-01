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
    
    <link rel="stylesheet" href="../resources/css/search.css">

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,100,1,-25" />

    <script src="https://kit.fontawesome.com/1fe7ba446e.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
    
    <script src="/resources/js/search.js"></script>
	
</head>
<style>
.searchtitle {
padding: 60px 0px;
width: 80%;
margin: 0 auto;
font-size: 28px;
text-align: center;
}
.searchtitle>strong {color: #11BC0D;}
.toptotal>strong {color: #11BC0D;}

.toptotal{
padding: 20px 0 30px 0;
width: 80%;
margin: 0 auto;
font-size: 18px;
}
.listcontent{width: 100%;}
.listproduct{
width: 80%;
margin: 0 auto;
text-align: center;
}
.searchedproduct{
display:inline-block;
margin: 40px;
}
.imgbox>a>img{border-radius: 10px;}


</style>

<body>
<%@include file= "../views/common/header.jsp" %>
 
<!--========== 메인 ==========-->
<main>
    <div class="searchtitle"><strong>'${__PAGE_MAKER__.cri.keyword}'</strong>&nbsp;검색결과</div>

    <div class="listcontent">
      <div class="toptotal">총 <strong>${__PAGE_MAKER__.totalAmount}개</strong>의 상품이 있습니다</div>
	        <div class="listproduct">
        	<c:forEach items="${mainsearchlist}" var="mainsearchlist">
	            <div class="searchedproduct">
	                <ul>
	                    <li>
	                        <div>
	                            <div class="imgbox">
	                                <a href="#"><img src="/resources/product/감자밭.jpg" width="200" height="200" alt="검색상품이미지"></a>
	
	                            </div>
	                            <div class="infobox">
	                                <div>${mainsearchlist.name}</div>
	                             	<div>${mainsearchlist.discount}%</div>
	                                <div>${mainsearchlist.price}</div>
	                                <div>${mainsearchlist.discount_price}</div>
	                            </div>
	                        </div>
	                    </li>
	                </ul>
	            </div>
			</c:forEach>
	        </div>
    </div>
<div>${__PAGE_MAKER__}</div>
</main>
  
<%@include file= "../views/common/footer.jsp" %>
</body>

</html>