<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>
        University
    </title>
    <link rel="stylesheet" href="css/main.css">
    <c:set var="isDefined" scope="session">${isUserDefined}</c:set>
    <c:set var="isAdmin" scope="session">${isUserAdmin}</c:set>
</head>
<body>
<div class="pageContainer">
<header>
    <ul>
        <c:if test="${isDefined eq true}">
            <li><a href="controller?command=logout">logout</a></li>
        </c:if>
        <c:if test="${isDefined eq false}">
            <li> <a href="controller?command=signUp&page=registration">sign up</a></li>
            <li> <a href="controller?command=forward&page=authorization">sign in</a></li>
        </c:if>
    </ul>
    <div class="UniversityTitle">Melbourne university </div>
</header>
<div class="UserGreeting">
    <c:if test="${isDefined eq true}">
        <c:if test="${isAdmin eq true}">
            ${user}, hello, you are an administrator!
        </c:if>
        <c:if test="${isAdmin eq false}">
            ${user}, hello, you are user!
        </c:if>
    </c:if>
</div>
<aside class="FacultiesSideBar">
    <c:forEach var="facultiesList" items="${applicationScope.faculties}">
    <div class="Faculty_item">
        <div class="Faculty_item_title">
                ${facultiesList.name}
            <c:forEach var="specialtiesOfFacultyList" items="${facultiesList.specialties}">
                <div class="specialtyNameAtList">
                        ${specialtiesOfFacultyList.name}
                </div>
            </c:forEach>
        </div>
        </c:forEach>
</aside>
<div class="MainList">
    <c:forEach var="specialtiesList" items="${applicationScope.faculties}">
        <c:forEach var="specialty" items="${specialtiesList.specialties}">
            <form class="specialty_item" method="post" action="controller?command=apply&specialty=${specialty.id}">
                <div class="specialty_item_title">
                        ${specialty.name}
                    <div class="specialty_item_description">
                            ${specialty.description}
                    </div>
                    <div class="applyBtnFont">
                        <button class="ApplyBtn" type="submit">Apply</button>
                    </div>
                </div>
            </form>
        </c:forEach>
    </c:forEach>
</div>
</div>
</body>
</html>