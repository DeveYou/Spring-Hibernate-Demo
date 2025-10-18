<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${category != null ? 'Edit' : 'Add'} Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>${category != null ? 'Edit' : 'Add'} Category</h1>
    <a href="${pageContext.request.contextPath}/categories/list" class="btn btn-secondary mb-3">Back to List</a>

    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/categories/save" method="post">
                <c:if test="${category != null}">
                    <input type="hidden" name="id" value="${category.id}" />
                </c:if>

                <div class="mb-3">
                    <label for="label" class="form-label">Label</label>
                    <input type="text" class="form-control" id="label" name="label" value="${category != null ? category.label : ''}" required>
                </div>

                <div class="mb-3">
                    <label for="code" class="form-label">Code</label>
                    <input type="text" step="0.01" class="form-control" id="code" name="code" value="${category != null ? category.code : ''}" required>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>