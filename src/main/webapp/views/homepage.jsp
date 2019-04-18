<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书馆管理系统</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/> ">
</head>
<body>
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="dota">
        <table class="table table-striped">
            <thead>
            <th>头像</th>
            <th>名字</th>
            <th>HP</th>
            </thead>
            <tbody>
            <tr>
                <td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/gareen.png"/></td>
                <td>盖伦</td>
                <td>616</td>
            </tr>
            <tr>
                <td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/teemo.png"/></td>
                <td>提莫</td>
                <td>383</td>
            </tr>
            <tr>
                <td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/akali.png"/></td>
                <td>阿卡丽</td>
                <td>448</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div style="height:200px"></div>
</body>
</html>

