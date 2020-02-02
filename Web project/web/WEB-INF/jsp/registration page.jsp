<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>
        Registration
    </title>
    <link rel="stylesheet" href="css/registration.css">
    <script async src="scripts/Registration%20form%20script.js"></script>
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
    <div class="tab">Create your login and password:
        <p><input name="login" type="text" placeholder="Username..." oninput="this.className = ''"></p>
        <p><input name="password" type="password" placeholder="Password..." oninput="this.className = ''"></p>
    </div>

    <div class="tab">Would you like to leave us a mailbox?
        <p><input name="mailbox" class="mailbox-input" placeholder="E-mail..." oninput="this.className = ''"></p>
    </div>
    <!-- One "tab" for each step in the form: -->
    <div class="tab">Now tell us who are you:
        <p><input name="first name" placeholder="First name..." oninput="this.className = ''"></p>
        <p><input name="second name" placeholder="Last name..." oninput="this.className = ''"></p>
        <p><input name="third name" placeholder="Third name..." oninput="this.className = ''"></p>
    </div>

    <div class="tab">Total points:
        <p><input name="total points" placeholder="dd" oninput="this.className = ''"></p>
    </div>
    <input type="hidden" name="command" value="sign_up">
    <div style="overflow:auto;">
        <div style="float:right;">
            <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
            <button type="submit" id="finish">Finish</button>
        </div>
    </div>

    <!-- Circles which indicates the steps of the form: -->
</form>
</body>
</html>