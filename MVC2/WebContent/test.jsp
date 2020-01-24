<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="/EMC"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.getSession().setAttribute("id", "admin");
	%>
		<c:set var="id" value="${sessionScope.id }"/>
		<c:choose>
			<c:when test="${'a' eq util:getGrade(id) }" >
				list
			</c:when>
			<c:otherwise>
				read
			</c:otherwise>
		</c:choose>
		<c:if test="${'a' eq util:getGrade(id)}">
			<a>list</a>
		</c:if>		
		<c:if test="${'a' ne util:getGrade(id)}">
			<a>read</a>
		</c:if>
</body>
</html>
