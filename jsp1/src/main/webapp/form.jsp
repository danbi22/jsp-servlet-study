<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- trimDirectiveWhitespaces="true": 지시자가 있음으로 발생하는 공백들을 trim(잘라낸다)
         - 코드가 깔끔해진다.
         - 클라이언트에게 같은 내용을 공백을 제거함으로써 더 작은 크기로 전달할 수 있다.
 --%>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>JSP</title>
		</head>
		<body>
				<form action="form-result.jsp" method="get">
                        <input type="text" name="username" placeholder="이름 입력" required autofocus />
                        <input type="submit" value="전송" />
                </form>
		</body>
</html>