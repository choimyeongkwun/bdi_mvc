<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
	<script>
		alert('${rMap.msg}');
		if ('${rMap.success}' == 'true') {
			location.href = "/user/userList";
		}
	</script>
</c:if>
<body>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${user.uiNo}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${user.uiName}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${user.uiId}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${user.uiPwd}</td>
			</tr>
			<tr>
				<th>비고</th>
				<td>${user.uiDesc}</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${user.uiAge}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<form action="/user/userDelete" method="post" style="">
					<button type="button" data-page='/user/userUpdate?uiNo=${uiNo}'>수정</button>
					<button type="button" data-page='/user/userList'>리스트 가기</button>
					<input type="hidden" name="uiNo" value="${user.uino}">
				</form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>