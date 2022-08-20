<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 23/04/2022
  Time: 4:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
<%--<div>--%>
<%--    <form action="CT_Add_Question">--%>
<%--        <h3>Tạo môn học mới</h3>--%>
<%--        <ul>--%>
<%--            <li>--%>
<%--                <label>Mã Đề</label>--%>
<%--                <select name="sel">--%>
<%--                    <option name="sel">1</option>--%>
<%--                    <option name="sel">2</option>--%>
<%--                    <option name="sel">3</option>--%>
<%--                    <option name="sel">4</option>--%>
<%--                </select>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Thứ tự</label>--%>
<%--                <input type="text" placeholder="Thứ tự" name="thutu">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Câu hỏi</label>--%>
<%--                <input type="text" placeholder="Câu hỏi" name="question">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 1</label>--%>
<%--                <input id="an1" type="text" placeholder="Đáp án 1" name="ans1">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 2</label>--%>
<%--                <input id="an2" type="text" placeholder="Đáp án 2" name="ans2">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 3</label>--%>
<%--                <input id="an3" type="text" placeholder="Đáp án 3" name="ans3">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 4</label>--%>
<%--                <input id="an4" type="text" placeholder="Đáp án 4" name="ans4">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án đúng</label>--%>
<%--                <input id="re" type="text" placeholder="Đáp án đúng" name="result">--%>
<%--            </li>--%>
<%--            <input  name="add-question" type="submit" value="submit">--%>
<%--        </ul>--%>
<%--    </form>--%>
<%--</div>--%>
<!-- DUNG CHUNG -->
<div class="wrapHeaderTop">
    <div class="containerApp ">
        <div class="headerTop">
            <p class="titleApp">
                Hệ thống thi trắc nghiệm trực tuyến
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
        THÊM CÂU HỎI
    </p>
</div>

<!-- PAGE QUAN TRI -->
<div class="pageAddQuestion containerApp">
    <form action="CT_Add_Question" class="formAddQuestion">
        <div class="wrapInputTitle">
            <p class="titleInput">
                Mã đề
            </p>
            <select name="sel" class="txtInput cursor_pointer">
                <option name="sel" value="1">Đề 1</option>
                <option name="sel" value="2">Đề 2</option>
                <option name="sel" value="3">Đề 3</option>
                <option name="sel" value="4">Đề 4</option>
            </select>
        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Thứ tự
            </p>
            <input type="number" class="txtInput" required name="thutu">
        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Câu hỏi
            </p>
            <input type="text" class="txtInput" required name="question">
        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Đáp án
            </p>
            <div class="subGrid">
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 1
                    </p>
                    <input type="text" class="txtInput" required name="ans1">
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 2
                    </p>
                    <input type="text" class="txtInput" required name="ans2">
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 3
                    </p>
                    <input type="text" class="txtInput" required name="ans3">
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 4
                    </p>
                    <input type="text" class="txtInput" required name="ans4">
                </div>
            </div>
        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Đáp án đúng
            </p>
            <input type="text" class="txtInput" required name="result">
        </div>
        <div>
            <input type="submit" class="btnPrimary" value="Hoàn thành">
        </div>
    </form>
</div>
</body>
</html>
