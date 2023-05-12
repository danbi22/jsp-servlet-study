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
                <table>
                        <tr>
                                <th>글 번호</th>
                                <td>${ post.id }</td>
                                <th>수정 시간</th>
                                <td>${ post.modifiedTime }</td>
                        </tr>
                        <tr>
                                <th>제목</th>
                                <td>${ post.title }</td>
                        </tr>
                        <tr>
                                <th>내용</th>
                                <td>${ post.content }</td>
                        </tr>
                        <tr>
                                <th>작성자</th>
                                <td>${ post.author }</td>
                        </tr>
                </table>
				<nav>
                        <c:url var="postList" value="/post"></c:url>
                        <button>
                                <a href="${ postList }">목록으로 돌아가기</a>
                        </button>
                </nav>
		</body>
</html>