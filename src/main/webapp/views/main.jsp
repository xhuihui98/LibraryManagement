<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.dhu.pojo.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dhu.pojo.Reader" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/> ">
    <title>图书</title>
</head>
<body>

    <h3>欢迎${sessionScope.user.getUserName()}访问</h3>

    <form action="main" method="post" accept-charset="UTF-8">
        <table>
            <tr>
                <td><label>书名</label></td>
                <td><input type="text" id="bookname" name="bookName" class="form-control"> </td>
            </tr>
            <tr>
                <td><label>ISBN</label></td>
                <td><input type="text" id="ISBN" name="ISBN" class="form-control"></td>
            </tr>
            <tr>
                <td><label>类型</label></td>
                <td><input type="text" id="typename" name="typeName" class="form-control"></td>
            </tr>
            <tr>
                <td><label>作者</label></td>
                <td><input type="text" id="author" name="author" class="form-control"></td>
            </tr>
            <tr>
                <td><label>出版社</label></td>
                <td><input type="text" id="publisher" name="publisher" class="form-control"></td>
            </tr>
            <tr>
                <td><label>单价</label></td>
                <td><input type="text" id="price" name="price" class="form-control"></td>
            </tr>
            <tr>
                <td><label>库存</label></td>
                <td><input type="text" id="stocknum" name="stockNum" class="form-control"></td>
            </tr>
            <tr>
                <td><label>总数</label></td>
                <td><input type="text" id="total" name="total" class="form-control"></td>
            </tr>

            <tr>
                <td><input id="submit" type="submit" value="提交"></td>
            </tr>
        </table>
    </form>

</body>
</html>
