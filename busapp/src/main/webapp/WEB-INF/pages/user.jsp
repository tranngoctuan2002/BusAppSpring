<%-- 
    Document   : user
    Created on : Aug 2, 2023, 11:03:42 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <div><a href="" class="btn btn-primary">Thêm User</a></div>
    <ul>
        <c:forEach items="${users}" var="u" >
            <li>${u.firstname} ${u.lastname}</li>
        </c:forEach>
    </ul>
</html>
