<%-- 
    Document   : editProducts
    Created on : Sep 30, 2016, 11:03:20 AM
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
        <h1>Edit Product</h1>
    
        <form action="ControllerProducts">
            Code: ${SP.code}<br/>
            Name: <input type="text" name="txtName" value="${SP.name}"/><br/>
            Price:<input type="text" name="txtPrice" value="${SP.price}"/><br/>
            <input type="hidden" name="txtCode" value="${SP.code}"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </center>
    </body>
</html>
