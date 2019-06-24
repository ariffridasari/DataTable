<%-- 
    Document   : navbar
    Created on : Jun 24, 2019, 9:48:37 AM
    Author     : Arif Fridasari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar fixed-top navbar-dark bg-primary navbar-expand-lg">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    MII
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item active" href="region.jsp">Region</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="employee.jsp">Employee</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="region.jsp">Region</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="employee.jsp">Employee</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
