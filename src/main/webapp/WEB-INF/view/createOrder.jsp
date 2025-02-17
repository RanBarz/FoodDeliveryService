<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function selectAddress(city) {
            document.getElementById("address").value = city;
            document.querySelectorAll(".city-btn").forEach(btn => btn.classList.remove("btn-success"));
            document.getElementById("btn-" + city).classList.add("btn-success");
        }
    </script>
</head>
<body>
    <div class="container mt-4">
        <h2>Create New Order</h2>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form:form action="${pageContext.request.contextPath}/orders/create" method="POST" modelAttribute="order">
            <!-- Restaurant selection dropdown -->
            <div class="mb-3">
                <label for="restaurant" class="form-label">Select Restaurant</label>
                <form:select class="form-control" path="restaurant" required="true">
                    <form:option value="" label="Choose a restaurant..." />
                    <form:option value="McDonald's" label="McDonald's" />
                    <form:option value="Burger King" label="Burger King" />
                    <form:option value="Subway" label="Subway" />
                    <form:option value="KFC" label="KFC" />
                    <form:option value="Pizza Hut" label="Pizza Hut" />
                </form:select>
            </div>

            <div class="mb-3">
                <label for="dishes" class="form-label">Dishes (one per line)</label>
                <form:textarea class="form-control" path="dishes" rows="3" required="true" />
            </div>

            <!-- City selection with buttons -->
            <div class="mb-3">
                <label class="form-label">Choose Delivery City</label>
                <div>
                    <button type="button" id="btn-New York" class="btn btn-outline-primary city-btn" onclick="selectAddress('New York')">New York</button>
                    <button type="button" id="btn-Los Angeles" class="btn btn-outline-primary city-btn" onclick="selectAddress('Los Angeles')">Los Angeles</button>
                    <button type="button" id="btn-Chicago" class="btn btn-outline-primary city-btn" onclick="selectAddress('Chicago')">Chicago</button>
                    <button type="button" id="btn-Houston" class="btn btn-outline-primary city-btn" onclick="selectAddress('Houston')">Houston</button>
                    <button type="button" id="btn-Miami" class="btn btn-outline-primary city-btn" onclick="selectAddress('Miami')">Miami</button>
                </div>
                <form:hidden path="address" id="address" required="true" />
            </div>

            <button type="submit" class="btn btn-primary">Create Order</button>
            <a href="${pageContext.request.contextPath}/orders" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>
</body>
</html>
