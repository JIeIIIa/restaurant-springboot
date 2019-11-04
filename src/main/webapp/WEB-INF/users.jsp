<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All users</title>
</head>
<body>
<h2>All users!</h2>
<c:forEach var = "user" items="${allUsers}">
User: <c:out value = "${user}"/><p>
    </c:forEach>
</body>
</html>