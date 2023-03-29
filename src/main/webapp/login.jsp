<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here</h3>


        <div class="text-center mt-5">
            <form action="login" method="post">
                <label for="email" hidden>Username: </label>
                <input type="text" id="email" name="email" placeholder="Email"/>
                <br/>
                <label for="password" hidden>Password: </label><br/>
                <input type="password" id="password" name="password" placeholder="Password"/>
                <br/>
                <br/>
                <input type="submit" class="btn btn-secondary fw-bold" style="width: 180px;" value="Log in"/>
            </form>
        </div>


        <div class="text-center mt-1">
            <form action="registerUser.jsp" method="post">
                <input type="submit" class="btn btn-link" style="text-decoration: none" value="Register new user">
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>