<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">
        Browse cake items
    </jsp:attribute>

    <jsp:body>

        <div class="container m-4">
            <div class="row">
                <div class="col">
                    <h3>Bottoms</h3>
                    <table>
                        <th>Item</th>
                        <th>Price</th>
                        <c:forEach var="bottom" items="${sessionScope.bottoms}">
                            <tr>
                                <td>${bottom.name}</td>
                                <td>${bottom.price}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col">
                    <h1>Cupcake items:</h1>
                    <h3>Tops:</h3>
                    <table>
                        <th>Item</th>
                        <th>Price</th>
                        <c:forEach var="top" items="${sessionScope.tops}">
                            <tr>
                                <td>${top.name}</td>
                                <td>${top.price}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col">
                    3 of 3
                </div>
        </div>



        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
