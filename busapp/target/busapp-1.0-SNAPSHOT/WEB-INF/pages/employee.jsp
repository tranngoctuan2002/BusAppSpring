<%-- 
    Document   : employee
    Created on : Aug 7, 2023, 9:26:08 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <div class="header d-flex justify-content-between mb-5" style="background: #fff;">
        <h1 class="title-container">Khách hàng</h1>
        <div>
            <a href="<c:url value="/employee/details" />" class="btn btn-primary mt-1">THÊM</a>
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
                        <th style="width:5%;"></th>
                        <th>Họ và tên</th>
                        <th>Ngày sinh</th>
                        <th>Số điện thoại</th>
                        <th>Chức vụ</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${employees}" var="emp">
                        <tr>
                            <td wtyle="width:5%;">
                                <img src="${emp.avatar}" alt="${emp.name}" width="100%" />
                            </td>
                            <td>${ emp.name }</td>
                            <td>${ emp.birth }</td>
                            <td>${ emp.phone }</td>
                            <td>${ emp.userId.role }</td>

                            <td>
                                <c:url value="/employee/details/${emp.id}" var="api" />
                                <c:url value="/api/employee/${emp.id}" var="delete" />
                                <a href="${api}" class="btn btn-success">Cập nhật</a>
                                <button class="btn btn-danger" onclick="deleteEmployee('${delete}')">Xóa</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="<c:url value="/js/js.js" />"></script>
</section>
