<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             View all receipts
    </jsp:attribute>

    <jsp:attribute name="footer">
            View all receipts
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
                    <th>Id Receipt</th>
                    <th>Id user</th>
                    <th>Time Of Order</th>
                    <td>Complete</td>
                    <th>Get all items</th>
                </tr>

                <c:forEach var="receipt" items="${requestScope.receipts}">
                    <tr>
                        <td>${receipt.idReceipt}</td>
                        <td>${receipt.getiduser()}</td>
                        <td>${receipt.timeOfOrder}</td>
                        <td>${receipt.complete}</td>

                        <td>
                            <form action="Orders" method="post">
                                <input type="text" hidden name="idReceipt" value="${receipt.idReceipt}">
                                <input type="submit" class="btn btn-secondary" value="Get Order Items">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </jsp:body>
</t:pagetemplate>