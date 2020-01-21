<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Control panel</title>
</head>
<body>
<header>
    <div class="page-title">Control panel</div>
    <ul class="menu-bar"></ul>
</header>
<table class="application-table">
    <tr>
        <th>ID</th>
        <th>Account id</th>
        <th>Faculty</th>
        <th>Specialty</th>
        <th>Status</th>
        <th>Date</th>
    </tr>
    <c:forEach var="application-item" items="${applicationsList}">
        <tr>
            <td>${application-item.id}</td>
            <td>${application-item.accountId}</td>
            <td>${application-item.facultyId}</td>
            <td>${application-item.specialtyId}</td>
            <td>${application-item.isAccpeted}</td>
            <td>${application-item.filingDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
