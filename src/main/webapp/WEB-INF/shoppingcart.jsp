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
        Shoppingcart
    </jsp:attribute>

    <jsp:body>

        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col">
                <table>
                        <c:forEach var="item" items="${requestScope.orderItemList}">
                    <tr>
                        <td>${item.toString()}</td>
                    </tr>
                        </c:forEach>
                </table>
                </div>
                <div class="col"></div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>