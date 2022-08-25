<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 23/04/2022
  Time: 12:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.0.0-web/css/all.css">
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        #header {
            background-color: black;
            height: 46.5px;
            position: fixed;
            top: 0;
            right: 0;
            left: 0;
            /* nang chieu sau cua header len phia mat tren */
            z-index: 1;
        }

        /* noi dung den dau dai den do */
        #nav {
            display: inline-block;
            float: right;
        }

        #nav, .subnav {
            list-style: none;
        }
        /* chi li cua header nam ngang hang */
        #nav > li {
            display: inline-block;
        }
        /* a chua text, li chua ca the */
        #nav li {
            position: relative;
        }

        #nav > li > a {
            color: #fff;
            text-transform: uppercase;
        }

        #nav li a {
            text-decoration: none;
            line-height: 46.5px;
            padding: 0 24px;
            display: block;

        }

        #nav li:hover .subnav {
            display: block;
        }

        #nav > li:hover > a,
        #nav .subnav li:hover a {
            color: #000;
            background-color: #ccc;
        }


        #nav .subnav {
            display: none;
            position: absolute;
            top: 46.5;
            left: 0;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            min-width: 160px
        }

        /* doi mau ca the li
        #nav .subnav li {
            width: 100%;
        } */

        #nav .subnav a {
            color: #000;
            padding: 0 12px;
            line-height: 38.5px;
        }

        #nav .nav-arrow-down {
            font-size: 16px;
        }

        /* Button */
        .btn-create {
            margin-top: 100px;

        }

        .add-subject {
            padding: 4px 8px;
        }

        .subject {
            height: 48px;
            width: 96px;
            margin: 8px 0;
            border: 1px solid #000;
            display: block;
            cursor: pointer;
        }

        /* Modal */
        .modal {
            position: fixed;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            background-color: rgba(0, 0, 0, 0.4);
            display: none;
            align-items: center;
            justify-content: center;
        }

        .modal.open {
            display: flex;
        }

        .modal-container {
            background-color: #fff;
            width: 900px;
            max-width: calc(100% - 32px);
            min-height: 300px;
            position: relative;
            margin: auto;
            margin-top: 200px;
            animation: modalFadeIn ease 0.7s;
        }

        .modal-header {
            color: #fff;
            background-color: #009688;
            height: 130px;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            font-size: 30px;
            font-weight: 400;
            letter-spacing: 4px;
        }

        .modal-close:hover {
            background-color: #ccc;
            color: #000;
        }

        .modal-close {
            position: absolute;
            right: 0;
            top: 0;
            color: #fff;
            padding: 16px;
            cursor: pointer;
        }

        .modal .modal-icon-heading {
            margin-right: 16px;
        }

        .modal-body {
            padding: 16px;
        }

        .modal-label {
            display: block;
            font-size: 15px;
            margin-bottom: 12px;
        }

        .modal-input {
            border: 1px solid #ccc;
            width: 100%;
            font-size: 15px;
            padding: 11px;
            margin-bottom: 24px;
        }

        #creat-subject {
            background-color: #009688;
            border: none;
            color: #fff;
            width: 100%;
            font-size: 15px;
            text-transform: uppercase;
            padding: 16px;
        }

        #creat-subject:hover {
            opacity: 0.9;
            cursor: pointer;
        }


        @keyframes modalFadeIn {
            from {
                opacity: 0;
                transform: translateY(-200px);
            }

            to {
                opacity: 1;
                transform: translateY(0px);
            }
        }
    </style>
</head>
<body>
<%--<div class="main container">--%>

<%--    <div id="header">--%>
<%--        <!-- Begin: Nav -->--%>
<%--        <ul id="nav">--%>
<%--            <li><a href="#">Xin chào bạn</a></li>--%>
<%--            <li><a href="#logout">Đăng xuất</a></li>--%>
<%--        </ul>--%>
<%--        <!-- End: Nav -->--%>

<%--    </div>--%>
<%--<h1 style="text-align: center;margin-top: 100px">TRANG QUẢN LÝ HỆ THỐNG THI ONLINE DÀNH CHO GIÁO VIÊN</h1>--%>
<%--    <div class="btn-create">--%>
<%--        <button  class="js-add-subject add-subject">Tạo môn học</button>--%>
<%--    </div>--%>
<%--&lt;%&ndash;    <div class="btn">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="CT_Add_Question"  class="">Thêm câu hỏi</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--    <div class="list-subject">--%>
<%--            <ul>--%>
<%--                <cc:forEach items="${list}" var="v">--%>
<%--                    <a style="text-decoration: none;color: white;background-color: #009688;font-size: 15px" href="CT_Load_List?name1= ${v.name}" type="submit" class="subject" name="nameMH">${v.name}</a>--%>
<%--                    <a href="CT_Delete_Subject?id=${v.ma}">Xoa</a>--%>
<%--                </cc:forEach>--%>
<%--            </ul>--%>
<%--    </div>--%>
<%--</div>--%>

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
    <div class="sectionApp">
        <p class="titleSection">
            Danh sách mã đề
        </p>
        <label for="openPopupCreateLession" class="btnPrimary">
            Tạo mã đề mới
        </label>
    </div>
    <div class="tableGrid">
        <div class="grid-col-5">
            <p class="col-title">
                Số thứ tự
            </p>
            <p class="col-title">
                Mã đề
            </p>
            <%--            <p class="col-title">--%>
            <%--                Thời gian làm bài--%>
            <%--            </p>--%>
            <p class="col-title">
                Mô tả
            </p>
            <p class="col-title">

            </p>
            <p class="col-title">

            </p>
        </div>

        <!-- HÀNG -->
        <cc:forEach items="${list}" var="v">
            <div class="grid-col-5">
                <div class="col-content col-action">
                    1
                </div>
                <div class="col-content">
                        ${v.name}
                            <input style="display: none" name="na" value="${v.name}">
                </div>
                    <%--            <div class="col-content col-action">--%>
                    <%--                60 phút--%>
                    <%--            </div>--%>
                <div class="col-content col-action">
                        ${v.des}
                </div>
                <div class="col-content col-action">
                    <form action="CT_Load_List">
                        <input style="display: none" name="na" value="${v.name}">
                        <input type="submit" class=" btnPrimary-sm" value="Xem danh sách câu hỏi">
                    </form>
                    <form action="CT_Load_Student">
                        <input style="display: none" name="na" value="${v.name}">
                        <input type="submit" class=" btnPrimary-sm" value="Xem danh sách sinh viên">
                    </form>
<%--                    <a href="CT_Load_List?name1= ${v.name}" type="submit" name="nameMH" class=" btnPrimary-sm">--%>
<%--                        Ques--%>
<%--                    </a>--%>
                </div>
                <div class="col-content col-action">
                    <a href="CT_Delete_Code?a=${v.id}" class="btnDanger-sm">
                       Xoá
                    </a>
                </div>
            </div>
        </cc:forEach>
    </div>
</div>
<!-- POPUP TẠO MÃ ĐỀ -->
<input type="checkbox" id="openPopupCreateLession" hidden="true">
<label for="openPopupCreateLession" class="overlayPopupCreateLession"></label>
<div class="wrapPopupCreateLession">
    <div class="popupCreateLession">
        <p class="titlePopup">
            Thêm mã đề
        </p>
        <form action="CT_Add_Code">
            <input style="display: none" name="dn" value="${ten_dang_nhap}">
            <input style="display: none" name="idsub" value="${id}">
            <div class="formCreateLession">
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Mã đề
                    </p>
                    <input type="text" class="txtInput" name="codename" required>
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Mô tả
                    </p>
                    <input type="text" class="txtInput" name="des" required>
                </div>
                <div class="wrapInputTitle">
                    <label for="file" class="custom-uploader">Tải lên</label>
                    <input id="file" type="file" name="fileToUploadExam" >
<%--                    <input type="text" class="txtInput" name="quan" required>--%>
                </div>
<%--                <div class="wrapInputTitle">--%>
<%--                    <label for="file" class="custom-uploader">Tải lên</label>--%>
<%--                    <input id="file" type="file" name="fileToUploadStudent" >--%>
<%--                    &lt;%&ndash;                    <input type="text" class="txtInput" name="quan" required>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <input type="text" class="txtInput" name="quan" required>--%>
<%--                <div class="wrapInputTitle">--%>
<%--                    <p class="titleInput">--%>
<%--                        Thời gian--%>
<%--                    </p>--%>
<%--                    <input type="text" class="txtInput" name="time" required>--%>
<%--                </div>--%>
            </div>
            <div class="wrapButtonForm">
                <input type="reset" class="btnDanger-sm" value="Reset">
                <input type="submit" class="btnPrimary-sm" value="Thêm mã đề">
            </div>
        </form>
    </div>
</div>
</body>
</html>


