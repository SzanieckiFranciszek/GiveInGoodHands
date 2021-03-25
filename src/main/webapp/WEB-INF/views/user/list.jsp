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
                Zarejestrowanych użytkowników:<br/>${numberAllUsers}<br/>
                Potwierdzonych/Niepotwierdzonych użytkowników:<br/>${numberConfirmedUsers}/${numberNotConfirmedUsers}
            </h1>
        </div>
    </div>
</header>

<section class="help">
    <h2>Lista Użytkowników:</h2>

    <table class="custom-table">
        <thead>
        <tr class="custom-tr-dark">
            <th class="custom-th">Id:</th>
            <th class="custom-th">Imię i Nazwisko:</th>
            <th class="custom-th">Email:</th>
            <th class="custom-th">Admin/User</th>
            <th class="custom-th">Stan weryfikacji:</th>
            <th class="custom-th">Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr class="custom-tr">
                <td class="custom-td">${user.id}</td>
                <td class="custom-td">${user.firstName} ${user.lastName}</td>
                <td class="custom-td">${user.email}</td>
                <td class="custom-td">
                    <c:forEach items="${user.roles}" var="role">
                        <c:if test='${role.name.equals("ROLE_ADMIN")}'>
                            ADMIN
                        </c:if>
                        <c:if test='${role.name.equals("ROLE_USER")}'>
                            USER
                        </c:if>
                    </c:forEach>
                </td>
                <td class="custom-td">${user.enabled}</td>
                <td class="custom-td">
                    <a href="/admin/user/edit/${user.id}" class="btn btn--without-border">Edytuj</a>
            <c:forEach items="${user.roles}" var="role">
                    <c:if test='${!role.name.equals("ROLE_ADMIN")}'>
                        <a href="/admin/user/delete/${user.id}" class="btn btn--without-border">Usuń</a>
                    </c:if>
            </c:forEach>
                    <c:if test="${user.enabled}">
                        <a href="/admin/user/enable/${user.id}" class="btn btn--without-border">Zablokuj</a>
                    </c:if>
                    <c:if test="${!user.enabled}">
                        <a href="/admin/user/enable/${user.id}" class="btn btn--without-border">Odblokuj</a>
                    </c:if>
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


