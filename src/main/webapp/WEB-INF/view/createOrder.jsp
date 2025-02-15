<!-- createOrder.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Create New Order</h2>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/orders/create" method="POST">
            <div class="mb-3">
                <label for="restaurant" class="form-label">Restaurant</label>
                <input type="text" class="form-control" id="restaurant" name="restaurant" required>
            </div>
            
            <div class="mb-3">
                <label for="dishes" class="form-label">Dishes (one per line)</label>
                <textarea class="form-control" id="dishes" name="dishes" rows="3" required></textarea>
            </div>
            
            <div class="mb-3">
                <label for="address" class="form-label">Delivery Address</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Create Order</button>
            <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>