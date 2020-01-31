<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>
        Login
    </title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<form id="regForm" action="">

    <h1>Register:</h1>
    <div class="tab">Login Info:
        <p><input type="text" placeholder="Username..." oninput="this.className = ''"></p>
        <p><input type="password" placeholder="Password..." oninput="this.className = ''"></p>
    </div>

    <!-- One "tab" for each step in the form: -->
    <div class="tab">Name:
        <p><input placeholder="First name..." oninput="this.className = ''"></p>
        <p><input placeholder="Last name..." oninput="this.className = ''"></p>
        <p><input placeholder="Third name..." oninput="this.className = ''"></p>
    </div>

    <div class="tab">Mailbox:
        <p><input placeholder="E-mail..." oninput="this.className = ''"></p>
        <p><input placeholder="Phone..." oninput="this.className = ''"></p>
    </div>

    <div class="tab">Total points:
        <p><input placeholder="dd" oninput="this.className = ''"></p>
    </div>

    <div style="overflow:auto;">
        <div style="float:right;">
            <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
        </div>
    </div>

    <!-- Circles which indicates the steps of the form: -->
    <div style="text-align:center;margin-top:40px;">
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
    </div>

</form>
</body>
</html>