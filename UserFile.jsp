<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Record</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('https://images.unsplash.com/photo-1604872441539-ef1db9b25f92?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D') no-repeat center center fixed; /* URL for a soft background image */
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #333;
        }
        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #608da6;
            font-weight: bold;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #555;
            margin-bottom: 15px;
        }
        .button {
            margin-top: 20px;
        }
        a.button-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #608da6;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        a.button-link:hover {
            background-color: #74abc8;
        }
    </style>
</head>
<body>
	
    <div class="container">
        <%
            String n = (String) request.getAttribute("name");
            String e = (String) request.getAttribute("email");
            if (n != null && e != null) {
        %>
             <p>Yes! this student exists</p>
            <p>Student Name: <strong><%= n %></strong></p>
            <p>Email: <strong><%= e %></strong></p>
        <%
            } else {
        %>
            <p>No student record found.</p>
        <%
            }
        %>
        <div class="button">
            <a href="admin.jsp" class="button-link">Go Back</a>
        </div>
    </div>
</body>
</html>


