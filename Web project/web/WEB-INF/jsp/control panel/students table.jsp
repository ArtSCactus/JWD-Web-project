<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/admin_panel.css">
    <%--@elvariable id="content" type="com.epam.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<body>
<table class="application-table">
    <tr>
        <th>ID</th>
        <th>Account id</th>
        <th>Faculty id</th>
        <th>Specialty id</th>
        <th>Enrollment date</th>
        <th>Action</th>
    </tr>
    <%--@elvariable id="student" type="com.epam.dto.entity.Student"--%>
    <c:forEach var="student" items="${pageContent.objectsList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.accountId}</td>
            <td>${student.facultyId}</td>
            <td>${student.specialtyId}</td>
            <td>${student.enrollmentDate}</td>
            <td>
                <form class="accept-form" name="accept" method="post" action="controller">
                    <input type="hidden" name="command" value="expel_student"/>
                    <input type="hidden" name="studentId" value="${student.id}"/>
                    <input class="button" type="submit" value="expel"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>