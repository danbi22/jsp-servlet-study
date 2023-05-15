<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>세부목록</title>
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
                                        <c:url value="/post/modify" var="postModify">
                                                <c:param name="id" value="${ post.id }"></c:param>
                                        </c:url>
                                        <a href="${ postModify }">포스트 수정</a>
                                </li>
                        </ul>
                </nav>
                <main>
                <form id="postModifyForm">
                        <div>
                                <input id="id" name="id" type="text" value="${ post.id }" readonly />
                        </div>
                        <div>
                                <input id="title" name="title" type="text" value="${ post.title }" autofocus />
                        </div>
                        <div>
                                <textarea id="content" name="content" rows="5" cols="80" >${ post.content }</textarea>
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
                        <div>
                                <c:url var="" value=""></c:url>
                                <button id="btnUpdate">수정완료</button>
                                <button id="btnDelete">삭제</button>
                        </div>
                </form>
                
        </main>
		</body>
</html>