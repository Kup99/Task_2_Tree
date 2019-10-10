<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
${count}

<style>
    body { background: url(/resources/images/theme.jpg); }
</style>

        <table border="4">
            <th><font color="white">Name</font></th>
            <th><font color="white">Link</font></th>
            <th><font color="white">Update</font></th>



            <c:forEach items="${child}" var="child">
            <tr>
                <td><font color="white"> ${child.name}</font></td>
                <td>
                <form method="get" action="/getFolder/${child.id}">
                    <p><input type="submit" value=""
                              style="height: 64px; width:64px;background-image: url(/resources/images/folder-0.png);"/>
                    </p>
                </form>
                </td>
<td>
            <form method="get" action="/edit/${child.id}">
                <p><input type="submit" value=""
                          style="height: 32px; width:32px;background-image: url(/resources/images/edit.png);"/></p>
            </form>

            </c:forEach>
</td>


          <h1>
            <form method="get" action="/add/${id}">
                <p><input type="submit" value=""
                          style="height: 72px; width: 72px;background-image: url(/resources/images/add.png);"/></p>
            </form>
          </h1>
</body>
</html>



