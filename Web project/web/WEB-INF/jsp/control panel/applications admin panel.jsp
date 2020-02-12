<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/admin_panel.css">
    <%--@elvariable id="pageContent" type="com.epam.model.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="request"/>
</head>
<body>
<div class="main-content">
<h3>Applications</h3>
<table class="application-table">
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Second name</th>
        <th>Third name</th>
        <th>Faculty</th>
        <th>Specialty</th>
        <th>Status</th>
        <th>Date</th>
        <th>Action</th>
    </tr>
    <%--@elvariable id="application" type="com.epam.model.dto.entity.Application"--%>
    <c:forEach var="application" items="${pageContent.objectsList}">
        <tr>
            <td>${application.id}</td>
            <td>${application.applierName}</td>
            <td>${application.applierSurname}</td>
            <td>${application.applierPatronymic}</td>
            <td>${application.facultyName}</td>
            <td>${application.specialtyName}</td>
            <td>${application.status.message}</td>
            <td>${application.filingDate}</td>
            <td>
                <c:choose>
                    <c:when test="${application.status.message eq 'waiting'}">
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
                    </c:when>
                    <c:when test="${application.status.message eq 'rejected'}">
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="change_application_status"/>
                            <input type="hidden" name="applicationId" value="${application.id}"/>
                            <input type="hidden" name="newStatus" value="accepted"/>
                            <input class="button" type="submit" value="accept"/>
                        </form>
                    </c:when>
                    <c:when test="${application.status.message eq 'accepted'}">
                        <form class="decline-form" name="decline" method="post" action="controller">
                            <input type="hidden" name="command" value="change_application_status"/>
                            <input type="hidden" name="applicationId" value="${application.id}"/>
                            <input type="hidden" name="newStatus" value="rejected"/>
                            <input class="button" type="submit" value="reject"/>
                        </form>
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
