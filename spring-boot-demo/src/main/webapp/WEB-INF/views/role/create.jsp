<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới vai trò</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<f:form action="/role/createOrUpdate" method="post" modelAttribute="roleDTO">

			<div class="form-group">
				<label>Tên vai trò:</label>
				<f:input path="name" type="text" class="form-control" />
				<f:errors path="name" style="color:red;"></f:errors>
			</div>

			<div class="form-group">
				<f:input path="status" type="hidden" value="1" />
			</div>

			<button type="submit" class="btn btn-primary">Thêm mới</button>
		</f:form>
	</div>
</body>
</html>