<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp" %>
<fmt:message bundle="${localizedContent}" key="main.page.news.title" var="title"/>
<html lang="${sessionScope.lang}">
<head>
    ${title}
    <c:set var="content" value="${requestScope.content}"/>
</head>
<body>
<%--@elvariable id="newsItem" type="com.epam.model.dto.entity.News"--%>
<c:forEach var="newsItem" items="${content.objectsList}">
    <div class="news-block">
        <div class="news-item">
            <div class="news-item-title">
                    ${newsItem.title}
            </div>
            <div class="news-item-date">
                    ${newsItem.date}
            </div>
            <div class="news-item-description">
                    ${newsItem.text}
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
