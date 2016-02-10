<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spring MVC and List Example</h2>

<c:if test="${not empty message}">

    <ul>
        <c:forEach var="listValue" items="${message}">
            <li>${listValue.link}</li>
        </c:forEach>
    </ul>

</c:if>
</body>
</html>
