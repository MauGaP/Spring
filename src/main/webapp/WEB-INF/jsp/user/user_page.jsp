<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HMTL 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title> - User Page - </title>
</head>
<body>
<h1>User List</h1>

<spring:url value="add" var="addURL"/>
<a href="${addURL}">Add User</a>

<table with="100%" border="1">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th colspan="2"> Action</th>
    </tr>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.address}</td>
            <td>
                <spring:url value="/user/update/${user.id}" var="updateURL"/>
                <a href="${updateURL}">Update</a>
            </td>
            <td>
                <spring:url value="/user/delete/${user.id}" var="deleteURL"/>
                <a href="${deleteURL}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>