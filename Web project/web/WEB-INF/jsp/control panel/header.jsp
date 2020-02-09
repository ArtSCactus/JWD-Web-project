<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="css/admin_panel.css">
    <script async src="scripts/Admin panel.js"></script>
    <script src="scripts/jquery/jquery-3.4.1.min.js"></script>
    <!-- 2. Подключим jQuery UI -->
    <link type="text/css" href="scripts/jquery/jquery-ui-1.12.1/jquery-ui.theme.css" rel="stylesheet"/>
    <script type="text/javascript" src="scripts/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
</head>
<div class="menu-container">
    <a class="open-btn"></a>
<menu id="side-menu">
    <a class="close-btn"></a>
    <a class="language-switch">EN</a>
    <a class="language-switch">RU</a>
    <ul class="list">
    <li><a href="controller?command=show_admissions_panel">Admissions</a></li>
    <li><a href="controller?command=show_applications_panel">Applications</a></li>
    <li><a href="controller?command=show_students_panel">Students</a></li>
    <li><a href="controller?command=show_accounts_panel">Accounts</a></li>
    <li><a href="controller?command=show_main_page">Main</a></li>
    <li><a href="controller?command=logout">Logout</a></li>
    </ul>
</menu>
</div>
<header>
    <div class="university-title">Melbourne university</div>
</header>
</html>
