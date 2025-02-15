<!-- editOrder.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Edit Order</h2>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/orders/${order.id}/edit" method="POST">
            <div class="mb-3">
                <label for="address" class="form-label">Delivery Address</label>
                <input type="text" class="form-control" id="address" name="address" 
                       value="${order.address}" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Order</button>
            <a href="/" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>