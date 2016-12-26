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
    <h3>Пользователь не удален</h3><br>
    <a href="index.html">Назад</a>
</c:if>
<c:if test="${result ne null}">
    <c:if test="${not empty result}">
        Удалены следующие пользователи:<br>
        <ul>
            ID Name
        <c:forEach items="${result}" var="item">
            <li>${item.getId()} ${item.getName()}</li>
        </c:forEach>
        </ul>
    <a href="index.html">Назад</a>
    </c:if>
</c:if>
</body>
</html>
