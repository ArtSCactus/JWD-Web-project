<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="Page content" var="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>
        Registration
    </title>
    <link type="text/css" href="scripts/jquery/jquery-ui-1.12.1/jquery-ui.theme.css" rel="stylesheet"/>
    <script type="text/javascript" src="scripts/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
    <script src="scripts/jquery/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="css/registration.css">
    <script async src="scripts/Registration%20form%20script.js"></script>
    <c:set var="error_message" value="${requestScope.errorMessage}"/>
</head>
<body>
<form id="regForm" action="controller">
    <div style="text-align:center;margin-top:40px;">
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
    </div>

    <h1>Registration:</h1>
    <c:if test="${not empty error_message}">
        <div class="error-message-div">${error_message}</div>
    </c:if>
    <div class="tab">Create your login and password:
        <p><input name="login" type="text" placeholder="Username..." required pattern="^[A-za-z0-9_-]{2,20}$" oninput="this.className = ''">
        <p><input name="password" type="password" placeholder="Password..." oninput="this.className = ''" required></p>
    </div>

    <div class="tab">Would you like to leave us a mailbox?
        <p><input name="mailbox" placeholder="E-mail..." oninput="this.className = ''"></p>
    </div>
    <!-- One "tab" for each step in the form: -->
    <div class="tab">Now tell us who are you:
        <p><input name="first name" placeholder="First name..." oninput="this.className = ''" required pattern="^[А-Яа-яA-Za-z0-9\s]{2,20}$"></p>
        <p><input  name="second name" placeholder="Last name..." oninput="this.className = ''" required pattern="^[А-Яа-яA-Za-z0-9\s]{2,20}$"></p>
        <p><input name="third name" placeholder="Third name..." oninput="this.className = ''" required pattern="^[А-Яа-яA-Za-z0-9\s]{2,20}$"></p>
    </div>

    <div class="tab">Total points:
        <p><input type="number" min="1" max="400" step="1" name="total points" placeholder="dd" oninput="this.className = ''"></p>
    </div>
    <input type="hidden" name="command" value="sign_up">
    <div style="overflow:auto;">
        <div style="float:right;">
            <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
            <button type="submit" id="finish" onclick="finalValidation()">Finish</button>
        </div>
    </div>
</form>
</body>
</html>