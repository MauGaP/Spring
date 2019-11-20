<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HMTL 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title> - User Page - </title>
    <style>
        * {
            box-sizing: border-box;
        }

        /* Create two equal columns that floats next to each other */
        .column {
            float: left;
            width: 50%;
            padding: 10px;
            height: 300px; /* Should be removed. Only for demonstration */
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
    </style>
</head>
<body>
<h1>User List</h1>

<div class="row">
    <div class="column">
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
                    <td>${user.userId}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.address}</td>
                    <td>
                        <spring:url value="/user/update/${user.userId}" var="updateURL"/>
                        <a href="${updateURL}">Update</a>
                    </td>
                    <td>
                        <spring:url value="/user/delete/${user.userId}" var="deleteURL"/>
                        <a href="${deleteURL}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="column">
        <spring:url value="addStudent" var="addStudentURL"/>
        <a href="${addStudentURL}">Add Student</a>
        <table with="100%" border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Grade</th>
                <th>Average</th>
                <th colspan="2"> Action</th>
            </tr>
            <c:forEach items="${listStudent}" var="student">
                <tr>
                    <td>${student.userId}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.address}</td>
                    <td>${student.grade}</td>
                    <td>${student.average}</td>
                    <td>
                        <spring:url value="/student/update/${student.userId}" var="updateURL"/>
                        <a href="${updateURL}">Update</a>
                    </td>
                    <td>
                        <spring:url value="/student/delete/${student.userId}" var="deleteURL"/>
                        <a href="${deleteURL}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>