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
                <main>
                        <c:url value="/post/create" var="postCreate"></c:url>
                        <form action="${ postCreate }" method="post">
                                <div>
                                        <input type="text" name="title" placeholder="제목을 입력해주세요" required autofocus />
                                </div>
                                <div>
                                        <textarea rows="5" cols="80" name="content" placeholder="내용을 입력해주세요" required></textarea>
                                </div>
                                <div>
                                        <input type="text" name="author" placeholder="아이디를 입력해주세요" required />
                                </div>
                                <div>
                                        <input type="submit" value="직성완료" />
                                </div>
                        </form>
                </main>
		</body>
</html>