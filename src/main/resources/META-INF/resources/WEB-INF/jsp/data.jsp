<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>target</th>
				<th>IsDone ?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${todo}" var="t">
			<tr>
				<td>${t.description}</td>
				<td>${t.target}</td>
				<td>${t.done}</td>
				<td><a href="/todo/delete?id=${t.id}" class="btn btn-warning">Delete
				</a>
				<td><a href="/todo/update?id=${t.id}" class="btn btn-success">Update
				</a>
			</tr>

		</c:forEach>
	</table>
	<a href="/todo/add" class="btn btn-success"> addTodo </a>
	<%@ include file="common/footer.jspf"%>
</div>

</body>
</html>