<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>
         Error
        </title>
    </head>
  <body>
 Request from ${pageContext.errorData.requestURI} is failed
 <br/>
 Servlet name or type: ${pageContext.errorData.servletName}
 <br/>
 Status code: ${pageContext.errorData.statusCode}
 <br/>
 Servlet Exception: ${throwable}
 <br/>
 404 Exception: ${pageContext.errorData.throwable}
 <br/>
 ${pageContext.errorData.throwable.cause.message}
  <br/>
  Servlet message: ${requestScope.message}
    </body>
    </html>