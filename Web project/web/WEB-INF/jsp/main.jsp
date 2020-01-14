<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>
        Welcome
    </title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <div class="signUpBtn">
        <a href="controller?command=signUp">sign up</a>
    </div>
    <div class="signInBtn">
        <a href="controller?command=login">sign in</a>
    </div>
</header>
<div class="userGreeting">
    <h3>
        University name here
    </h3>
    ${user}, hello!
</div>
<aside class="specialtiesSideBar">
    <dl>faculties</dl>
    <dt>faculty</dt>
    <dd>specialty</dd>
</aside>
<%--Temporary disabled due to the lack of data for the list--%>
<%--<c:forEach var="specialtiesList" items="${specialties}">
<div class="specialtyContainer">
    <div class="row">
        <div class="columns">
            <h4>TITLE</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
        </div>
    </div>
    </c:forEach>--%>
    <a href="controller?command=logout">Logout</a>
</body>
</html>