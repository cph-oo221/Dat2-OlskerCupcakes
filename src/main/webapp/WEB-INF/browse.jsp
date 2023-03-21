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

        <h1>Cupcake items:</h1>
        <form action="additem" method="post">
            <div class="container mb-4">
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
                                    <td>
                                        <input type="radio" name="idBottom" value="${bottom.idBottom}" checked>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col">

                        <h3>Topping</h3>
                        <table>
                            <th>Item</th>
                            <th>Price</th>
                            <c:forEach var="top" items="${sessionScope.tops}">
                                <tr>
                                    <td>${top.name}</td>
                                    <td>${top.price}</td>
                                    <td>
                                        <input type="radio" name="idTop" value="${top.idTop}" checked>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                    <div class="col">
                        <h3>Amount</h3>
                        <input type="number" name="amount" value="1">
                    </div>
                    <div class="col">

                        <h3>Selected</h3>

                        <table>
                            <c:forEach var="orderitem" items="${sessionScope.orderItemList}">
                                <tr>
                                    <td>${orderitem.toString()}</td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>

                    <div class="col-2">
                        <br><br><br><br><br>
                        <button type="submit">Choose</button>
                    </div>
                </div>
                <br><br>
            </div>
        </form>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>
