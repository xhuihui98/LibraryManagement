<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/16
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书管理系统</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/> ">
</head>
<body>
<div style="padding-top:100px">

    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">登陆</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">注册</label>
            <div class="login-form">

                <div class="sign-in-htm">
                    <form action="login" method="post">
                    <div class="group">
                        <label class="label">用户名</label>
                        <input type="text" id="username" name="username" class="input" value=${username}>
                    </div>
                    <div class="group">
                        <label class="label">密码</label>
                        <input type="password" id="password" name="password"  class="input" value=${password}>
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" name="check" class="check" checked>
                        <label for="check"><span class="icon"></span> 记住密码</label>
                    </div>
                    <div class="group">
                        <input id="submit" type="submit" value="登陆" class="button">
                    </div>
                    </form>

                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot"></a>
                    </div>
                </div>

                <div class="sign-up-htm">
                    <form action="register" method="post">
                    <div class="group">
                        <label class="label">用户名</label>
                        <input type="text" id="user" name="username" class="input">
                    </div>
                    <div class="group">
                        <label class="label">密码</label>
                        <input type="password" id="pass" name="password" class="input">
                    </div>
                    <div class="group">
                        <label class="label">确认密码</label>
                        <input type="password" id="pass_confirm" name="pass_confirm" class="input">
                    </div>
                    <div class="group">
                        <input id="register" class="button" type="submit" value="注册">
                    </div>
                    </form>
                </div>
            </div>
            <h2 style="color: red">${requestScope.message}</h2>

        </div>

    </div>
</div>
</body>
</html>

