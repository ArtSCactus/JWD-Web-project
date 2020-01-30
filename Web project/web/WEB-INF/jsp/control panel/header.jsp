<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="css/admin_panel.css">
</head>
<header>
    <div class="university-title">Melbourne university</div>
    <a href="controller?command=logout">logout</a>
    <menu>
        <li><a href="controller?command=show_admissions_panel">Admissions</a></li>
        <li><a href="controller?command=show_applications_panel">Applications</a></li>
        <li><a href="controller?command=show_students_panel">Students</a></li>
        <li><a href="controller?command=show_accounts_panel">Accounts</a></li>
    </menu>
</header>
</html>
