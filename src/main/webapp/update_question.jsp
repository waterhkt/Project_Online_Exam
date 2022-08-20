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
    <title>Update Question</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<%--<div>--%>
<%--    <form action="CT_Question_Update">--%>
<%--        <h3>Update Question</h3>--%>
<%--        <input name="id" value="${detail.id}">--%>
<%--        <ul>--%>
<%--            <li>--%>
<%--                <label>Ma De</label>--%>
<%--                <select name="sel">--%>
<%--                    <option name="sel">1</option>--%>
<%--                    <option name="sel" >2</option>--%>
<%--                    <option name="sel" >3</option>--%>
<%--                    <option name="sel">4</option>--%>
<%--                </select>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Thu tu</label>--%>
<%--                <input type="text" placeholder="Thutu" name="thutu" value="${detail.number}">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Cau hoi</label>--%>
<%--                <input type="text" placeholder="Question" name="question"  value="${detail.content}">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 1</label>--%>
<%--                <input type="text" placeholder="DA1" name="ans1"  value="${detail.a}">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 2</label>--%>
<%--                <input type="text" placeholder="DA2" name="ans2"  value="${detail.b}">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 3</label>--%>
<%--                <input type="text" placeholder="DA3" name="ans3"  value="${detail.c}">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Đáp án 4</label>--%>
<%--                <input type="text" placeholder="DA4" name="ans4"  value="${detail.d}">--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <label>Kết quả </label>--%>
<%--                <input type="text" placeholder="Result" name="result"  value="${detail.resukt}">--%>
<%--            </li>--%>
<%--            <input type="submit" value="submit">--%>
<%--        </ul>--%>
<%--    </form>--%>
<%--</div>--%>
<!-- DUNG CHUNG -->
<div class="wrapHeaderTop">
    <div class="containerApp ">
        <div class="headerTop">
            <p class="titleApp">
                online Exam
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
        ADD QUESTION
    </p>
</div>

<!-- PAGE QUAN TRI -->
<div class="pageAddQuestion containerApp">
    <form action="CT_Question_Update" class="formAddQuestion">
        <div class="wrapInputTitle">
            <input style="display: none" name="id" value="${detail.id}">
            <input style="display: none" name="code" value="${code}">

        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Thứ tự
            </p>
            <input type="number" class="txtInput" required name="thutu" value="${detail.number}">
        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Câu hỏi
            </p>
            <input type="text" class="txtInput" required name="question" value="${detail.content}" readonly>
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
                    <input type="text" class="txtInput" required name="ans1" value="${detail.a}" readonly>
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 2
                    </p>
                    <input type="text" class="txtInput" required name="ans2" value="${detail.b}" readonly>
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 3
                    </p>
                    <input type="text" class="txtInput" required name="ans3" value="${detail.c}" readonly>
                </div>
                <div class="wrapInputTitle">
                    <p class="titleInput">
                        Đáp án 4
                    </p>
                    <input type="text" class="txtInput" required name="ans4"  value="${detail.d}" readonly>
                </div>
            </div>
        </div>
        <div class="wrapInputTitle">
            <p class="titleInput">
                Kết quả
            </p>
            <input type="text" class="txtInput" required name="result"  value="${detail.resukt}">
        </div>
        <div>
            <input type="submit" class="btnPrimary" value="Hoàn thành">
        </div>
    </form>
</div>
</body>
</html>

