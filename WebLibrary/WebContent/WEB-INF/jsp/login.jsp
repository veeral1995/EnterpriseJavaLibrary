<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Login Page</title>
<script language="javascript" type="text/javascript"></script>
    <style type="text/css">

        .style1
        {
            width: 0%;
            height: 183px;
        }
        .style2
        {
            width: 0px;
            text-align: right;
        }
        .style4
        {
            width: 0px;
            text-align: left;
            
        }
        .style3
        {
            width: 0px;
        }
        </style>
</head>
<body bgcolor="#eeeeee">
<h1>Login</h1>
<div style="border-bottom-style:solid"></div>
    <sf:form method="POST" action="loginCustomer" modelAttriute="command">
    		  <h2 style="padding: 6px; margin: 6px; font-weight: bold; color: #0000FF">Welcome to Mounds View Public Library!</h2>  
              <h2>Please Login:</h2>
          <div style="width: 500px;">
          	<div class="fields">
          		<sf:label path="username"> User: </sf:label>
          		<sf:input path="username" cssClass="input" />
          		<sf:errors path="username" cssClass="errors" />
          	</div>
          	<div class="fields">
          		<sf:label path="password"> Password: </sf:label>
          		<sf:input path="password" cssClass="input" />
          		<sf:errors path="password" cssClass="errors" />
          	</div>
          	<div class="fields">
          		<input type="submit" value="Submit" />
          	</div>
          </div>
     </sf:form>
     <a href="<%=request.getContextPath() %>/registerCustomer">Register Customer</a>
</body>
</html>