<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
    HttpSession ss = request.getSession(false); 
    if(ss == null || !"admin".equals(ss.getAttribute("type"))){
        response.sendRedirect("loginn.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Student By Email</title>
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
    background: rgba(255, 255, 255, 0.8); /* Semi-transparent white */
    padding: 20px 40px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
    text-align: left;
}

/* Form heading */
h1 {
    text-align: center;
    color: #608da6;
    font-weight: bold;
    margin-bottom: 20px;
}
label {
    display: block;
    margin-bottom: 5px;
    color: #555;
    font-size: 14px;
}

/* Text input fields */
input[type="text"],
input[type="password"],
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
    box-sizing: border-box;
}
.buttons {
    display: flex;
    flex-direction: column;
}

/* Submit buttons */
input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #608da6;
        border: none;
        border-radius: 4px;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-bottom: 10px;
    }

input[type="submit"]:hover {
    background-color: #74abc8;
}
</style>
</head>
<body>
    <div class="container">
        <form action="SearchServlet" method="post">
            <h1>Search Student By Email</h1>
            Name: <input type="text" name="name" placeholder="Enter name"/> <br><br>
            Student Email: <input type="text" name="email" placeholder="Enter email"/>
            <div class="button">
                <input type="submit" value="Search" /><br><br>
            </div>
        </form>
    </div>
</body>
</html>
