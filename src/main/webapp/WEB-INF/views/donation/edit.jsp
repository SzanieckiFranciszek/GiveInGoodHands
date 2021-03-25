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
                <span class="uppercase">Nr edytowanej darowizny: "${donation.id}"</span>
            </h1>
        </div>
    </div>
</header>
<section class="login-page">
    <h2>Edytuj dane użytkownika</h2>
    <form:form modelAttribute="donation" action="/admin/donation/edit/${donation.id}" method="post">
        <div class="form-section form-section--columns">

            <div class="form-section--column">
                <h4>Dane fundacji</h4>
                <div class="form-group form-group--inline">
                    <label> Liczba przekazanych worków <form:input path="quantity"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label> Nazwa fundacji dla której zostaną przekazane dary:
                        <form:input path="institution"/> </label>
                </div>
            </div>


            <div class="form-section--column">
                <h4>Adres odbioru</h4>
                <div class="form-group form-group--inline">
                    <label> Ulica <form:input path="street"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label> Miasto
                        <form:input path="city"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label>
                        Kod pocztowy <form:input path="zipCode"/>
                    </label>
                </div>

                <div class="form-group form-group--inline">
                    <label>
                        Numer telefonu <form:input type="phone" path="phoneNumber"/>
                    </label>
                </div>
            </div>

            <div class="form-section--column">
                <h4>Termin odbioru</h4>
                <div class="form-group form-group--inline">
                    <label> Data <form:input type="date" path="pickUpDate"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label> Godzina <form:input type="time" path="pickUpTime"/> </label>
                </div>

                <div class="form-group form-group--inline">
                    <label> Komentarz <textarea name="pickUpComment" rows="5"></textarea>
                    </label>
                </div>
            </div>
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

