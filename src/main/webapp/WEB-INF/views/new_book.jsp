<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Book</title>
</head>
<body>
<div align="center">
    <h2>New Book</h2>
    <form:form action="save" method="post" modelAttribute="book">
        <table border="0" cellpadding="5">
            <tr>
                <td>Title: </td>
                <td><form:input path="bookTitle" /></td>
            </tr>
            <tr>
                <td>Author: </td>
                <td><form:input path="bookAuthor" /></td>
            </tr>
            <tr>
                <td>Count: </td>
                <td><form:input path="count" /></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><form:input path="price" /></td>
            </tr>



            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
