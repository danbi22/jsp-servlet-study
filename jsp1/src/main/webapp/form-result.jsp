<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>JSP</title>
		</head>
		<body>
				<h1>요청 결과 처리</h1>
                
                <%-- 클라이언트에서 보낸 요청 파라미터의 값을 찾는 방법 
                            - String username = request.getParameter("username");
                            - 파라미터값을 받을 변수 = request.getParameter("input에서 지어준 name");
                         request변수를 선언하지 않았는데 사용할 수 있다
                         WAS가 준것. JSP내장 객체
                --%>
                <%
                String username = request.getParameter("username");
                %>
                <h2>안녕하세요, <%=username %>!</h2>
                
                <%-- JSP 내장 객체
                    JSP가 Java로 변환될 때 _jspService(request, response) 매서드 안에서 선언되는 변수들
                    JSP에서 별도의 변수 선언 없이 JSP 태그 안에서 언제든지 사용할 수 있는 변수들. -> JSP 내장 객체
                    
                 --%>
                
		</body>
</html>