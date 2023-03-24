<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        <div class="text-center">
         Your orders
        </div>
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div class="mt-3">
            <table class="table table-dark table-striped">
                <tr>
                    <th>Order Number</th>
                    <th>Time Of Order</th>
                    <td>Complete</td>
                    <th>Actions</th>
                </tr>

                <c:forEach var="receipt" items="${requestScope.receiptList}">
                    <tr>
                        <td>${receipt.idReceipt}</td>
                        <td>${receipt.timeOfOrder}</td> <!-- maybe add a to string -->


                        <td>
                            <form action="Orders" method="post">
                                <input type="text" hidden name="idReceipt" value="${receipt.idReceipt}">
                                <input type="submit" class="btn btn-secondary" value="View order">
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>

    </jsp:body>

</t:pagetemplate>