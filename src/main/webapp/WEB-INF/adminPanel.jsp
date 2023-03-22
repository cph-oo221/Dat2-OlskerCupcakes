<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Admin panel
    </jsp:attribute>

    <jsp:attribute name="footer">
            Admin panel
    </jsp:attribute>

    <jsp:body>


        <div class="mt-3">
            <input type="submit" formaction="" formmethod="post" class="btn btn-secondary" value="View all Receipts">
        </div>


        <!-- TABLE FOR LIST OVER USERS -->
        <style>
            table
            {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th
            {
                /*border: 1px solid #dddddd;*/
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
                    <th>Email</th>
                    <th>Password</th>
                    <td>Role</td>
                    <th>Balance</th>
                    <th>Edit</th>
                </tr>

                <c:forEach var="user" items="${requestScope.userList}">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.role}</td>
                        <td>${user.balance}</td>

                        <td>
                            <form action="editUser" method="post">
                                <input type="hidden" name="email" value="${user.username}">
                                <input type="submit" class="btn btn-secondary" value="Edit">
                            </form>
                        </td>
                    </tr>
                </c:forEach>


            </table>
        </div>

    </jsp:body>
</t:pagetemplate>