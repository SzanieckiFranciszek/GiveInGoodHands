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
        <li><a href='<c:url value="/user/register"/>' class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    <ul class="nav--actions">
        <li class="logged-user">
            <p>${currentUser.firstName} ${currentUser.lastName}</p>
            <ul class="dropdown">
                <li><a href="#" class="btn-link btn--without-border">Profil</a></li>
                <li><a href="#" class="btn-link btn--without-border">Moje zbiórki</a></li>
                <li>
                    <form action="<c:url value="/logout"/>" method="post">
                        <input type="submit" value="Wyloguj" class="btn-link btn--without-border"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </ul>
        </li>
    </ul>
    </sec:authorize>
