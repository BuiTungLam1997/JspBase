<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 08/03/2023
  Time: 11:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
The images name is :<%=request.getAttribute("imagesName")%>
<img alt="this is a show" src="images/funny.png">
</body>
</html>
