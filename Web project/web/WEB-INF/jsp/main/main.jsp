<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp" %>

<fmt:setLocale value="ru_RU" scope="session"/>
<fmt:setBundle basename="Page content" var="content"/>
<fmt:message bundle="${content}" key="page_title" var="page_title"/>
<html lang="${sessionScope.language}">
<head>
    <title>
       University
    </title>
    <head>
        <meta http-equiv="Content-type" content="text/html;charset=utf-8">
    <script src="scripts/jquery/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="../../../css/main.css">
    <script async src="scripts/Main page.js"></script>
    <!-- 2. Подключим jQuery UI -->
    <link type="text/css" href="scripts/jquery/jquery-ui-1.12.1/jquery-ui.theme.css" rel="stylesheet"/>
    <script type="text/javascript" src="scripts/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <c:set var="pageContent" value="${requestScope.content}" scope="page"/>
</head>
<body>
<div class="faculties-block">
    <aside class="faculties-enum-block">
        <%--@elvariable id="faculty" type="com.epam.model.dto.university.Faculty"--%>
        <c:forEach var="faculty" items="${pageContent.additionalAttributes.get('faculties')}">
            <div class="faculty-item">
                <div class="faculty-item-title">
                        ${faculty.name}
                </div>
            </div>
        </c:forEach>
    </aside>
    <div class="faculty-description-block">
        ${page_title}
        Established in 1853, the University of Melbourne is a public-spirited
        institution that makes distinctive contributions to society in research,
        learning and teaching and engagement. It’s consistently ranked among the
        leading universities in the world, with international rankings of world universities
        placing it as number 1 in Australia and number 32 in the world
        (Times Higher Education World University Rankings 2017-2018).
    </div>
</div>
<div class="specialties-toolbox">
    <form class="search-form">
        <input type="text" class="search-input-field" placeholder="Search here..."/>
        <label for="only-with-admission-checkbox">
            Only with admission
            <input type="checkbox" id="only-with-admission-checkbox" value="false">
        </label>
        <input class="find-btn" type="button" value="find" onclick="updateSpecialtiesBlock()">
    </form>
</div>
<div class="specialty-block-title">Choose your way</div>
<div class="specialties-block">
    <%--@elvariable id="specialty" type="com.epam.model.dto.university.Specialty"--%>
    <c:forEach var="specialty" items="${pageContent.additionalAttributes.get('specialties')}">
        <div id="${specialty.admissionId}" class="specialty-item">
            <div class="specialty_item_title">
                    ${specialty.name}
            </div>
            <div class="specialty_item_description">
                    ${specialty.description}
            </div>
            <form class="apply-btn-form" method="post"
                  action="controller?command=apply&specialty=${specialty.id}&faculty=${specialty.facultyId}">
                <button class="apply-btn" type="submit">Apply</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>