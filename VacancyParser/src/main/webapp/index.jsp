<%@ page import="tools.VacancyForJSP" %>
<%@ page import="valueobject.Vacancy" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <!-- Bootstrap -->

    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Retry</h1>

<div class="table">
    <table class="table">
        <thead>
        <tr>
            <th>
                <div class="col-xs-3">
                    <a href="index.jsp?sort-by=title">Title</a>
                </div>
            </th>
            <th>
                <div class="col-xs-3">
                    <a href="index.jsp?sort-by=data">Date</a>
                </div>
            </th>
            <th>
                <div class="col-xs-6">
                    <a href="index.jsp?sort-by=description">Description</a>
                </div>
            </th>
            <th>
                <div class="col-xs-3">
                    <a href="index.jsp?sort-by=city">City</a>
                </div>
            </th>
            <th>
                <div class="col-xs-3">
                    <a href="index.jsp?sort-by=company">Company</a>
                </div>
            </th>
        </tr>
        </thead>
        <%
            VacancyForJSP vacancyList = new VacancyForJSP();
            List<Vacancy> vacancies = vacancyList.getVacancyList();
            String typeOfSort = request.getParameter("sort-by");
            if (typeOfSort != null)
                vacancyList.sortByTitle(typeOfSort);
            for (Vacancy vacancy : vacancies) {
                out.print("<tr>");
                out.print("<td class=\"col-xs-3\">" + vacancy.getTitle() + "</td>");
                out.print("<td class=\"col-xs-1\">" + vacancy.getDateOfPublication() + "</td>");
                out.print("<td class='description col-xs-6'>" + vacancy.getDescription() + "</td>");
                out.print("<td class=\"col-xs-1\">" + vacancy.getCity() + "</td>");
                out.print("<td class=\"col-xs-1\">" + vacancy.getCompanyName() + "</td>");
                out.print("</tr>");
            }
        %>
    </table>

    <script>
        function ellipsify(str) {
            if (str.length > 200) {
                return (str.substring(0, 200) + "...");
            }
            else {
                return str;
            }
        }
        var descriptions = document.getElementsByClassName("description");
        for(var i = 0; i < descriptions.length; i++){
            //do something to each div like
            var str = descriptions[i].innerHTML;
            descriptions[i].innerHTML = ellipsify(str);
        }

    </script>
</div>
</body>
</html>