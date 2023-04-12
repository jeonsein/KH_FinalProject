// 비밀번호 유효성 검사
function pw_input_con() {
    // document.getElementById("pw_input_con").style.display = "block";

    const passwordInput = document.querySelector('#input_pw');
    const passwordCondition = document.querySelector('#pw_input_con');

    const isOk = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,16}$/;


    if (isOk.test(passwordInput.value)) {
        passwordCondition.style.display = 'none'; // 조건 만족 시 안 보이도록 함
    } else {
        passwordCondition.style.display = 'block';
    }
};

// 비밀번호 확인 유효성 검사 
function confirm_pw_input_con() {
    // document.getElementById("confirm_pw_input_con").style.display = "block";


    const input_pw = document.getElementById("input_pw");
    const input_confirm_pw = document.getElementById("input_confirm_pw");
    const confirm_pw_input_con = document.getElementById("confirm_pw_input_con");

    if (input_pw.value != input_confirm_pw.value) {
        confirm_pw_input_con.style.display = "block";
    } else {
        confirm_pw_input_con.style.display = "none";
    }

};

// 이름 유효성 검사
function name_input_con() {
    // document.getElementById("name_input_con").style.display = "block";

    const nameInput = document.querySelector('#input_name');
    const nameCondition = document.querySelector('#name_input_con');

    const isOk = /^[a-zA-Z가-힣]{2,20}$/;


    if (isOk.test(nameInput.value)) {
        nameCondition.style.display = 'none'; // 조건 만족 시 안 보이도록 함
    } else {
        nameCondition.style.display = 'block';
    }
};
// 아이디 유효성 검사
function id_btn() {
    document.getElementById("id_confirm").style.backgroundColor = "#10bc0d"
    // document.getElementById("id_input_con").style.display = "block";
    document.querySelector("#id_confirm").disabled = false;             // 배경, 버튼 활성화

    const input_id = document.getElementById("input_id").value;
    const isOk = /^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,12}$/;

    if (isOk.test(input_id)) {
        document.getElementById("id_input_con").style.display = "none";
    } else {
        document.getElementById("id_input_con").style.display = "block";
    }
};

//이메일 유효성 검사
function email_btn() {
    document.getElementById("email_confirm").style.backgroundColor = "#10bc0d"
    // document.getElementById("email_input_con").style.display = "block";
    document.querySelector("#email_confirm").disabled = false;          // 배경, 버튼 활성화

    const emailInput = document.querySelector('#input_email').value;
    const emailCondition = document.querySelector('#email_input_con');
    const emailConfirm = document.querySelector('#email_confirm');

    var isOk = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/;

    if (isOk.test(emailInput)) {
        emailCondition.style.display = 'none'; // 조건 만족 시 안 보이도록 함
        // emailConfirm.disabled = false; // 버튼 활성화
    } else {
        emailCondition.style.display = 'block';
        // emailConfirm.disabled = true; // 버튼 비활성화
    }
};

// 휴대폰 번호 유효성 검사
function hp_btn() {
    document.getElementById("hp_confirm").style.backgroundColor = "#10bc0d"
    // document.getElementById("hp_input_con").style.display = "block";
    document.querySelector("#hp_confirm").disabled = false;

    const input_hp = document.getElementById("input_hp");
    const hp_input_con = document.getElementById("hp_input_con");

    const isOk = /^\d{10,11}$/;

    if (isOk.test(input_hp.value)) {
        hp_input_con.style.display = "none";
        document.getElementById("hp_confirm").disabled = false;
    } else {
        hp_input_con.style.display = "block";
        // document.getElementById("hp_confirm").disabled = true;
    }
};




// YYYY 유효성 검사 (올해까지)
function validateYYYY(input) {
    const isOk = /^(19|20)\d{2}$/;
    const isValid = input.value === '' || (isOk.test(input.value) && parseInt(input.value) <= new Date().getFullYear());

    // const isValid = isOk.test(input.value) && parseInt(input.value) <= new Date().getFullYear();
    // input.setCustomValidity(isValid ? '' : 'YYYY 형식이 올바르지 않습니다.');
    if (isValid === true) {


    } else {
        document.querySelector('.popmenu11').style.display = 'block';
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
    }
}

// MM 유효성 검사
function validateMM(input) {
    const isOk = /^(0?[1-9]|1[0-2])$/;
    const isValid = input.value === '' || isOk.test(input.value);
    // input.setCustomValidity(isValid ? '' : 'MM 형식이 올바르지 않습니다.');
    if (!isValid) {
        document.querySelector('.popmenu11').style.display = 'block';
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
    }
}

// DD 유효성 검사
function validateDD(input) {
    const yyyy = document.querySelector('.YYYY').value;
    const mm = document.querySelector('.MM').value;
    const lastDay = new Date(yyyy, mm, 0).getDate();
    const isOk = /^(0?[1-9]|[1-2][0-9]|3[0-1])$/;
    const isValid = input.value === '' || isOk.test(input.value) && parseInt(input.value) <= lastDay;
    // input.setCustomValidity(isValid ? '' : 'DD 형식이 올바르지 않습니다.');
    if (!isValid) {
        document.querySelector('.popmenu11').style.display = 'block';
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
    }
}


// 팝업 1 조건에 맞게 입력해주세요
function popup_on1() {
    $(".popmenu1").show();
    popup_blur1(true);
};

function exit1() {
    $(".popmenu1").hide();
    popup_blur1(false);
};

function popup_blur1(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};



// 팝업 2 사용하실 수 있는 아이디입니다
function popup_on2() {
    $(".popmenu2").show();
    popup_blur2(true);
};

function exit2() {
    $(".popmenu2").hide();
    popup_blur2(false);
};

function popup_blur2(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 3 중복된 아이디입니다
function popup_on3() {
    $(".popmenu3").show();
    popup_blur3(true);
};

function exit3() {
    $(".popmenu3").hide();
    popup_blur3(false);
};

function popup_blur3(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 4 사용하실 수 있는 이메일입니다
function popup_on4() {
    $(".popmenu4").show();
    popup_blur4(true);
};

function exit4() {
    $(".popmenu4").hide();
    popup_blur4(false);
};

function popup_blur4(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 5 중복된 이메일입니다
function popup_on5() {
    $(".popmenu5").show();
    popup_blur5(true);
};

function exit5() {
    $(".popmenu5").hide();
    popup_blur5(false);
};

function popup_blur5(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 6 인증번호가 전송되었습니다
function popup_on6() {
    $(".popmenu6").show();
    popup_blur6(true);
    document.querySelector("#num_form").style.display = "block";    // 전송시 인증번호 창 생성
};

function exit6() {
    $(".popmenu6").hide();
    popup_blur6(false);
};

function popup_blur6(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 7 중복된 번호입니다
function popup_on7() {
    $(".popmenu7").show();
    popup_blur7(true);
};

function exit7() {
    $(".popmenu7").hide();
    popup_blur7(false);
};

function popup_blur7(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 8 인증번호가 틀렸습니다
function popup_on8() {
    $(".popmenu8").show();
    popup_blur8(true);
};

function exit8() {
    $(".popmenu8").hide();
    popup_blur8(false);
};

function popup_blur8(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 9 인증시간이 만료되었습니다
function popup_on9() {
    $(".popmenu9").show();
    popup_blur8(true);
};

function exit9() {
    $(".popmenu9").hide();
    popup_blur9(false);
};

function popup_blur9(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};


// 팝업 10 인증되었습니다
function popup_on10() {
    $(".popmenu10").show();
    popup_blur10(true);
};

function exit10() {
    $(".popmenu10").hide();
    popup_blur10(false);
};

function popup_blur10(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 11 날짜형식에 맞게 입력해주세요
function popup_on11() {
    $(".popmenu11").show();
    popup_blur11(true);
};

function exit11() {
    $(".popmenu11").hide();
    popup_blur11(false);
};

function popup_blur11(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};

// 팝업 12 필수 정보를 입력해주세요
function popup_on12() {
    $(".popmenu12").show();
    popup_blur12(true);
};

function exit12() {
    $(".popmenu12").hide();
    popup_blur12(false);
};

function popup_blur12(chk) {
    if (chk === false)
        $('#entire').css({ "opacity": "1", "pointer-events": "auto" });
    else
        $('#entire').css({ "opacity": "0.3", "pointer-events": "none" });
};



// 회원가입 기능

$(document).ready(function () {
    //회원가입 버튼(회원가입 기능 작동)
    $(".가입하기").click(function () {
        $("#signup").attr("action", "/signup/info");
        $("#signup").submit();
    });
});







// 주소 검색 
window.onload = function () {
    var addrElem = document.getElementById("addr");
    var addrBtnElem = document.getElementById("addr_btn");

    addrElem.addEventListener("click", openKakaoPostcode);
    addrBtnElem.addEventListener("click", openKakaoPostcode);
};

function openKakaoPostcode() {
    //카카오 주소
    new daum.Postcode({

        oncomplete: function (data) { //선택시 입력값 세팅
            document.getElementById("addr_form").style.display = "none";	// 주소 검색창 안보이게
            document.getElementById("addr_form2").style.display = "block";
            document.getElementById("addr2").value = data.address; // 주소 넣기
            document.getElementById("detail_addr_form").style.display = "block";
            document.querySelector("#detail_addr").focus(); //상세입력 포커싱
            document.getElementById('postal_code').style.display = "block";
            document.getElementById('post_num').value = data.zonecode;  // 우편번호 가져오기
        }
    }).open();
}



// 아이디 중복 확인

function checkId() {
    var id = $("#input_id").val();    // 아이디 입력값

    $.ajax({
        url: "/signup/infoa",
        type: "post",
        data: { id: id },
        dataType: 'json',
        success: function (cntId) {
            if (cntId == 0) {          // 0이면 사용가능 
                console.log(" 사용가능 ")
                popup_on2();

            } else if (cntId == 1) {                // 1이면 중복
                console.log(" 중복이래 ")
                popup_on3();
                $("#input_id").val("");  //중복시 초기화 
            }
        },
        error: function (xhr, status, error) { // 에러 콜백 함수
            console.error('AJAX 요청 실패:', status, error);
        }
    });
};


// 이메일 중복 확인
function checkEmail() {
    var email = $("#input_email").val();       // 이메일 입력값

    $.ajax({
        url: "/signup/infob",
        type: "post",
        data: { email: email },
        dataType: 'json',
        success: function (cntEmail) {
            if (cntEmail == 0) {                   // 0이면 사용 가능
                popup_on4();
            } else if (cntId == 1) {                          // 1이면 이메일 중복
                popup_on5();
                $("#input_email").val("");  // 중복시 이메일 입력창 초기화
            }
        },
        error: function (xhr, status, error) { // 에러 콜백 함수
            console.log("AJAX 요청 실패", status, error)
        }
    });
};


// 휴대폰 번호 중복 검사 및 인증
function checkHp() {
    var tel = $("#input_hp").val();

    $.ajax({
        url: "/signup/infoc",
        type: "post",
        data: { tel: tel },
        dataType: 'json',
        success: function (cntTel) {
            if (cntTel == 0) {            // 0이면 사용 가능, 인증번호 전송
                popup_on6();
            } else if (cntId == 1) {                  // 1이면 중복
                popup_on7();
                $("#input_hp").val(""); // 휴대폰 번호 창 초기화
            }
        },
        error: function (xhr, status, error) { // 에러 콜백 함수
            console.log("AJAX 요청 실패", status, error)
        }
    });
};


// 인증번호 입력 함수
function num_btn() {    // 입력시 인증하기 버튼 활성화
    document.getElementById("num_confirm").style.backgroundColor = "#10bc0d";
    document.querySelector("#num_confirm").disabled = false;
};