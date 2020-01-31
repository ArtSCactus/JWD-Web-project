<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>
        University
    </title>
    <link rel="stylesheet" href="../../../css/main.css">
</head>
<body>
<div class="faculties-block">
    <aside class="faculties-enum-block">
       <c:forEach var="facultiesList" items="${applicationScope.faculties}">
       <div class="faculty-item">
           <div class="faculty-item-title">
                   ${facultiesList.name}
           </div>
       </div>
       </c:forEach>
    </aside>
           <div class="faculty-description-block">
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
    <input type="submit" value="find">
</form>
</div>
    <div class="specialties-block">
        <c:forEach var="specialtiesList" items="${applicationScope.faculties}">
            <c:forEach var="specialty" items="${specialtiesList.specialties}">
                <div class="specialty_item">
                    <div class="specialty_item_title">
                            ${specialty.name}
                    </div>
                    <div class="specialty_item_description">
                                ${specialty.description}
                        </div>
                        <form class="apply-btn-form" method="post"
                              action="controller?command=apply&specialty=${specialty.id}&faculty=${specialtiesList.id}">
                            <button class="apply-btn" type="submit">Apply</button>
                        </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>
</body>
</html>