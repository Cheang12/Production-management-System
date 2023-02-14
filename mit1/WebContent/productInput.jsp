<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.button{
	width: 80px; height: 40px; background-color:#FAFAD2;
	box-shadow: 1.5px 1.5px 0px 1px #aaaaaa; border: 10px;margin : 30px 5px 10px 0px;
	font-size: 17px;
	}
	
	.fieldset{
	border: 3px solid #dcdcdc;}
</style>
</head>
<body>


<h1>생산관리 등록화면</h1>
<fieldset class = "fieldset">
	<legend>생산관리 등록화면</legend>
	<form action="productServlet/input" method = "post">
	
	<ul> 
		<li>제품코드 <input type = "text" name = "code"> </li>
		<li>제품이름 <input type = "text" name = "pname"> </li>
		<li>제품원가 <input type = "number" name = "cost"> </li>
		<li>목표수량 <input type = "number" name = "pnum"> </li>
		<li>재고수량 <input type = "number" name = "jnum"> </li>
		<li>출고가 <input type = "number" style="margin-left: 15px;" name = "sale"> </li>
		<li>그룹이름 <select name = "gcode"> 
		<c:forEach items="${glist}" var = "gdata" >
		<option value = "${gdata.gcode}">${gdata.gname}</option>
		</c:forEach>
			</select>
		</li>
	</ul>
	
	<input type = "submit" value = "등  록" class = "button" style="margin-left: 40px;" onclick = "alert('등록되었습니다.')">
	<input type = "button" value = "메인화면" class = "button" onclick = "goMain()">
	<input type = "hidden" name = "flag" value = "on">
	</form>

</fieldset>


<script type="text/javascript">
function goMain() {
	location.href = "productServlet/main"
}
</script>

</body>
</html>