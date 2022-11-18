<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment - Ticket Booking</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>One step away from flying away !!</h1>
	<div class="container1">
<form action="Servlet2" method="post">
<div>

	<%  session.setAttribute("source", session.getAttribute("source")); 
	session.setAttribute("destination", session.getAttribute("destination"));
	session.setAttribute("persons", session.getAttribute("persons"));
	session.setAttribute("date", session.getAttribute("date"));
	session.setAttribute("airline", session.getAttribute("airline"));%>

<h1 class="item">Make Payment for flight from <%=session.getAttribute("source")%> to <%=session.getAttribute("destination")%> on <%=session.getAttribute("date")%></h1>
<% int persons = Integer.parseInt(session.getAttribute("persons").toString());%>
<% int price = Integer.parseInt(session.getAttribute("price").toString());%>

<h5 style="text-align:center;"><%="Total ticket price Rs "+persons*price%> </h5>
</div>
	<div class="item" ><input type="text" placeholder="Email id" class="tb"  name="emailid" /></div>	
	<div class="item" ><input type="text" placeholder="Name on Card" class="tb"  name="nameoncard" /></div>
	<div class="item" ><input type="text" placeholder="Card Number" class="tb"  name="cardnumber" /></div>
	<div class="item" ><input type="text" placeholder="CVV" class="tb"  name="cvv" /></div>
	<div style="color:white; margin: 10px; text-align:center;">Card Expiry Date</div>
	<div class="item" ><input type="date" class="tb" name="date" /></div>
	<div ><input type="submit" value="Make Payment" class="btn"  /></div>
</form>
</div>
</body>
</html>