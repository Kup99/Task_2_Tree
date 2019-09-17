<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/cs-select.css" />
    <link rel="stylesheet" type="text/css" href="css/cs-skin-border.css" />
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
</head>
<body>

<style>
    body { background: url(/resources/images/editTheme.png); }
</style>
<form method="get" action="/delete/${id}">
    <style>
        .center {
            text-align: center;
        }
    </style>
    <div class = "center">
        <p>Delete Folder</p>
     <p><input type="submit" value=""
              style="height: 128px; width:128px;background-image: url(/resources/images/delete.png);"/></p></div>
</form>


<c:forEach items="${folderList}" var="folder">
<form method="get" action="/moveOn/${id}/${folder.id}">
    </c:forEach>
<p>Move folder on</p>
        <section>
            <label class="select-label">Choose new folder:</label>
        <select name="name" id="name">
            <c:forEach items="${folderList}" var="folder">
                <option value="${folder.name}">${folder.name}</option>
            </c:forEach>
    </select>
        </section>

    <p><input type="submit" value=""
              style="height: 128px; width:128px;background-image: url(/resources/images/move_on.png);"/></p></div>
</form>

    </div>
</div>

</body>
</html>