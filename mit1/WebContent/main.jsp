<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.button{
	width: 150px; height: 40px; background-color:#FAFAD2;
	box-shadow: 2px 2px 0px 1px #aaaaaa; border: 10px;margin : 0px 0px 5px 0px;
	font-size: 17px;
	}
	
	.fieldset{
	border: 3px solid #dcdcdc;}
</style>
</head>
<body>
<h1>생산관리 시스템</h1>
<fieldset class = "fieldset">
	<legend>생산관리 메인메뉴</legend>
	<input type = "button" value = "제품입력" class = "button" onclick = "location.href = 'productServlet/input'">
	<input type = "button" value = "제품조회" class = "button" onclick = "location.href = 'productServlet/list'">
	<input type = "button" value = "우선생산제품" class = "button" onclick = "location.href = 'productServlet/first'">
	<input type = "button" value = "이익순위" class = "button" onclick = "location.href = 'productServlet/rank'"> 
	<input type = "button" value = "그룹별재고수량" class = "button" onclick = "location.href = 'productServlet/group'">

</fieldset>


</body>
</html>