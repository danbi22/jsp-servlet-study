/**
 * switch.js
 * 스위치문 자바스크립트
 */

// DOM: Document Object Model
// DOMContentLoaded: HTML 문서의 모든 요소(element)들이 만들어졌을 때 발생하는 이벤트.
// 이벤트 처리 함수를 등록.
document.addEventListener('DOMContentLoaded', function () {
     // select#weekday element를 찾음
     const weekday = document.getElementById('weekday');
     console.log(weekday);
     
     // div#result element를 찾음.
     const result = document.getElementById('result');
     console.log(result);
     
     // button#btn element를 찾음.
     const btn = document.getElementById('btn');
     // btn에 click 이벤트 리스너를 등록
     btn.addEventListener('click', printResult);
     
     function printResult() {
         const weekdayValue = weekday.value; // select에서 선택된 값을 읽음
         switch (weekdayValue) {
             case 'mon':
             case 'tue':
             case 'wed':
             case 'thu':
             case 'fri':
                result.innerHTML = '학원 출석';
                break;
             case 'sat':
             case 'sun':
                 result.innerHTML = '캠핑';
                 break;
             default:
                 result.innerHTML = '몰라요';
        }
        // 자바스크립트의 swich-case에서 비교는 === 연산자 비교
        // 타입을 자동으로 변환하지 않고, 타입과 값이 일치하는 case의 문장을 실행.
    }
     
});