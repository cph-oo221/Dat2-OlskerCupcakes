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

        <div class="text-center">
                <table>
                        <c:forEach var="item" items="${sessionScope.orderItemList}">
                    <tr>
                        <td>${item.toString()}</td>
                    </tr>
                        </c:forEach>
                </table>
        </div>

    </jsp:body>

</t:pagetemplate>