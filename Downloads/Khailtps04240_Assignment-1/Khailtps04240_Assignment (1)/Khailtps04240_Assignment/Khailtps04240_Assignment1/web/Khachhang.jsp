<%-- 
    Document   : Khachhang
    Created on : Oct 15, 2016, 4:11:29 PM
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
    <center>
        
        <h1>Khach Hang</h1>
         <form action="ControllerKhachhang">
            Ten KH:<input type="text" name="txtTenKH" value=""/>
            <input type="submit" name="action" value="Search"/>
        </form>
         <a href="newkhachhang.jsp">New Khach Hang</a>
        <table border="1">
            <tr>
                <td>MaKH</td>
                <td>MatKhau</td>
                <td>HoTen</td>
                <td>Email</td>
                <td>SoDT</td>
                <td>Delete</td>
                <td>Edit</td>
            </tr>            
            
                <c:forEach var="rows" items="${listKH}">
                    <tr>
                    <form action="ControllerKhachhang">
                        <td>${rows.maKhachHang}</td>
                        <td>${rows.matKhau}</td>
                        <td>${rows.hoVaTen}</td>
                        <td>${rows.email}</td>
                        <td>${rows.dienThoai}</td>
                        <td><input type="submit" name="action" value="Delete"/>
                            <input type="hidden" name="txtMaKH" value="${rows.maKhachHang}"/>
                        </td>
                        <td><a href="editkhachhang.jsp?txtMaKH=${rows.maKhachHang}">Edit</a></td>
                        </form>
                    </tr>
                </c:forEach>
        </table>
    </center>
    </body>
</html>
