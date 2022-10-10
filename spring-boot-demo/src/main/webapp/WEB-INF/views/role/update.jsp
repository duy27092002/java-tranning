<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa vai trò</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<f:form action="/role/createOrUpdate" method="post"
			modelAttribute="roleDTO">

			<f:input path="id" type="hidden" value="${roleDetails.id}" />

			<div class="form-group">
				<label>Tên vai trò:</label>
				<f:input path="name" type="text" class="form-control"
					value="${roleDetails.name}" />
				<f:errors path="name" style="color:red;"></f:errors>
			</div>

			<div class="form-group">
				<label>Trạng thái:</label>
				<f:select path="status" cssClass="form-control">
					<option value="1" <c:if test="${roleDetails.status == 1}"><c:out value="selected" /></c:if>>Đang hoạt động</option>
					<option value="0" <c:if test="${roleDetails.status == 0}"><c:out value="selected" /></c:if>>Đã hủy</option>
				</f:select>
			</div>

			<button type="submit" class="btn btn-primary">Cập nhật</button>
		</f:form>
	</div>
</body>
</html>