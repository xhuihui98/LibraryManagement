<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/21
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
</head>
<body>
<table border="1">
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>ISBN</th>
        <th>类型</th>
        <th>作者</th>
        <th>出版社</th>
        <th>单价</th>
        <th>库存</th>
        <th>总数</th>
    </tr>

    <c:forEach items="${requestScope.book_list }" var="u">

        <tr>
            <td>${u.bookId }</td>
            <td>${u.bookName }</td>
            <td>${u.ISBN }</td>
            <td>${u.typeName }</td>
            <td>${u.author }</td>
            <td>${u.publisher }</td>
            <td>${u.price }</td>
            <td>${u.stockNum }</td>
            <td>${u.total }</td>
        </tr>

    </c:forEach>





</table>

</body>
</html>
