<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="header.jsp" %>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.id.col" var="id_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.login.col" var="login_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.mailbox.col" var="mailbox_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.name.col" var="name_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.surname.col" var="surname_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.patronymic.col" var="patronymic_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.admin.status.col" var="admin_status_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.block.status.col" var="block_status_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.action.col" var="action_col"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.action.block" var="block_action"/>
<fmt:message bundle="${localizationContent}" key="control.panel.accounts.action.unblock" var="unblock_action"/>


<html>
<head>
    <link rel="stylesheet" href="css/admin_panel.css">
    <%--@elvariable id="content" type="com.epam.model.dto.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<body>
<div class="main-content">
    <h3>Accounts</h3>
    <table class="account-table">
        <tr>
            <th>${id_col}</th>
            <th>${login_col}</th>
            <th>${mailbox_col}</th>
            <th>${name_col}</th>
            <th>${surname_col}</th>
            <th>${patronymic_col}</th>
            <th>${admin_status_col}</th>
            <th>${block_status_col}</th>
            <th>${action_col}</th>
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
                                <input class="button" type="submit" value="${unblock_action}"/>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form class="decline-form" name="decline" method="post" action="controller">
                                <input type="hidden" name="command" value="change_block_status"/>
                                <input type="hidden" name="accountId" value="${account.id}"/>
                                <input type="hidden" name="blockStatus" value="true"/>
                                <input class="button" type="submit" value="${block_action}"/>
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
