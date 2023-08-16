<%-- 
    Document   : customer
    Created on : Aug 6, 2023, 12:19:04 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <div class="header d-flex justify-content-between mb-5">
        <h1 class="title-container">Khách hàng</h1>
        <div>
            <a href="<c:url value="/customer/add" />" class="btn btn-primary mt-1">THÊM</a>
        </div>
    </div>
    <div class="filter mb-1" style="margin-right: 0px;">
        <input type="text" placeholder="Tìm kiếm" name="kw" class="form-floating" style="display:block; margin-left: auto;"/>
    </div>
    <div class="content-container">
        <div>
            <table class="table table-hover text-center ">
                <thead>
                    <tr class="table-secondary">
                        <th></th>
                        <th>Họ và tên</th>
                        <th>Giới tính</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customers}" var="c">
                        <tr>
                            <td>
                                Ava
                            </td>
                            <td>${ c.name }</td>
                            <td>${ c.gender }</td>
                            <td>${ c.address }</td>
                            <td>${ c.phone }</td>

                            <td>
                                <c:url value="/customer/add/${c.id}" var="api" />
                                <a href="${api}" class="btn btn-success">Cập nhật</a>
                                <button class="btn btn-danger" onclick="deleteProduct('${api}')">Xóa</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
