<!-- viewOrder.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Order Details</h2>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <c:if test="${not empty order}">
            <div class="card">
                <div class="card-body">
                    <p>${order}</p>
                </div>
            </div>
            
            <div class="mt-3">
                <a href="/orders/${orderId}/edit" class="btn btn-warning">Edit</a>
                <a href="/orders" class="btn btn-secondary">Back to List</a>
            </div>
        </c:if>
    </div>
</body>
</html>