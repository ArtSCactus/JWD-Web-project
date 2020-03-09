<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>
            Not found
        </title>
    </head>
  <body>
  <h3>404 <br/> Not found</h3>
  Code:<br/>
  ${pageContext.errorData.statusCode}<br/>
  Application:<br/>
  ${pageContext.errorData.servletName}<br/>
  Uri:<br/>
  ${pageContext.errorData.requestURI}<br/>
    </body>
    </html>