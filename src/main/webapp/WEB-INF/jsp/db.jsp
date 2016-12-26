<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Моя ДБ-шечка</title>
</head>
<body>

<br>
<table border="1">
    <tr valign="top"><td>
    Добавление нового пользователя:
        <form method="get" action="adduser.html">
    <table>
        <tr>
            <td>
                Имя:<br>
                <input type="text" name="name">
            </td>
            <td>
                Возраст:<br>
                <input type="number" name="age">
            </td>
        </tr>
        <tr valign="top">
            <td valign="top">
                Пол:<br>
                <input type="radio" name="sex" value="m"> Мужчина<Br>
                <input type="radio" name="sex" value="f"> Женщина
            </td>
            <td>
                Права:<br>
                <input type="radio" name="isadmin" value="true"> Админ<Br>
                <input type="radio" name="isadmin" value="false"> Пользователь<Br>
                <p><input type="submit" value="Добавить"></p>
            </td>
        </tr>
    </table>
    </form>
    </td>
        <td>
            Модификация пользователя:
            <form method="get" action="updateuser.html">
                <table>
                    <td>
                        ID:<br>
                        <input type="number" name="id">
                    </td>
                    <tr>
                        <td>
                            Имя:<br>
                            <input type="text" name="name">
                        </td>
                        <td>
                            Возраст:<br>
                            <input type="number" name="age">
                        </td>
                    </tr>
                    <tr valign="top">
                        <td valign="top">
                            Пол:<br>
                            <input type="radio" name="sex" value="m"> Мужчина<Br>
                            <input type="radio" name="sex" value="f"> Женщина
                        </td>
                        <td>
                            Права:<br>
                            <input type="radio" name="isadmin" value="true"> Админ<Br>
                            <input type="radio" name="isadmin" value="false"> Пользователь<Br>
                            <p><input type="submit" value="Обновить"></p>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
        <td>
            Поиск пользователя:
            <form method="get" action="searchuser.html">
                <table>
                    <td>
                        ID:<br>
                        <input type="number" name="id">
                    </td>
                    <tr>
                        <td>
                            Имя:<br>
                            <input type="text" name="name">
                        </td>
                        <td>
                            Возраст:<br>
                            <input type="number" name="age">
                        </td>
                    </tr>
                    <tr valign="top">
                        <td valign="top">
                            Пол:<br>
                            <input type="radio" name="sex" value="m"> Мужчина<Br>
                            <input type="radio" name="sex" value="f"> Женщина
                        </td>
                        <td>
                            Права:<br>
                            <input type="radio" name="isadmin" value="true"> Админ<Br>
                            <input type="radio" name="isadmin" value="false"> Пользователь<Br>
                            <p><input type="submit" value="Поиск"></p>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <tr>
        <table border="1">
            <tr>
                <td>
                    Удаление по id:
                    <form method="get" action="deluseronid.html">
                        <input type="number" name="id">
                        <p><input type="submit" value="Удалить"></p>
                    </form>
                </td>
                <td>
                    Удаление по имени:
                    <form method="get" action="deluseronname.html">
                        <input type="text" name="name">
                        <p><input type="submit" value="Удалить"></p>
                    </form>
                </td>
                <td>
                    <form method="get" action="add20users.html">
                        <p><input type="submit" value="Добавить 20 записей в БД"></p>
                    </form>
                </td>
            </tr>
        </table>
    </tr>
</table>
<br>
<br>
<table>
    <td>
<c:if test="${not empty list}">
Пользователи в базе:
<table border="1">
    <c:forEach var="listValue" items="${list}">
    <tr>
            <td>${listValue.getId()}</td>
            <td>${listValue.getName()}</td>
            <td>${listValue.getSex()}</td>
            <td>${listValue.getAge()}</td>
            <td>${listValue.isAdmin()}</td>
            <td>${listValue.getCreateDate()}</td>
    </tr>
    </c:forEach>
</table>
</c:if>
    </td>
<td valign="top">
<c:if test="${not empty searchlist}">
    Найденные пользователи в базе:
    <table border="1">
        <c:forEach var="searchlistValue" items="${searchlist}">
            <tr>
                <td>${searchlistValue.getId()}</td>
                <td>${searchlistValue.getName()}</td>
                <td>${searchlistValue.getSex()}</td>
                <td>${searchlistValue.getAge()}</td>
                <td>${searchlistValue.isAdmin()}</td>
                <td>${searchlistValue.getCreateDate()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</td>
</table>
</body>
</html>
