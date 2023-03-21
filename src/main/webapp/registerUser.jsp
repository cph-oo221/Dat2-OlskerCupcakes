<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             SingUp
    </jsp:attribute>

    <jsp:attribute name="footer">
            SingUp
    </jsp:attribute>

    <jsp:body>

        <h3>You can Sing Up here</h3>


        <div class="text-center mt-5">
            <form action="SignUp" method="post">
                <label for="username" hidden>Username: </label>
                <input type="text" id="username" name="username" placeholder="Insert Email"/>
                <br/>
                <label for="password" hidden>Password: </label><br/>
                <input type="password" id="password" name="password" placeholder="Insert Password"/>
                <br/>
                <br/>
                <input type="submit" class="btn btn-secondary fw-bold" style="width: 180px;" value="Log in"/>
            </form>
        </div>

    </jsp:body>
</t:pagetemplate>