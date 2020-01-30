<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="css/main.css">
</head>
<header>
    <ul class="sign-btn-ul">
        <c:if test="${not empty sessionScope.accountId}">
            <li><a href="controller?command=logout">logout</a></li>
        </c:if>
        <c:if test="${empty sessionScope.accountId}">
            <li><a href="controller?command=forward&page=registration">sign up</a></li>
            <li><a href="controller?command=forward&page=authorization">sign in</a></li>
        </c:if>
    </ul>
    <div class="page-title">Melbourne university</div>
</header>
<header>
    <menu>
        <li><a href="#"><i class="fa fa-home fa-fw"></i>Home</a></li>
        <li><a href="#">News</a></li>
        <li><a href="#">Admissions</a></li>
        <li><a href="#">Contacts</a></li>
        <c:if test="${isUserAdmin}">
            <li>
                <a href="controller?command=show_admin_panel">Control panel</a>
            </li>
        </c:if>
    </menu>
</header>
</html>
