<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/accounts_admin_panel.css">
    <%--@elvariable id="content" type="com.epam.model.entity.controlpanel.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<body>
<table class="application-table">
    <tr>
        <th>ID</th>
        <th>Account id</th>
        <th>Faculty</th>
        <th>Specialty</th>
        <th>Status</th>
        <th>Date</th>
        <th>Action</th>
    </tr>
    <%--@elvariable id="application" type="com.epam.model.entity.Application"--%>
    <c:forEach var="application" items="${pageContent.objectsList}">
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
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
