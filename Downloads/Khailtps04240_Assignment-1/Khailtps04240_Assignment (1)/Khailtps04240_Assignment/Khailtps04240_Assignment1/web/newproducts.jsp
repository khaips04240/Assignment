<%-- 
    Document   : newproducts
    Created on : Oct 12, 2016, 7:33:09 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>New Products</h1>
        <form action="ControllerProducts">
           Code : <input type="text" name="txtCode" value="">
           Name : <input type="text" name="txtName" value="">
           Price : <input type="text" name="txtPrice" value="">
            <input type="submit" name="action" value="Insert"/>
        </form>
    </center>
       
    </body>
</html>
