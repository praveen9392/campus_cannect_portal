<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Internship</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
         body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            /*background: linear-gradient(to right, #74ebd5, #acb6e5);*/
            background-image: url('https://img.freepik.com/free-vector/watercolor-painted-abstract-background_23-2149107118.jpg?ga=GA1.1.2064247889.1729060619&semt=ais_hybrid');
    		background-repeat: no-repeat;  /* Prevents image from repeating */
    		background-size: cover;  /* Ensures the image covers the whole body */
    		background-position: center;  /* Centers the image on the screen */
    		margin: 0;
    		padding: 0;
        }
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .form-container {
            max-width: 50%;
            margin: 50px auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #343a40;
        }
        .btn-custom {
            background-color: #007bff;
            color: blue;
            border: none;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
        h2 {
            text-align: center;
            color: #3a3a3a;
            margin-bottom: 25px;
            font-size: 28px;
            font-weight: bold;
            text-transform: uppercase;
            border-bottom: 2px solid #007bff;
            display: inline-block;
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="home.jsp" />
<div class="form-container">
    <h2>Internship</h2>
    <form method="post" action="Internship">
        <div class="mb-3">
            <label for="projectname" class="form-label">Internship Title</label>
            <input type="text" name="internshipname" id="internshipname" class="form-control" placeholder="Enter internship title" required>
        </div>
        <div class="mb-3">
            <label for="ProblemStatement" class="form-label">Role</label>
            <input type="text" name="role" id="role" class="form-control" placeholder="Ex: Tester role " required>
        </div>
        <div class="mb-3">
            <label for="technology" class="form-label">Company name</label>
            <input type="text" name="company" id="company" class="form-control" placeholder="Enter Company name and Location" required>
        </div>
        <div class="mb-3">
            <label for="overview" class="form-label">skills gained</label>
            <textarea name="skills" id="skills" rows="4" class="form-control" placeholder="Provide a brief Internship overview, mension duration" required></textarea>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-custom" style="background-color:blue">Submit</button>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
