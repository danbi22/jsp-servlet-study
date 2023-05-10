<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
		</head>
		<body>
				<header>
                        <h1>Create page</h1>
                </header>
                
                <nav>
                        <ul>
                                <li>
                                        <%-- <c:url>에서 "/" 요청주소는 context root까지 --%>
                                        <c:url var="mainPage" value="/"></c:url>
                                        <a href="${ mainPage }">메인 페이지</a>
                                </li>
                                <li>
                                        <%-- <c:url>에서 "/post" 요청주소는 PostListController까지 --%>                                
                                        <c:url var="postList" value="/post"></c:url>
                                        <a href="${ postList }">포스트 목록 페이지</a>
                                </li>
                        </ul>
                </nav>
		</body>
</html>