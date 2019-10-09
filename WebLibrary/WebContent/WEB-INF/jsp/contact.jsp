<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  width: 80%;
  background: #f1f1f1;
}

/* Style the submit button */
form.example button {
  float: left;
  width: 20%;
  padding: 10px;
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
                <a href="<%=request.getContextPath() %>/">Logout</a>
            </nav>
        </div>
    </div>
    
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2019 Mounds View Public Library </div>        
    </div>
</body>
</html>