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
<form class="Start-admission-form" method="post" action="controller">
    <label for="date-end-input">
        End date:
        <input type="date" class="date-end-input-field" name="end" id="date-end-input"/>
    </label>
    <label>
        Faculty:
        <select class="select-faculty-list" name="faculty" required="required">
            <%--@elvariable id="faculty_item" type="com.epam.dto.university.Faculty"--%>
            <c:forEach var="faculty_item" items="${requestScope.content.additionalAttributes.get('faculties')}">
                <option>${faculty_item.name}</option>
            </c:forEach>
        </select>
    </label>
    <label>
        Specialty:
        <select class="select-specialty-list" name="specialty" required="required">
            <%--@elvariable id="specialty_item" type="com.epam.dto.university.Specialty"--%>
            <c:forEach var="specialty_item" items="${requestScope.content.additionalAttributes.get('specialties')}">
                <option>${specialty_item.name}</option>
            </c:forEach>
        </select>
    </label>
    <label>
        Limit:
        <input class="limit-input" name="limit" type="text" required="required" placeholder="Integer limit here"/>
    </label>
    <input class="start-admission-btn" type="submit" value="start">
    <input type="hidden" name="command" value="start_admission">
</form>
<table class="admission-table">
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
                    <input type="hidden" name="command" value="change_admission_status"/>
                    <input type="hidden" name="admissionId" value="${admission.id}"/>
                    <input type="hidden" name="newStatus" value="false"/>
                    <input class="button" type="submit" value="finish"/>
                </form>
                <form class="decline-form" name="decline" method="post" action="controller">
                    <input type="hidden" name="command" value="change_admission_status"/>
                    <input type="hidden" name="admissionId" value="${admission.id}"/>
                    <input type="hidden" name="newStatus" value="true"/>
                    <input class="button" type="submit" value="resume"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>