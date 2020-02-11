<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>
         Error
        </title>
    </head>
  <body>
 Request from ${requestUri} is failed
 <br/>
 Servlet name or type: ${servletName}
 <br/>
 Status code: ${statusCode}
 <br/>
 Exception: ${throwable}
  <br/>
  Message: ${requestScope.message}
    </body>
    </html>