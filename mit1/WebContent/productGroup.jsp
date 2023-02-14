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
	<h1>그룹별 재고수량 목록</h1>
<fieldset class = "fieldset" >
	<legend>제품 그룹별 재고수량</legend>
	<table border = "1px">
		<tr>
			<th> 그룹이름 </th>
			<th> 재고수량 </th>
		</tr>	
	
		<c:forEach items = "${glist}" var = "gitem">
			<c:forEach items = "${list }" var = "item">

				<c:if test="${gitem.gcode == item.gcode}">
				<tr>
					<td>${gitem.gname}</td>
					<td>${item.jnum }</td>
				</tr>		
				</c:if>

			</c:forEach>
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