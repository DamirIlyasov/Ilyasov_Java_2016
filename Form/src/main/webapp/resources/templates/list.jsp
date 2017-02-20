<%--
  Created by IntelliJ IDEA.
  User: damir
  Date: 19.02.17
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    ${message}

    <table border="1" width="100%" cellpadding="5">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Middle Name</th>
            <th>Age</th>
            <th>Sex</th>
        </tr>
        <c:forEach items="${list}" var="item">
            <c:if test="${item.getFirstName() != null && item.getLastName() != null && item.getMiddleName() != null}">
                <tr>
                    <th>${item.getFirstName()}</th>
                    <th>${item.getLastName()}</th>
                    <th>${item.getMiddleName()}</th>
                    <th>${item.getAge()}</th>
                    <th>${item.getSex()}</th>
                </tr>
            </c:if>

        </c:forEach>
    </table>
</head>
<body>

</body>
</html>
