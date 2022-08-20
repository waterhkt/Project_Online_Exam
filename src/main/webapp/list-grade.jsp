<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 03/05/2022
  Time: 11:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách điếm</title>
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
</head>
<body>
<%--<section id="main">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-3">--%>

<%--            </div>--%>
<%--            <div class="col-md-9">--%>
<%--                <!-- Website Overview -->--%>
<%--                <div class="panel panel-default">--%>
<%--                    <div class="panel-heading main-color-bg">--%>
<%--                        <h3 class="panel-title">List Grade</h3>--%>
<%--                    </div>--%>
<%--                    <div class="panel-body">--%>
<%--                        <table class="table table-striped table-hover" style="width: 100%">--%>
<%--                            <tr>--%>
<%--                                <th>User id</th>--%>
<%--                                <th>Code id</th>--%>
<%--                                <th>Grade</th>--%>
<%--                                <th>Time</th>--%>
<%--                                <th>Date</th>--%>


<%--                            </tr>--%>
<%--                            <cc:forEach items="${list}" var="p">--%>
<%--                                <tr>--%>
<%--                                    <td >${p.userid}</td>--%>
<%--                                    <td >${p.codeid}</td>--%>
<%--                                    <td>${p.grade}</td>--%>
<%--                                    <td>${p.stime}</td>--%>
<%--                                    <td>${p.date}</td>--%>

<%--                                </tr>--%>
<%--                            </cc:forEach>--%>

<%--                        </table>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
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
    <div class="sectionApp">
        <p class="titleSection">
            Danh sách điểm
        </p>
        <p class="titleSection">
            Môn : ${name}
        </p>
        <div class="btn-create" style="float: right">
            <a class="js-add-subject add-subject " style="text-decoration: none;color: white;font-size: 17px;border: 1px solid darkblue;background-color: #7979d7" href="CT_Add_Question">Thêm câu hỏi</a>
        </div>
    </div>

    <div class="tableGrid">
        <div class="grid-col-5">
            <p style="width: 150%" class="col-title">
                MSSV
            </p>
            <p class="col-title">
               Mã đề
            </p>
            <p class="col-title">
                Điểm
            </p>
            <p class="col-title">
                Giờ
            </p>
            <p class="col-title">
                Ngày
            </p>

        </div>

        <!-- HÀNG -->
        <cc:forEach items="${list}" var="p">
        <div class="grid-col-5">
            <div style="width: 150%" class="col-content col-action">
                    ${p.userid}
            </div>
            <div class="col-content col-action">
                    ${p.codeid}
            </div>
            <div class="col-content">
                    ${p.grade}
            </div>
            <div class="col-content col-action">
                    ${p.stime}
            </div>
            <div class="col-content col-action">
                    ${p.date}
            </div>
        </div>
        </cc:forEach>
        <!-- END HÀNG -->
</body>
</html>

