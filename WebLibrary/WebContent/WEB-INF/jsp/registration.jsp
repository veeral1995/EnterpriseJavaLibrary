<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<sf:form method="post" modelAttriute="register">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="password" required>
    <hr>

   <button type="submit"><i>Register</i></button>
  </div>
  <div class="container signin">
    <p>Already have an account? <a href="<%=request.getContextPath() %>/">Sign in</a>.</p>
  </div>
</sf:form>
</body>
</html>