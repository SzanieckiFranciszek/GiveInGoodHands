<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.franciszekszaniecki.give_in_good_hands.service.UserService" %>
<%@ page import="com.franciszekszaniecki.give_in_good_hands.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="pl">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8"/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>--%>
<%--    <title>Document</title>--%>
<%--    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>--%>
<%--</head>--%>
<%--<header class="header--main-page">--%>
    <%
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
        UserService userService = context.getBean(UserService.class);
        User currentUser = userService.findByUserEmail(name);
        pageContext.setAttribute("currentUser", currentUser);
    %>
    <nav class="container container--70">
        <sec:authorize access="isAnonymous()">
        <ul class="nav--actions">
            <li><a href='<c:url value="/login"/>' class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href='<c:url value="/user/add"/>' class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <ul class="nav--actions">
            <li class="logged-user">
                <p>${currentUser.firstName} ${currentUser.lastName}</p>
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li>
                        <form action="<c:url value="/logout"/>" method="post">
                            <input type="submit" value="Wyloguj"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </li>
                </ul>
            </li>
        </ul>
        </sec:authorize>
<%--        <ul>--%>
<%--            <li><a href="/" class="btn btn--without-border active">Start</a></li>--%>
<%--            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--            <sec:authorize access="isAuthenticated()">--%>
<%--                <li><a href='<c:url value = "/donation/form"/>' class="btn btn--without-border ">Oddaj rzeczy</a></li>--%>
<%--            </sec:authorize>--%>
<%--            <li><a href="#" class="btn btn--without-border">O nas</a></li>--%>
<%--            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>--%>
<%--            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>--%>
<%--        </ul>--%>
<%--    </nav>--%>

<%--    <div class="slogan container container--90">--%>
<%--        <div class="slogan--item">--%>
<%--            <h1>--%>
<%--                Zacznij pomagać!<br/>--%>
<%--                Oddaj niechciane rzeczy w zaufane ręce--%>
<%--            </h1>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</header>--%>