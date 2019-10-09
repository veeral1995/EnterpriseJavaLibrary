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
  width: 80%;
  background: #f1f1f1;
}

/* Style the submit button */
form.example button {
  float: left;
  width: 20%;
  margin-left: 40%;
  margin-right: 40%;
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
    <div class="container">
       <sf:form action="getRentedStuff" method="GET" modelAttriute="command">
  			<button type="submit"><i>Click To Get Rented Items</i></button>
	   </sf:form>
    </div>  
    <div style="margin-top:7%; margin-left:35%; margin-right:35%;">
    <table>
    			<c:forEach items="${resData}" var="em">
        			<tr>
        				<td>${em.getType()}</td>
                        <td>${em.getTitle()}</td>
                        <td>${em.getAuthorArtist()}</td>                      
                        <td>${em.getCatalogNumber()}</td>
                        <td>${em.getReturnDate()}</td>
                    </tr>
				</c:forEach>
    </table>			
    </div>
    
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2019 Mounds View Public Library </div>        
    </div>
</body>
</html>