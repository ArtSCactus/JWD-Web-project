<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Control panel</title>
    <link rel="stylesheet" href="css/control_panel.css">
    <%--@elvariable id="content" type="com.epam.model.entity.controlpanel.PageContent"--%>
    <c:set var="pageContent" value="${content}" scope="page"/>
</head>
<header>
    <div class="university-title">Melbourne university</div>
    <a href="controller?command=logout">logout</a>
</header>
<body>
<menu>
    <li><a href="controller?command=load_content&type=admissions">Admissions</a></li>
    <li><a href="controller?command=load_content&type=applications">Applications</a></li>
    <li><a href="controller?command=load_content&type=students">Students</a></li>
    <li><a href="controller?command=load_content&type=accounts">Accounts</a></li>
</menu>
<aside>
    <h4>Active admissions here</h4>
</aside>
<c:choose>
    <c:when test="${pageContent.type.stringValue == 'applications'}">
        <table class="application-table">
            <tr>
                <th>ID</th>
                <th>Account id</th>
                <th>Faculty</th>
                <th>Specialty</th>
                <th>Status</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
                <%--@elvariable id="application" type="com.epam.model.entity.Application"--%>
            <c:forEach var="application" items="${pageContent.objectsList}">
                <tr>
                    <td>${application.id}</td>
                    <td>${application.accountId}</td>
                    <td>${application.facultyId}</td>
                    <td>${application.specialtyId}</td>
                    <td>${application.status.message}</td>
                    <td>${application.filingDate}</td>
                    <td>
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="change_application_status"/>
                            <input type="hidden" name="applicationId" value="${application.id}"/>
                            <input type="hidden" name="newStatus" value="accepted"/>
                            <input class="button" type="submit" value="accept"/>
                        </form>
                        <form class="decline-form" name="decline" method="post" action="controller">
                            <input type="hidden" name="command" value="change_application_status"/>
                            <input type="hidden" name="applicationId" value="${application.id}"/>
                            <input type="hidden" name="newStatus" value="rejected"/>
                            <input class="button" type="submit" value="reject"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:when test="${pageContent.type.stringValue == 'accounts'}">
        <table class="account-table">
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Password</th>
                <th>MailBox</th>
                <th>Admin status</th>
                <th>Block status</th>
                <th>Action</th>
            </tr>
                <%--@elvariable id="account" type="com.epam.model.entity.Account"--%>
            <c:forEach var="account" items="${pageContent.objectsList}">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.login}</td>
                    <td>${account.mailbox}</td>
                    <c:if test="${account.admin eq true}">
                        <td>admin</td>
                    </c:if>
                    <c:if test="${account.admin eq false}">
                        <td>user</td>
                    </c:if>
                    <c:if test="${account.blocked eq true}">
                        <td>banned</td>
                    </c:if>
                    <c:if test="${account.blocked eq false}">
                        <td>available</td>
                    </c:if>
                    <td>
                        <form class="accept-form" name="accept" method="post" action="controller">
                            <input type="hidden" name="command" value="change_block_status"/>
                            <input type="hidden" name="accountId" value="${account.id}"/>
                            <input type="hidden" name="blockStatus" value="false"/>
                            <input class="button" type="submit" value="Unban"/>
                        </form>
                        <form class="decline-form" name="decline" method="post" action="controller">
                            <input type="hidden" name="command" value="change_block_status"/>
                            <input type="hidden" name="accountId" value="${account.id}"/>
                            <input type="hidden" name="blockStatus" value="true"/>
                            <input class="button" type="submit" value="Ban"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
</c:choose>

</body>
</html>
