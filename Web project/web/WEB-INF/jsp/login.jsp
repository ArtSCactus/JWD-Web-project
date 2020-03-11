<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization/Page content" var="localizedContent"/>
<fmt:message bundle="${localizedContent}" key="sign.in.page.title" var="title"/>
<fmt:message bundle="${localizedContent}" key="sign.in.page.username" var="username"/>
<fmt:message bundle="${localizedContent}" key="sign.in.page.password" var="password"/>
<fmt:message bundle="${localizedContent}" key="sign.in.page.form.title" var="form_title"/>
<html>
<head>
    <title>
        ${title}
    </title>
    <link rel="stylesheet" href="css/login.css">
</head>
<div class="container-login">
    <div class="Wrap-login">
        <form class="LoginForm" name="LoginForm" method="POST" action="controller">
            <span class="Login form title">${form_title}</span>
            <div class="Main part">
                <input type="hidden" name="command" value="login"/>
                <span class="Login field title">${username}:<br></span>
                <input type="text" name="login" value=""/>
                <span class="Password field title"><br>${password}:<br/></span>
                <input type="password" name="password" value=""/>
                <br/>
                ${errorMessage}
                <br/>
                <input class="signInBtn" type="submit" value="sign in"/>
            </div>
        </form>
    </div>
</div>
<hr/>
</body>
</html>