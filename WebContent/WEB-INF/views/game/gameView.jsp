<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<table class="table table-borederd">
			<tr>
				<th>번호</th>
				<td>${game.gcNum}</td>
			</tr>
			<tr>
				<th>게임이름</th>
				<td>${game.gcName}</td>
			</tr>
			<tr>
				<th>게임가격</th>
				<td>${game.gcPrice}</td>
			</tr>
			<tr>
				<th>회사이름</th>
				<td>${game.gcVendor}</td>
			</tr>
			<tr>
				<th>게임순위</th>
				<td>${game.gcOrder}</td>
			</tr>
			<tr>
				<th>게임설명</th>
				<td>${game.gcDesc}</td>
			</tr>
			<tr>
				<th>게임이미지</th>
				<td>${game.gcImg}</td>
			</tr>
			<tr>
				<td colspan="2">
				<form action="/game/gameDelete" method ="post">
					<button data-page="/game/gameUpdate?gcNum=${game.gcNum}">수정</button>
					<button>삭제</button>
					<input type="hidden" name="gcNum" value="${game.gcNum}">
				</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>