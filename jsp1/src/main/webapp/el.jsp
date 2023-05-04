<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>JSP</title>
		</head>
		<body>
				<h1>El(Expression Languege)</h1>
                <%-- EL
                    JSP expression 태그(<%= %>)를 대체하는 문법.
                    ${ 식 }
                    * 지시문 <%@ %> 안에서는 사용할 수 없음.
                    * 선언분 <%! %> 안에서는 사용할 수 없음.
                    * 스크립트릿 <% %> 안에서는 사용할 수 없음.
                    * 식 <%= %> 안에서는 사용할 수 없음.
                    * 그 이외의 JSP 안에서는 언제든지 사용 가능.
                       - HTML 태그의 컨텐트
                       - HTML 태그의 속성 값
                       - CSS 프로퍼티 값 설정
                       - JavaScript 코드의 일부.
                 --%>
                 
                 <p><%= 1 + 2 %></p>
                 <p>${ 1 + 2 }</p>
                 
                 <%-- 상태 정보 유지: 
                    JSP에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
                      * pageContext: JSP 페이지가 유지되는 동안 사용 가능 
                      * request: 요청 객체가 유지되는 동안 사용 가능
                      * sessoin: 세션이 유지되는 동안 사용 가능
                      * application: 웹 애플리케이션이 동작하는 동안 사용 가능
                  --%>
                 
                 
		</body>
</html>