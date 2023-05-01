/**
 *  array_function.js
 */

 document.addEventListener('DOMContentLoaded', function(){
     const numbers = [1, 2, 3, 4, 5, 6, 7];
     
     // 배열 concat() 메서드: 배열에 새로운 원소를 끝에 추가. 원소가 추가된 새로운 배열을 리턴
     // 배열 pust() 메서드: 기존 배열의 끝에 원소를 추가. 리턴값은 없음.
     const arr =[]; // 빈 배열 선언
     console.log(arr);
     
     arr.push(100);
     console.log(arr);
     
     arr.push(200);
     console.log(arr);
     
     // 1. 배열 numbers의 원소들 중에서 홀수들만 원소로 갖는 배열을 만들고 출력
     
     let odds = [];
     for (let x of numbers) {
         if (x % 2 === 1) {
             odds = odds.concat(x);
             console.log(x);
         }
     } 
    console.log('odds = ', odds);
     
     // 2. 배열 numbers의 원소를 제곱한 숫자들을 원소로 갖는 배열을 만들고 출력
    let times = [];
    for (let x of numbers) {
        times = times.const(x*x);
    }     
    console.log('times', times);
     
     // 3. 배열 numbers의 원소들 중에서 홀수의 제곱을 원소로 갖는 배열을 만들고 출력
     let oddsTimes = [];
 });