<%-- 
    Document   : routeDetails
    Created on : Aug 10, 2023, 2:25:17 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section>
    <c:url value="/station/details" var="action" />
    <c:url value="/station" var="back" />
    <div class="header d-flex align-items-center">
        <div>
            <a href="${back}" class="btn btn-primary"> < </a>
        </div>
        <div class="h1 ms-5">
            THÔNG TIN Bến xe
        </div>
    </div>
    <div class="container">
        <form:form modelAttribute="station"  method="post" action="${action}" enctype="multipart/form-data">
            <div class="form-floating mb-3 mt-3">
                <form:hidden path="id" />
                <form:input type="text" class="form-control" path="name" id="name" name="name"/>
                <label for="name">Tên bến xe</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="street" id="street" name="street"/>
                <label for="name">Số nhà</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="provinceCode" name="provinceCode" path="provinceCode.code">
                    <option value="">Chọn tỉnh</option>
                    <c:forEach items="${provinces}" var="p">
                        <c:choose>
                            <c:when test="${station.provinceCode.code == p.code}">
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
                <form:select class="form-select" id="districtCode" name="districtCode" path="districtCode.code">
                    <option value="">Chọn thành phố</option>
                    <c:forEach items="${districts}" var="d">
                        <c:choose>
                            <c:when test="${station.districtCode.code == d.code}">
                                <option value="${d.code}" selected>${d.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${d.code}">${d.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <label for="districtCode" class="form-label">Thành phố</label>
            </div>

            <div class="form-floating mb-3 mt-3" ">
                <form:button class="btn btn-primary mt-1" type="submit" style="display:block;margin:auto;" >
                    <c:choose>
                        <c:when test="${station.id != null}">
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

