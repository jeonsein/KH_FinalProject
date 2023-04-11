<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>

    <style>
        .container{
            width: 80%;
            margin: 20px auto;

            -webkit-touch-callout: none;
            -webkit-user-select: none;
            -khtml-user-select: none;
            -moz-user-select: none;
            -ms-user-selct: none;
            user-select: none;
        } 

        .images{
            /* width: 500px;
            height: 500px; */

            position: relative;
            display: inline-block;

            margin: 50px 100px;
            /* border: 1px solid blue; */
        }

        #main_img {
            width: 500px;
            height: 400px;
        }

        ul {
            padding: 0;
        }

        .sub_img > li{
            display: inline-block;
            margin: 0;
        }

        .sub_img > li > img {
            width: 110px;
            height: 100px;

            padding: 0 5px;
        }

        .sub_img > li:nth-of-type(0) {
            float: left;
        }

        .sub_img > li:nth-last-of-type(3) {
            float: right;
        }

        .info {
            /* width: 500px;
            height: 500px; */

            position: absolute;
            display: inline-block;

            margin: 50px auto;

            /* border: 1px solid red; */
        }

        .info > div {
            margin: 0 0 30px;
        }

        .title {
            font-size: 2rem;
            font-weight: bold;
        }

        .price .disprice {
            font-size: 1.1rem;
        }

        .price > span {
            margin: 0 0 0 60px;
            font-size: 1rem;
        }

        .disp {
            margin: 0 0 0 60px;

            font-size: 1.5rem;
            font-weight: bold;
        }

        .disc {
            padding: 0 30px;

            font-size: 1.8rem;
            font-weight: bold;
            color: #06e19a;
        }

        .buyNum {
            margin: 0 !important;
        }
        .totalPrice > span {
            margin: 0 0 0 100px;
        }

        .totalPrice > input {
            width: 15%;

            margin: 0 0 0 10px;

            font-size: 1.8rem;
            font-weight: bold;

            border: none;
            outline: none;
        }

        .num {
            display: inline-block;

            border: 1px solid gray;
        }

        .num > li {
            display: inline-block;
            margin: 0;

            padding: 5px 5px;
        }

        #minus {
            cursor: pointer;
        }

        #plus {
            cursor: pointer;
        }

        #p_num{
            width: 20px;;
            border: none;

            text-align: center;
        }

        .btn > input {
            width: 150px;
            height: 50px;
        }

        .btn > input:nth-of-type(1){
            margin: 0 20px 0 0;

            font-weight: bold;
            background-color: #06e19a;
            border: none;
            color: #ffffff
        }

        .btn > input:nth-of-type(2) {
            font-weight: bold;
            background-color: #000000;
            border: none;
            color: #ffffff
        }





        .detailInfo {
            position: absolute;

            width: 60%;
            height: 100%;
            
            margin: 50px 100px;
            /* border: 1px solid red; */
        }

        .p_Info {
            position: relative;

            width: 50%;
            height: 50px;

            display: inline-block;

            text-align: center;
            line-height: 50px;

            font-weight: bold;
            
            border: 1px solid darkgray;
            border-bottom: 1px;
        }

        .p_Return {
            position: absolute;

            width: 50%;
            height: 50px;

            display: inline-block;

            text-align: center;
            line-height: 50px;
            
            font-weight: bold;

            border: 1px solid darkgray;
            border-left: 0;

            background-color: lightgray;
        }

        .de1 {
            margin: 30px;
        }

        .p_Info_detail {
            text-align: center;
        }

        .p_Return_detail {
            display: none;
        }

        .rep {
            font-size: 14px;
            line-height: 25px;
        }

        table{
            width: 100%;
        }

        .td1, .td3 {
            width: 20%;

            font-size: 13px;
            text-align: center;
            line-height: 20px;

            background-color: #F5F4F4;

            border-top: 1px solid lightgray;
        }

        .td2, .td4 {
            padding: 5px 15px;

            font-size: 13px;
            border-top: 1px solid lightgray;
        }

        .td3, .td4 {
            border-bottom: 1px solid lightgray;
        }

        .td5, .td7, .td9 {
            width: 20%;

            font-size: 13px;
            text-align: center;

            background-color: #F5F4F4;

            border-top: 1px solid lightgray;
        }

        .td6, .td8, .td10 {


            padding: 10px 15px;

            font-size: 13px;
            border-top: 1px solid lightgray;
        }

        .td9, .td10 {
            border-bottom: 1px solid lightgray;
        }

        .head {
            padding: 50px 0 0 0;
        }

        .rep_lim {
            font-size: 14px;
            line-height: 25px;;
        }
    </style>

</head>

<body>
    <div class="container">
        <div class="link">
            <span><i class="fa fa-home" style="font-size:20px"></i></span> > <span>농산</span> > <span>국내외과일</span>
        </div> 

        <div class="images">
            <img id="main_img" src="/resources/images/${__INFO__.image}" alt="">

            <ul class="sub_img" id="sub_img">
                <li><img src="/resources/images/${__INFO__.subimage1}" alt=""></li>
                <li><img src="/resources/images/${__INFO__.subimage2}" alt=""></li>
                <li><img src="/resources/images/${__INFO__.subimage3}" alt=""></li>
                <li><img src="/resources/images/${__INFO__.subimage4}" alt=""></li>
            </ul>
        </div>

        
        <div class="info">
            <div class="title">${__INFO__.pname}</div>
            <div class="price">일반가 
                <span><fmt:formatNumber type="number" pattern="0,000" value="${__INFO__.price}"  />원</span>
            </div>
            <div class="disprice">할인가 
                <span class="disp"><fmt:formatNumber type="number" pattern="0,000" value="${__INFO__.disprice}"  />원</span>
                <span class="disc">${__INFO__.discount}%</span>
            </div>
            <div class="buyNum">구매수량</div>
            <div class="totalPrice"> 
                <ul class="num">
                    <li id="minus">-</li>
                    <li><input type="text" id="p_num" value="1" readonly disabled></li>
                    <li id="plus">+</li>
                </ul>       
                <span> 총 상품 금액 </span> 
                <input type="number" id="tPrice" value="${__INFO__.disprice}" readonly disabled>원
            </div>
            <div class="btn">
                <input type="button" value="장바구니">
                <input type="button"  value="구매하기">
            </div>
        </div>


        <div class="detailInfo">
            <div class="p_Info" id="p_Info" data-target="#p_Info">상품상세정보</div>
            <div class="p_Return" id="p_Return" data-target="#p_Return">교환/반품정보</div>

            <div class="de1">
                <div class="p_Info_detail">
                    <img src="https://picsum.photos/id/1081/600/400" alt="">

                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt illo quibusdam quis molestiae mollitia eos eveniet provident ea vel, perferendis amet veniam, corporis repellendus consectetur accusantium ex ullam eius illum!
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates nobis non, rerum id porro dolorem molestiae officiis quaerat omnis! Voluptatibus cum sint beatae tenetur molestiae distinctio culpa modi, necessitatibus vitae ipsa at exercitationem repellat fugiat ab nostrum facilis libero aut ducimus officia voluptates dolore quae quos. Esse autem voluptatibus qui dolores, veniam fugit earum dignissimos saepe consectetur necessitatibus doloribus explicabo ut enim! Molestias accusamus voluptate dolor ut repellendus! Rerum est nam deserunt temporibus totam dolorum, consectetur odit ut commodi sit culpa atque sint aperiam perferendis amet aliquam saepe molestiae dignissimos quibusdam exercitationem. Voluptatem totam neque molestias molestiae eius laboriosam suscipit.
                    </p>
                </div>

                <div class="p_Return_detail" >
                    <h2>교환/반품 안내</h2>

                    <p class="rep">
                        &#183; 교환/반품에 관한 일반적인 사항은 판매자가 제시사항보다 관계법령이 우선합니다.<br>
                        다만, 판매자의 제시사항이 관계법령보다 소비자에게 유리한 경우에는 판매자 제시사항이 적용됩니다.
                    </p>

                    <p>
                        <table>
                            <tr>
                                <td class="td1">교환/반품 비용</td>
                                <td class="td2">1. [총 주문금액]-[반품 상품금액] = 20,000원 미만인 경우 반품비 5,000원<br>
                                    2. [총 주문금액]-[반품 상품금액] = 20,000원 이상인 경우 반품비 2,500원
                                </td>
                            </tr>
                            <tr>
                                <td class="td3">교환/반품 신청 기준일</td>
                                <td class="td4">1. 단순 변심에 의한 상품의 교환/반품은 수령 후 30일 이내까지 가능<br>
                                    (단, 신선/냉장/냉동 상품의 경우 단순변심에 의한 반품이 제한됩니다.)<br>
                                    2. 상품의 내용이 표시/광고의 내용과 다른 경우에는 상품을 수령한 날부터
                                    3개월 이내, 그 사실을 안 날부터 30일 이내에 가능
                                </td>
                            </tr>
                        </table>
                    </p>
                    
                    <h2 class="head">무료 교환/반품 </h2>
                    <p>
                        <table>
                            <tr>
                                <td class="td5">미출고</td>
                                <td class="td6">결품이나 누락으로 인한 전체 미출고</td>
                            </tr>
                            <tr>
                                <td class="td7">상품 파손</td>
                                <td class="td8">고객이 아닌 출고나 배송중 파손의 경우</td>
                            </tr>
                            <tr>
                                <td class="td9">오배송</td>
                                <td class="td10">주문 상품과 상이한 상품 배송시</td>
                            </tr>
                        </table>
                    </p>

                    <h2 class="head">교환/반품 제한사항</h2>
                    <p class="rep_lim">
                        &#183; 주문/제작 상품의 경우 상품의 제작이 이미 진행된 경우<br>
                        &#183; 상품 포장을 개봉하여 사용 후 상품의 가치가 훼손된 경우<br>
                               (단, 내용 확인을 위한 포장 개방의 경우는 예외)<br>
                        &#183; 고객의 사용, 시간경과, 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우<br>
                        &#183; 고객이 단순 변심으로 교환/반품을 무료로 요청한 경우
                    </p>


                </div>
            </div>
        </div>

    </div>
</body>

<script>
    const main_img = document.querySelector('#main_img');
    const sub_img = document.querySelectorAll('#sub_img > li > img');
    const minus = document.querySelector("#minus");
    const plus = document.querySelector("#plus");
    const p_num = document.querySelector("#p_num");
    const p_Info = document.querySelector(".p_Info");
    const p_Return = document.querySelector(".p_Return");
    
    
    

    // mousehover 했을 때 이미지 변경
    sub_img.forEach((el, index) => {
        el.onmouseover = () => {
            let tempSrc = sub_img[index].src;
            main_img.setAttribute('src', tempSrc);
        }
    });

    let num = 1;
    plus.addEventListener('click', () => {
        num = num + 1;
        p_num.value = num;

        const defaultPrice = "${__INFO__.disprice}";
        //console.log(defaultPrice);

        let totalPrice = num * defaultPrice;
        tPrice.value = totalPrice;
    });

    minus.addEventListener('click', () => {    
        if(num > 1){
            num = num - 1;
            p_num.value = num;

            const defaultPrice = "${__INFO__.disprice}";
            const chPrice = tPrice.value;
           
            let totalPrice = chPrice - defaultPrice;
            tPrice.value = totalPrice;
        } else {
            alert('1개부터 구매할 수 있습니다.');
        } // if-else
    });

    p_Info.addEventListener('click', () => {
        document.querySelector('#p_Info').scrollIntoView();   
        document.querySelector('.p_Return_detail').style.display = "none";
        document.querySelector('.p_Info_detail').style.display = "block";

        p_Info.style.backgroundColor = 'white';
        p_Return.style.backgroundColor = 'lightgray';

        p_Info.style.borderBottom = 'none';
        p_Return.style.borderBottom = '1px solid darkgray';
    });

    p_Return.addEventListener('click', () => {
        document.querySelector('#p_Return').scrollIntoView();  
        document.querySelector('.p_Info_detail').style.display = "none";
        document.querySelector('.p_Return_detail').style.display = "block";

        p_Info.style.backgroundColor = 'lightgray';
        p_Return.style.backgroundColor = 'white';

        p_Return.style.borderBottom = 'none';
        p_Info.style.borderBottom = '1px solid darkgray';
    });


    

</script>

</html>