<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/accounts_admin_panel.css">
    <%--@elvariable id="content" type="com.epam.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<body>
<table class="application-table">
    <tr>
        <th>ID</th>
        <th>Started at</th>
        <th>Ends at</th>
        <th>Amount of students</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <%--@elvariable id="admission" type="com.epam.dto.entity.Admission"--%>
    <c:forEach var="admission" items="${pageContent.objectsList}">
        <tr>
            <td>${admission.id}</td>
            <td>${admission.start}</td>
            <td>${admission.end}</td>
            <td>${admission.amountOfStudents}</td>
            <td>${admission.active}</td>
            <td>
                <form class="accept-form" name="accept" method="post" action="controller">
                    <input type="hidden" name="command" value="finish_admission"/>
                    <input type="hidden" name="admissionId" value="${admission.id}"/>
                    <input type="hidden" name="newStatus" value="false"/>
                    <input class="button" type="submit" value="finish"/>
                </form>
                <form class="decline-form" name="decline" method="post" action="controller">
                    <input type="hidden" name="command" value="continue_admission"/>
                    <input type="hidden" name="admissionId" value="${admission.id}"/>
                    <input type="hidden" name="newStatus" value="true"/>
                    <input class="button" type="submit" value="continue"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>