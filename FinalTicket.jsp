<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Done with FlyAway !!</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Booking done successfully..Happy Journey!!</h1>
	<div class="container1">
<form>
<div>

<h1 class="item" style="color:white;">Thank you <%=request.getAttribute("passengerName").toString()%> for booking with FlyAway !</h1>
<h1 class="item">Your AirTicket</h1>

</div>
	<div class="item" >Passengers's Name: <%=request.getAttribute("passengerName").toString()%></div>	
	<div class="item" >Source: <%=request.getAttribute("source").toString()%></div>	
	<div class="item" >Destination: <%=request.getAttribute("destination").toString()%></div>
	<div class="item" >Departure Date:  <%=request.getAttribute("date").toString()%></div>		
	<div class="item" >Airways:  <%=request.getAttribute("airline").toString()%></div>	
	<div ><input type="submit" onclick="window.print()" value="Print ticket" class="btn"  /></div>
</form>
</div>
</body>
</html>