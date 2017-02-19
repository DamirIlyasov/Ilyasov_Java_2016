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

    <c:forEach items="${list}" var="item">
        <c:if test="${item.getFirstName() != null && item.getLastName() != null && item.getMiddleName() != null}">
            <p>${item.getFirstName()}
            ${item.getLastName()}
            ${item.getMiddleName()}</p>
            </br>
        </c:if>

    </c:forEach>
</head>
<body>

</body>
</html>
