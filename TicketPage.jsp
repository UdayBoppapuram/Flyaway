<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights Available</title>
<style>body{font-family: Tahoma, sans-serif;background:url("https://img.freepik.com/premium-vector/airplane-blue-sky-flight-plane-origami-style-aviation-tourism_176411-1540.jpg?w=2000");background-size:cover;}button{margin: auto;padding: 8px 20tpx;text-align: center;text-transform: uppercase;background-size: 200% auto;color: #fff;background-color:#ff0080;border:none;border-radius:10px;display: block;}table{  background-color: rgba(20, 121, 210, 0.406);color:white;width:100%;border:2px solid white;padding:10px;text-align:center;}h1{color:#2d54b1;}a{ text-decoration: none;}tr{color:white;border:2px solid white;padding:10px;}td{color:white;}</style>
</head>
<body>
	<h1>These are the Available Flights</h1>
	
	<table><tr><th>Flight id</th><th>Source</th><th>Destination</th><th>Airline Company</th><th>Price</th></tr>
	<tr>
	<%  session.setAttribute("source", request.getAttribute("source"));  %>
	<%  session.setAttribute("destination", request.getAttribute("destination"));
	session.setAttribute("persons", request.getAttribute("persons"));
	session.setAttribute("price", request.getAttribute("price"));
	session.setAttribute("date", request.getAttribute("date"));
	session.setAttribute("airline", request.getAttribute("airline"));%>
	<td><%=request.getAttribute("FlightId")%></td>
	<td><%=request.getAttribute("source")%></td>
	<td><%=request.getAttribute("destination")%></td>
	<td><%=request.getAttribute("airline")%></td>
	<td>Rs<%=request.getAttribute("price")%></td>
	<td><a href="Payment.jsp"><button>Proceed to Pay</a></button>
	</tr>
	</table>
	
	
</body>
</html>
