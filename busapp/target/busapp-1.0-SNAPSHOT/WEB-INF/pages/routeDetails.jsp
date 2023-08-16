<%-- 
    Document   : routeDetails
    Created on : Aug 10, 2023, 2:25:17 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section>
    <c:url value="/route/details" var="action" />
    <c:url value="/route" var="back" />
    <div class="header d-flex align-items-center">
        <div>
            <a href="${back}" class="btn btn-primary"> < </a>
        </div>
        <div class="h1 ms-5">
            THÔNG TIN TUYẾN XE
        </div>
    </div>

    <div class="container">
        <form:form modelAttribute="route"  method="post" action="${action}" enctype="multipart/form-data">
            <form:hidden path="id" />
            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="departure_p" name="provinceCode" path="">
                    <option value="">Chọn tỉnh</option>
                    <c:forEach items="${provinces}" var="p">
                        <c:choose>
                            <c:when test="${route.departure.provinceCode.code == p.code}">
                                <option value="${p.code}" selected>${p.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${p.code}">${p.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <label for="provinceCode" class="form-label">Tỉnh</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="departure_s" name="departure" path="departure.id">
                    <option value="">Chọn bến xe</option>
                    <c:forEach items="${departure_s}" var="ds">
                        <c:choose>
                            <c:when test="${ds.id == route.departure.id}">
                                <option value="${ds.id}" selected>${ds.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${ds.id}">${ds.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <label for="departure" class="form-label">Bến đi</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="destination_p" name="provinceCode" path="">
                    <option value="">Chọn tỉnh</option>
                    <c:forEach items="${provinces}" var="p">
                        <c:choose>
                            <c:when test="${route.destination.provinceCode.code == p.code}">
                                <option value="${p.code}" selected>${p.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${p.code}">${p.name}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </form:select>
                <label for="provinceCode" class="form-label">Tỉnh</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="destination_s" name="destiantion" path="destination.id">
                    <option value="">Chọn bến xe</option>
                    <c:forEach items="${destination_s}" var="ds">
                        <c:choose>
                            <c:when test="${ds.id == route.destination.id}">
                                <option value="${ds.id}" selected>${ds.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${ds.id}">${ds.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <label for="destiantion" class="form-label">Bến đến</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="price" id="price" name="price"/>
                <label for="name">Giá</label>
            </div>



            <div class="form-floating mb-3 mt-3" ">
                <form:button class="btn btn-primary mt-1" type="submit" style="display:block;margin:auto;" >
                    <c:choose>
                        <c:when test="${route.id != null}">
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

