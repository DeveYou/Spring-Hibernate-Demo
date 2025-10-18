<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product and Category Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Product and Category Management</h1>
    <div class="row mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Product Management</h5>
                    <p class="card-text">Create, read, update and delete products.</p>
                    <a href="${pageContext.request.contextPath}/products/list" class="btn btn-primary">Manage Products</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Category Management</h5>
                    <p class="card-text">Create, read, update and delete categories.</p>
                    <a href="${pageContext.request.contextPath}/categories/list" class="btn btn-primary">Manage Categories</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>