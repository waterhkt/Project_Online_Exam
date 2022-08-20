<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 27/04/2022
  Time: 6:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/list.css">
    <link href="admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="admin/css/font-awesome.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Question</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.0.0-web/css/all.css">
    <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
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
<%--                        <h3 class="panel-title">Quản lý câu hỏi</h3>--%>
<%--                    </div>--%>
<%--                    <div class="panel-body">--%>
<%--                        <table class="table table-striped table-hover" style="width: 100%">--%>
<%--                            <a href="CT_Add_Question"> <button id="btn_get_list">Xem danh sach SV</button></a>--%>
<%--                            <a href="CT_Add_Question"> <button id="btn_them_post">Thêm câu hỏi mới</button></a>--%>
<%--                            <tr>--%>
<%--                                <th>Thứ tự</th>--%>
<%--                                <th>Câu hỏi</th>--%>
<%--                                <th>Đáp án A</th>--%>
<%--                                <th>Đáp án B</th>--%>
<%--                                <th>Đáp án C</th>--%>
<%--                                <th>Đáp án D</th>--%>
<%--                                <th>KQ</th>--%>
<%--                                <th>Thao tác</th>--%>


<%--                            </tr>--%>
<%--                            <cc:forEach items="${list}" var="p">--%>
<%--                                <tr>--%>
<%--                                    <td >${p.number}</td>--%>
<%--                                    <td >${p.content}</td>--%>
<%--                                    <td>${p.a}</td>--%>
<%--                                    <td>${p.b}</td>--%>
<%--                                    <td>${p.c}</td>--%>
<%--                                    <td>${p.d}</td>--%>
<%--                                    <td>${p.resukt}</td>--%>
<%--                                    <td><a  class="btn btn-default" class="list-group-item" href="CT_Get_Question_Update?id=${p.id}">--%>
<%--                                        Chỉnh sữa</a>--%>
<%--                                        <a class="btn btn-danger"  class="list-group-item"--%>
<%--                                           href="CT_Delete_Question?id=${p.id}">Xóa</a>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
<%--                            </cc:forEach>--%>

<%--                        </table>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- DUNG CHUNG -->
<div class="wrapHeaderTop">
    <div class="containerApp ">
        <div class="headerTop">
            <p class="titleApp">
                online Exam
            </p>
            <p class="notification">
                (QC) Xem Phim HOT 100% DATA TOC DO CAO voi DV TV360 tai http://s.viettel.vn/cliptv. Dang ky, soan XN1 gui 1331 (3.000d/ngay, gia han theo ngay).
            </p>
            <div class="Wrap_headerLogin">
                Xin chao, ${ten_dang_nhap}
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
            Danh sách các câu hỏi
        </p>
        <p class="titleSection">
            Môn : ${name}
            <input style="display: none" name="na" value="${name}">
        </p>
<%--        <div class="btn-create" style="float: right">--%>
<%--            <a class="js-add-subject add-subject " style="text-decoration: none;color: white;font-size: 17px;border: 1px solid darkblue;background-color: #7979d7" href="CT_Add_Question?namecode=${name}">Thêm câu hỏi</a>--%>
<%--        </div>--%>
    </div>

    <div class="tableGrid">
        <div class="grid-col-5">
            <p class="col-title">
                STT
            </p>
            <p class="col-title">
                Câu hỏi
            </p>
            <p class="col-title">
                Kết quả
            </p>
            <p class="col-title">
                Edit
            </p>
            <p class="col-title">
                Remove
            </p>
        </div>

        <!-- HÀNG -->
        <cc:forEach items="${list}" var="v">
        <div class="grid-col-5">
            <div class="col-content col-action">
                ${v.id}
            </div>
            <div class="col-content">
                    ${v.content}
            </div>
            <div class="col-content col-action">
                ${v.resukt}
            </div>
<%--            <div class="col-content col-action">--%>
<%--                    ${v.number}--%>
<%--            </div>--%>
            <div class="col-content col-action">
                <a href="CT_Get_Question_Update?id=${v.id}&code=${name}" class=" btnPrimary-sm">
                    Edit
                </a>
            </div>
            <div class="col-content col-action">
                <a href="CT_Delete_Question?id=${v.id}" class="btnDanger-sm">
                    Remove
                </a>
            </div>
        </div>
        </cc:forEach>
        <!-- END HÀNG -->
</body>
</html>
