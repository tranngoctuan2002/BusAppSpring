<%-- 
    Document   : login
    Created on : Aug 5, 2023, 12:37:20 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ĐĂNG NHẬP</title>
        <style>
            body {
                background-image: url(https://res.cloudinary.com/de0pt2lzw/image/upload/v1691219192/oubus/system/login_bg_gcjz1k.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }

            #form-login {
                margin: 10% 35%;
                display: block;
                background: blue;
                width:30%;
                padding:10px;
                border: 1px solid white;
                box-shadow: 5px 5px black;
                background-image: url(https://res.cloudinary.com/de0pt2lzw/image/upload/v1691219192/oubus/system/login_bg_gcjz1k.jpg);
            }

            form > div {
                margin: 10px;
            }

          
        </style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </head>
    <body>
        <div id="form-login">
            <c:url value="/login" var="action" />
            <form  method="POST" action="${action}">
                <div class="form-floating">
                    <input type="text" class="form-control" id="username" placeholder="Username" name="username">           
                    <label for="username">Tên đăng nhập: </label>
                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="pwd" placeholder="Password" name="password">
                    <label for="password">Mật khẩu</label>
                </div>

                <div class="form-floating" style="align-items: center;">
                    <input style="display: block; margin : 0 auto;" type="submit" value="Đăng nhập" class="btn btn-danger text-center"  />
                </div>
            </form>
        </div>

    </body>
</html>
