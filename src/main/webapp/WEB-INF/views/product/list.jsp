<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="/ico/circle.ico" type="image/x-icon">
        <link rel="icon" href="/ico/circle.ico" type="image/x-icon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/fc11644ca8.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
        <title>상품 목록</title>

		<link rel="stylesheet" href="/resources/css/list.css">
    </head>
    
    <body>
        <div class="container">
            <h1 class="subject"><a href="/product/list">국내외과일</a></h1>
            <div class="link">
                <span><i class="fa fa-home" style="font-size:20px"></i></span> > <span>농산</span> > <span>국내외과일</span>
            </div> 
    
            <div class="content">
                <aside class="side_search">
                    <form id=search>
                    <ul class="brand"> 브랜드
                        <c:forEach var="bn" items="${__BrandName__}">
                            <li>
                                <input type="checkbox" name="brand" id="brand_check"  value="${bn.brandname}">
                                <label for="brand_check">${bn.brandname}</label>
                            </li>
                        </c:forEach>
                    </ul>
    				</form>
    				
                    <hr>
    
                    <ul> 중량
                        <li>
                            <input type="checkbox">
                            <label for="">50g 이하</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">50 ~ 100g</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">100 ~ 500g</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">500g ~ 1kg</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">1 ~ 2kg</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">2kg 이상</label>
                        </li>
                    </ul>
    
                    <hr>
    
                    <ul> 가격
                        <li>
                            <input type="checkbox">
                            <label for="">5천원 이하</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">5천원 ~ 1만원</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">1만원 ~ 2만원</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">2만원 이상</label>
                        </li>
                    </ul>
                </aside>
    
    			
                <div class="list">
                    
                        <div class="sort">
                            <i class="fa-solid fa-check"></i><div class="sort1" name="row" id="row1" value="best">베스트순</div>
                            <i class="fa-solid fa-check"></i><div class="sort2" name="row" id="row1" value="newProduct">신상품순</div>
                            <i class="fa-solid fa-check"></i><div class="sort3" name="row" id="row1" value="productName">상품명순</div>
                            <i class="fa-solid fa-check"></i><div class="sort4" name="row" id="row1" value="lowPrice">낮은가격순</div>
                           
                            
                            <div class="sort5">
                                <!-- <form name="myform" method="GET"> -->
                                    <select name="number" id="number">
                                        <option value="12" selected>12개씩 보기</option>
                                        <option value="24">24개씩 보기</option>
                                        <option value="36">36개씩 보기</option>
                                    </select>
                                <!-- </form> -->
                            </div>
                        </div>
                        

                    <div class="img_list" id="list">
                        <c:forEach var="productVO" items="${__List__}">
                        <div class="info">
                            <a href="/product/info?pno=${productVO.pno}"><img src="/resources/images/${productVO.image}" width="200" height="200" alt=""></a>
                            <p class="pname">${productVO.pname}</p>
                            <span class="discount">${productVO.discount}%</span> 
                             
                            <span class="disprice"><fmt:formatNumber type="number" pattern="0,000" 
                                value="${productVO.disprice}"  /><span class="won">원</span></span>    
                            <span class="price"><fmt:formatNumber type="number" pattern="0,000" value="${productVO.price}" />원</span>
                          
                          	<!-- <span class="disprice"><fmt:formatNumber type="number" pattern="0,000" 
                                value="${product.price - (product.price * (product.discount / 100)) - (product.price - (product.price * (product.discount / 100))) % 10 }"  /><span class="won">원</span></span>  -->
                        </div>
                        </c:forEach>
                    </div> 
                     
                    
                    <div id="pagination">
                        <!-- 페이지번호목록 표시-->
                        <c:forEach var="pageNum" begin="${__PAGE_MAKER__.startPage}" end="${__PAGE_MAKER__.endPage}">
                            <li class="${param.currPage eq pageNum ? 'currPage' : ''}">
                                <a data-temp="${__PAGE_MAKER__.cri.setCurrPage(pageNum)}"
                                href="/product/list${__PAGE_MAKER__.cri.pagingUri}">${pageNum}</a>
                            </li>
                        </c:forEach>
                    </div>
                    
                    <p id="test1" value="test2"></p>
                </div>

            </div>
        </div>   
    </body>
    <script>

        const url = new URL(window.location.href);
        const urlParams = new URLSearchParams(url.search);
        
        // 한페이지에서 상품목록을 출력하는 개수 설정
        const number = document.querySelector("#number");
        number.addEventListener('change', () => {
            const valueNum = number.options[number.selectedIndex].value;
            const len  = number.options.length;
            
            for(let idx=0; idx<len; idx++){
                if(number.options[idx].value == valueNum){
                    number.options[idx].selected = true;
                } // if
            } // for 

            if(urlParams.has('amount') == true){
                urlParams.set('amount', valueNum);
                location.href = "/product/list?" + urlParams.toString();
            } else {
                location.href = "/product/list?amount="+valueNum;
            } // if-else
        });

        // 상품목록 출력 개수 확인
        const amountVal = urlParams.get('amount');
        for(let idx=0; idx<number.options.length; idx++){
            if(number.options[idx].value == amountVal){
                number.options[idx].selected = true;
            } // if
        } // for 
        
        // 상품목록 정렬 설정
        const row = document.querySelectorAll('div[name="row"]');
        const rowlen = row.length;
        for(let i=0; i<rowlen; i++){
            let rowNum = document.querySelectorAll("#row1")[i];
            rowNum.addEventListener('click', () => {
                let value = $(".sort"+ (i+1)).attr('value');

                const urlpage = new URLSearchParams("${__PAGE_MAKER__.cri.pagingUri}");
                if(urlpage.has('order') == false){
                    urlpage.set("currPage", 1);
                    urlpage.append("order", value);
                } else {
                    urlpage.set("currPage", 1);
                    urlpage.set("order", value);
                } // if-else
                location.href = "/product/list?" + urlpage.toString();  
            });
        } // for

        
        // 사이드 검색 
        // 브랜드
        const br_len = document.querySelectorAll('input[name="brand"]').length;
        const chk_data = new Array();
        let data_cnt = 0
        for(let i=0; i<br_len; i++){
            const brchk = document.querySelectorAll('#brand_check')[i];

            brchk.addEventListener('change', () => {
                let chkTrue = brchk.checked;

                const urlpage = new URLSearchParams("${__PAGE_MAKER__.cri.pagingUri}");
                if(urlpage.has('brand') == true){
                    chk_data[data_cnt] = brand;
                    data_cnt++;
                } // if
                
                chk_data[data_cnt] = brchk.value;
                // 체크가 되었다면 
                if(chkTrue == true){
                    if(urlpage.has('brand') == false){
                        urlpage.set("currPage", 1);
                        urlpage.append("brand", brchk.value);
                    } else {
                        
                        data_cnt++;    
                        urlpage.set("currPage", 1);
                        urlpage.set("brand", chk_data);
                    } // if-else
                    location.href = "/product/list?" + urlpage.toString();
                } else {
                    const brand = urlParams.get('brand');
                    const strIndex = brand.indexOf(',');
                    console.log(brchk.value);
                    if(strIndex > 0){
                        const strSplit = brand.split(',');

                        for(let i=0; i<strSplit.length; i++){
                           if(strSplit[0] == brchk.value) {
                                urlpage.set("brand",brand.replace(strSplit[i] + ',', ''));
                                break;
                           } else if(strSplit[i] == brchk.value) {
                                urlpage.set("brand",brand.replace(',' + strSplit[i],''));
                                break;
                           } // if-else
                        } //for
                        
                        urlpage.set("currPage", 1);
                        location.href = "/product/list?" + urlpage.toString();
                    } else {
                        urlpage.set("currPage", 1);
                        urlpage.delete("brand", brchk.value);
                        location.href = "/product/list?" + urlpage.toString();
                    } // if-else
                } // if-else
            });            
        } // for


        // 브랜드 검색 후 체크 확인
        const brand = urlParams.get('brand');
        if(brand != null) {
            for(let idx=0; idx<br_len; idx++){
                const brandObj = document.querySelectorAll('#brand_check')[idx];
                
                const strIndex = brand.indexOf(',');
                
                if(strIndex > 0){
                    const strSplit = brand.split(',');

                    for(let i=0; i<strSplit.length; i++){
                        if(strSplit[i] == brandObj.value){
                            brandObj.checked = true;
                        } // if 
                    } //for
                } else {
                    if(brand == brandObj.value){
                        brandObj.checked = true;
                    } //if
                } // if-else
            } // for 
        } // if

        const sort_i1 = document.querySelector(".sort > i:nth-of-type(1)");
        const sort_i2 = document.querySelector(".sort > i:nth-of-type(2)");
        const sort_i3 = document.querySelector(".sort > i:nth-of-type(3)");
        const sort_i4 = document.querySelector(".sort > i:nth-of-type(4)");

        const sort1 = document.querySelector(".sort1");
        const sort2 = document.querySelector(".sort2");
        const sort3 = document.querySelector(".sort3");
        const sort4 = document.querySelector(".sort4");

        const order = urlParams.get('order');
        switch(order) {
            case 'best':
                sort_i1.style.visibility = "visible";
                sort1.style.color = "#0000FF";
                break;
            case 'newProduct':
                sort_i2.style.visibility = "visible";
                sort2.style.color = "#0000FF";
                break;
            case 'productName':
                sort_i3.style.visibility = "visible";
                sort3.style.color = "#0000FF";
                break;
            case 'lowPrice':
                sort_i4.style.visibility = "visible";
                sort4.style.color = "#0000FF";
                break;
        } // switch

    </script>
    </html>