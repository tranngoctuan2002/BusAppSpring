<%-- 
    Document   : customerDetails
    Created on : Aug 6, 2023, 10:07:52 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section>


    <c:url value="/customer/add" var="action" />
    <c:url value="/customer" var="back" />
    <div class="header d-flex align-items-center">
        <div>
            <a href="${back}" class="btn btn-primary"> < </a>
        </div>
        <div class="h1 ms-5">
            Quản lý khách hàng
        </div>
    </div>

    <div class="container">
        <form:form modelAttribute="customer"  method="post" action="${action}" enctype="multipart/form-data">

            <form:hidden path="id" />
            <form:hidden path="avatar" />
            <form:hidden path="userId.id"/>
            <form:hidden path="userId.password"/>
            <form:hidden path="userId.role"/>
            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="name" id="name" placeholder="Nhập tên khách hàng..." name="name"/>
                <label for="name">Tên khách hàng</label>
            </div>
            <div class="form-floating mt-3 mb-3">
                <form:input type="email" class="form-control" path="email" id="email" placeholder="Nhập email..." name="email"/>
                <label for="address">Email</label>
            </div>

            <div class="form-floating mt-3 mb-3">
                <form:input type="number" class="form-control" path="phone" id="phone" placeholder="Nhập email..." name="phone" />
                <label for="phone">Số điện thoại</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:input type="file" class="form-control" path="file" id="file" 
                            placeholder="Ảnh sản phẩm"  />
                <label for="file">Avatar</label>
            </div>


            <div class="form-floating mt-3 mb-3">
                <c:choose>
                    <c:when test="${customer.userId.id != null}">
                        <form:input disabled="true" type="text" class="form-control" path="userId.username" id="username" placeholder="Nhập email..." name="username" />
                    </c:when>
                    <c:otherwise>
                        <form:input type="text" class="form-control" path="userId.username" id="username" placeholder="Nhập email..." name="username" />
                    </c:otherwise>
                </c:choose>
                <label for="username">Username</label>
            </div>

            <div class="form-floating mb-3 mt-3" ">
                <form:button class="btn btn-primary mt-1" type="submit" style="display:block;margin:auto;" >
                    <c:choose>
                        <c:when test="${customer.id != null}">
                            Cập nhật
                        </c:when>
                        <c:otherwise>
                            Thêm
                        </c:otherwise>
                    </c:choose>
                </form:button>
            </div>

        </form:form>
    </div>

</section>