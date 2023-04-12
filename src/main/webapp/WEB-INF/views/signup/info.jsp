<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/signup/css/info.css">
     <%@include file="/WEB-INF/views/common/favicon.jsp" %>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="../resources/signup/js/info.js"></script>
     <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
     
     <%@page import="java.util.Date" %>

<%@page import="java.text.SimpleDateFormat" %>

    <title>MOYAMOGA</title>

    
</head>

<body>
	 
    <div id="entire">
		
		<%@include file="../common/header.jsp"%>


		<div class='wrapper'>

			<div class="탑로고">
				<img id="logo" src="../resources/imgs/logo.png">
			</div>
			<div class="가입단계">
				<div id="가입단계1">약관동의</div>
				<div class="triangle"></div>
				<div id="가입단계2">회원 정보 입력</div>
				<div class="triangle"></div>
				<div id="가입단계3">가입 완료</div>
			</div>

			<h1>회원가입</h1>

			<div class="wrapper-input">
				<div class='필수입력'>
					<span id="필수빨강">*</span> 필수 입력
				</div>

				<div class='line'></div>

				<div class="정보">
					<form action="/signup/info" id="signup" method="post"
						autocomplete="off">

						<div>
							<label class="라벨">아이디<span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="input_id" name="id" method="post"
								onkeyup="id_btn();" placeholder="아이디를 입력해주세요" autofocus>

							<input form="id_form" type="submit" class='인증' id="id_confirm"
								value="중복확인" onclick="checkId();" disabled>
							<div class='입력조건' id="id_input_con">6~12자 영문 또는 영문 + 숫자 조합</div>
						</div>

						<div>
							<label class="라벨">비밀번호<span id="필수빨강">*</span></label> <input
								type="password" class='회원정보' id="input_pw" name="password"
								method="post" oninput="pw_input_con()"
								placeholder="비밀번호를 입력해주세요">

							<div class='입력조건' id="pw_input_con">대/소문자 구분, 숫자 8~16자</div>
						</div>

						<div>
							<label class="라벨">비밀번호 확인<span id="필수빨강">*</span></label> <input
								type="password" class='회원정보' method="post" id="input_confirm_pw"
								oninput="confirm_pw_input_con()"
								placeholder="비밀번호를 한 번 더 입력해주세요">

							<div class='입력조건' id="confirm_pw_input_con">비밀번호 불일치</div>
						</div>

						<div>
							<label class="라벨">이름<span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="input_name" name="name"
								method="post" oninput="name_input_con()"
								placeholder="이름을 입력해주세요">

							<div class='입력조건' id="name_input_con">한글 또는 영문 2~20자</div>
						</div>

						<div>
							<label class="라벨">이메일 <span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="input_email" name="email"
								method="post" onkeyup="email_btn();" placeholder="이메일을 입력해주세요">

							<input form="email_form" type="submit" class='인증'
								id="email_confirm" value="중복확인" onclick="checkEmail();" disabled>
							<div class='입력조건' id="email_input_con">이메일 형식에 맞게 입력해주세요</div>
						</div>

						<div>
							<label class="라벨">휴대폰 번호<span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="input_hp" name="tel" method="post"
								onkeyup="hp_btn();" placeholder="휴대폰 번호를 입력해주세요"> <input
								form="hp_form" type="submit" class='인증' id="hp_confirm"
								value="휴대폰인증" onclick="checkHp();" disabled>

							<div class='입력조건' id="hp_input_con">숫자만 입력해 주세요</div>
						</div>

						<div id="num_form">
							<label class="라벨">인증번호 입력<span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="input_num" method="post"
								oninput="num_btn()" placeholder="인증번호를 입력해주세요"> <input
								form="num_from" type="submit" class='인증' id="num_confirm"
								value="인증하기" disabled>
						</div>



						<div id="addr_form">
							<label class="라벨">주소<span id="필수빨강">*</span></label> <input
								form="addr_form" type="submit" class='회원정보' id="addr"
								value="주소검색">
						</div>

						<div id="postal_code">
							<label class="라벨">우편번호</label> <input type="text" class='회원정보'
								id="post_num" name="address1">
						</div>

						<div id="addr_form2">
							<label class="라벨">주소<span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="addr2" name="address2" readonly>
							<input type="button" id="addr_btn" value="재검색">
						</div>

						<div id=detail_addr_form>
							<label class="라벨">상세주소<span id="필수빨강">*</span></label> <input
								type="text" class='회원정보' id="detail_addr" name="address3"
								placeholder="상세주소를 입력해주세요">
						</div>

						<div id="gender_form" class="성별" name="gender">
							<label class="라벨">성별</label> <input type="radio" name="gender"
								value="남자" id="남자">남자 <input type="radio" name="gender"
								value="여자" id="여자">여자 <input type="radio" name="gender"
								value="" id="선택안함" checked>선택안함
						</div>

						<div id="birth_form" class="생년월일" name="birth_date">
							<label class="라벨">생년월일</label> <span> <input type="text"
								class='YYYY' placeholder="YYYY" onblur="validateYYYY(this)">
								<input type="text" class='MM' placeholder="MM"
								onblur="validateMM(this)"> <input type="text" class='DD'
								placeholder="DD" onblur="validateDD(this)">
							</span>
						</div>

						<div class="하단버튼">
							<button type="submit" class='가입하기'>가입하기</button>

							<div>
								<a id="다음에" href="agreement"><span class="이전단계">이전단계</span></a>
							</div>

						</div>
						<% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  								String currentDate = dateFormat.format(new Date()); %>

						<input type="hidden" name="signup_date" value="<%= currentDate %>">
						<input type="hidden" name="adminCk" value="0">
					</form>
				</div>
			</div>
		</div>

		<%@include file= "../common/footer.jsp" %>

        </div>



    <!-- 팝업 -->
     <div class="popmenu1" id="common_pop">
        <p>조건에 맞게 입력해주세요</p>
        <input type="button" class="exit1" id="common_btn" onclick="exit1()" value="확인">
    </div>

    <div class="popmenu2" id="common_pop">
        <p>사용하실 수 있는 아이디입니다</p>
        <input type="button" class="exit2" id="common_btn" onclick="exit2()" value="확인">
    </div>

    <div class="popmenu3" id="common_pop">
        <p>중복된 아이디입니다</p>
        <input type="button" class="exit3" id="common_btn" onclick="exit3()" value="확인">
    </div>

    <div class="popmenu4" id="common_pop">
        <p>사용하실 수 있는 이메일입니다</p>
        <input type="button" class="exit4" id="common_btn" onclick="exit4()" value="확인">
    </div>

    <div class="popmenu5" id="common_pop">
        <p>중복된 이메일입니다</p>
        <input type="button" class="exit5" id="common_btn" onclick="exit5()" value="확인">
    </div>

    <div class="popmenu6" id="common_pop">
        <p>인증번호가 전송되었습니다</p>
        <input type="button" class="exit6" id="common_btn" onclick="exit6()" value="확인">
    </div>

    <div class="popmenu7" id="common_pop">
        <p>중복된 번호입니다</p>
        <input type="button" class="exit7" id="common_btn" onclick="exit7()" value="확인">
    </div>

    <div class="popmenu8" id="common_pop">
        <p>인증번호가 틀렸습니다</p>
        <input type="button" class="exit8" id="common_btn" onclick="exit8()" value="확인">
    </div>

    <div class="popmenu9" id="common_pop">
        <p>인증시간이 만료되었습니다</p>
        <input type="button" class="exit9" id="common_btn" onclick="exit9()" value="확인">
    </div>

    <div class="popmenu10" id="common_pop">
        <p>인증되었습니다</p>
        <input type="button" class="exit10" id="common_btn" onclick="exit10()" value="확인">
    </div>

    <div class="popmenu11" id="common_pop">
        <p>날짜형식에 맞게 입력해주세요</p>
        <input type="button" class="exit11" id="common_btn" onclick="exit11()" value="확인">
    </div>

    <div class="popmenu12" id="common_pop">
        <p>필수 정보를 입력해주세요</p>
        <input type="button" class="exit12" id="common_btn" onclick="exit12()" value="확인">
	</div>
</body>

</html>