<%-- 
    Document   : navigation
    Created on : Aug 4, 2023, 10:14:16 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action" />
<section>
    <ul id="navi" class="nav flex-column nav-tab">
        <li class="nav-item">
            <a class="nav-link" href="${action}">Logo</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${action}">Trang chủ</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/customer" />">Khách hàng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/employee" />">Nhân viên</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/buses" />">Xe khách</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/station" />">Bến xe</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/route" />">Tuyến xe</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/trip" />">Chuyến xe</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/ticket" />">Vé xe</a>
        </li>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <div class="ms-3 text-danger">${pageContext.request.userPrincipal.name}</div>
                    <a class="nav-link text-danger" href="<c:url value="/logout" />">Đăng xuất</a>
                </li>

            </c:when>
            <c:otherwise>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                </li>
            </c:otherwise>
        </c:choose>




    </ul>
</section>