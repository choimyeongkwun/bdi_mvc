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
		</tbody>
	</table>
	<div>
		<button data-page="/views/game/gameList">게임 등록</button>
	</div>
</div>
</body>
</html>