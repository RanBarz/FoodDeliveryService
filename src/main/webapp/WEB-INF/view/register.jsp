<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery - Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
        }

        .card {
            border-radius: 15px;
        }

        .card p {
            font-size: 0.875rem;
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-primary {
            background-color: #4CAF50;
            border-color: #4CAF50;
            border-radius: 10px;
        }

        .btn-primary:hover {
            background-color: #45a049;
            border-color: #45a049;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center vh-100 bg-light">

    <div class="card p-4 shadow-lg" style="width: 400px;">
        <h3 class="text-center mb-4">Create Your Account</h3>

        <%-- Display error message if present --%>
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center mb-3">
                ${error}
            </div>
        </c:if>

        <form action="register" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Create a password" required>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100 py-2">Register</button>
        </form>

        <p class="text-center mt-3">
            <a href="login" class="text-decoration-none">Already have an account? Login</a>
        </p>
    </div>

</body>

</html>
