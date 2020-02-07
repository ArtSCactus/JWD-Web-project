<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="Page content" var="content"/>
<fmt:message bundle="${content}" key="sign_in_btn" var="sign_in_btn"/>
<fmt:message bundle="${content}" key="sign_up_btn" var="sign_up_btn"/>
<fmt:message bundle="${content}" key="home_btn" var="home_btn"/>
<fmt:message bundle="${content}" key="news_btn" var="news_btn"/>
<fmt:message bundle="${content}" key="admissions_btn" var="admissions_btn"/>
<fmt:message bundle="${content}" key="contacts_btn" var="contacts_btn"/>
<fmt:message bundle="${content}" key="control_panel_btn" var="control_panel_btn"/>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <link rel="stylesheet" href="css/main.css">
</head>
<div class="top-menu-container">
    <div class="top-menu">
        <div class="buttons">
        <a href="controller?command=change_language&lang=ru">RU</a>
        <a href="controller?command=change_language&lang=end">EN</a>
            <c:if test="${not empty sessionScope.accountId}">
                <a href="controller?command=logout">logout</a>
            </c:if>
            <c:if test="${empty sessionScope.accountId}">
                <a href="controller?command=forward&page=registration">${sign_up_btn}</a>
                <a href="controller?command=forward&page=authorization">${sign_in_btn}</a>
            </c:if>
        </div>
        <%--       <div class="down-section">
                   <div class="page-title">Melbourne university</div>
                   <div class="Apply-form"><a>Apply</a></div>
               </div>--%>
    </div>
</div>
<header>
    <div class="upper-bar-wrapper">
    <div class="upper-bar">
    <ul class="sign-btn-ul">
    </ul>
 <%--       <div class="down-section">
            <div class="page-title">Melbourne university</div>
            <div class="Apply-form"><a>Apply</a></div>
        </div>--%>
    </div>
    </div>
    <menu>
        <li><a href="#"><i class="fa fa-home fa-fw"></i>${home_btn}</a></li>
        <li><a href="#">${news_btn}</a></li>
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
