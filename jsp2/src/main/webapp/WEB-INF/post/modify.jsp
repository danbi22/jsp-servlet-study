<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>수정하기</title>
		</head>
		<body>
				<nav>
                        <ul>
                                <li>
                                        <c:url var="postList" value="/post"></c:url>
                                            <a href="${ postList }">목록으로 돌아가기</a>
                                </li>
                                <li>
                                        <c:url var="postMain" value="/"></c:url>
                                                <a href="${ postMain }">메인으로 돌아가기</a>
                                </li>
                                <li>
                                        <c:url value="/post/detail" var="postDetail">
                                                <c:param name="id" value="${ post.id }"></c:param>
                                        </c:url>
                                        <a href="${ postDetail }">포스트 상세보기</a>
                                </li>
                        </ul>
                </nav>
                <main>
                <form>
                        <div>
                                <input type="text" value="${ post.id }" readonly />
                        </div>
                        <div>
                                <input type="text" value="${ post.title }" readonly />
                        </div>
                        <div>
                                <textarea rows="5" cols="80" readonly>${ post.content }</textarea>
                        </div>
                        <div>
                                <input type="text" value="${ post.author }" readonly />
                        </div>
                        <div>
                                <input type="text" value="${ post.createdTime }" readonly />
                        </div>
                        <div>
                                <input type="text" value="${ post.modifiedTime }" readonly />
                        </div>
                </form>
        </main>
		</body>
</html>