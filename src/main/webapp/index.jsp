<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 26/05/2021
  Time: 11:15 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Trang chủ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./css/style.css">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <style>
        body{
            background-color: #eeeeee;
        }
        .container{
            background-color: #efecec54;
            padding-left: 10%;
            padding-right: 10%;
            padding-bottom: 20%;
            height: auto;
        }
        a{
            width: 100%;
        }
        li{
            background-color: #efecec54;

        }
        form{
            background-color: #bfccc7;
            border: 3px solid #00000038;
            margin-bottom: 3%;
            padding-bottom: 3%;
        }
        h2{
            margin-top: 20px;
            font-weight: 600;
        }
        h3,p,button{
            margin-left: 3%;
            /*text-align: center;*/
            color: black;
            font-size: 18px;
        }
        button{
            /*margin-left: 40%;*/
            margin-left: 3%;
        }
    </style>
</head>

<body>
<%--<div class="container">--%>
<%--    <div>--%>
<%--        <h1 style="text-align: center;color: blue;margin-top: 70px;font-size: 42px">Hệ thống thi trắc nghiệm trực tuyến </h1>--%>
<%--    </div>--%>
<%--    <div style="width: 40%;margin-top: 30px;margin-left: 40%;">--%>
<%--        <div style="display: flex;width: 66%">--%>
<%--            <h4 style="flex: 1">Thí sinh:</h4>--%>
<%--            <p style="flex: 1.4;margin-top: 4%;color: #c0392b;font-size: 18px">Nguyễn Văn A</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<!-- DUNG CHUNG -->
<div class="wrapHeaderTop">
    <div class="containerApp ">
        <div class="headerTop">
            <p class="titleApp">
                Hệ thống thi trắc nghiệm trực tuyến
            </p>
            <p class="notification">
                Hệ thống thi trắc nghiệm Online - Trường Đại học Nông Lâm - Khoa Công nghệ Thông tin
            </p>
            <div class="Wrap_headerLogin">
                Xin chào, ${ten_dang_nhap}
                <div class="wrapSubMenu">
                    <div class="subMenu">
                        <a href="#!" class="menuItem">
                            Đổi mật khẩu
                        </a>
                        <a href="CT_Logout" class="menuItem">
                            Đăng xuất
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapTitlePage">
    <div class="overlay"></div>
    <p class="titlePage">
        Hệ thống thi trắc nghiệm trực tuyến
    </p>
</div>

<div class="pageQuanTri containerApp">
    <div>
<%--        <form action="CT_Load_Question" >--%>
<%--            <label class="lb-made" style="font-size: 28px">Mã đề</label>--%>
<%--            <input class="filed-text-made" style="width: 160px; height: 36px" type="text" name="codename" value="" placeholder="Nhập mã đề">--%>
<%--            <label class="lb-made" style="font-size: 28px">Mã môn học</label>--%>
<%--            <input class="filed-text-made" style="width: 160px; height: 36px" type="text" name="subjectId" value="" placeholder="Nhập mã môn học">--%>
<%--            <input type="submit" value="SUBMIT">--%>
<%--        </form>--%>
        <div>
            <h2>Danh sách các môn thi</h2>
        </div>
        <div>
            <ul>
                <li style="display: flex;flex-direction: column;">
                    <cc:forEach items="${list}" var="p">
                    <form action="#" style="flex: 1">
                        <h3 style="margin-top: 10px">${p.name}</h3>
                        <p style="padding-bottom: 10px;">Thời gian làm bài: 60 phút</p>
<%--                        <a href="CT_Load_Question?subjectName=${p.name}">Làm bài</a>--%>
                        <a style="background-color: #292589;padding: 10px;border-radius: 3px;margin-left: 3%;color: white;
                            text-decoration: none;" href="CT_Check_Inf?subId=${p.ma}">Làm bài</a>
                    </form>
                    </cc:forEach>
                </li>
            </ul>
        </div>
    </div>
    <!--    <div class="dropdown">-->
    <!--        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">-->
    <!--            Chọn môn học-->
    <!--        </button>-->

    <!--        <div class="dropdown-menu">-->
    <!--            <a class="dropdown-item" href="CT_Load_Question">Lập Trinh cơ bản</a>-->
    <!--            <a class="dropdown-item" href="CT_Load_Question">Lập Trình nâng cao</a>-->
    <!--            <a class="dropdown-item" href="CT_Load_Question">Lập Trình mạng</a>-->
    <!--        </div>-->
<%--</div>--%>
<%--</div>--%>
</body>
</html>

