<%@ page import="model.ReadFromFile" %>
<%@ page import="vo.Vacancy" %>
<html>
<head>
</head>
<body>
<table>
    <thead>
    <tr>
        <th><a href="index.jsp?sort-by=title">Title</a></th>
        <th><a href="index.jsp?sort-by=data">Date</a></th>
        <th><a href="index.jsp?sort-by=description">Description</a></th>
        <th><a href="index.jsp?sort-by=city">City</a></th>
        <th><a href="index.jsp?sort-by=company">Company</a></th>
    </tr>
    </thead>
    <%
        ReadFromFile readFromFile = new ReadFromFile();
        Vacancy[] vacancies = readFromFile.getData();
        String typeOfSort = request.getParameter("sort-by");
        if (typeOfSort != null)
            readFromFile.sortByTitle(typeOfSort);
        for (Vacancy vacancy : vacancies) {
            out.print("<tr>");
            out.print("<td>" + vacancy.getTitle() + "</td>");
            out.print("<td>" + vacancy.getDateOfPublication() + "</td>");
            out.print("<td>" + vacancy.getDescription() + "</td>");
            out.print("<td>" + vacancy.getCity() + "</td>");
            out.print("<td>" + vacancy.getCompanyName() + "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>