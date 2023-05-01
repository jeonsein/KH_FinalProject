<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>상품 정보</title>
<script src="https://kit.fontawesome.com/fc11644ca8.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/product/info.css">

</head>

<body>
    <div class="container">
        <div class="link">
            <span><i class="fa fa-home" style="font-size:20px"></i></span> > <span>농산</span> > <span>국내외과일</span>
        </div> 

        <div class="images">
            <img id="main_img" src="/resources/product/${__INFO__.main_image}" onerror="this.src='https://picsum.photos/id/684/500/400';" alt="">

            <ul class="sub_img" id="sub_img">
                <li><img src="/resources/product/${__INFO__.sub_image1}" alt="이미지1"></li>
                <li><img src="/resources/product/${__INFO__.sub_image2}" alt="이미지2"></li>
                <li><img src="/resources/product/${__INFO__.sub_image3}" alt="이미지3"></li>
                <li><img src="/resources/product/${__INFO__.sub_image4}" alt="이미지4"></li>
            </ul>
        </div>

        
        <div class="info">
            <div class="title">${__INFO__.name}</div>
            <div class="price">일반가 
                <span><fmt:formatNumber type="number" pattern="0,000" value="${__INFO__.price}"  />원</span>
            </div>
            <div class="disprice">할인가 
                <span class="disp"><fmt:formatNumber type="number" pattern="0,000" value="${__INFO__.discount_price}"  />원</span>
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
                <input type="number" id="tPrice" value="${__INFO__.discount_price}" readonly disabled>원

            </div>
            <div class="btn">
                <input type="button" value="장바구니">
                <input type="button"  value="구매하기">
            </div>
        </div> 


        <div class="detailInfo">
            <div class="detailInfoHead">
                <div class="p_Info" id="p_Info" data-target="#p_Info">상품상세정보</div>
                <div class="p_Return" id="p_Return" data-target="#p_Return">교환/반품정보</div>
                <div class="p_recipes" id="p_recipes" data-target="#p_recipes">레시피정보</div>
            </div>
            <div class="de1">
                <div class="p_Info_detail">
                    <!-- <img src="https://picsum.photos/id/1081/600/400" alt=""> -->
                    <p>
                        ${__INFO__.content}
                    </p>

                </div> <!-- 상세 정보 끝 -->

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
                </div> <!-- 교환/반품 끝 -->

                
                <!-- 레시피 정보(공공데이터) -->
                <div class="p_repices_detail">
                    <c:forEach var="api" items="${__API__}" varStatus="status">
                        <div class="recipe_btn_${status.count}" id="recipeBtn">레시피${status.count}. ${api.rcp_nm}</div>

                        <div class="recipe_${status.count}" id="recipeBody">
                            <div class="repice_number">레시피${status.count}.  ${api.rcp_nm}</div>    
                            
                            <c:if test="${api.att_file_no_main != null}">
                                <div><img src="${api.att_file_no_main}" width="400px" height="400px" alt="" onerror="this.style.display='none';"></div>    
                            </c:if>

                            <div class="nu_info">
                                <div class="nu_head"><span class="nu_head_info">영양정보</span> <span class="nu_head_eng">${api.info_eng} kcal</span></div>
                                
                                <c:choose>
                                    <c:when test="${api.info_car != null}">
                                        <div class="nu_car"><span>탄수화물</span> <span class="nu_car_num">${api.info_car} g</span></div>
                                    </c:when>
                                    <c:when test="${api.info_car eq null}">
                                        <div class="nu_car"><span>탄수화물</span> <span class="nu_car_num">-</span></div>
                                    </c:when>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${api.info_pro != null}">
                                        <div class="nu_pro"><span>단백질</span> <span class="nu_pro_num">${api.info_pro} g</span></div>
                                    </c:when>
                                    <c:when test="${api.info_pro eq null}">
                                        <div class="nu_pro"><span>단백질</span> <span class="nu_pro_num">-</span></div>
                                    </c:when>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${api.info_fat != null}">
                                        <div class="nu_fat"><span>지방</span> <span class="nu_fat_num">${api.info_fat} g</span></div>
                                    </c:when>
                                    <c:when test="${api.info_fat eq null}">
                                        <div class="nu_fat"><span>지방</span> <span class="nu_fat_num">-</span></div>
                                    </c:when>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${api.info_na != null}">
                                        <div class="nu_na"><span>나트륨</span> <span class="nu_na_num">${api.info_na} mg</span></div>
                                    </c:when>
                                    <c:when test="${api.info_na eq null}">
                                        <div class="nu_na"><span>나트륨</span> <span class="nu_na_num">-</span></div>
                                    </c:when>
                                </c:choose>
                            </div>
                        
                            <c:if test="${api.rcp_parts_dtls != null}">
                                <div class="food_ing">
                                    <div class="food_head">요리 재료</div> 
                                    <div class="food_val">${api.rcp_parts_dtls}</div> 
                                </div>
                            </c:if>

                            <c:if test="${api.manual01 != null}">
                                <div class="manual">${api.manual01}</div>
                                <div class="manual_img"><img src="${api.manual_img01}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual02 != null}">
                                <div class="manual">${api.manual02}</div>
                                <div class="manual_img"><img src="${api.manual_img02}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>


                            <c:if test="${api.manual03 != null}">
                                <div class="manual">${api.manual03}</div>
                                <div class="manual_img"><img src="${api.manual_img03}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>


                            <c:if test="${api.manual04 != null}">
                                <div class="manual">${api.manual04}</div>
                                <div class="manual_img"><img src="${api.manual_img04}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual05 != null}">
                                <div class="manual">${api.manual05}</div>
                                <div class="manual_img"><img src="${api.manual_img05}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:choose>
                                <c:when test="${api.manual06 eq null || api.manual06 == api.manual_img05}"></c:when>
                                <c:when test="${api.manual06 != null && api.manual06 != api.manual_img05}">
                                    <div class="manual">${api.manual06}</div>
                                    <div class="manual_img"><img src="${api.manual_img06}" onerror="this.style.display='none';"></div>
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${api.manual07 eq null || api.manual07 == api.manual_img06}"></c:when>
                                <c:when test="${api.manual07 != null && api.manual07 != api.manual_img06}">
                                    <div class="manual">${api.manual07}</div>
                                    <div class="manual_img"><img src="${api.manual_img07}" onerror="this.style.display='none';"></div>
                                </c:when>
                            </c:choose>
                            

                            <c:if test="${api.manual08 != null}">
                                <div class="manual">${api.manual08}</div>
                                <div class="manual_img"><img src="${api.manual_img08}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual09 != null}">
                                <div class="manual">${api.manual09}</div>
                                <div class="manual_img"><img src="${api.manual_img09}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual10 != null}">
                                <div class="manual">${api.manual10}</div>
                                <div class="manual_img"><img src="${api.manual_img10}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual11 != null}">
                                <div class="manual">${api.manual11}</div>
                                <div class="manual_img"><img src="${api.manual_img11}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual12 != null}">
                                <div class="manual">${api.manual12}</div>
                                <div class="manual_img"><img src="${api.manual_img12}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual13 != null}">
                                <div class="manual">${api.manual13}</div>
                                <div class="manual_img"><img src="${api.manual_img13}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual14 != null}">
                                <div class="manual">${api.manual14}</div>
                                <div class="manual_img"><img src="${api.manual_img15}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual16 != null}">
                                <div class="manual">${api.manual16}</div>
                                <div class="manual_img"><img src="${api.manual_img16}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual17 != null}">
                                <div class="manual">${api.manual17}</div>
                                <div class="manual_img"><img src="${api.manual_img17}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual18 != null}">
                                <div class="manual">${api.manual18}</div>
                                <div class="manual_img"><img src="${api.manual_img18}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual19 != null}">
                                <div class="manual">${api.manual19}</div>
                                <div class="manual_img"><img src="${api.manual_img19}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.manual20 != null}">
                                <div class="manual">${api.manual20}</div>
                                <div class="manual_img"><img src="${api.manual_img20}" alt="" onerror="this.style.display='none';"></div>
                            </c:if>

                            <c:if test="${api.rcp_na_tip != null}">
                                <div class="tip">* 조리 정보 : ${api.rcp_na_tip}</div>
                            </c:if>
                        </div>
                        
                    </c:forEach>
                </div>

            </div>
        </div> 
        
    </div>
</body>

</html>

<script>
    const main_img = document.querySelector('#main_img');
    const sub_img = document.querySelectorAll('#sub_img > li > img');
    const minus = document.querySelector("#minus");
    const plus = document.querySelector("#plus");
    const p_num = document.querySelector("#p_num");
    const p_Info = document.querySelector(".p_Info");
    const p_Return = document.querySelector(".p_Return");
    const p_recipes = document.querySelector(".p_recipes");
    const tPrice = document.querySelector("#tPrice");

    // mousehover 했을 때 이미지 변경
    sub_img.forEach((el, index) => {
        el.onmouseover = () => {
            let tempSrc = sub_img[index].src;
            main_img.setAttribute('src', tempSrc);
        }
    });

    window.addEventListener('load', () => {
        let num = Number("${__INFO__.discount_price}").toLocaleString();
    })


    let num = 1;
    plus.addEventListener('click', () => {
        num = num + 1;
        p_num.value = num;

        const defaultPrice = "${__INFO__.discount_price}";
        //console.log(defaultPrice);

        let totalPrice = num * defaultPrice;
        tPrice.value = totalPrice;
    });

    minus.addEventListener('click', () => {    
        if(num > 1){
            num = num - 1;
            p_num.value = num;

            const defaultPrice = "${__INFO__.discount_price}";
            const chPrice = tPrice.value;
           
            let totalPrice = chPrice - defaultPrice;
            tPrice.value = totalPrice;

        } else {
            alert('1개부터 구매할 수 있습니다.');
        } // if-else
    });

    p_Info.addEventListener('click', () => {
        document.querySelector('#p_Info').scrollIntoView();   
        document.querySelector('.p_Info_detail').style.display = "block";
        document.querySelector('.p_Return_detail').style.display = "none";
        document.querySelector('.p_repices_detail').style.display = "none";

        p_Info.style.backgroundColor = 'white';
        p_Return.style.backgroundColor = 'lightgray';
        p_recipes.style.backgroundColor = 'lightgray';

        p_Info.style.borderBottom = 'none';
        p_Return.style.borderBottom = '1px solid darkgray';
        p_recipes.style.borderBottom = '1px solid darkgray';
    });

    p_Return.addEventListener('click', () => {
        document.querySelector('#p_Return').scrollIntoView();  
        document.querySelector('.p_Info_detail').style.display = "none";
        document.querySelector('.p_Return_detail').style.display = "block";
        document.querySelector('.p_repices_detail').style.display = "none";

        p_Info.style.backgroundColor = 'lightgray';
        p_Return.style.backgroundColor = 'white';
        p_recipes.style.backgroundColor = 'lightgray';

        p_Return.style.borderBottom = 'none';
        p_Info.style.borderBottom = '1px solid darkgray';
        p_recipes.style.borderBottom = '1px solid darkgray';
    });

    p_recipes.addEventListener('click', () => {
        document.querySelector('#p_recipes').scrollIntoView();  
        document.querySelector('.p_Info_detail').style.display = "none";
        document.querySelector('.p_Return_detail').style.display = "none";
        document.querySelector('.p_repices_detail').style.display = "block";

        p_Info.style.backgroundColor = 'lightgray';
        p_Return.style.backgroundColor = 'lightgray';
        p_recipes.style.backgroundColor = 'white';

        p_Return.style.borderBottom = '1px solid darkgray';
        p_Info.style.borderBottom = '1px solid darkgray';
        p_recipes.style.borderBottom = 'none';

    });

    const reCnt = '${__APICOUNT__}';
   
    if(reCnt == 0 ){
        p_recipes.style.display = 'none';
        p_Info.style.width = '50%';
        p_Return.style.width = '50%';
    }

    for(let i=1; i<=reCnt; i++){
        let reBtn = document.querySelector('.recipe_btn_' + i);
        let reBody = document.querySelector('.recipe_' + i);

        reBtn.addEventListener('click', () => {
            reBody.style.display = 'block';
        });
    }


    // 서브 이미지 오류 처리
    const subImg = document.querySelector(".sub_img > li > img");
    subImg.addEventListener('error', () =>{
    
        for(let i=1; i<=4; i++){
            const imgNo = document.querySelector(".sub_img > li:nth-of-type("+i+") > img" );
            imgNo.style.display = "none";
        } // for
    });


</script>