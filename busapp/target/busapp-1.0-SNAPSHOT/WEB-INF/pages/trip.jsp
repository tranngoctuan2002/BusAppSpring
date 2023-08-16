<%-- 
    Document   : trip
    Created on : Aug 9, 2023, 9:28:00 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <div class="header d-flex justify-content-between mb-5" style="background: #fff;">
        <h1 class="title-container">Chuyến xe</h1>
        <div>
            <a href="<c:url value="/trip/details" />" class="btn btn-primary mt-1">THÊM</a>
        </div>
    </div>
    <div class="filter mb-1" style="margin-right: 0px;">
        <input type="text" placeholder="Tìm kiếm" name="id" class="form-floating" style="display:block; margin-left: auto;"/>
        <input type="text" placeholder="Tìm kiếm" name="departure" class="form-floating" style="display:block; margin-left: auto;"/>
        <input type="text" placeholder="Tìm kiếm" name="destination" class="form-floating" style="display:block; margin-left: auto;"/>
        <input type="text" placeholder="Tìm kiếm" name="fromPrice" class="form-floating" style="display:block; margin-left: auto;"/>
        <input type="text" placeholder="Tìm kiếm" name="toPrice" class="form-floating" style="display:block; margin-left: auto;"/>
    </div>
    <div class="content-container">
        <div>
            <table class="table table-hover text-center ">
                <thead>
                    <tr class="table-secondary">
                        <th>ID</th>
                        <th>Tuyến đi</th>
                        <th>Bus</th>
                        <th>Tài xé</th>
                        <th>Ngày đi</th>
                        <th>Giờ đi</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${trips}" var="tr">
                        <tr>
                            <td>${tr.id}</td>
                            <td>${tr.route.departure.name} -> ${tr.route.destination.name}</td>
                            <td>${tr.bus.licensePlate}</td>
                            <td>${tr.employee.name}</td>
                            <td>${tr.dayOfDeparture}</td>
                            <td>${tr.timeOfDeparture}</td>
                             <td>
                                <c:url value="/trip/details/${tr.id}" var="api" />
                                <c:url value="/api/trip/${tr.id}" var="delete" />
                                <a href="${api}" class="btn btn-success">Cập nhật</a>
                                <button class="btn btn-danger" onclick="deleteEmployee('${delete}')">Xóa</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>