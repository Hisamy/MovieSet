<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="../css/alert.css"/>
        <title>Success</title>
    </head>
    <body>
        <div class="container">
            <h1><c:out value="${h1}" /></h1>
            <p><c:out value="${p}" /></p>
        </div>
    </body>
</html>
