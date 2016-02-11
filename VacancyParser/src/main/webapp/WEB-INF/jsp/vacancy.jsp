<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spring MVC and List Example</h2>

<c:if test="${not empty message}">

    <table>
        <thead>
            <th>Title</th>
            <th>City</th>
            <th>Description</th>
            <th>Date of publication</th>
            <th>Company</th>
        </thead>
        <c:forEach var="obj" items="${message}">
            <tr>
                <td><a href="${obj.link}">${obj.title}</a></td>
                <td>${obj.city}</td>
                <td>${obj.description}</td>
                <td>${obj.dateOfPublication}</td>
                <td>${obj.companyName}</td>
            </tr>
        </c:forEach>
    </table>

</c:if>
</body>
</html>
