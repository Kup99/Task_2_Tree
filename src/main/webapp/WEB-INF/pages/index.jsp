<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Folder</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">

            <form class="login100-form validate-form">

                <table border="4">
                    <th>Name</th>
                    <th>Link</th>
                    <th>Update</th>


                    ${no_direct}

                    <c:forEach items="${parent}" var="parent">
                    <tr>
                        <td>${parent.name}</td>
                        <td>
                            <form method="get" action="/getFolder/${parent.id}">
                                <p><input type="submit" value=""
                                          style="height: 64px; width:64px;background-image: url(/resources/images/folder-${parent.parent_id}.png);"/>
                                </p>
                            </form>
                        </td>
                        <td>

                            <form method="get" action="/edit/${parent.id}">
                                <p><input type="submit" value=""
                                          style="height: 32px; width:32px;background-image: url(/resources/images/edit.png);"/>
                                </p>
                            </form>

                            </c:forEach>
                    </table>
            </form>
        </div>
    </div>
</div>

<p>
<form method="get" action="/add/${parent_id}">
    <div class="container-login100-form-btn">
        <p><input class="login100-form-btn" type="submit" value="Add New Folder"/></p>
    </div>
</form>
</p>
<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/tilt/tilt.jquery.min.js"></script>
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>