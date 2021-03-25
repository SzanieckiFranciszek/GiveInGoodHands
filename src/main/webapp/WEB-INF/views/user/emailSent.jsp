<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Donation</title>
    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">
    <%@include file="../header.jsp" %>
    </nav>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <sec:authorize access="isAuthenticated()">
            <li><a href='<c:url value = "/donation/form"/>' class="btn btn--without-border ">Oddaj rzeczy</a></li>
        </sec:authorize>
        <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Twoje konto zostało utworzone!<br/>
                Na podany adres mailowy wysłany został link aktywacyjny
            </h1>
        </div>
    </div>
</header>

<%@include file="../footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="<c:url value="/resources/js/configurationForm.js"/>"></script>
</body>
</html>
