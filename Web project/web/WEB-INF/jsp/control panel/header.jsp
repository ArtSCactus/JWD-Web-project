<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization/Page content" var="localizationContent"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.admissions" var="admissions"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.applications" var="applications"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.students" var="students"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.accounts" var="accounts"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.main" var="main"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.logout" var="logout"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.university.title" var="title"/>
<fmt:message bundle="${localizationContent}" key="control.panel.header.page.title" var="page_title"/>
<html lang="${sessionScope.lang}">
<head>
    <title>${page_title}</title>
    <link rel="stylesheet" href="css/admin_panel.css">
    <script async src="scripts/Admin panel.js"></script>
    <script src="scripts/jquery/jquery-3.4.1.min.js"></script>
    <link type="text/css" href="scripts/jquery/jquery-ui-1.12.1/jquery-ui.theme.css" rel="stylesheet"/>
    <script type="text/javascript" src="scripts/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
</head>
<div class="menu-container">
    <a class="open-btn"></a>
<menu id="side-menu">
    <a class="close-btn"></a>
    <a class="language-switch" href="controller?command=change_language&lang=en">EN</a>
    <a class="language-switch" href="controller?command=change_language&lang=ru">RU</a>
    <ul class="list">
    <li><a href="controller?command=show_admissions_panel">${admissions}</a></li>
    <li><a href="controller?command=show_applications_panel">${applications}</a></li>
    <li><a href="controller?command=show_students_panel">${students}</a></li>
    <li><a href="controller?command=show_accounts_panel">${accounts}</a></li>
    <li><a href="controller?command=show_main_page">${main}</a></li>
    <li><a href="controller?command=logout">${logout}</a></li>
    </ul>
</menu>
</div>
<header>
    <div class="university-title">${title}</div>
</header>
</html>
