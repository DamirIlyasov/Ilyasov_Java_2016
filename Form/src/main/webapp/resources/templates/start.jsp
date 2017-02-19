<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form action="/list/1" method="post">

    <input type="text" placeholder="Имя" name="firstName">
    <input type="text" placeholder="Фамилия" name="lastName">
    <input type="text" placeholder="Отчество" name="middleName">
    <input type="text" placeholder="Возраст" name="age">
    <input type="radio" name="sex" value="male" checked>Мужской
    <input type="radio" name="sex" value="female">Женский
    <button type="submit">Отправить</button>
</form>

</body>
</html>
