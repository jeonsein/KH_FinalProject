<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>errorpage.jsp</title>
</head>
<body>
    <h1><%= request.getRequestURI() %></h1>
    <hr>

    <p><%= exception %></p>
    <p>${__EXCEPTION__}</p>

    <h2>시스템에 잠시 문제가 발생하였습니다.</h2>
    <h2>잠시후에 다시 시도해주세요</h2>

</body>
</html>