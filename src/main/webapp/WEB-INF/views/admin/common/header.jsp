<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/admin/common.css">
</head>
<!-- 헤더 - 로그인/로그아웃 로고, 관리자페이지 메인글씨 -->
<header>
    <div class="state">
        <span class="login">admin님 로그인하였습니다</span>
        <span class="login">Ι</span>
        <span class="login"><a href="/main">홈페이지</a></span>
        <span class="login">Ι</span>
        <span class="login"><a href="/logout">로그아웃</a></span>
    </div>
    <div>
        <h1><a href="/admin/main"><img src="/resources/css/admin/logo.png" id="logo" width="200"></a></h1> 
    </div>
    <h2 class="admin">관리자 페이지</h2>
    
</header>

<!-- 메인 - 보라색 가로줄(메인페이지글자), 왼쪽 메뉴 -->
<main>
    <div class="sub_content">
        <nav></nav>
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
	</div>
</main>
</body>
</html>