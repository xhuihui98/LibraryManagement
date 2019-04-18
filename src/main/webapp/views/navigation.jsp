<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/22
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<ul id="myTab" class="nav nav-tabs">
    <li class="active">
        <a href="#dota" data-toggle="tab">
            首页
        </a>
    </li>
    <li class="dropdown">
        <a href="#" id="bookManager" class="dropdown-toggle"
           data-toggle="dropdown">图书管理
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
            <li><a href="#storm" tabindex="-1" data-toggle="tab">查询</a></li>
            <li><a href="#h300" tabindex="-1" data-toggle="tab">借阅</a></li>
        </ul>
    </li>

    <li class="dropdown">
        <a href="#" id="myTabDrop1" class="dropdown-toggle"
           data-toggle="dropdown">账户管理
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
            <li><a href="#storm" tabindex="-1" data-toggle="tab">修改</a></li>
            <li><a href="#h300" tabindex="-1" data-toggle="tab">新建</a></li>
        </ul>
    </li>
</ul>
