<%-- 
    Document   : login
    Created on : Feb 21, 2017, 11:12:06 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <base href="${pageContext.servletContext.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center>
        <h1>Login</h1>
        <form action="loginController"  modelAttribute="user">
            Username : <input type="text" name="txtUsername" value=""/>
            <br>
            Password : <input type="password" name="txtPassword" value=""/><br>
            <br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" name="Reset" value="Reset"/>
        </form>
    </center>
    </body>
</html>