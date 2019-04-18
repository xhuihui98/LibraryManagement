<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/22
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<div id="bg">
    <div style="position: absolute ;bottom: 5px; right:70px">
        <h3 >当前登录:${sessionScope.user.getUserName()}</h3>
    </div>
</div>