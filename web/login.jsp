<%@ page import="models.User" %>
<link rel="icon" href="css/logo.jpg">
<!doctype html>
<html>
<!--border: 3px solid #f1f1f1;
-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: "Tele2 Slab", Helvetica, sans-serif;
            background-image: url("https://digitalsynopsis.com/wp-content/uploads/2017/07/beautiful-color-ui-gradients-backgrounds-decent.png");
            background-size: cover;
        }

        form {

            width: 30%;
            position: center;
            margin-left: 3%;
            border-radius: 50px;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-family: "Tele2 Slab";
            border-radius: 50px;
        }

        button {
            background-color: rgba(10, 64, 51, 0.8);
            color: #d7d7d7;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            border-radius: 50px;
        }

        .wsc_logo {
            margin-top: 3%;
            margin-left: 3%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: rgba(255, 249, 186, 0.8);
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding-left: 16px;
            padding-right: 16px;
            padding-bottom: 16px;
            padding-top: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }

            .cancelbtn {
                width: 100%;
            }
        }

        .custom-select {
            position: relative;
            width: 100%;
            background-color: #E8F0F8;
            z-index: 10;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;

        }

        .custom-select select {
            border: #664D4F;
            outline: none;
            background: transparent;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            border-radius: 10%;
            margin: none;
            display: block;
            width: 100%;
            padding: 0;
            font-size: 14px;
            color: #664D4F;
            font-family: "Tele2 Slab";
        }

        .custom-select:after {
            position: absolute;
            right: 0;
            top: 0;
            width: 50px;
            height: 100%;
            line-height: 38px;
            content: "∵";
            text-align: center;
            color: #664D4F;
            font-size: 32px;
            border-left: 1px solid #E8F0F8;

            z-index: -1;
        }
    </style>
</head>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        response.sendRedirect("indexLDAP.jsp");
        return;
    }
%>
<body>
<form style="margin-left: 33%; margin-top: 10%" action="/wsc/Login" method="post">

    <div class="container">
        <input name="email" type="text" id="inputLogin" class="form-control" placeholder="Name.Surname" required
               autofocus>

        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required autofocus>

        <button type="submit" style="font-family: 'Tele2 Slab'">Login</button>
        <%
            String error = request.getParameter("error");
            if (error != null) {
                if (error.equals("1")){
                    out.println("<p style=\"color: red\"> Wrong login or password </p>");
                }
         //       else if(error.equals("2")){out.println("<p style=\"color: red\"> You are not invited, create remedy request for wsc.tele2.kz</p>");)
            }
        %>

    </div>
</form>

</body>
</html>
