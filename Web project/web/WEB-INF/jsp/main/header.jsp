<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="Page content" var="localizedContent"/>
<fmt:message bundle="${localizedContent}" key="sign_in_btn" var="sign_in_btn"/>
<fmt:message bundle="${localizedContent}" key="sign_up_btn" var="sign_up_btn"/>
<fmt:message bundle="${localizedContent}" key="home_btn" var="home_btn"/>
<fmt:message bundle="${localizedContent}" key="news_btn" var="news_btn"/>
<fmt:message bundle="${localizedContent}" key="admissions_btn" var="admissions_btn"/>
<fmt:message bundle="${localizedContent}" key="contacts_btn" var="contacts_btn"/>
<fmt:message bundle="${localizedContent}" key="control_panel_btn" var="control_panel_btn"/>
<fmt:message bundle="${localizedContent}" key="university_title" var="university_title"/>
<fmt:message bundle="${localizedContent}" key="logout_btn" var="logout_btn"/>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <link rel="stylesheet" href="css/main.css">
    <script src="scripts/jquery/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="../../../css/main.css">
    <script async src="scripts/Main page.js"></script>
    <link type="text/css" href="scripts/jquery/jquery-ui-1.12.1/jquery-ui.theme.css" rel="stylesheet"/>
    <script type="text/javascript" src="scripts/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
</head>
<div class="top-menu-container">
    <div class="top-menu">
        <a class="title">${university_title}</a>
        <a href="controller?command=change_language&lang=ru">RU</a>
        <a href="controller?command=change_language&lang=en">EN</a>
            <c:if test="${not empty sessionScope.accountId}">
                <a href="controller?command=logout">${logout_btn}</a>
            </c:if>
            <c:if test="${empty sessionScope.accountId}">
                <a href="controller?command=forward&page=registration">${sign_up_btn}</a>
                <a href="controller?command=forward&page=authorization">${sign_in_btn}</a>
            </c:if>
    </div>
</div>
<header>
   <%-- <div class="header-background-top-border-wrapper">--%>
    <div class="header-background-top-border">
    </div>
<%--    </div>--%>
    <menu>
        <li><a href="controller?command=show_main_page"><i class="fa fa-home fa-fw"></i>${home_btn}</a></li>
        <li><a href="controller?command=news">${news_btn}</a></li>
        <li><a href="#">${admissions_btn}</a></li>
        <li><a href="#">${contacts_btn}</a></li>
        <c:if test="${isUserAdmin}">
            <li>
                <a href="controller?command=show_admin_panel">${control_panel_btn}</a>
            </li>
        </c:if>
    </menu>
</header>
</html>
