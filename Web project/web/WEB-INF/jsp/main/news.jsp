<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp" %>
<fmt:message bundle="${localizedContent}" key="main.page.newsFeedItem.title" var="title"/>
<html lang="${sessionScope.lang}">
<head>
    ${title}
    <c:set var="content" value="${requestScope.content}"/>
</head>
<body>
<%--@elvariable id="newsItem" type="com.epam.model.dto.entity.NewsFeedItem"--%>
<c:forEach var="newsItem" items="${content.objectsList}">
    <div class="newsFeedItem-block">
        <div class="newsFeedItem-item">
            <div class="newsFeedItem-item-title">
                    ${newsItem.title}
            </div>
            <div class="newsFeedItem-item-date">
                    ${newsItem.date}
            </div>
            <div class="newsFeedItem-item-description">
                    ${newsItem.text}
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
