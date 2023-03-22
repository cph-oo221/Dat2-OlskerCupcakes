<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Admin Edit
    </jsp:attribute>

    <jsp:attribute name="footer">
            Admin Edit
    </jsp:attribute>

    <jsp:body>
        <p>Edit for ${requestScope.editUser}</p>
        <p>${requestScope.balance}</p>

        <div class="text-start mt-5">
            <form action="EditUser" method="get">
                <input type="text" id="balance" name="balance" placeholder="Add balance"/>
                <br/>
                <br/>
                <input type="submit" class="btn btn-secondary fw-bold" value="Add balance"/>
            </form>
        </div>




    </jsp:body>
</t:pagetemplate>