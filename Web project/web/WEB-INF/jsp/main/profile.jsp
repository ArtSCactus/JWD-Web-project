<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp" %>
<fmt:message bundle="${localizedContent}" key="main.page.profile.title" var="title"/>
<fmt:message bundle="${localizedContent}" key="main.page.profile.name.label" var="name_label"/>
<fmt:message bundle="${localizedContent}" key="main.page.profile.surname.label" var="surname_label"/>
<fmt:message bundle="${localizedContent}" key="main.page.profile.patronymic.label" var="patronymic_label"/>
<fmt:message bundle="${localizedContent}" key="main.page.profile.edit.btn" var="edit_btn"/>
<fmt:message bundle="${localizedContent}" key="main.page.profile.mailbox.label" var="mailbox_label"/>
<fmt:message bundle="${localizedContent}" key="main.page.profile.total.points.label" var="total_points_label"/>
<html>
<head>
    <title>Profile</title>
    <%--@elvariable id="pageContent" type="com.epam.model.dto.PageContent"--%>
    <c:set var="pageContent" value="${pageContent}"/>
    <%--@elvariable id="account" type="com.epam.model.dto.entity.Account"--%>
    <c:set var="account" value="${pageContent.getAttribute('account')}"/>
</head>
<body>
<c:if test="${not empty account.studentId and account.studentId ne 0}">
    You are the student of ${pageContent.getAttribute('facultyName')} by the specialty ${pageContent.getAttribute('specialtyName')}.
</c:if>
<form id="main-profile-data">
    <label for="profile-name-input">${name_label}</label>
    <input id="profile-name-input" type="text"
           value="${account.name}">
    <label for="profile-surname-input">${surname_label}</label><input id="profile-surname-input" type="text"
                                                                      value="${account.surname}">
    <label for="profile-patronymic-input">${patronymic_label}</label><input id="profile-patronymic-input" type="text"
                                                                            value="${account.patronymic}">
    <label for="profile-mailbox-input">${mailbox_label}</label><input id="profile-mailbox-input" type="text"
                                                                      value="${account.mailbox}">
    <label for="profile-total=points-input">${total_points_label}</label><input id="profile-total=points-input"
                                                                                type="text"
                                                                                value="${account.totalPoints}">
    <input id="profile-save-btn" type="submit" value="${edit_btn}">
</form>
</body>
</html>
