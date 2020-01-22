<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
*{
text-align: center;
margin: auto;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body >
	<form action="insert.do" method="post">
		<table >
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>

			<tr>
				<th>Password</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>Birth</th>
				<td colspan="3">
				<select name="year">
						<option value="0000">0000</option>
				</select>
				
				<strong>-</strong>
				<select name="month">
						<option value="00">00</option>
				</select>
				<strong>-</strong>
				<select name="date">
						<option value="00">00</option>
				</select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>