<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        body {
            font-family: arial, sans-serif;
            margin: 0;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333333;
        }

        li {
            float: left;
        }

        li a {
            font-weight: 800;
            display: block;
            color: white;
            text-align: center;
            padding: 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111111;
        }

        form{
            margin: 25px;
            position: fixed;
            top: 50%;
            left: 50%;
            width: 30%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }

        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #6297cb;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #4c79a5;
        }
    </style>
    <meta charset="UTF-8">
    <title>Log In</title>
</head>
<body>


<ul>
    <li><a href="#">Home</a></li>
</ul>

<form action="LoginServlet" method="post">
    <label>Login</label>
    <input  type="text" name="login" placeholder="Enter your login">

    <label>Password</label>
    <input type="text" name="password" placeholder="Enter your password">

    <input type="submit" value="Log In">
</form>
</body>
</html>
