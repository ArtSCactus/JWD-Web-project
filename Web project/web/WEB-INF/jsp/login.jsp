<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>
        Login
    </title>
    <link href="../css/login.css" rel="stylesheet">
</head>
	<div class="container-login">
	<div class="Wrap-login">
<form class="LoginForm" name="LoginForm" method="POST" action="controller">
    <span class="Login form title">Student login</span>
    <div class="Main part">
        <input type="hidden" name="command" value="login"/>
        <span class="Login field title"> Login:<br></span>
        <input type="text" name="login" value=""/>
        <span class="Password field title"><br>Password:<br/></span>
        <input type="password" name="password" value=""/>
        <br/>
        ${errorLoginPassMessage}
        <br/>
        ${wrongAction}
        <br/>
        ${nullPage}
        <br/>
        <input class="signInBtn" type="submit" value="sign in"/>
    </div>
</form>
		</div>
		</div>
<hr/>
</body>
</html>