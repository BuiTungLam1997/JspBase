<%@ page import="com.example.demo.Images" %>
<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 08/03/2023
  Time: 10:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Images name :<%= ((Images)request.getAttribute("imagesName")).getName()%>
<img alt="Ca sau khoa than vi moi truong" src="images/Crocodile.png">
</body>
</html>
