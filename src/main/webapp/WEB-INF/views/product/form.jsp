<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${product != null ? 'Edit' : 'Add'} Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>${product != null ? 'Edit' : 'Add'} Product</h1>
    <a href="${pageContext.request.contextPath}/products/list" class="btn btn-secondary mb-3">Back to List</a>

    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/products/save" method="post">
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="${product.id}" />
                </c:if>

                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${product != null ? product.name : ''}" required>
                </div>

                <div class="mb-3">
                    <label for="price" class="form-label">Price</label>
                    <input type="number" step="0.01" class="form-control" id="price" name="price" value="${product != null ? product.price : ''}" required>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>