<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Mounds View Library</title>
<style type="text/css">

    * {
  		box-sizing: border-box;
	  }

    body{        
        padding-top: 60px;
        padding-bottom: 40px;
    }
    .fixed-header, .fixed-footer{
        width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    nav a{
        color: #fff;
        text-decoration: none;
        padding: 7px 25px;
        display: inline-block;
    }
form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 60%;
  background: #f1f1f1;
}

/* Style the submit button */
form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  margin-left: 2%;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none; /* Prevent double borders */
  cursor: pointer;
}

form.example select {
  float: left;
  width: 8%;
  padding: 10px;
  margin-right: 2%;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none; /* Prevent double borders */
  cursor: pointer;

}


form.example button:hover {
  background: #0b7dda;
}

/* Clear floats */
form.example::after {
  content: "";
  clear: both;
  display: table;
}
</style>
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <a href="<%=request.getContextPath() %>/search">Search</a>
                <a href="<%=request.getContextPath() %>/rent">Rent</a>
                <a href="<%=request.getContextPath() %>/contact">Contact Us</a>
                <a href="<%=request.getContextPath() %>/useritemsrented">My Rented Items</a>
                <a href="<%=request.getContextPath() %>/login">Logout</a>
            </nav>
        </div>
    </div>
    <div class="container">
    	<sf:form method="GET" action="rentItem" modelAttriute="command">
			<sf:select path="mediaType" >
				<sf:option value="sys.book">Book</sf:option>
				<sf:option value="sys.cd">CD</sf:option>
				<sf:option value="sys.movie">Movie</sf:option>
			</sf:select>      
  			<sf:input path="catalogNumber" />
  			<button type="submit"><i>Submit</i></button>
	   	</sf:form>
    </div>    
    <div style="margin-top:7%; margin-left:35%; margin-right:35%;">
    	<c:if test="${!rentOutput}">
			<p>Rental Item Is Unsuccessful, Please Try Again :(</p>
		</c:if>
		<c:if test="${rentOutput == true}">
			<p>Rental Item Is Successful :)</p>
		</c:if>
    </div>
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2019 Mounds View Public Library </div>        
    </div>
</body>
</html>