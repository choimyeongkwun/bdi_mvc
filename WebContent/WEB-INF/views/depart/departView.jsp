<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<table class="table table-borederd">
			<tr>
				<th>부서번호</th>
				<td>${d.diNo}</td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td>${d.diName}</td>
			</tr>
			<tr>
				<th>부서설명</th>
			<td>${d.diDesc}</td>
			</tr>
			<tr>
				<th>부서 인원</th>
				<td>${d.dicnt}</td>
			</tr>
			<tr>
				<td colspan="2">
				<form action="/depart/departDepete" method ="post">
				<button data-page="/depart/departUpdate?dino=${d.diNo}">수정</button>
				 <button>삭제</button>
				 <input type="hidden" name="diNo" value="${d.diNo}">
				</form>
				</td>
			</tr>
		</table>
		</div>
</body>
</html>