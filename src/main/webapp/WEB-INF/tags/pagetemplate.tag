<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Favicon -->
    <link rel="icon" href="<%=request.getContextPath()%>/images/favicon1.png">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <%--  HEADER  --%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <img src="${pageContext.request.contextPath}/images/CupcakeBanner955x205.png" width="400px;"
                     class="img-fluid" alt="Banner foto for Olsker Cupcakes, no background with 4 cupcakes and titel"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <%--                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/">Page 1</a>--%>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/browse">Browse</a>
                    <c:if test="${sessionScope.user != null }">
                    <a class="nav-item nav-link " href="${pageContext.request.contextPath}/userpage">Userpage</a>
                        <!-- Link sends you to the logout servlet -->
                    </c:if>
                    <c:if test="${sessionScope.user == null }">
                        <!-- Link sends you to the login jsp side -->
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <!-- Link sends you to the logout servlet -->
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>
</header>

<!--  BODY   -->
<div id="body" class="container mt-4" style="min-height: 400px;">
    <div class="text-end">
        <c:if test="${sessionScope.user != null }">
            <!-- Link sends you to the logout servlet -->
            <p>${sessionScope.user.username}</p>
        </c:if>
    </div>
    <h1>
        <jsp:invoke fragment="header"/>
    </h1>
    <jsp:doBody/>
</div>

<!-- FOOTER -->
<div class="container mt-3">
    <hr/>
    <div class="row mt-4">
        <div class="col text-center">
            <a href="https://www.google.com/maps/place/Kureg%C3%A5rdsvej+7,+3782+Klemensker/@55.1789673,14.848106,17z/data=!3m1!4b1!4m6!3m5!1s0x46550f13f0fad93d:0x9d7f6d7ffdb98b8b!8m2!3d55.1789673!4d14.8502947!16s%2Fg%2F11c1v980qq"
               target="_blank" style="text-decoration: none;">
                Kuregårdsvej 7<br/>
                3782 Klemensker
            </a>
        </div>

        <div class="col text-center">
            <jsp:invoke fragment="footer"/>
            <br/>
            <p>&copy; 2022 - Olsker Cupcakes</p>
        </div>

        <div class="col text-center">
            Kontakt Information:<br/>
            olskercupcakes@gmail.com<br/>
        </div>
    </div>
</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>