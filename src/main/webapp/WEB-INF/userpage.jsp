<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        <div class="text-center">
         Shoppingcart
        </div>
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div class="mt-3">
            <table class="table table-dark table-striped">
                <tr>
                    <th>Time Of Order</th>
                    <td>Complete</td>
                    <th>Get all items</th>
                </tr>

                <c:forEach var="receipt" items="${requestScope.receiptList}">
                    <tr>
                        <td>${receiptList.idReceipt}</td>
                        <td>${receiptList.timeOfOrder}</td> <!-- maybe add a to string -->
                        <td>${receiptList.completed}</td>


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