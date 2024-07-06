<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*, javax.servlet.*" %>
   <% 
   		HttpSession ss = request.getSession(false); 
   		if(ss == null || !"user".equals(ss.getAttribute("type"))){
   			response.sendRedirect("loginn.html");
   		}
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User-Page</title>
<link rel="stylesheet" href="style1.css">
</head>
<style>
body {
        font-family: Arial, sans-serif;
        background: url('https://images.unsplash.com/photo-1604872441539-ef1db9b25f92?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D') no-repeat center center fixed; /* Background image */
        background-size: cover;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        color: #333;
    }
    .container {
        background: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
        padding: 20px 40px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 800px;
        text-align: center;
    }
h1 {
    text-align: center;
    color: #608da6;
    font-weight: bold;
    margin-bottom: 20px;
}
    /* Table styles */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #608da6;
        color: #E5F2F2;
    }

    /* Link styles */
    a {
        text-decoration: none;
        color: #608da6;
    }

    a:hover {
        text-decoration: underline;
        color: #74abc8;
    }
</style>
<body>
	
	<div class="container">
	<h1>Welcome Student</h1>
			<table border=1>
        <tr>
        	<th>Exam ID</th>
            <th>Title</th>
            <th>Total Marks</th>
            <th>Total Time</th>
            <th>Question Type</th>
            <th>Action</th>
        </tr>
        <tr>
        	
            <td>E1</td>
            <td>Physics</td>
            <td>100</td>
            <td>90 minutes</td>
            <td>Short Questions</td>
            <td><a href="takeExam1.jsp">Take Exam</a></td>
        </tr>
        <tr>
            <td>E2</td>
            <td>English</td>
            <td>150</td>
            <td>100 minutes</td>
            <td>Short Questions</td>
            <td><a href="takeExam2.jsp">Take Exam</a></td>
        </tr>
        <tr>
            <td>E3</td>
            <td>Social Science</td>
            <td>85</td>
            <td>80 minutes</td>
            <td>Short Questions</td>
            <td><a href="takeExam3.jsp">Take Exam</a></td>
        </tr>
        <tr>
            <td>E4</td>
            <td>Computer</td>
            <td>70</td>
            <td>90 minutes</td>
            <td>Short Questions</td>
            <td><a href="takeExam4.jsp">Take Exam</a></td>
        </tr>
         <tr>
            <td>E5</td>
            <td>Math</td>
            <td>70</td>
            <td>90 minutes</td>
            <td>Short Questions</td>
            <td><a href="takeExam5.jsp">Take Exam</a></td>
        </tr>
    </table>
	</div>
	
	
</body>
</html>