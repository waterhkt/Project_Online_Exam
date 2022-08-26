<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 06/08/2022
  Time: 5:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.0.0-web/css/all.css">
    <title>Check code</title>
    <style>
        .container{
            text-align: center;
            margin-top: 10%;
        }
        from{
            display: inline;
        }
        .code{
            margin-top: 2%;
            text-align: center;
        }
        .btn{
            margin-top: 2%;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="CT_Load_Question">
        <input name="subject"  style="display: none" value="${subid}">
        <input style="display: none" name="username" class="txtContentInfo" value="${ten_dang_nhap}">
        <h3 style="color: brown;font-size: 32px;">Nhập mã số sinh viên</h3>
        <div style="width: 100%"><input class="code form-control" type="text" name="code_name" ></div>
        <div style="width: 100%"><input class="btn btn-primary" type="submit"></div>

    </form>
</div>
</body>
</html>
