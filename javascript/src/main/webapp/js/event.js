/**
 * event.js
 */

 // btnInput 리스너 달기 -> input#itemInput 내용을 가지고 ul#itemList을 만든다 -> input#itemInput의 내용을 지운다
document.addEventListener('DOMContentLoaded', function () {
    const btnInput = document.getElementById('btnInput');
    const itemInput = document.getElementById('itemInput');
    const itemList = document.getElementById('itemList');
    
    btnInput.addEventListener('click', function () {
        let itemInputValue = itemInput.value;
        console.log(itemInputValue);
        
        itemList.innerHTML = itemInputValue;
        itemInput.innerText = '';
    });
});