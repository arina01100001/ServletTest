<%@ page import="ruAppline.logic.Model1" %>

<%--
  Created by IntelliJ IDEA.
  User: APerepelkina
  Date: 19.11.2021
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Домашняя страница по работе с пользователями</h1>
  Введите ID пользователя (0-для вывода всех пользователей)
  <br/>
  Доступно: <%
  Model1 model = Model1.getInstance();
  out.print(model.getFromList().size());
  %>
  <form method="get" action="get">
    <label>ID
      <input type="text" name="id"><br/>

    </label>
    <button type="submit">Поиск</button>
  </form>

  <a href="addUser.html">Создать нового пользователя</a>
  </body>
</html>
