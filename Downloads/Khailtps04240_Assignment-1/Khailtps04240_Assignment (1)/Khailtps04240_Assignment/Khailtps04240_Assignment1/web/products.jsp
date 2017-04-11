<%-- 
    Document   : products
    Created on : Sep 30, 2016, 6:51:07 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      welcome, ${USER}
    <center>
         <h1>Products</h1>
        <form action="ControllerProducts">
            Nhap Ten SP:<input type="text" name="txtTenSP" value=""/>
            <input type="submit" name="action" value="Search"/>
          </form>
          <a href="newproducts.jsp">New Product</a>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>
                <td>Edit</td>
                <td>Delete</td>
                </tr>
                <c:forEach var="rows" items="${listSP}">
                    <form action="ControllerProducts">
                         <tr>
                        <td>${rows.code}</td>
                        <td>${rows.name}</td>
                        <td>${rows.price}</td>
                        <c:url var="del" value="ControllerProducts">
                            <c:param name="action" value="Edit"/>
                            <c:param name="txtCode" value="${rows.code}"/>
                            <c:param name="txtName" value="${rows.name}"/>
                            <c:param name="txtPrice" value="${rows.price}"/>
                                </c:url>
                        <td><a href="${del}">Edit</a></td>
                                <td>
                                    <input type="hidden" name="txtCode" value="${rows.code}"/>
                                    <input type="submit" name="action" value="Delete"/>
                                </td>
                         </tr>
                      </form>
                </c:forEach>
            </table>
        <br/>
    </center>
  </body>
</html>
