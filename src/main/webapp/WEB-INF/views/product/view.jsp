<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Product Details</h1>
    <a href="${pageContext.request.contextPath}/products/list" class="btn btn-secondary mb-3">Back to List</a>

    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${product.name}</h5>
            <p class="card-text">
                <strong>ID:</strong> ${product.id}<br>
                <strong>Price:</strong> ${product.price}
            </p>
            <a href="${pageContext.request.contextPath}/products/edit?id=${product.id}" class="btn btn-warning">Edit</a>
            <a href="${pageContext.request.contextPath}/products/delete?id=${product.id}" class="btn btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
        </div>
    </div>
</div>
</body>
</html>