<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true" %>
<html>
    <head>
        <title>
            Not found
        </title>
    </head>
  <body>
  <h3>Oops... <br/> Looks like you are searching for something, that does not exist.</h3>
  Code:<br/>
  ${pageContext.errorData.statusCode}<br/>
  Applications:<br/>
  ${pageContext.errorData.servletName}<br/>
  Uri:<br/>
  ${pageContext.errorData.requestURI}<br/>
    </body>
    </html>