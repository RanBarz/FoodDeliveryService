<!-- orderList.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Orders</h2>
        
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <a href="${pageContext.request.contextPath}/orders/create" class="btn btn-primary mb-3">Create New Order</a>
        
        <c:if test="${not empty orders}">
            <div class="list-group">
                <c:forEach items="${orders}" var="order">
                    <div class="list-group-item">
                        <div class="d-flex justify-content-between align-items-center">
                            <div>${order}</div>
                            <div>
                                <a href="${pageContext.request.contextPath}/orders/${order.id}/edit" class="btn btn-warning btn-sm">Edit</a>
                                <form style="display: inline" action="${pageContext.request.contextPath}/orders/${order.id}/delete" method="POST">
                                    <button type="submit" class="btn btn-danger btn-sm" 
                                            onclick="return confirm('Are you sure?')">Delete</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</body>
</html>