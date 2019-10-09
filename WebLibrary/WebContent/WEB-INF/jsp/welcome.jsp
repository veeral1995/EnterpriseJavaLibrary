<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Mounds View Library</title>
<style type="text/css">
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
</style>
</head>
<body>
 <form id="welcomeForm">
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
    <div class="container">
        <p title="LibraryHomePage"> <b>Welcome to Mounds View Public Library, You Are Successfully Logged In!</b> </p>
    </div>    
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2019 Mounds View Public Library </div>        
    </div>
  </form>
</body>
</html>