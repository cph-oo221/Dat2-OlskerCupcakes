<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the logged in area
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <p>You should be logged in now</p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "<b>${sessionScope.user.role}</b>".</p>
        </c:if>


        <div class="row mt-3">
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
                        <p>You are not logged in yet. You can do it here: </p>
                        <a href="login.jsp" class="btn btn-secondary btn-lg fw-bold">Login</a>
                    </c:if>
                </div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>