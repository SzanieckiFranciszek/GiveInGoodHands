<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Users</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <%@ include file="../header.jsp" %>

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
                Liczba przekazanych darowizn:<br/>${numberOfDonations}<br/>
            </h1>
        </div>
    </div>
</header>

<section class="help">
    <h2>Lista darowizn:</h2>

    <table class="custom-table">
        <thead>
        <tr class="custom-tr-dark">
            <th class="custom-th">Id:</th>
            <th class="custom-th">Imię i nazwisko oddającego :</th>
            <th class="custom-th">Dla jakiej fundacji:</th>
            <th class="custom-th">Liczba przekazanych worków:</th>
            <th class="custom-th">Adres odbioru:</th>
            <th class="custom-th">Stan odbioru:</th>
            <th class="custom-th">Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${donations}" var="donation">
            <tr class="custom-tr">
                <td class="custom-td">${donation.id}</td>
                <td class="custom-td"></td>
                <td class="custom-td">${donation.institution.name}</td>
                <td class="custom-td">${donation.quantity}</td>
                <td class="custom-td">${donation.street} ${donation.zipCode} ${donation.city}</td>
                <td class="custom-td">${donation.received}</td>
                <td class="custom-td">
                    <a href="/admin/donation/edit/${donation.id}" class="btn btn--without-border">Edytuj</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section>

<%@include file="../admin/adminFooter.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


