<%-- 
    Document   : employeeDetails
    Created on : Aug 7, 2023, 11:08:57 PM
    Author     : PC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section>
    <c:url value="/employee/details" var="action" />
    <c:url value="/employee" var="back" />
    <div class="header d-flex align-items-center">
        <div>
            <a href="${back}" class="btn btn-primary"> < </a>
        </div>
        <div class="h1 ms-5">
            THÔNG TIN NHÂN VIÊN
        </div>
    </div>

    <div class="container">
        <form:form modelAttribute="employee"  method="post" action="${action}" enctype="multipart/form-data">

            <form:hidden path="id" />
            <form:hidden path="avatar" />
            <form:hidden path="userId.id"/>
            <form:hidden path="userId.password"/>
          
            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="name" id="name" name="name"/>
                <label for="name">Tên nhân viên</label>
            </div>
            <div class="form-floating">
                <form:select class="form-select" id="gender" name="gender" path="gender">
                    <c:choose>
                        <c:when test="${!employee.gender}">
                            <option value="0" selected>Nam</option>
                            <option value="1">Nữ</option>
                        </c:when>
                        <c:otherwise>
                            <option value="0">Nam</option>
                            <option value="1" selected>Nữ</option>
                        </c:otherwise>
                    </c:choose>
                </form:select>
                <label for="cate" class="form-label">Giới tính</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:input type="date" class="form-control" path="birth" id="birth" name="birth" />
                <label for="birth">Ngày sinh</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:input type="text" class="form-control" path="address" id="address" name="address"/>
                <label for="address">Địa chỉ</label>
            </div>

            <div class="form-floating mt-3 mb-3">
                <form:input type="number" class="form-control" path="phone" id="phone" name="phone" />
                <label for="phone">Số điện thoại</label>
            </div>

            <div class="form-floating mt-3 mb-3">
                <form:input type="email" class="form-control" path="email" id="email" name="email"/>
                <label for="address">Email</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:input type="file" class="form-control" path="file" id="file" 
                            placeholder="Ảnh sản phẩm"  />
                <label for="file">Avatar</label>
            </div>

            <div class="form-floating mb-3 mt-3">
                <form:select class="form-select" id="role" name="role" path="userId.role">
                    <c:forEach items="${role}" var="r">
                        <c:if test="${r != role[3]}" >
                            <c:choose>
                                <c:when test="${employee.userId.role == r}">
                                    <option value="${r}" selected>${r}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${r}">${r}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                </form:select>
                <label for="role" class="form-label">Vai trò</label>
            </div>

            <div class="form-floating mt-3 mb-3">
                <c:choose>
                    <c:when test="${employee.userId.id != null}">
                        <form:hidden path="userId.username"/>
                        <form:input disabled="true" type="text" class="form-control" path="userId.username" id="username" name="username" />
                    </c:when>
                    <c:otherwise>
                        <form:input type="text" class="form-control" path="userId.username" id="username" name="username" />
                    </c:otherwise>
                </c:choose>
                <label for="username">Username</label>
            </div>

            <div class="form-floating mb-3 mt-3" ">
                <form:button class="btn btn-primary mt-1" type="submit" style="display:block;margin:auto;" >
                    <c:choose>
                        <c:when test="${employee.id != null}">
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
