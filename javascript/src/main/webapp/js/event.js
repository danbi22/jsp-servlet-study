/**
 * event.js
 */

 // btnInput 리스너 달기 -> input#itemInput 내용을 가지고 ul#itemList을 만든다 -> input#itemInput의 내용을 지운다
document.addEventListener('DOMContentLoaded', function () {
   /* const btnInput = document.getElementById('btnInput');
    const itemInput = document.getElementById('itemInput');
    const itemList = document.getElementById('itemList');*/
    
    const itemInput = document.querySelector('input#itemInput');
    const btnInput= document.querySelector('button#btnInput');
    const itemList= document.querySelector('ul#itemList');
    
    btnInput.addEventListener('click', function (e) {
        console.log(e);
        // input에 입력된 값을 읽음
        const itemInputValue = itemInput.value;
        console.log(itemInputValue);
        
        // input에 입력된 값으로 li 요소를 만듦
        const item = `<li>${itemInputValue}</li>`;
        itemList.innerHTML += item;
        
        // input의 값을 지움
        itemInput.value = '';
        
        // input에 포커스를 줌
        itemInput.focus();
    });
    
    const itemInput2 = document.querySelector('input#itemInput2');
    const itemList2 = document.querySelector('ul#itemList2');
    
    // 'keydown'리스너: 키를 누르면 실행
    itemInput2.addEventListener('keydown', function(event) {
         console.log(event); // -> event: KeyboardEvent 객체
        // 모든 이벤트 핸들러 함수(콜백)은 이벤트 객체를 argument로 전달 받음.
        if (event.keyCode === 13) {
            const value = itemInput2.value;
            const item = `<li>${value}</li>`;
            itemList2.innerHTML += item;
            
          itemInput2.value = '';
          
          itemInput2.focus();  
        }
    });
    
    const username = document.getElementById('username');
    const age = document.getElementById('age');
    const result = document.getElementById('result');
   
    function update() {
        const val1 = username.value;
        const val2 = age.value;
        const result1 = 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
});