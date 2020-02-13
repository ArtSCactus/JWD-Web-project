<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.id.col" var="id_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.start.col" var="start_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.end.col" var="end_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.limit.col" var="limit_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.status.col" var="status_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.action.col" var="action_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.action.resume" var="resume_action"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.action.finish" var="finish_action"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.toolbar.end.date" var="end_label"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.toolbar.faculty" var="faculty_label"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.toolbar.specialty" var="specialty_label"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.toolbar.limit" var="limt_label"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.toolbar.limit.placeholder" var="limit_placeholder"/>
<fmt:message bundle="${localizationContent}" key="control.panel.admissions.toolbar.start.btn" var="start_btn"/>
<html lang="${sessionScope.lang}">
<head>
    <link rel="stylesheet" href="css/admin_panel.css">
    <%--@elvariable id="content" type="com.epam.model.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
    <c:set var="errorMessageVar" value="${error}" scope="page"/>
</head>
<body>
<div class="main-content">
<h3>Admissions</h3>
<c:if test="${not empty errorMessageVar}">
    <div class="error-message">
        ${errorMessageVar}
    </div>
</c:if>
<form class="Start-admission-form" method="post" action="controller">
    <label for="date-end-input">
        ${end_label}
        <input type="date" class="date-end-input-field" name="end" id="date-end-input"/>
    </label>
    <label>
        ${faculty_label}
        <select class="select-faculty-list" name="faculty" required="required">
            <%--@elvariable id="faculty_item" type="com.epam.model.dto.university.Faculty"--%>
            <c:forEach var="faculty_item" items="${pageContent.additionalAttributes.get('faculties')}">
                <option>${faculty_item.name}</option>
            </c:forEach>
        </select>
    </label>
    <label>
        ${specialty_label}
        <select class="select-specialty-list" name="specialty" required="required">
            <%--@elvariable id="specialty_item" type="com.epam.model.dto.university.Specialty"--%>
            <c:forEach var="specialty_item" items="${pageContent.additionalAttributes.get('specialties')}">
                <option>${specialty_item.name}</option>
            </c:forEach>
        </select>
    </label>
    <label>
        ${limt_label}
        <input class="limit-input" name="limit" type="text" required="required" placeholder="${limit_placeholder}"/>
    </label>
    <input class="start-admission-btn" type="submit" value="${start_btn}">
    <input type="hidden" name="command" value="start_admission">
</form>
<table class="admission-table">
    <tr>
        <th>${id_col}</th>
        <th>${start_col}</th>
        <th>${end_col}</th>
        <th>${limit_col}</th>
        <th>${status_col}</th>
        <th>${action_col}</th>
    </tr>
    <%--@elvariable id="admission" type="com.epam.model.dto.entity.Admission"--%>
    <c:forEach var="admission" items="${pageContent.objectsList}">
        <tr>
            <td>${admission.id}</td>
            <td>${admission.start}</td>
            <td>${admission.end}</td>
            <td>${admission.amountOfStudents}</td>
            <c:choose>
                <c:when test="${admission.active}">
                    <td>in process</td>
                </c:when>
                <c:otherwise>
                    <td>finished</td>
                </c:otherwise>
            </c:choose>
            <td>
                <c:choose>
                    <c:when test="${admission.active}">
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="change_admission_status"/>
                            <input type="hidden" name="admissionId" value="${admission.id}"/>
                            <input type="hidden" name="newStatus" value="false"/>
                            <input class="button" type="submit" value="${finish_action}"/>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form class="decline-form" name="decline" method="post" action="controller">
                            <input type="hidden" name="command" value="change_admission_status"/>
                            <input type="hidden" name="admissionId" value="${admission.id}"/>
                            <input type="hidden" name="newStatus" value="true"/>
                            <input class="button" type="submit" value="${resume_action}"/>
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