<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>
         Error
        </title>
    </head>
  <body>
 Request from ${pageContext.errorData.requestUri} is failed
 <br/>
 Servlet name or type: ${pageContext.errorData.servletName}
 <br/>
 Status code: ${pageContext.errorData.statusCode}
 <br/>
 Exception: ${pageContext.errorData.throwable}
    </body>
    </html>