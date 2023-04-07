// 수량 증/감소
function count(type,num)  {
    // 결과를 표시할 element
    const resultElement = document.getElementById('result' + num);
    
    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
    
    // 더하기/빼기
    if(type === 'plus') {
      number = parseInt(number) + 1;
    }
    if(type === 'minus')  {
      if(parseInt(number) > 1){
        number = parseInt(number) - 1;
      }else{
        parseInt(number) == 1
      }
    }
    // 결과 출력
    resultElement.innerText = number;
}

// 체크박스
function selectAllCheckboxes() {
    var selectAll = document.getElementById("check_all");
    var checkboxes = document.querySelectorAll("input[type='checkbox']:not(#selectAll)");
    
    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = selectAll.checked;
    }
    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].onclick = function () {
          if (!this.checked) {
            selectAll.checked = false;
          }
        };
    }
    selectAll.onclick = function () {
        for (var i = 0; i < checkboxes.length; i++) {
          checkboxes[i].checked = this.checked;
        }
    };
}
// 선택삭제
function deleteSelectedProducts() {
    var checkboxes = document.getElementsByClassName('checkbox');
    for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i].checked) {
        var product = checkboxes[i].parentNode;
        product.parentNode.removeChild(product);
        i--;
      }
    }
}

// X 버튼 삭제 ( 작동 안함... 어떻게 해야하는지 몰겠음... )
const Delete_1 = document.getElementById("Delete_1");

Delete_1.addEventListener("click", function() {
  const productId = Delete_1.dataset.productId;
  deleteProduct(productId);
});