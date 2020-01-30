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
  <%--  <aside class="FacultiesSideBar">
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
    </aside>--%>
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