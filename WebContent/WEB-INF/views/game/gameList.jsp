<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class = "table table-borderd table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>게임이름</th>
				<th>게임가격</th>
				<th>회사이름</th>
				<th>게임순위</th>
				<th>게임설명</th>
				<th>게임이미지</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${gameList}" var="game">
			<tr>
				<td>${game.gcNum}</td>
				<td><a href="/game/gameView?gcNum=${game.gcNum}">${game.gcName}</a></td>
				<td>${game.gcPrice}</td>
				<td>${game.gcVendor}</td>
				<td>${game.gcOrder}</td>
				<td>${game.gcDesc}</td>
				<td>${game.gcImg}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div>
		<button data-page="/views/game/gameInsert">게임 등록</button>
	</div>
</div>
</body>
</html>