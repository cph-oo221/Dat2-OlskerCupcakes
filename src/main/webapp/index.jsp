<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to Olsker Cupcakes
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <p>
            We are a bakery shop, known for our delicious cupcakes. On this site you can place pick up orders
            for our shop. You will receive an e-mail when the order is ready to pick up.
            This usually takes about a week.
        </p>
        <p>
            Navigate through the site with the navigation
            bar at the top of the site.
        </p>

        <c:if test="${sessionScope.user == null}">
            <strong>
                Log in or create a new account to place orders
            </strong>
        </c:if>

        <div class="row mt-3">
            <c:if test="${sessionScope.user != null}">
                <p>You are logged in with the role of "${sessionScope.user.role}".</p>
                <div class="col">
                    <c:if test="${sessionScope.user.role.equalsIgnoreCase('admin')}">
                        <div class="text-center">
                            <form action="AdminPanel" method="post">
                                <input type="submit" class="btn btn-secondary btn-lg fw-bold" value="Admin Panel"/>
                            </form>
                        </div>
                        <br/>
                        <br/>
                    </c:if>
                </div>
            </c:if>

            <div class="col">
                <div class="text-center">
                    <form action="${pageContext.request.contextPath}/browse" method="get">
                        <input type="submit" class="btn btn-secondary btn-lg fw-bold" value="Browse Cupcakes"/>
                    </form>
                    <br/>
                </div>
            </div>

            <div class="col">
                <div class="text-center">
                    <c:if test="${sessionScope.user == null}">
                        <a href="login.jsp" class="btn btn-secondary btn-lg fw-bold">Login</a>
                    </c:if>
                </div>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>