<%-- 
    Document   : customerDetails
    Created on : Aug 6, 2023, 10:07:52 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section>


    <c:url value="/buses/details" var="action" />
    <c:url value="/buses" var="back" />
    <div class="header d-flex align-items-center">
        <div>
            <a href="${back}" class="btn btn-primary"> < </a>
        </div>
        <div class="h1 ms-5">
            Quản lý xe
        </div>
    </div>

    <div class="container">
        <form:form modelAttribute="bus"  method="post" action="${action}" enctype="multipart/form-data">
            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="licensePlate" id="licensePlate" name="licensePlate"/>
                <label for="licensePlate">Biển số</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:input type="number" class="form-control" path="seat" id="seat" name="seat"/>
                <label for="seat">Số lượng ghế</label>
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