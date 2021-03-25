<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">
    <%@include file="../header.jsp" %>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Strona główna</a></li>
        <li><a href="<c:url value="/admin/user/list"/>" class="btn btn--without-border">Użytkownicy</a></li>
        <li><a href="<c:url value = "/admin/list"/>" class="btn btn--without-border ">Administratorzy</a></li>
        <li><a href="<c:url value="/admin/institutions/list"/> " class="btn btn--without-border">Fundacje</a></li>
        <li><a href="<c:url value="/admin/donation/list"/> " class="btn btn--without-border">Dary</a></li>
    </ul>
    </nav>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                <span class="uppercase">Użytkownik: "${user.firstName} ${user.lastName}"</span>
            </h1>
        </div>
    </div>
</header>
<section class="login-page">
    <h2>Edytuj dane użytkownika</h2>
    <form:form modelAttribute="user" action="/admin/user/edit/${user.id}" method="post">
        <div class="form-group">
            <h1>Imię:</h1>
            <form:input path="firstName" type="text" placeholder="Imię"/>
        </div>
        <div class="form-group">
            <h1>Nazwisko:</h1>
            <form:input path="lastName" type="text" placeholder="Nazwisko"/>
        </div>
        <div class="form-group">
            <h1>Adres email:</h1>
            <form:input path="email" type="email" placeholder="Email"/>
        </div>

        <div class="form-group">
                <%--                            <form:checkboxes path="roles" items="${roles}"/>--%>
            <c:forEach items="${roles}" var="role">
                <input id="roles${role.id}" type="checkbox" name="roles" value="${role.id}">
                <label for="roles${role.id}">${role.name}</label>
            </c:forEach>
        </div>

        <div class="form-group form-group--buttons">
            <button type="submit" class="btn">Zatwierdź</button>
            <a href="/admin/user/list" class="btn">Cofnij</a>
            <a href="/user/${user.id}/changePassword" class="btn">Zmień hasło</a>
        </div>
    </form:form>
</section>
<%@include file="../admin/adminFooter.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

