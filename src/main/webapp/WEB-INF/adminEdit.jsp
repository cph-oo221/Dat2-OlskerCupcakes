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

        <style>
            table
            {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th
            {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even)
            {
                background-color: #dddddd;
            }
        </style>

        <div class="mt-3">
            <table class="table table-dark table-striped">
                <tr>
                    <th>User id</th>
                    <th>Email</th>
                    <th>Password</th>
                    <td>Role</td>
                    <th>Balance</th>
                </tr>

                <tr>
                    <td>${requestScope.userId}</td>
                    <td>${requestScope.editUser}</td>
                    <td>${requestScope.password}</td>
                    <td>${requestScope.role}</td>
                    <td>${requestScope.balance}</td>
                </tr>
            </table>
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