<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>부서설명</th>
				<th>부서총인원</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${departList}" var="d">
			<tr>
				<td>${d.diNo}</td>
				<td><a href="/depart/departView?diNo=${d.diName}">${d.diName }</a></td>
				<td>${d.diDesc}</td>
				<td>${d.diCnt}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div>
		<button data-page="/views/depart/departInsert">부서등록</button>
	</div>
</div>
</body>
</html>