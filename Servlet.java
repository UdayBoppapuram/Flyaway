package flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String htmldate = request.getParameter("date");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		long l = 0;
		try {
			l = sdf.parse(htmldate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Date date = new Date(l);
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String persons = request.getParameter("persons");
		PrintWriter out = response.getWriter();
		FlightDao fd = new FlightDao();
		String flydate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		System.out.println("fly"+flydate);

			
		
		for(FlightDetails dl:fd.searchFlights(flydate, source, destination, persons))
		{
	
			
			if((dl.getD().equalsIgnoreCase(flydate))&&(dl.getSource().equals(source))&&(dl.getDestination().equals(destination)))
			{
				request.setAttribute("FlightId", dl.getFlightId());
				request.setAttribute("source", dl.getSource());
				request.setAttribute("destination", dl.getDestination());
				request.setAttribute("airline", dl.getAirline());
				request.setAttribute("price", dl.getPrice());
				request.setAttribute("persons", persons);
				request.setAttribute("date", flydate);
				RequestDispatcher rd = request.getRequestDispatcher("TicketPage.jsp");
				rd.forward(request, response);
		
			}
		}
		out.println("</table>");
		out.println("</body></html>");
	}



}
