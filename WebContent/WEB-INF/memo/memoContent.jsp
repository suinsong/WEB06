<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 12px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>��ȣ</td>
			<td>${vo.mnum}</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td>${vo.mname}</td>
		</tr>
		<tr>

			<td>���ٸ޸�</td>
			<td>${vo.mcontent}</td>
		</tr>

		<tr>

			<td colspan="2" align="center">
			<a href='mUpdateForm.mo?mnum=${vo.mnum}'>[����]</a>
			<a href='mDelete.mo?mnum=${vo.mnum}'>[����]</a>
			<a href='mList.mo'>[���]</a></td>
		</tr>


	</table>



</body>
</html>