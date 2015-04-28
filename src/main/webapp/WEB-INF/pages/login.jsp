<!DOCTYPE html>
<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring Security Example </title>
</head>
<body>

<form action="<c:url value='/j_spring_security_check'/>" method="POST">
    <div><label> User Name : <input type="text" name="j_username"/> </label></div>
    <div><label> Password: <input type="password" name="j_password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>