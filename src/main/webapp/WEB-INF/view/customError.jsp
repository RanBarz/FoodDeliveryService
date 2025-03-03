<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error - ${errorTitle}</title>
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    <style>
        .error-container {
            max-width: 800px;
            margin: 50px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        
        .error-code {
            font-size: 72px;
            color: #e74c3c;
            margin: 0;
        }
        
        .error-title {
            font-size: 24px;
            margin-top: 0;
            color: #333;
        }
        
        .error-message {
            font-size: 16px;
            color: #555;
            margin: 20px 0;
            line-height: 1.5;
        }
        
        .back-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
            margin-top: 20px;
            transition: background-color 0.3s;
        }
        
        .back-link:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1 class="error-code">${errorCode}</h1>
        <h2 class="error-title">${errorTitle}</h2>
        <p class="error-message">${errorMessage}</p>
        <a href="<c:url value='${backLink}'/>" class="back-link">${backLinkText}</a>
    </div>
</body>
</html>