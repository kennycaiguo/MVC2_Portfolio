<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="/EMC"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table{
	text-align: center;
}
* {
	text-align: center;
	margin: auto;
}

.pattern_msg{
	padding-bottom: 20px;
	
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="script/birth.js"></script>
<script type="text/javascript" src="script/memberform.js"></script>
<script type="text/javascript">
$(function(){
	var id=$("input[name='id']").val();
	var blankCheck = /.*\s.*/;
	var specialCharacterCheck = /.*[\W].*/;
	var hangulCheck = /.*[ㄱ-ㅎㅏ-ㅣ가-힣].*$/;
	var startCheck = /^[_]|[_]$/;
	var startNumberCheck = /^[0-9]/;
	var msg;
	$("input[name='id']").focusout(function() {
						id = $("input[name='id']").val();
							msg = id.length < 5 || id.length>16? "6글자 이상 15글자이하 여야합니다.":
								  blankCheck.test(id) ? "공백을 포함할수 없습니다.": 
								  startCheck.test(id) ? "첫시작과 마지막엔 '_'을 사용할수 없습니다.":
								  hangulCheck.test(id) ? "한글을 포함 할수 없습니다.":
								  specialCharacterCheck.test(id) ? "'_'특수문자만 사용 가능합니다.":
								  startNumberCheck.test(id) ? "숫자로 시작하실수 없습니다":null;
							if (msg != null) {
								$("#pattern_id").html(msg).attr("style","font-size: 15px; padding:0px;color:red;");
							}else{
								$("#pattern_id").html("").attr("style","padding-bottom:20px;");
							}
					});
});
</script>
</head>
<body>
	<form action="test.test" method="post" id="memberfrom">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td colspan="2" class="pattern_msg" id="pattern_id"> </td>
			</tr>
			<tr>
				<th>Password</th>
				<td ><input type="password" name="password" ></td>
			</tr>
			<tr>
				<td colspan="2" class="pattern_msg" id="pattern_password"> </td>
			</tr>
			
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td colspan="2" class="pattern_msg" id="pattern_name"> </td>
			</tr>
			<tr>
				<th>Birth</th>
				<td colspan="3"><select name="year" id="year">
						<c:forEach items="${util:getYear()}" var="year">
							<option value="${year}">${year}</option>
						</c:forEach>
				</select> <strong>-</strong> <select name="month" id="month">
						<c:forEach items="${util:getMonth()}" var="month">
							<option value="${month}">${month}</option>
						</c:forEach>
				</select> <strong>-</strong> <select name="date" id="date">
				</select></td>
			</tr>
			<tr>
				<td colspan="2" class="pattern_msg"> </td>
			</tr>
			<tr>
				<th colspan="3">img</th>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="img"/></td>
			</tr>
			<tr>
				<td colspan="2"><img src="${util:getImgPath('temp')}member.jpg" alt="왜없냐?"/></td>
			</tr>
			<tr>
				<td colspan="3" class="pattern_msg"> </td>
			</tr>
			<tr>
				<th colspan="3">
					<input type="submit" value="회원가입"  style="margin: 5px;"/>
					<input type="button" value="다시쓰기" style="margin: 5px;" onclick="reset()"/>
					<input type="button" value="처음화면"  onclick="location.href='index.do'"/>					
				</th>
			</tr>
		</table>
	</form>
</body>
</html>