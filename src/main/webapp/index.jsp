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

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <div class="row mt-3">

            <c:if test="${sessionScope.user != null}">
                <div class="col text-center">
                    <p>Here you can see our cupcakes</p>
                    <a class="btn btn-secondary fw-bold" href="${pageContext.request.contextPath}/browse">Cupcakes</a>
                </div>
            </c:if>

            <c:if test="${sessionScope.user == null}">
                <div class="col text-center">
                    <p>Here you can see our cupcakes</p>
                    <a class="btn btn-secondary fw-bold" href="${pageContext.request.contextPath}/browse">Cupcakes</a>
                </div>
            </c:if>

            <div class="col text-center">
                <c:if test="${sessionScope.user == null}">
                    <p>You log in here:</p>
                    <a class="btn btn-secondary fw-bold" href="login.jsp">Login</a>
                </c:if>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>