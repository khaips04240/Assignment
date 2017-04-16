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
    <h2>Quản Lý Phòng Ban</h2>
    <form:form action="phongban/showalldp.htm" modelAttribute="depart" >
        <div>Id:</div>
        <form:input path="id"/>
        <div>Name</div>
        <form:input path="name"/>
        </br>
            <button name="btnInsert2">Thêm</button>
            <button name="btnUpdate2">Cập nhật</button>         
        </div>
    </form:form>
    <br>            
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="rows" items="${listDepart}">
            <form action="phongban/delete.htm">
            <tr>
                <td>${rows.id}</td>
                <td>${rows.name}</td>
                <c:url var="del" value="phongban/edit.htm">
                    <c:param name="txtId" value="${rows.id}"/>
                    <c:param name="txtName" value="${rows.name}"/>
                </c:url>
                <td><a href="${del}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtId" value="${rows.id}"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>
            </form>
        </c:forEach>    
    </table>
</center>
</body>
</html>
