<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/style.css" />
</head>
<body>
<div class="login">
  <h1>Login Credentials</h1>
  <form method="post" action="login" th:action="@{/login}" th:object="${user}">
    <p><input type="text" name="userid" value="" placeholder="UserId"></p>
    <p><input type="password" name="password" value="" placeholder="Password"></p>
    <p class="submit"><input type="submit" name="commit" value="Login"></p>
   <!--   <button type="submit" class="submit"> Login</button>-->
  </form>
</div>
</body>
</html>