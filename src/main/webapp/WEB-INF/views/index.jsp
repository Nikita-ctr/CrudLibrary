<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Book Manager</title>
</head>
<body>
<div align="center">
    <h2>Book Manager</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="${pageContext.request.contextPath}/new">New Book</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author</th>
            <th>Count</th>
            <th>Price</th>
            <th>Date of issue</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookTitle}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.count}</td>
                <td>${book.price}</td>
                <td>${book.dateOfIssue}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=${book.id}">Edit</a>

                    <a href="${pageContext.request.contextPath}/delete?id=${book.id}">Delete</a>
                </td>
            </tr>

        </c:forEach>

    </table>


</div>
<table border="1" cellpadding="5">
    <tr>
        <th>Information</th>
    </tr>
    <tr>
        <td>Sum of all books:<jsp:text>${sum}</jsp:text></td>
    </tr>
    <tr>
        <td>Count of books:<jsp:text>${count}</jsp:text></td>
    </tr>
</table>
</body>
</html>
