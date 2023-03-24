<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             View order
    </jsp:attribute>

    <jsp:attribute name="footer">
            View order
    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.user.role.equalsIgnoreCase('admin')}">
        <div class="text-start">
            <form action="AdminPanel" method="post">
                <input type="submit" class="btn btn-secondary fw-bold" value="Admin Panel"/>
            </form>
        </div>
        </c:if>

        <c:if test="${sessionScope.user.role.equalsIgnoreCase('user')}">
            <div class="text-start">
                <form action="userpage" method="get">
                    <input type="submit" class="btn btn-secondary fw-bold" value="UserPage"/>
                </form>
            </div>
        </c:if>

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
                    <th>Orders</th>
                </tr>

                <c:forEach var="items" items="${requestScope.orderItems}">
                    <tr>
                        <td>${items.toString()}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="col">
                                total price = ${requestScope.total}
                                </div>
                            </div>

                        </div>


                    </div>

                </tr>

            </table>
        </div>

    </jsp:body>
</t:pagetemplate>