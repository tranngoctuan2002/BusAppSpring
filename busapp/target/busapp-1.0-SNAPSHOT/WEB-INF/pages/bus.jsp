<%-- 
    Document   : bus
    Created on : Aug 11, 2023, 11:50:05 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section>
    <div class="header d-flex justify-content-between mb-5" style="background: #fff;">
        <h1 class="title-container">Xe khách</h1>
        <div>
            <a href="<c:url value="/buses/details" />" class="btn btn-primary mt-1">THÊM</a>
        </div>
    </div>
    <div class="filter mb-1" style="margin-right: 0px;">
        <input type="text" placeholder="Tìm kiếm" name="id" class="form-floating" style="display:block; margin-left: auto;"/>
        <input type="text" placeholder="Tìm kiếm" name="departure" class="form-floating" style="display:block; margin-left: auto;"/>
        <input type="text" placeholder="Tìm kiếm" name="destination" class="form-floating" style="display:block; margin-left: auto;"/>
    </div>
    <div class="content-container">
        <div>
            <table class="table table-hover text-center ">
                <thead>
                    <tr class="table-secondary">
                        <th>ID</th>
                        <th>Biển số</th>
                        <th>Loại xe</th>
                        <th>Chỗ ngồi</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach items="${buses}" var="b">
                            <td>${b.id}</td>
                            <td>${b.licensePlate}</td>
                            <td>x</td>
                            <td>${b.seat}</td>
                            <td>
                                <c:url value="/buses/details/${b.id}" var="api" />
                                <c:url value="/api/buses/${b.id}" var="delete" />
                                <a href="${api}" class="btn btn-success">Cập nhật</a>
                                <button class="btn btn-danger" onclick="deleteBus('${delete}')">Xóa</button>
                            </td>
                        </c:forEach>
                    </tr>                 
                </tbody>
            </table>
        </div>
    </div>
    <script src="<c:url value="/js/js.js" />"></script>
</section>
