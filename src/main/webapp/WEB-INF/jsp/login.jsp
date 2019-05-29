<%--
  Created by IntelliJ IDEA.
  User: gokhan
  Date: 5/29/19
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>PetClinic Login Page</h1>
<form action="login" method="post">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    Remember Me:<input type="checkbox" name="remember-me"/><br/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="login"/>
    <font color="red">
        <c:if test="${not empty param.loginFailed}">
            <c:out value="Login Failed, Incorrect Username or Password"></c:out>
        </c:if>
    </font>
</form>
</body>
</html>
