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

		<link rel="stylesheet" href="/resources/css/product/list.css">
    </head>
    
    <body>
        <div class="container">
            <div>
                <c:forEach var="cate1" items="${__CategoryAll__}">
                    <li style="display: inline-block; list-style: none;"><a href="/product/list?code=${cate1.code}">${cate1.categoryName}</a></li>
                </c:forEach>
            </div>

            <c:forEach var="cate" items="${__Category__}">
                <h1 class="subject"><a href="/product/list?code=${cate.code}">${cate.categoryName}</a></h1>
            
                <div class="link">
                    <span><i class="fa fa-home" style="font-size:20px"></i></span> > <span>농산</span> > <span>${cate.categoryName}</span>
                </div> 
            </c:forEach>

            <div class="content">
                <aside class="side_search">
                    <ul> 원산지
                        <c:forEach var="bn" items="${__OriginName__}">
                            <li>
                                <input type="checkbox" name="origin" id="origin_check"  value="${bn.origin}">
                                <label for="origin_check">${bn.origin}</label>
                            </li>
                        </c:forEach>
                    </ul>

                    <hr>
    
                    <ul> 중량
                        <li>
                            <input type="checkbox" name="weight" id="weight_check" value="w1">
                            <label for="weight_check">50g 이하</label>
                        </li>
                        <li>
                            <input type="checkbox" name="weight" id="weight_check" value="w2">
                            <label for="weight_check">50 ~ 100g</label>
                        </li>
                        <li>
                            <input type="checkbox" name="weight" id="weight_check" value="w3">
                            <label for="weight_check">100 ~ 500g</label>
                        </li>
                        <li>
                            <input type="checkbox" name="weight" id="weight_check" value="w4">
                            <label for="weight_check">500g ~ 1kg</label>
                        </li>
                        <li>
                            <input type="checkbox" name="weight" id="weight_check" value="w5">
                            <label for="weight_check">1 ~ 2kg</label>
                        </li>
                        <li>
                            <input type="checkbox" name="weight" id="weight_check" value="w6">
                            <label for="weight_check">2kg 이상</label>
                        </li>
                    </ul>
    
                    <hr>
    
                    <ul class="sp"> 가격
                        <li>
                            <div name="search_price" id="price1" value="p1">5천원 이하</div>
                        </li>
                        <li>
                            <div name="search_price" id="price2" value="p2">5천원 ~ 1만원</div>
                        </li>
                        <li>
                            <div name="search_price" id="price3" value="p3">1만원 ~ 2만원</div>
                        </li>
                        <li>
                            <div name="search_price" id="price4" value="p4">2만원 이상</div>
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
                            <select name="number" id="number">
                                <option value="12" selected>12개씩 보기</option>
                                <option value="24">24개씩 보기</option>
                                <option value="36">36개씩 보기</option>
                            </select>
                        </div>
                    </div>
                        
                    <div class="img_list" id="list">   
                        <c:if test="${empty __List__}" > 
                            <p class="empty"> 내용이 없습니다.</p>
                        </c:if> 
                        <c:forEach var="productVO" items="${__List__}">
                            <div class="info">
                                <a href="/product/info?no=${productVO.no}"><img src="/resources/product/${productVO.main_image}" width="200" height="200" alt=""></a>
                                <p class="pname">${productVO.name}</p>
                                <span class="discount">${productVO.discount}%</span> 
                                    
                                <span class="disprice"><fmt:formatNumber type="number" pattern="0,000" 
                                    value="${productVO.discount_price}"  /><span class="won">원</span></span>    
                                <span class="price"><fmt:formatNumber type="number" pattern="0,000" value="${productVO.price}" />원</span>
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
        
        // 현재 페이지에서 상품목록을 출력하는 개수 설정
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

        // 상품 정렬 체크 확인
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

        
        // 사이드 검색 
        // 원산지
        const br_len = document.querySelectorAll('input[name="origin"]').length;
        const chk_data_origin = new Array();
        let data_cnt_origin = 0
        for(let i=0; i<br_len; i++){
            const brchk = document.querySelectorAll('#origin_check')[i];

            brchk.addEventListener('change', () => {
                let chkTrue = brchk.checked;

                const urlpage = new URLSearchParams("${__PAGE_MAKER__.cri.pagingUri}");
                if(urlpage.has('origin') == true){
                    chk_data_origin[data_cnt_origin] = origin;
                    data_cnt_origin++;
                } // if
                
                chk_data_origin[data_cnt_origin] = brchk.value;
                
                // 체크가 되었다면 
                if(chkTrue == true){
                    if(urlpage.has('origin') == false){
                        urlpage.set("currPage", 1);
                        urlpage.append("origin", brchk.value);
                    } else {
                        data_cnt_origin++;    
                        urlpage.set("currPage", 1);
                        urlpage.set("origin", chk_data_origin);
                    } // if-else
                    location.href = "/product/list?" + urlpage.toString();
                } else {
                    const origin = urlParams.get('origin');
                    const strIndex = origin.indexOf(',');
                    // console.log(brchk.value);
                    if(strIndex > 0){
                        const strSplit = origin.split(',');

                        for(let i=0; i<strSplit.length; i++){
                           if(strSplit[0] == brchk.value) {
                                urlpage.set("origin",origin.replace(strSplit[i] + ',', ''));
                                break;
                           } else if(strSplit[i] == brchk.value) {
                                urlpage.set("origin",origin.replace(',' + strSplit[i],''));
                                break;
                           } // if-else
                        } //for
                        
                        urlpage.set("currPage", 1);
                        location.href = "/product/list?" + urlpage.toString();
                    } else {
                        urlpage.set("currPage", 1);
                        urlpage.delete("origin", brchk.value);
                        location.href = "/product/list?" + urlpage.toString();
                    } // if-else
                } // if-else
            });            
        } // for


        // 브랜드 검색 후 체크 확인
        const origin = urlParams.get('origin');
        if(origin != null) {
            for(let idx=0; idx<br_len; idx++){
                const originObj = document.querySelectorAll('#origin_check')[idx];
                const strIndex = origin.indexOf(',');
                
                if(strIndex > 0){
                    const strSplit = origin.split(',');

                    for(let i=0; i<strSplit.length; i++){
                        if(strSplit[i] == originObj.value){
                            originObj.checked = true;
                        } // if 
                    } //for
                } else {
                    if(origin == originObj.value){
                        originObj.checked = true;
                    } //if
                } // if-else
            } // for 
        } // if

        // 중량(무게)
        const we_len = document.querySelectorAll('input[name="weight"]').length;  //6
        const chk_data_weight = new Array();  // 배열 생성
        let chk_cnt_weight = 0;     // 인덱스
        const weight = urlParams.get('weight');
        
        for(let i=0; i<we_len; i++){
            const wechk = document.querySelectorAll('#weight_check')[i];

            wechk.addEventListener('change', () => {
                const chkTrue_weight = wechk.checked;  // 체크여부 확인

                const urlpage = new URLSearchParams("${__PAGE_MAKER__.cri.pagingUri}"); // 현재 보여지는 URL+URI 정보
                if(urlpage.has('weight') == true){  // 보여지는 현재 URI 정보에 "weight" 파라미터가 있다면..
                    chk_data_weight[chk_cnt_weight] = weight;  
                    chk_cnt_weight++;
                } // if

                chk_data_weight[chk_cnt_weight] = wechk.value;  // 배열에 체크한 value값을 저장

                if(chkTrue_weight == true){ // 체크박스에 체크를 한다면
                    if(urlpage.has('weight') == false){  // weight 파라미터가 없다면..
                        urlpage.set("currPage", 1);
                        urlpage.append("weight", wechk.value);
                    } else {  
                        chk_cnt_weight++;
                        urlpage.set("currPage", 1);
                        urlpage.set("weight", chk_data_weight);
                    } // if-else
                    location.href = "/product/list?" + urlpage.toString();
                } else {  // 체크를 해제 한다면
                    const weight_param = urlParams.get('weight');
                    const strIndex_weight = weight_param.indexOf(',');

                    if(strIndex_weight > 0){  // "," 가 있다면 
                        const strSplit = weight_param.split(',');

                        for(let i=0; i<strSplit.length; i++){
                           if(strSplit[0] == wechk.value) {  // 파라미터 값에서 첫번째 값일 경우
                                urlpage.set("weight",weight_param.replace(strSplit[i] + ',', '')); // value값과 뒤에 있는 ',' 를 제거한다
                                break;
                           } else if(strSplit[i] == wechk.value) {
                                urlpage.set("weight",weight_param.replace(',' + strSplit[i],''));
                                break;
                           } // if-else
                        } //for
                        
                        urlpage.set("currPage", 1);
                        location.href = "/product/list?" + urlpage.toString();
                    } else {  // ',' 가 없다면
                        urlpage.set("currPage", 1);
                        urlpage.delete("weight", wechk.value); // weight 파라미터와 값을 삭제
                        location.href = "/product/list?" + urlpage.toString();
                    } // if-else

                    // console.log(brchk.value);
                } // if-else
            });
        } // for


        // 중량(무게) 검색 후 체크 확인
        if(weight != null) { // "weight" 파라미터가 있다면
            for(let idx=0; idx<we_len; idx++){
                const weightObj = document.querySelectorAll('#weight_check')[idx];
                const strIndex = weight.indexOf(',');
                
                if(strIndex > 0){
                    const strSplit = weight.split(',');

                    for(let i=0; i<strSplit.length; i++){
                        if(strSplit[i] == weightObj.value){
                            weightObj.checked = true;
                        } // if 
                    } //for
                } else {  
                    if(weight == weightObj.value){
                        weightObj.checked = true;
                    } //if
                } // if-else
            } // for 
        } // if



        // 가격 검색
        const search_price = document.querySelectorAll('div[name="search_price"]');
        const sp_len = row.length;
        for(let i=0; i<sp_len; i++){
            let pr_Num = document.querySelectorAll('[name="search_price"]')[i];
            pr_Num.addEventListener('click', () => {
                let value = $("#price"+(i+1)).attr('value');

                const urlpage = new URLSearchParams("${__PAGE_MAKER__.cri.pagingUri}");
                if(urlpage.has('price') == false){
                    urlpage.set("currPage", 1);
                    urlpage.append("price", value);
                } else {
                    urlpage.set("currPage", 1);
                    urlpage.set("price", value);
                } // if-else
                location.href = "/product/list?" + urlpage.toString();  
            });
        } // for

        // 가격 검색 체크 확인
        const price1 = document.querySelector("#price1");
        const price2 = document.querySelector("#price2");
        const price3 = document.querySelector("#price3");
        const price4 = document.querySelector("#price4");

        const price = urlParams.get('price');
        switch(price) {
            case 'p1':
                price1.style.color = "#0000FF";
                break;
            case 'p2':
                price2.style.color = "#0000FF";
                break;
            case 'p3':
                price3.style.color = "#0000FF";
                break;
            case 'p4':
                price4.style.color = "#0000FF";
                break;
        } // switch

    </script>
    </html>