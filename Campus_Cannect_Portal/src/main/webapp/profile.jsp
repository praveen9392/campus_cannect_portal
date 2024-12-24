<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <style>
        /* General body styling */
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

        /* Container Styling */
        .container {
            width: 60%;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
        }
        #container{
             width: 60%;            /*above width is not working,so provide by uding id*/
        }

        /* Header styling */
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

        /* Form styling */
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .form-control {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            color: #333;
            transition: box-shadow 0.3s ease;
        }

        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.6);
            outline: none;
        }

        textarea {
            resize: vertical;
            border: 1px solid #ccc;
            border-radius: 6px;
            padding: 10px;
            font-size: 16px;
        }

        textarea:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.6);
        }

        .button {
            background-color: #007bff;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        button:hover {
            background-color: #0056b3;
            transform: scale(1.01);
        }

        button:active {
            transform: scale(1);
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .container {
                width: 90%;
                padding: 20px;
            }

            h2 {
                font-size: 24px;
            }

            .form-control, button {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

    <!-- Include the header -->
    <jsp:include page="home.jsp" />

    <!-- Main Profile Form -->
    <div class="container" id="container">
        <h2>Profile Information</h2>

        <!-- Form to update profile -->
        <form class="form-group" method="post" action="ProfileServlet">
            <input type="text" name="name" id="name" placeholder="Full name" class="form-control" required>
            <input type="email" name="email" id="email" placeholder="Email" class="form-control" required>
            <input type="text" name="phone" id="phone" placeholder="Phone Number" class="form-control" required>
            <input type="text" name="degree" id="degree" placeholder="Degree" class="form-control" required>
            <input type="text" name="branch" id="branch" placeholder="Branch" class="form-control" required>
            <input type="text" name="cgpa" id="cgpa" placeholder="CGPA" class="form-control" required>
            <input type="text" name="address" id="address" placeholder="Address" class="form-control" required>
            <input type="text" name="city" id="city" placeholder="City" class="form-control" required>
            <input type="text" name="state" id="state" placeholder="State" class="form-control" required>
            <input type="text" name="zip" id="zip" placeholder="Pincode" class="form-control" required>
            <textarea id="summary" name="summary" placeholder="Enter a brief summary about yourself..." rows="4" cols="50" class="form-control"></textarea>
            <button type="submit" class="button">Update Profile</button>
        </form>
    </div>

</body>
</html>
