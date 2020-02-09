<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="Page content" var="content"/>
<fmt:message bundle="${content}" key="page_title" var="page_title"/>
<fmt:message bundle="${content}" key="university_description" var="university_description"/>
<fmt:message bundle="${content}" key="specialty_block_title" var="specialty_block_title"/>
<fmt:message bundle="${content}" key="only_with_admissions_check_box" var="checkbox_content"/>
<fmt:message bundle="${content}" key="main_page_search_input_field_placeholder" var="search_field_placeholder"/>
<fmt:message bundle="${content}" key="apply_btn" var="apply_btn"/>
<fmt:message bundle="${content}" key="find_btn" var="find_btn"/>
<fmt:message bundle="${content}" key="applied_btn_status" var="applied"/>
<html lang="${sessionScope.lang}">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title>
        ${page_title}
    </title>
    <c:set var="pageContent" value="${requestScope.content}" scope="page"/>
    <c:set var="existingApplications" value="${pageContent.additionalAttributes.get('existingApplications')}"/>
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
        ${university_description}
    </div>
</div>
<div class="specialty-block-title">${specialty_block_title}</div>
<div class="specialties-toolbox">
    <form class="search-form">
        <label>
            <i class="fa fa-search"></i>
            <input type="text" class="search-input-field" placeholder="${search_field_placeholder}">
        </label>
        <label for="only-with-admission-checkbox">
            ${checkbox_content}
            <input type="checkbox" id="only-with-admission-checkbox" value="false">
        </label>
        <input class="find-btn" type="button" value="${find_btn}" onclick="updateSpecialtiesBlock()">
    </form>
</div>
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
            <c:set var="contains" value="false"/>
        <%--@elvariable id="appliedApplication" type="com.epam.model.dto.entity.Application"--%>
            <c:forEach var="appliedApplication" items="${existingApplications}" varStatus="loop">
                <c:if test="${not contains eq true}">
                <c:if test="${appliedApplication.specialtyId eq specialty.id}">
                    <form class="apply-btn-form" method="post">
                        <button class="apply-btn" type="submit">${applied}</button>
                    </form>
                    <c:set var="contains" value="true" />
                </c:if>
                </c:if>
            </c:forEach>
            <c:if test="${contains eq false}">
                <form class="apply-btn-form" method="post"
                      action="controller?command=apply&specialty=${specialty.id}&faculty=${specialty.facultyId}">
                    <button class="apply-btn" type="submit">${apply_btn}</button>
                </form>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>