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
    <title>Home</title>

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
                Witaj administratorze:<br/>
                Oto przegląd danych dodanych od ostatniego logowania.
            </h1>
        </div>
    </div>
</header>
<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${allBags}</em>

            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${allTransferDonation}</em>
            <h3>Przekazanych darów</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section class="help" id="institutions">
    <h2>Lista fundacji:</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>
        <ul class="help--slides-items">
            <li>
                <c:forEach items="${institutions}" var="intitutions" varStatus="number">
                <div class="col">
                    <div class="title">${intitutions.name}</div>
                    <div class="subtitle">${intitutions.description}</div>
                </div>
                <c:if test="${number.index%2==1}">
            </li>
            <li>
                </c:if>
                </c:forEach>
            </li>
        </ul>
    </div>

    <section class="help" >
        <h2>Lista darów:</h2>

        <!-- SLIDE 1 -->
        <div class="help--slides active" data-id="1">
            <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
                Możesz sprawdzić czym się zajmują.</p>
            <ul class="help--slides-items">
                <li>
                    <c:forEach items="${institutions}" var="intitutions" varStatus="number">
                    <div class="col">
                        <div class="title">${intitutions.name}</div>
                        <div class="subtitle">${intitutions.description}</div>
                    </div>
                    <c:if test="${number.index%2==1}">
                </li>
                <li>
                    </c:if>
                    </c:forEach>
                </li>
            </ul>
        </div>

    </section>

</section>
<%@include file="../footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="<c:url value="/resources/js/configurationForm.js"/>"></script>
</body>
</html>


