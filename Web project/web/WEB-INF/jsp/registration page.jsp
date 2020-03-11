<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization/Page content" var="localizedContent"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.title" var="sign_up_page_title"/>
<fmt:message bundle="${localizedContent}" key="sign.up.form.title" var="form_title"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.log.pas.tab.title" var="log_pas_tab_title"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.mailbox.tab.title" var="mailbox_tab_title"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.name.tab.title" var="name_tab_title"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.total.points.tab.title" var="total_points_tab_title"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.previous.btn" var="previous_btn"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.next.btn" var="next_btn"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.finish.btn" var="finish_btn"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.login.placeholder" var="login_placeholder"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.password.placeholder" var="password_placeholder"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.email.placeholder" var="email_placeholder"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.first.name.placeholder" var="first_name_placeholder"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.second.name.placeholder" var="second_name_placeholder"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.third.name.placeholder" var="third_name_placeholder"/>
<fmt:message bundle="${localizedContent}" key="sign.up.page.total.points.placeholder" var="total_points_placeholder"/>
<html lang="${sessionScope.lang}">
<head>
    <title>
        ${sign_up_page_title}
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

    <h1>${form_title}</h1>
    <c:if test="${not empty error_message}">
        <div class="error-message-div">${error_message}</div>
    </c:if>
    <div class="tab">${log_pas_tab_title}
        <p><input name="login" type="text" placeholder="${login_placeholder}" required pattern="^[A-za-z0-9_-]{2,20}$" oninput="this.className = ''">
        <p><input name="password" type="password" placeholder="${password_placeholder}" oninput="this.className = ''" required min="3" max="16"></p>
    </div>

    <div class="tab">${mailbox_tab_title}
        <p><input name="mailbox" placeholder="${email_placeholder}" oninput="this.className = ''"></p>
    </div>
    <div class="tab">${name_tab_title}
        <p><input name="first name" placeholder="${first_name_placeholder}" oninput="this.className = ''" required pattern="^[А-Яа-яA-Za-z0-9\s]{2,20}$"></p>
        <p><input  name="second name" placeholder="${second_name_placeholder}" oninput="this.className = ''" required pattern="^[А-Яа-яA-Za-z0-9\s]{2,20}$"></p>
        <p><input name="third name" placeholder="${third_name_placeholder}" oninput="this.className = ''" required pattern="^[А-Яа-яA-Za-z0-9\s]{2,20}$"></p>
    </div>

    <div class="tab">${total_points_tab_title}
        <p><input type="number" min="1" max="400" step="1" name="total points" placeholder="${total_points_placeholder}" oninput="this.className = ''"></p>
    </div>
    <input type="hidden" name="command" value="sign_up">
    <div style="overflow:auto;">
        <div style="float:right;">
            <button type="button" id="prevBtn" onclick="nextPrev(-1)">${previous_btn}</button>
            <button type="button" id="nextBtn" onclick="nextPrev(1)">${next_btn}</button>
            <button type="submit" id="finish" onclick="finalValidation()">${finish_btn}</button>
        </div>
    </div>
</form>
</body>
</html>