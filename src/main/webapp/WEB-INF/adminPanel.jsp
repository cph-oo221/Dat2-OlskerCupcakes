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

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                /*border: 1px solid #dddddd;*/
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
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

                <tr>
                    <td>oskar@gmail.com</td>
                    <td>1234</td>
                    <td>user</td>
                    <td>100</td>

                    <!-- TODO change to right value, formaction & formmethod   -->
                    <input type="text" hidden name="Valg" value="${ChangeThis}">
                    <td> <input type="submit" formaction="Admin" formmethod="post" class="btn btn-link" value="Edit"></td>
                </tr>
            </table>
        </div>

    </jsp:body>
</t:pagetemplate>