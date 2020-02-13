<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<fmt:message bundle="${localizationContent}" key="control.panel.students.id.col" var="id_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.name.col" var="name_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.surname.col" var="surname_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.patronymic.col" var="patronymic_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.faculty.col" var="faculty_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.specialty.col" var="specialty_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.enrollment.date.col" var="date_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.status.col" var="status_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.action.col" var="action_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.action.dismiss" var="dismiss_action"/>
<fmt:message bundle="${localizationContent}" key="control.panel.students.action.enroll" var="enroll_action"/>
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
        <th>${id_col}</th>
        <th>${name_col}</th>
        <th>${surname_col}</th>
        <th>${patronymic_col}</th>
        <th>${faculty_col}</th>
        <th>${specialty_col}</th>
        <th>${date_col}</th>
        <th>${status_col}</th>
        <th>${action_col}</th>
    </tr>
    <%--@elvariable id="student" type="com.epam.model.dto.entity.Student"--%>
    <c:forEach var="student" items="${pageContent.objectsList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.patronymic}</td>
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
                            <input class="button" type="submit" value="${dismiss_action}"/>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="expel_student"/>
                            <input type="hidden" name="studentId" value="${student.id}"/>
                            <input type="hidden" name="status" value="enrolled">
                            <input class="button" type="submit" value="${enroll_action}"/>
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