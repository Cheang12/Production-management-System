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
<fieldset class = "fieldset" >
	<legend>생산관리 조회화면</legend>
	<form action="" method = "post" >
	<ul> 
			<li>제품코드 <input type = "text" name = "code" id = "code" value = "${pdata.code}"> </li>
			<li>제품이름 <input type = "text" name = "pname" id = "pname" value = "${pdata.pname}"> </li>
			<li>제품원가 <input type = "number" name = "cost" id = "cost" value = "${pdata.cost}"> </li>
			<li>목표수량 <input type = "number" name = "pnum" id = "pnum" value = "${pdata.pnum}"> </li>
			<li>재고수량 <input type = "number" name = "jnum" id = "jnum" value = "${pdata.jnum}"> </li>
			<li>출고가 <input type = "number" style="margin-left: 15px;" name = "sale" id = "sale" value = "${pdata.sale}"> </li>
			<li>그룹이름 <select name = "gcode" id = "gcode"> 
			<c:forEach items="${glist}" var = "gdata" >
				<option value = "${gdata.gcode}" ${gdata.gcode == pdata.gcode ? "selected":""}>${gdata.gname}</option>
			</c:forEach>
			</select>
			</li>
	
	</ul>
	<button type = "submit" name = "action" value = "search" class = "button" style="margin-left: 40px;">조  회</button>
	<button type = "submit" name = "action" value = "update" class = "button" id = "update" >수  정</button> <%--수정삭제처리 시 취소 누르면 submit 작동 안되게 하기 --%>
	<button type = "submit" name = "action" value = "delete" class = "button" id = "delete" >삭  제</button>
	<button type = "button"  class = "button" onclick = "goMain()">메인화면</button>
	<input type = "hidden" name = "flag" value = "on">
	</form>
	
</fieldset>


<script src="http://code.jquery.com/jquery-1.10.1.js"></script>

<script type="text/javascript">
function goMain() {
	location.href = "productServlet/main"
}


$("#update").click(function (e) {
	var code = $("#code").val();
	var pname = $("#pname").val();
	var cost = $("#cost").val();
	var pnum = $("#pnum").val();
	var jnum = $("#jnum").val();
	var sale = $("#sale").val();
	var gcode = $("#gcode").val();

	console.log("코드값"+code);
	var check = confirm("제품코드 : "+code+"\n제품이름 : "+pname+"\n제품원가 : "+cost+"\n목표수량 : "+pnum+"\n재고수량 : "+jnum+"\n출고가 : "+sale+"\n그룹이름 : "+gcode+"\n"+"\n입력하신 내용을 확인해주세요.\n해당 내용으로 수정하시겠습니까?");
	console.log("check 값 :"+check);

	if (check == true) {
		alert("수정되었습니다.");
	}else{
		e.preventDefault();
		alert("취소하였습니다.");
	}
})

$("#delete").click(function (e) {
	var check = confirm("제품코드 : ${pdata.code} 제품이름 : ${pdata.pname} \n해당 제품코드의 정보를 삭제하시겠습니까?");
	console.log("check 값 :"+check);

	if (check == true) {
		alert("삭제되었습니다.");
	}else{
		e.preventDefault();
		alert("취소하였습니다.");
	}
})


</script>

</body>
</html>