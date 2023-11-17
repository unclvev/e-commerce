<%-- 
    Document   : Menu
    Created on : Jun 23, 2023, 10:48:18 PM
    Author     : viet2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Start Header Area -->
<header class="header_area sticky-header">
    <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light main_box">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href="home"><img src="img/logo.png" alt=""></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <!-- Collect the nav links, forms, and other content for toggling -->

                <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                    <ul class="nav navbar-nav menu_nav ml-auto">
                        <li class="nav-item active"><a class="nav-link" href="home">Home</a></li>
                        <li class="nav-item "><a class="nav-link" href="category">Shop</a></li>

                        <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.acc != null && sessionScope.acc.isSell == 1 && sessionScope.acc.isAdmin == 0}">
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Hello ${sessionScope.acc.user}s</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item "><a class="nav-link" href="manager">Manager Products</a></li>
                                        <li class="nav-item "><a class="nav-link" href="changePass.jsp">Change password</a></li>
                                        <li class="nav-item "><a class="nav-link" href="logout">Logout</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:when test="${sessionScope.acc != null && sessionScope.acc.isSell == 1 && sessionScope.acc.isAdmin == 1}">
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Owner</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item "><a class="nav-link" href="dashboard">Admin</a></li>
                                        <li class="nav-item "><a class="nav-link" href="#">Seller</a></li>
                                        <li class="nav-item "><a class="nav-link" href="changePass.jsp">Change password</a></li>
                                        <li class="nav-item "><a class="nav-link" href="logout">Logout</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${sessionScope.acc != null}">
                                    <li class="nav-item submenu dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                           aria-expanded="false">Hello ${sessionScope.acc.user}</a>
                                        <ul class="dropdown-menu">
                                            <li class="nav-item "><a class="nav-link" href="changePass.jsp">Change password</a></li>
                                            <li class="nav-item "><a class="nav-link" href="logout">Logout</a></li>
                                        </ul>
                                    </li>
                                </c:if>
                                <c:if test="${sessionScope.acc == null}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="login.jsp">Login</a>
                                    </li>
                                </c:if>
                            </c:otherwise>
                        </c:choose>



                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item"><a href="show" class="cart">(${requestScope.size}) <span class="ti-bag"></span></a></li>
                        <li class="nav-item">
                            <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="search_input" id="search_input_box">
        <div class="container">
            <form action="search" method="get" action="search" method="post" class="d-flex justify-content-between">
                <input name="txt" type="text" class="form-control" id="search_input" placeholder="Search Here">
                <button type="submit" class="btn"></button>
                <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
            </form>
        </div>
    </div>
</header>
<!-- End Header Area -->

