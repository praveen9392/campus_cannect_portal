<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        /* Reset some default browser styling */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        
        /* Background styling */
        body {
            background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTaZEE0waqaA7iymshgDwKnpvdCAYF1e0FbQ&s');
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Center the form with padding and shadow */
        .form-container {
            background: rgba(255, 255, 255, 0.85); /* Light transparent white */
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
            width: 360px;
            text-align: center;
        }

        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .form-control {
   		 width: 100%;  /* Ensures input fields take the full width of their container */
 	     padding: 10px;  /* Adds space inside the input fields */
    	 margin: 10px 0;  /* Adds space between the input fields */
   	     border: 1px solid #ccc;  /* Adds a light border around the fields */
    	 border-radius: 4px;  /* Rounds the corners of the input fields */
		}

        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        p {
            margin-top: 20px;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>
        <form class="form-group" name="registration" method="post" action="login">
   		<input type="text" name="rollno" id="rollno" placeholder="Roll Number" class="form-control" required>
    	<input type="password" name="password" id="password" placeholder="Password" class="form-control" required>
    	<button type="submit">Login</button>
		</form>
        <p style="color:red;">
        	<%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
        </p>
        <p>Don't have an account? <a href="index.jsp" style="text-decoration:none;">Register here</a></p>
    </div>
</body>
</html>
