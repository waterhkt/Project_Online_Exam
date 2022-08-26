<%--
  Created by IntelliJ IDEA.
  User: LaptopUSAPro
  Date: 17/04/2022
  Time: 10:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đề</title>
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
<%--<div>--%>
<%--    <div class="container-ful-exam container">--%>
<%--        <div class="left-content-exam">--%>
<%--            <ul>--%>
<%--                <li>--%>
<%--<cc:forEach items="${list}" var="p">--%>
<%--                    <button>--%>
<%--                        ${p.id}--%>
<%--                    </button>--%>
<%--</cc:forEach>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--        <div class="main-content-exam">--%>
<%--            <div style="text-align: center;margin-top: 5%;margin-bottom: 5%">--%>
<%--                <h1>Bài thi Online</h1>--%>
<%--                <h2>Môn hoc : </h2>--%>
<%--            </div>--%>
<%--            <form action="CT_Submit?score=${score}">--%>
<%--            <cc:forEach items="${list}" var="p">--%>
<%--            <p>Please select your age:</p>--%>
<%--                <div class="answer">--%>
<%--                    <input type="radio" id="c1+${p.id}" name="ans${p.id}" value="${p.a}"/>--%>
<%--                    <label for="c1+${p.id}">A.${p.a}</label>--%>
<%--                    <input type="radio" id="c2+${p.id}" name="ans${p.id}" value="${p.b}" />--%>
<%--                    <label for="c2+${p.id}">B.${p.b}</label>--%>
<%--                    <input type="radio" id="c3+${p.id}" name="ans${p.id}" value="${p.c}" />--%>
<%--                    <label for="c3+${p.id}">C.${p.c}</label>--%>
<%--                    <input type="radio"  id="c4+${p.id}" name="ans${p.id}" value="${p.d}"/>--%>
<%--                    <label for="c4+${p.id}" >D.${p.d}</label>--%>
<%--                </div>--%>
<%--                <hr>--%>
<%--            </cc:forEach>--%>
<%--                    <input style="background-color: blue;color: white;padding: 5px;margin-left: 40%" type="submit" value="Submit">--%>
<%--            </form>--%>
<%--        </div>--%>
<%--        <div class="right-content-exam">--%>
<%--            <div>Thời gian làm bài còn lại : <br><span style="margin: auto;text-align: center" id="time">60:00</span> phút!</div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="wrapHeaderTop">
    <div class="containerApp ">
        <div class="headerTop">
            <p class="titleApp">
                Hệ thống thi trắc nghiệm trực tuyến
            </p>
        </div>
    </div>
</div>
<div class="pageExam containerApp">
    <div class="wrapInfoExam">
        <div class="infoExam">
            <p class="title">
                Thông tin bài thi
            </p>
            <div class="contentInfo">
                <div class="rowInfo">
                    <p class="titleInfo">
                        MSSV
                    </p>
                    <p class="txtContentInfo">
                        ${ten_dang_nhap}
                    </p>

                </div>
                <div class="rowInfo">
                    <p class="titleInfo">
                        Bài thi môn :
                    </p>
                    <p class="txtContentInfo">
                        ${name}
                    </p>
                </div>
                <div class="rowInfo">
                    <p class="titleInfo color-red">
                        Thời gian còn lại
                    </p>
                    <p class="txtContentInfo color-red font-bold" id="time">
                        00:59:59
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div class="wrapContentExam">
        <form action="CT_Submit?score=${score}" class="contentExam">
            <input style="display: none" name="username" class="txtContentInfo" value="${ten_dang_nhap}">
            <input  name="code" class="txtContentInfo" value="${code1}" style="display: none">
            <cc:forEach items="${list}" var="p">
            <div class="question">
                <p class="title">
                    Câu ${p.number} : ${p.content}
                </p>
                <div class="wrapOption">
                    <div class="option">
                        <input type="radio" id="c1+${p.number}"  name="ans${p.number}" value="${p.a}">
                        <label for="c1+${p.number}" class="txt_option">
                            A.${p.a}                        </label>
                    </div>
                    <div class="option">
                        <input type="radio" id="c2+${p.number}" name="ans${p.number}" value="${p.b}">
                        <label for="c2+${p.number}" class="txt_option">
                            B.${p.b}
                        </label>
                    </div>
                    <div class="option">
                        <input type="radio" id="c3+${p.number}" name="ans${p.number}" value="${p.c}">
                        <label for="c3+${p.number}" class="txt_option">
                            C.${p.c}                        </label>
                    </div>
                    <div class="option">
                        <input type="radio" id="c4+${p.number}" name="ans${p.number}" value="${p.d}">
                        <label for="c4+${p.number}" class="txt_option">
                            D.${p.d}                        </label>
                    </div>
                </div>
            </div>
            </cc:forEach>
            <div class="wrapButtonSubmit">
                <input type="submit" value="Nộp bài" class="btnPrimary">
            </div>
        </form>
    </div>
</div>
<script>
    function startTimer(duration, display) {
        var timer = duration, minutes, seconds;
        setInterval(function () {
            minutes = parseInt(timer / 60, 10);
            seconds = parseInt(timer % 60, 10);

            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            display.textContent = minutes + ":" + seconds;

            if (--timer < 0) {
                timer = duration;
            }
        }, 1000);
    }

    window.onload = function () {
        var fiveMinutes = 60 * 60,
            display = document.querySelector('#time');
        startTimer(fiveMinutes, display);
    };
</script>
</body>
</html>
