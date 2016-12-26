<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alien
  Date: 25.12.16
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат добавления пользователя</title>
</head>
<body>
<c:if test="${result eq null}">
    <h3>Пользователь не добавлен</h3><br>
    <a href="index.html">Назад</a>
</c:if>
<c:if test="${result ne null}">
    <h3>Пользователь ${result.getName()} добавлен</h3><br>
    <a href="index.html">Назад</a>
</c:if>
</body>
</html>
