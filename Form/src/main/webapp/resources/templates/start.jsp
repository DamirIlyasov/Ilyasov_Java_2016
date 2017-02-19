<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form action="/list/1" method="post">

    <input type="text" placeholder="First Name" name="firstName">
    <input type="text" placeholder="Last Name" name="lastName">
    <input type="text" placeholder="Middle Name" name="middleName">
    <input type="date" name="date">
    <select name="sex">
        <option value="">Выберите пол</option>
        <option value="male">Мужской</option>
        <option value="female">Женский</option>
    </select>
    <button type="submit">Отправить</button>
</form>

</body>
</html>
