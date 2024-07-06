<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered</title>
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
.buttons {
    display: flex;
    flex-direction: column;
}

/* Submit buttons */
input[type="button"] {
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

    .question {
        margin-bottom: 15px;
    }

    .question label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
    }

    .question textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
        resize: vertical; /* Allow vertical resizing of textarea */
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
    	<form action="UserExamServlet" method="post">
    
        <div class="question">
            <label for="question1">*Question 1:<br>
            	Define nuclear fission and nuclear fusion.
            </label>
            <textarea id="question1" name="question1" rows="4" required></textarea>
        </div>

        <div class="question">
            <label for="question2">*Question 2:<br>
            	What is the Heisenberg Uncertainty Principle? Explain its significance in the context of quantum mechanics.
            </label>
            <textarea id="question2" name="question2" rows="4" required></textarea>
        </div>

        <div class="question">
            <label for="question3">*Question 3: <br>
            	Explain the difference between interference and diffraction of light.  
            	
            </label>
            <textarea id="question3" name="question3" rows="4" required></textarea>
        </div>

        <div class="buttons">
            <input type="submit" value="Submit Answers" />
        </div>
    </form>
    </div>
    
</body>
</html>