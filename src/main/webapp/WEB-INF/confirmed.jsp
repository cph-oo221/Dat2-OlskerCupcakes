<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Purchase confirmed!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Purchase confirmed
    </jsp:attribute>

    <jsp:body>

        <style>
            h1 {
                text-align: center;
            }

            #body {
              text-align: center;
            }

        </style>

        <p ID="body">
            Your purchase has been registered, and your order will be ready to get picked up around next week.
            You will receive an e-mail when it is ready
        </p>

        <form action="userpage">
            <button type="submit" class="btn btn-secondary fw-bold">Return to User Page</button>
        </form>

    </jsp:body>

</t:pagetemplate>