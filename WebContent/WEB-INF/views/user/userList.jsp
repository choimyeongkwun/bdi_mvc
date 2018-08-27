<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class = "container">
		<h4>유저리스트</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>비고</th>
					<th>나이</th>
					<th>재원번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="m">
					<tr>
						<td>${m.uino}</td>
						<td><a href="/user/userView?uiNo=${m.uino}">${m.uiname}</a></td>
						<td>${m.uiid}</td>
						<td>${m.uipwd}</td>
						<td>${m.uidesc}</td>
						<td>${m.uiage}</td>
						<td>${m.dino}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<div>
	<button onclick="goPage()">유저등록</button>
	</div>
	</div>	
	<script>
		function goPage(){
			location.href='/views/user/userInsert';
		}
	</script>
</body>
</html>