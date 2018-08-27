<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<c:if test="${!empty rUser}">
<script>
	alert('${rMap.msg}');
	if('${rMap.success}' =='true'){
		location.href="/user/userList";
	}
</script>
</c:if>
</body>
	<div class="container">
	<form action="/user/userInsert" method="post">
		<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td><input type="number" name="uiNo"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="uiName"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="uiPwd"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><input type="text" name="uiDesc"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" name="uiAge"></td>
		</tr>
		<tr>
			<td colspan="2"><button>등록</button></td>
		</table>
	</form>
	</div>
</html>