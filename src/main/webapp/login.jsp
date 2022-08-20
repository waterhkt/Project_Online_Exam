<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 19/06/2021
  Time: 11:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            background: #eee !important;
        }

        .wrapper {
            margin-top: 80px;
            margin-bottom: 80px;
        }

        .form-signin {
            max-width: 380px;
            padding: 15px 35px 45px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid rgba(0, 0, 0, 0.1);
        }

        .form-signin-heading,
        .checkbox {
            margin-bottom: 30px;
        }

        .checkbox {
            font-weight: normal;
        }

        .form-control {
            position: relative;
            font-size: 16px;
            height: auto;
            padding: 10px;
        @include box-sizing(border-box);
        }

        input[type="text"] {
            margin-bottom: -1px;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
        }

        input[type="password"] {
            margin-bottom: 20px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .correc{
            height: 60px;
            background-color: red;
            position: absolute;
            margin-top: 100px;
            margin-left: 400px;
        }


    </style>
</head>
<body>
<div class="wrapper">
    <form class="form-signin" action="CT_Login?${username}" method="post">
        <h2 class="form-signin-heading">ĐĂNG NHẬP</h2>
        <input type="text" class="form-control" name="username" placeholder="Tên đăng nhập" required="" autofocus="" />
        <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required=""/>
        <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Nhớ mật khẩu
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Đăng nhập</button>
    </form >
<%--    <div class="correc">--%>
<%--        <form action="CT_Login_Correct">--%>
<%--            <label class="corect-content">Nhập sai tên đăng nhập hoặc mật khẩu</label>--%>
<%--            <button class="" type="submit">Nhập lại</button>--%>
<%--        </form>--%>
<%--    </div>--%>
</div>
</body>
</html>
