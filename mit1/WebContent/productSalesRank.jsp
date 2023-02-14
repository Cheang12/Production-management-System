<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>이익 순위 제품</h1>
<fieldset class = "fieldset" >
	<legend>현 재고수량 모두 판매 시 총 이익 순위</legend>
	<table border = "1px">
		<tr>
			<th> 제품이름 </th>
			<th> 총 이익금액 </th>
		</tr>	

		<c:forEach items = "${list }" var = "item">
		<tr>
			<td>${item.pname }</td>
			<td>${item.jnum*(item.sale) }</td>
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