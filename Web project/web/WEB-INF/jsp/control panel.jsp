<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/control_panel.css">
</head>
<header>
    <div class="university-title">Melbourne university</div>
    <a href="controller?command=logout">logout</a>
</header>
<body>
<menu>
    <li><a href="#"><i class="fa fa-home fa-fw"></i>Admissions</a></li>
    <li><a href="#">Applications</a></li>
    <li><a href="#">Students</a></li>
    <li><a href="#">Accounts</a></li>
</menu>
<aside>
    <h4>Active admissions here</h4>
</aside>
<table class="application-table">
    <tr>
        <th>ID</th>
        <th>Account id</th>
        <th>Faculty</th>
        <th>Specialty</th>
        <th>Status</th>
        <th>Date</th>
        <th>Change status</th>
    </tr>
    <c:forEach var="application" items="${requestScope.applicationsList}">
        <tr>
            <td>${application.id}</td>
            <td>${application.accountId}</td>
            <td>${application.facultyId}</td>
            <td>${application.specialtyId}</td>
            <td>${application.status.message}</td>
            <td>${application.filingDate}</td>
            <td>
                <form class="accept-form" name="accept" method="post" action="controller">
                    <input type="hidden" name="command" value="change_application_status"/>
                    <input type="hidden" name="applicationId" value="${application.id}"/>
                    <input type="hidden" name="newStatus" value="accepted"/>
                    <input class="button" type="submit" value="accept"/>
                </form>
                <form class="decline-form" name="decline" method="post" action="controller">
                    <input type="hidden" name="command" value="change_application_status"/>
                    <input type="hidden" name="applicationId" value="${application.id}"/>
                    <input type="hidden" name="newStatus" value="rejected"/>
                    <input class="button" type="submit" value="reject"/>
                </form>
                    <%-- Create possibility to change application status--%>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
