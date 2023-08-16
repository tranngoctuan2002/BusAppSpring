<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section>
    <c:url value="/trip/details" var="action" />
    <c:url value="/trip" var="back" />
    <div class="header d-flex align-items-center">
        <div>
            <a href="${back}" class="btn btn-primary"> < </a>
        </div>
        <div class="h1 ms-5">
            THÔNG TIN CHUYẾN XE
        </div>
    </div>
    <div class="container">
        <form:form modelAttribute="trip"  method="post" action="${action}" enctype="multipart/form-data">
            <form:hidden path="id" />

            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="route_trip" name="route" path="route.id">
                    <option value="">Chọn tuyến xe</option>
                    <c:forEach items="${attr.routes}" var="r">
                        <c:choose>
                            <c:when test="${trip.route.id == r.id}">
                                <option value="${r.id}" selected>${r.departure.name} (${r.departure.provinceCode.name}) >>> ${r.destination.name} (${r.destination.provinceCode.name})</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${r.id}">${r.departure.name} (${r.departure.provinceCode.name}) >>> ${r.destination.name} (${r.destination.provinceCode.name})</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <label for="route" class="form-label">Tuyến xe</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="bus" name="bus" path="bus.id">
                    <option value="">Chọn xe</option>
                    <c:forEach items="${attr.buses}" var="b">
                        <c:choose>
                            <c:when test="${trip.bus.id == b.id}">
                                <option value="${b.id}" selected>${b.licensePlate}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${b.id}">${b.licensePlate}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <label for="bus" class="form-label">Xe</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="driver" name="driver" path="employee.id">
                    <option value="">Chọn tài xế</option>
                    <c:forEach items="${attr.driver}" var="d">
                        <c:choose>
                            <c:when test="${trip.employee.id == d.id}">
                                <option value="${d.id}" selected>${d.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${d.id}">${d.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            <label for="route" class="form-label">Tài xế</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="date" class="form-control" path="dayOfDeparture" id="dayOfDeparture" name="dayOfDeparture" />
            <label for="dayOfDeparture">Ngày khởi hành</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="time" class="form-control" path="timeOfDeparture" id="timeOfDeparture" name="timeOfDeparture" />
            <label for="timeOfDeparture">Giờ khởi hành</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" disabled="true" min="0.0" class="form-control" path="totalPrice" id="totalPrice" name="totalPrice" />
            <form:hidden path="totalPrice"/>
            <label for="totalPrice">Tổng tiền</label>
        </div>   
        <div class="form-floating mb-3 mt-3" ">
            <form:button class="btn btn-primary mt-1" type="submit" style="display:block;margin:auto;" >
                <c:choose>
                    <c:when test="${trip.id != null}">
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
</div>
<script src="<c:url value="/js/initilizaLocation.js" />"></script>

</section>

