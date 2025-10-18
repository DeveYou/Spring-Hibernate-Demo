<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Category List</h1>
    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary mb-3">Home</a>
    <a href="${pageContext.request.contextPath}/categories/new" class="btn btn-primary mb-3">Add New Category</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>code</th>
            <th>label</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.code}</td>
                <td>${category.label}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/categories/view?id=${category.id}" class="btn btn-info btn-sm">View</a>
                    <a href="${pageContext.request.contextPath}/categories/edit?id=${category.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/categories/delete?id=${category.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>