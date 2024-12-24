<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    HttpSession session1 = request.getSession(false);
    String userName = (session1 != null) ? (String) session1.getAttribute("name") : null;
    String rollNo = (session1 != null) ? (String) session1.getAttribute("rollNo") : null;

    if (userName == null || rollNo == null) {
        response.sendRedirect("login.jsp"); // Redirect to login if session is not valid
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navigation</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .navbar-custom {
            background-color: #1c1c1e; /* Dark solid background */
            color: #ffffff; /* White text */
        }
        .navbar-custom .navbar-brand, .navbar-custom .nav-link, .navbar-custom .btn {
            color: white;
        }
        .navbar-custom .nav-link:hover, .navbar-custom .btn:hover {
            color: #f0ad4e; /* Gold color on hover */
        }
        .navbar-custom .btn-outline-danger:hover {
            background-color: #d9534f;
            color: white;
        }
        .nav-user-info {
            font-weight: bold;
            margin-right: auto;
            padding-left: 10px;
            color: white;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-custom py-3">
        <div class="container-fluid">
            <!-- User Information -->
            <span class="nav-user-info">
                Welcome, <%= userName %>
            </span>
            
            <!-- Centered Navigation Buttons -->
            <div class="collapse navbar-collapse justify-content-center">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="profile.jsp" class="nav-link px-3">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a href="internship.jsp" class="nav-link px-3">Internships</a>
                    </li>
                    <li class="nav-item">
                        <a href="Projects.jsp" class="nav-link px-3">Projects</a>
                    </li>
                    <li class="nav-item">
                        <a href="documents.jsp" class="nav-link px-3">Documents</a>
                    </li>
                </ul>
            </div>
            
            <!-- Logout Button -->
            <div>
                <form action="logout" method="post" class="d-inline">
                    <button class="btn btn-outline-danger" type="submit">Logout</button>
                </form>
            </div>
        </div>
    </nav>
</body>
</html>
