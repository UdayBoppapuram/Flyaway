package flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sessions = request.getSession(); 
		
		String passengerName = request.getParameter("nameoncard");
		String emailId = request.getParameter("emailid");
		String source = (String) sessions.getAttribute("source");
		String destination = (String) sessions.getAttribute("destination");
		String date = (String) sessions.getAttribute("date");
		String airline = (String) sessions.getAttribute("airline");
		
		PassengerDetails pd = new PassengerDetails();
		pd.setPassengerName(passengerName);
		pd.setEmailId(emailId);
		pd.setSource(source);
		pd.setDestination(destination);
		pd.setDate(date);
		pd.setAirline(airline);
	
		

		Configuration con = new Configuration().configure("/hibernate/hibernate.cfg.xml").addAnnotatedClass(PassengerDetails.class);
		
		SessionFactory sf = con.buildSessionFactory();
				
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		session.save(pd);

		tx.commit();
				
	
		request.setAttribute("passengerName", passengerName);
		request.setAttribute("emailId", emailId);
		request.setAttribute("source",sessions.getAttribute("source") );
		request.setAttribute("destination",sessions.getAttribute("destination") );
		request.setAttribute("date",sessions.getAttribute("date") );
		request.setAttribute("airline",sessions.getAttribute("airline") );
		RequestDispatcher rd = request.getRequestDispatcher("FinalTicket.jsp");
		rd.forward(request, response);

		
	}



}
