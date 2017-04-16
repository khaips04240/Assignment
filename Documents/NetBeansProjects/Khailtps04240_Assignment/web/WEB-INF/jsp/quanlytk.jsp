<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Spring MVC - Databinding</title>
        <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
<center>
     <jsp:include page="menu.jsp"/>
    <h2>Quản Lý Tài Khoản</h2>
    <form:form action="quanlytk.htm" modelAttribute="user" >
        <div>Username:</div>
        <form:input path="username"/>
        
        <div>Password:</div>
        <form:input path="password"/>

        <div>Fullname;</div>
        <form:input path="fullname"/>
        <div>
            
            <button name="btnInsert">Thêm</button>
            <button name="btnUpdate">Cập nhật</button>         
        </div>
    </form:form>
    <br>            
    
        
    <table border="1">
        <tr>
            <td>UserName</td>
            <td>Password</td>
            <td>Fullname</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="rows" items="${listUser}">
            <form action="delete.htm">
            <tr>
                <td>${rows.username}</td>
                <td>${rows.password}</td>
                <td>${rows.fullname}</td>
                <c:url var="del" value="edit.htm">
                    <c:param name="txtUsername" value="${rows.username}"/>
                    <c:param name="txtPassword" value="${rows.password}"/>
                    <c:param name="txtFullname" value="${rows.fullname}"/>
                </c:url>
                <td><a href="${del}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtUsername" value="${rows.username}"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>
            </form>
        </c:forEach>    
    </table>
</center>
</body>
</html>
