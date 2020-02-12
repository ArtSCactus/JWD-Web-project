<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/admin_panel.css">
    <%--@elvariable id="content" type="com.epam.model.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<body>
<div class="main-content">
    <h3>Accounts</h3>
    <table class="account-table">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>MailBox</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Patronymic</th>
            <th>Admin status</th>
            <th>Block status</th>
            <th>Action</th>
        </tr>
        <%--@elvariable id="account" type="com.epam.model.dto.entity.Account"--%>
        <c:forEach var="account" items="${pageContent.objectsList}">
            <tr>
                <td>${account.id}</td>
                <td>${account.login}</td>
                <td>${account.mailbox}</td>
                <td>${account.name}</td>
                <td>${account.surname}</td>
                <td>${account.patronymic}</td>
                <c:if test="${account.admin eq true}">
                    <td>admin</td>
                </c:if>
                <c:if test="${account.admin eq false}">
                    <td>user</td>
                </c:if>
                <c:if test="${account.blocked eq true}">
                    <td>blocked</td>
                </c:if>
                <c:if test="${account.blocked eq false}">
                    <td>not blocked</td>
                </c:if>
                <td>
                    <c:choose>
                        <c:when test="${account.blocked eq true}">
                            <form class="accept-form" name="accept" method="post" action="controller">
                                <input type="hidden" name="command" value="change_block_status"/>
                                <input type="hidden" name="accountId" value="${account.id}"/>
                                <input type="hidden" name="blockStatus" value="false"/>
                                <input class="button" type="submit" value="unblock"/>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form class="decline-form" name="decline" method="post" action="controller">
                                <input type="hidden" name="command" value="change_block_status"/>
                                <input type="hidden" name="accountId" value="${account.id}"/>
                                <input type="hidden" name="blockStatus" value="true"/>
                                <input class="button" type="submit" value="block"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
