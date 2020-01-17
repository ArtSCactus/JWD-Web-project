<%@ page import="com.epam.model.entity.University" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>
        Welcome
    </title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <%--<c:set var="facultiesList" scope="application">${faculties}</c:set>--%>
    <c:set var="isDefined" scope="session">${isUserDefined}</c:set>
    <c:set var="isAdmin" scope="session">${isUserAdmin}</c:set>
</head>
<body>
<header>
    <c:if test="${isUserDefined eq true}">
        <a class="logoutBtn" href="controller?command=logout">Logout</a>
    </c:if>
    <c:if test="${isUserDefined eq false}">
        <div class="signUpBtn">
            <a href="controller?command=signUp">sign up</a>
        </div>
        <div class="signInBtn">
            <a href="controller?command=forward&page=authorization">sign in</a>
        </div>
    </c:if>
</header>
<div class="userGreeting">
    <h3>
        University name here
    </h3>
   <c:if test="${isDefined eq true}">
       <c:if test="${isAdmin eq true}">
           ${user}, hello, you are an administrator!
       </c:if>
       <c:if test="${isAdmin eq false}">
           ${user}, hello, you are user!
       </c:if>
    </c:if>
</div>
<aside class="facultiesSideBar">
    <c:forEach var="facultiesList" items="${applicationScope.faculties}">
    <div class="facultyListContainer">
        <div class="row">
            <div class="columns">
                <h3>${facultiesList.name}</h3>
                <c:forEach var="specialtiesOfFacultyList" items="${facultiesList.specialties}">
                   <div class="specialtyNameAtList">
                       <h4>${specialtiesOfFacultyList.name}</h4>
                   </div>
                </c:forEach>
            </div>
        </div>
        </c:forEach>
</aside>
<%--Temporary disabled due to the lack of data for the list--%>
<c:forEach var="specialtiesList" items="${applicationScope.faculties}">
<c:forEach var="specialty" items="${specialtiesList.specialties}">
<div class="specialtiesContainer">
    <div class="title">
        <h4>${specialty.name}</h4>
        <div class="description">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
            ${specialty.description}</p>
        </div>
    </div>
</c:forEach>
    </c:forEach>
</body>
</html>