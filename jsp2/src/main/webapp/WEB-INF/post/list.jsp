<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
                <style>
                </style>
		</head>
		<body>
                <header>
				        <h1>포스트 목록 페이지</h1>
                </header>
                
                <nav>
                        <ul>
                                <li>
                                        <%-- 상대경로에서 현재 폴더(./)의 의미: context root까지의 주소 
                                                http://localhost:8081/post/
                                        --%>
                                        <c:url var="mainPage" value="./"></c:url>
                                        <a href="${ mainPage }">메인 페이지</a>
                                </li>
                                <li>
                                        <c:url var="postCreate" value="/post/create"></c:url>
                                        <a href="${ postCreate }">새 포스트 작성</a>
                                </li>
                        </ul>
                </nav>
                
                <main>
                        <table>
                                <thead>
                                        <tr>
                                                <th>번호</th>
                                                <th>제목</th>
                                                <th>작성자</th>
                                                <th>수정 시간</th>
                                        </tr>
                                </thead>
                                <tbody>
                                        <c:forEach var="posts" items="${ posts }">
                                                <tr>
                                                        <td>${ posts.id }</td>
                                                        <td>
                                                                <c:url value="/post/detail" var="postDetail">
                                                                        <c:param name="id" value="${ posts.id }"></c:param>
                                                                </c:url>
                                                                <a href="${ postDetail }">${ posts.title }</a>
                                                        </td>
                                                        <td>${ posts.author }</td>
                                                        <td>${ posts.modifiedTime }</td>
                                                </tr>
                                        </c:forEach>
                                </tbody>
                        </table>
                        <c:url value="/post/serch" var="search"></c:url>
                        <form action="${search}">
                                <select name="category">
                                        <option value="optT">제목</option>
                                        <option value="optC">내용</option>
                                        <option value="optTC">제목 + 내용</option>
                                        <option value="optA">작성자</option>
                                </select>
                                <input type="text" name="keyword" placeholder="검색어" required autofocus />
                                <input type="submit" value="검색" />
                        </form>
                </main>
		</body>
</html>

