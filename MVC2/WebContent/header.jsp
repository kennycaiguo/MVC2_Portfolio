<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="/EMC"%>
<c:set var="id" value="${sessionScope.id }" />
<c:choose>
	<c:when test="${not empty id}">
		<h1>
			<c:out value="${id}�� ȯ���մϴ�." />
		</h1>
			<c:choose>
				<c:when test="${'a' eq util:getGrade(id)}">
					<a href="list.do">ȸ�����</a>
					<a href="gradeupdateui.do">ȸ�����Ѽ���</a>
					<a href="searchui.do">ȸ����ȸ</a>
				</c:when>
				<c:otherwise>
					<a href="read.do">������</a>
					<a href="update.do">����������</a>
				</c:otherwise>
			</c:choose>
			<a href="logoutui.do">�α׾ƿ�</a>
	</c:when>
	<c:otherwise>
		<a href="loginui.do">�α���</a>
	</c:otherwise>
</c:choose>