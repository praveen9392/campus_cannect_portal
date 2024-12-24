<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTaZEE0waqaA7iymshgDwKnpvdCAYF1e0FbQ&s');
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.85);
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
        }

        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: green;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

       p{
            margin-top: 20px;
        }

         #ajaxresponse {
            margin-top: -2px;
            font-weight: bold;
            text-align: left;  /* Align text to the left */
            margin-left: 10px;  /* Slightly shift the message to the left */
        }
		.black{ font-size:11px; color:black}
		.red{font-size:11px; color:red}
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div class="form-container">
        <h2>User Registration</h2>
        <form class="form-group" name="register" method="post" action="register">
            <input type="email" name="email" id="email" placeholder="Email" class="form-control" required>
            <p id="ajaxresponse" ></p>
            <div id="status">
            <input type="text" name="first_name" id="first_name" placeholder="First Name" class="form-control" required disabled>
            <input type="text" name="last_name" id="last_name" placeholder="Last Name" class="form-control" required disabled>
            <input type="text" name="rollno" id="rollno" placeholder="Roll Number" class="form-control" required disabled>
            <input type="password" name="password" id="password" placeholder="Password" class="form-control" required disabled>
            <button type="submit" disabled>Register</button>
            </div>
        </form>
        <p style="color:red;">
            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
        </p>
        <p>Already have an account? <a href="login.jsp" style="text-decoration:none;">Login here</a></p>
    </div>
    <script type="text/javascript">
    $(document).ready(function() {
        $('#email').blur(function(event) {
            var mail = $('#email').val();
            $.get('GetServlet', {           //send email data by using doget method
                email: mail
            }, function(res) {
                // Check the 'exists' property in the response
               if (res.exists) { // Assuming `res.exists` is a boolean returned by the server
                        $('#ajaxresponse').text("Email available ✅").removeClass('red').addClass('black');  
                        $('#status').find('input, button').prop('disabled', false); // Enable form inputs and button
                    } else {
                        $('#ajaxresponse').text("Email unavailable ❌ Contact admin").removeClass('black').addClass('red');
                        $('#status').find('input, button').prop('disabled', true); // Disable form inputs and button
                    }
            });
        });
    });
    </script>
</body>
</html>
