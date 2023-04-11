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
        <title>상품 목록</title>

		<link rel="stylesheet" href="/resources/css/list.css">
        <script src="resources/js/list.js" defer></script>       

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
                    
                        <li>
                            <input type="checkbox" name="aSearch" value="">
                            <label for=""></label>
                        </li>
                        
                    </ul>
    				</form>
    				
                    <hr>
    
                    <ul> 중량
                        <li>
                            <input type="checkbox">
                            <label for="">상품1</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">상품2</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">상품3</label>
                        </li>
                    </ul>
    
                    <hr>
    
                    <ul> 가격
                        <li>
                            <input type="checkbox">
                            <label for="">상품1</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">상품2</label>
                        </li>
                        <li>
                            <input type="checkbox">
                            <label for="">상품3</label>
                        </li>
                    </ul>
                </aside>
    
    			
                <div class="list">
                    <div class="sort">
                        <i class="fa-solid fa-check"></i><div class="sort1" id="best">베스트순</div>
                        <i class="fa-solid fa-check"></i><a href="/product/list?order=pno" ><div class="sort2" id="newProduct">신상품순</div></a>
                        <i class="fa-solid fa-check"></i><a href="/product/list?order=pname"><div class="sort3" id="sortProductName">상품명순</div></a>
                        <i class="fa-solid fa-check"></i><a href="/product/list?order=disprice"><div class="sort4" id="lowPrice">낮은가격순</div></a>
                        <div class="sort5">
                            <form id="" name="myform" action="/product/list" method="GET">
                            <select name="amount" id="number">
                                <option value="12" selected>12개씩 보기</option>
                                <option value="24">24개씩 보기</option>
                                <option value="36">36개씩 보기</option>
                            </select>
                            </form>
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
                    
                    
                </div>

            </div>
        </div>   
    </body>
    <script>
        let number = document.querySelector("#number");

        number.addEventListener('mouseover', () => {
            // console.log("mouseover...");
        }); 

        number.addEventListener('change', () => {
            let value = number.options[number.selectedIndex].value;
            
            location.href="/product/list${__PAGE_MAKER__.cri.pagingUri}";
            document.myform.submit();
        });

    </script>

    
    </html>