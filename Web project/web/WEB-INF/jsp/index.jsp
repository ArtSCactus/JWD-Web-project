<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="r" uri="/WEB-INF/taglib/RedirectionTagLib.tld" %>
<html>
    <head>
        <title>
         Index
        </title>
    </head>
    <body>
    <r:redirect url="controller?command=show_main_page" redirectionType="CLIENT_SIDE"/>
    </body>
</html>