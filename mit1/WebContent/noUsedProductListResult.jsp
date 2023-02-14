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
	box-shadow: 1.5px 1.5px 0px 1px #aaaaaa; border: 10px;margin : 20px 5px 20px 0px;
	font-size: 17px;
	}
	
	.fieldset{
	border: 3px solid #dcdcdc;}
</style>
</head>
<%--
	0. 그룹이름에 db연결해서 나오게 하기 / input name에 db column명과 동일한 이름 부여
	1. 조회를 누르면 value에 값 넣기 (변수 넣기?) <제품코드만으로도 나와야 함>
	2. 값을 바꾼 후 수정을 누르면 해당 데이터가 이동 >> controller >> java(내용 db에 삽입 등) <제품코드만으로도 수정돼야 함>
	3. 삭제 <제품코드만으로도 삭제 돼야 함>
	4. form을 통해 이동할 곳 : ex)controller1, 2 // controller1 여기서 누른 버튼에 해당하는 작업을 할 java 파일을 찾아 값을 옮겨주고, 그 java에서 처리가 끝나면 controller2를 통해 값을 가져오던지 해야함
--%>


<body>


<h1>생산관리 조회 & 수정 화면</h1>
<fieldset class = "fieldset">
	<legend>생산관리 조회화면</legend>
	<form action="listResult">
	<ul> 
			<li>제품코드 <input type = "text" name = "code" value = "${pdata.code}"> </li>
			<li>제품이름 <input type = "text" name = "pname" value = "${pdata.pname}"> </li>
			<li>제품원가 <input type = "number" name = "cost" value = "${pdata.cost}"> </li>
			<li>목표수량 <input type = "number" name = "pnum" value = "${pdata.pnum}"> </li>
			<li>재고수량 <input type = "number" name = "jnum" value = "${pdata.jnum}"> </li>
			<li>출고가 <input type = "number" style="margin-left: 15px;" name = "sale" value = "${pdata.sale}"> </li>
			<li>그룹이름 <select name = "gcode"> 
			<c:forEach items="${glist}" var = "gdata" >
				<option value = "${gdata.gcode}" ${gdata.gcode == pdata.gcode ? "selected":""}>${gdata.gname}</option>
			</c:forEach>
			</select>
			</li>
	
	</ul>
	<button type = "submit" name = "action" value = "search" class = "button" style="margin-left: 40px;">조  회</button>
	<button type = "submit" name = "action" value = "update" class = "button">수  정</button>
	<button type = "submit" name = "action" value = "delete" class = "button">삭  제</button>
	<button type = "button"  class = "button" onclick = "goMain()">메인화면</button>
	<input type = "hidden" name = "flag" value = "true">

	</form>
	
</fieldset>

<script type="text/javascript">
function goMain() {
	location.href = "productServlet/main"
}
</script>

</body>
</html>