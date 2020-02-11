<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/admin_panel.css">
    <%--@elvariable id="content" type="com.epam.model.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<body>
<div class="main-content">
<h3>Students</h3>
<table class="student-table">
    <tr>
        <th>ID</th>
        <th>Account id</th>
        <th>Faculty id</th>
        <th>Specialty id</th>
        <th>Enrollment date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <%--@elvariable id="student" type="com.epam.model.dto.entity.Student"--%>
    <c:forEach var="student" items="${pageContent.objectsList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.accountId}</td>
            <td>${student.facultyId}</td>
            <td>${student.specialtyId}</td>
            <td>${student.enrollmentDate}</td>
            <td>${student.status.message}</td>
            <td>
                <c:choose>
                    <c:when test="${student.status.message eq 'enrolled'}">
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="expel_student"/>
                            <input type="hidden" name="studentId" value="${student.id}"/>
                            <input type="hidden" name="status" value="dismissed">
                            <input class="button" type="submit" value="expel"/>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="expel_student"/>
                            <input type="hidden" name="studentId" value="${student.id}"/>
                            <input type="hidden" name="status" value="enrolled">
                            <input class="button" type="submit" value="enroll"/>
                        </form>
                    </c:otherwise>
                </c:choose>

            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>