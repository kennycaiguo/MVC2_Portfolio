<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="id" value="${requestScope.id }" />
<c:set var="msg" value="${requestScope.msg }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
			if($("input[name='id']").val()==''&& ${not empty id}){
				$("input[name='id']").val("${id}");
			}
			});
	</script>
</head>
<body>

	<form action="login.do" method="post">
		<table>
			<tr>
				<th>아이디:</th>
				<c:choose>
					<c:when test="${empty id}">
						<td class="idCheck"><input type="text" name="id" placeholder="아이디를입력해주세요."></td>
					</c:when>
					<c:otherwise>
						<td class="idCheck"><input id="setId" type="text" name="id" placeholder="${id}" /></td>
					</c:otherwise>
				</c:choose>
				<td><samp id="idmsg"></samp></td>
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td class="pwCheck"><input type="password" name="password" placeholder="비밀번호를입력해주세요." /></td>
				<td><samp id="pwmsg"></samp></td>
			</tr>
			<c:if test="${not empty msg }">
				<tr>
					<th colspan="2"><strong style="color: red">${msg}</strong></th>
				</tr>
			</c:if>
			<tr>

				<th colspan="2"><input type="hidden"><input
					type="submit" value="로그인" /></th>
			</tr>
		</table>
	</form>
</body>
</html>