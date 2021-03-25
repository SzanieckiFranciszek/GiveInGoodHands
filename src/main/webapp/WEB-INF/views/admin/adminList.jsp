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
                Liczba administratorów:<br/>${numberOfAdmins}
            </h1>
        </div>
    </div>
</header>

<section class="help">
    <h2>Lista administratorów:</h2>

    <table class="custom-table">
        <thead>
        <tr class="custom-tr-dark">
            <th class="custom-th">Id:</th>
            <th class="custom-th">Imię i Nazwisko:</th>
            <th class="custom-th">Email:</th>
            <th class="custom-th">Stan weryfikacji:</th>
            <th class="custom-th">Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${admins}" var="admin">
            <tr class="custom-tr">
                <td class="custom-td">${admin.id}</td>
                <td class="custom-td">${admin.firstName} ${admin.lastName}</td>
                <td class="custom-td">${admin.email}</td>

                <td class="custom-td">${admin.enabled}</td>
                <td class="custom-td">
                    <a href="/admin/user/edit/${admin.id}" class="btn btn--without-border">Edytuj</a>
                    <c:if test="${user.enabled}">
                        <a href="/admin/enable/${admin.id}" class="btn btn--without-border">Zablokuj</a>
                    </c:if>
                    <c:if test="${!admin.enabled}">
                        <a href="/admin/enable/${admin.id}" class="btn btn--without-border">Odblokuj</a>
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


