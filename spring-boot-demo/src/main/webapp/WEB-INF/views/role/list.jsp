<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Role</title>
</head>
<body>
	<div class="container">
		<h3 style="color: red;">${error}</h3>
		<h3 style="color: green;">${message}</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Tên vai trò</th>
					<th scope="col">Trạng thái</th>
					<th scope="col">Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roleList}" var="role">
					<tr>
						<td>${role.id}</td>
						<td>${role.name}</td>
						<td>${role.status}</td>
						<td>
							<a href="/role/details?roleId=${role.id}">Xem</a> |
							<a href="/role/createOrUpdate?roleId=${role.id}">Sửa</a> |
							<a href="/role/delete?roleId=${role.id}">Xóa</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>