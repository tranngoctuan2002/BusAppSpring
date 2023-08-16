<%-- 
    Document   : route
    Created on : Aug 9, 2023, 12:15:31 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section>
    <div class="header d-flex justify-content-between mb-5" style="background: #fff;">
        <h1 class="title-container">Tuyến xe</h1>
        <div>
            <a href="<c:url value="/route/details" />" class="btn btn-primary mt-1">THÊM</a>
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
                        <th>Điểm đi</th>
                        <th>Điển đến</th>
                        <th>Giá tiền</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${routes}" var="r">
                        <tr>
                            <td>${r.id}</td>
                            <td>${r.departure.name} </br> (${r.departure.provinceCode.name})</td>
                            <td>${r.destination.name} </br> (${r.destination.provinceCode.name})</td>
                            <td>${r.price}</td>
                            <td>
                                <c:url value="/route/details/${r.id}" var="api" />
                                <c:url value="/api/route/${r.id}" var="delete" />
                                <a href="${api}" class="btn btn-success">Cập nhật</a>
                                <button class="btn btn-danger" onclick="deleteRoute('${delete}')">Xóa</button>
                            </td>
                        </tr> 
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</section>