<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>우선 생산 제품 목록</h1>
<fieldset class = "fieldset" >
	<legend>재고수량이 목표수량의 20% 미만인 제품</legend>
	<table border = "1px">
		<tr>
			<th> 제품코드 </th>
			<th> 제품이름 </th>
			<th> 생산해야할 수량 </th>
		</tr>	

		<c:forEach items = "${list }" var = "item">
		<tr>
			<td>${item.code }</td>
			<td>${item.pname }</td>
			<td>${item.pnum*(20/100)-item.jnum }</td>
		</tr>	
		</c:forEach>
	</table>
</fieldset>		

<input type = "button" value = "메인화면" class = "button" onclick = "goMain()">
		
<script type="text/javascript">
function goMain() {
	location.href = "productServlet/main"
}
</script>		
	

</body>
</html>