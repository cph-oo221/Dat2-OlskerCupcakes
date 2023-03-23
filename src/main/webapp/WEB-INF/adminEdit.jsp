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

        <div class="text-start">
            <form action="AdminPanel" method="post">
                <input type="submit" class="btn btn-secondary fw-bold" value="Admin Panel"/>
            </form>
        </div>


        <div class="text-start-2">
            <p><b> Over view for: ${requestScope.editUser} </b></p>
            <p><b>Password: ${requestScope.password}</b></p>
            <p><b>Role: ${requestScope.role}</b></p>
            <p><b>Balance:  ${requestScope.balance} kr.</b></p>
            <p><b>User id: ${requestScope.userId}</b></p>
        </div>

        <div class="text-start mt-5">
            <form action="EditUser" method="get">
                <input type="text" hidden name="Email" value="${requestScope.editUser}">
                <input type="text" hidden name="UserId" value="${requestScope.userId}">
                <input type="text" hidden name="Balance" value="${requestScope.balance}">
                <input type="text" hidden name="Role" value="${requestScope.role}">
                <input type="text" hidden name="Password" value="${requestScope.password}">
                <input type="text" id="balance" name="balance" placeholder="Add balance"/>
                <br/>
                <br/>
                <input type="submit" class="btn btn-secondary fw-bold" value="Add balance"/>
            </form>
        </div>
    </jsp:body>
</t:pagetemplate>