/**
 * object.js
 */

 document.addEventListener('DOMContentLoaded', function () {
     // JSON(JavaScript Object Notation): 자바스크립트 객체 표기법
     // 자바의 객체 생성: class -> new constr();
     // 자바스크립트의 객체생성:
     // { property: value, ... }
     
     const person = {
         name: '다한', 
         age: 26,
         phone: ['010-0000-0000', '02-000-0000'],
         gender: 'male'
     };
     console.log(person);
     
     // 객체의 프로퍼티 접근(사용): (1) 참조 연산자 (2) 인덱스 연산자
     console.log(person.name); // person 객체의 name 프로퍼티 값을 읽음.
     console.log(person['age']); // person 객체의 age 프로퍼티 값을 읽음.
     console.log(person.phone);
     console.log(person.phone[0]);
     console.log(person['phone'][1]);
     
     person.name = '홍길동'; // person 객체의 name 프로퍼티 값을 변경
     console.log(person);
     
     // 자바스크립트 객체는 프로퍼티를 추가할 수 있음.
     person.company = '아이티윌';
     console.log(person['company']);
     console.log(person);
     
     //div.innHTML = ''; -> 원래의 목적은 div의 컨텐츠를 빈문자열로 저장하려고 했지만 결과는 div 객체에 innHTML이라는 프로퍼티를 만들고 빈문자열을 저장
      
     // 객체(Object)에서 for-in 구문: 객체에서 프로퍼티 이름들을 iteration
     for (let key in person) {
         console.log(key, ':', person[key]);
     }
     
     // 객체(Object)에서 for-of 구문:
     for (let key of person) {
         console.log(key);
     }
 }) 