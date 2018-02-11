<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#aaccff">
<Font color="green" size="10">
    Форма для работы со словарем
</Font>
<br>
<br>
<form name="frm" method="Get" action="MyServlet" accept-charset="UTF-8">
    <Font color="blue" size="6"> Введите слово:</Font>
    <Input type="Text" name="txt" value=""/>
    <br>
    <br>
    <Font color="blue" size="6">Перевод:

    </Font><input type="text" value="${translate}"/><br>

    <h4>Кликни здесь для получения перевода :<Input type="submit" value="Перевести"/>
    </h4>
</form>
</body>