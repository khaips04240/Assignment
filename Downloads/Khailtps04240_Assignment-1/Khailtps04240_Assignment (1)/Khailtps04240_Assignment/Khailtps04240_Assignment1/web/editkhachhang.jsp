<%-- 
    Document   : editkhachhang
    Created on : Oct 16, 2016, 8:12:08 PM
    Author     : Administrator
--%>

<%@page import="entity.Khachhang"%>
<%@page import="dao.KhachhangDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <center>
        <h1>Edit Khach Hang</h1>
    <% KhachhangDAO kd=new KhachhangDAO();
    Khachhang kh = kd.layThongTinKH(request.getParameter("txtMaKH"));
    %>
        <form action="ControllerKhachhang">
            MaKH:<%=kh.getMaKhachHang()%> <br/>
            Mat Khau: <input type="text" name="txtMatKhau" value="<%=kh.getMatKhau()%>"/><br/>
            Ho Va Ten: <input type="text" name="txtHoVaTen" value="<%=kh.getHoVaTen()%>"/><br/>
            Email: <input type="text" name="txtEmail" value="<%=kh.getEmail()%>"/><br/>
            Dien Thoai:<input type="text" name="txtDienThoai" value="<%=kh.getDienThoai()%>"/><br/>
            <input type="hidden" name="txtMaKH" value="<%=kh.getMaKhachHang()%>"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </center>
    </body>
</html>
