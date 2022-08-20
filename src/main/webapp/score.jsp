<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 17/04/2022
  Time: 11:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Score</title>
    <style>
        h1{
            text-align: center;
        }
        h3{
            text-align: center;
            color: #de3810;
        }
    </style>
</head>
<body>
<h1>Số điểm bạn đạt được là :</h1>
<h3> ${score} điểm</h3>
<form action="CT_Logout"><button class="btn btnPrimary" type="submit" style="margin-left: 48%;">Hoàn Thành</button></form>

</body>
</html>
