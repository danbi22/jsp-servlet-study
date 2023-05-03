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
                --%>
                <%
                String username = request.getParameter("username");
                %>
                <h2>안녕하세요, <%=username %>!</h2>
		</body>
</html>