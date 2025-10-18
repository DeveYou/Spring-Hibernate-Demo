<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Category Details</h1>
    <a href="${pageContext.request.contextPath}/categories/list" class="btn btn-secondary mb-3">Back to List</a>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${category.code}</h5>
            <p class="card-text">
                <strong>ID:</strong> ${category.id}<br>
                <strong>Price:</strong> ${category.label}
            </p>
            <a href="${pageContext.request.contextPath}/categories/edit?id=${category.id}" class="btn btn-warning">Edit</a>
            <a href="${pageContext.request.contextPath}/categories/delete?id=${category.id}" class="btn btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
        </div>
    </div>
</div>
</body>
</html>