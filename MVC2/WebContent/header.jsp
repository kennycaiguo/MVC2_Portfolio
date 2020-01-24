<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="/EMC"%>
<c:set var="id" value="${sessionScope.id }" />
<c:choose>
	<c:when test="${not empty id}">
		<h1>
			<c:out value="${id}님 환영합니다." />
		</h1>
			<c:choose>
				<c:when test="${'a' eq util:getGrade(id)}">
					<a href="list.do">회원목록</a>
					<a href="gradeupdateui.do">회원권한수정</a>
					<a href="searchui.do">회원조회</a>
				</c:when>
				<c:otherwise>
					<a href="read.do">내정보</a>
					<a href="update.do">내정보수정</a>
				</c:otherwise>
			</c:choose>
			<a href="logoutui.do">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="loginui.do">로그인</a>
	</c:otherwise>
</c:choose>