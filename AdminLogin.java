package flyaway;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import learnersacademy.LAClasses;
import learnersacademy.LAStudentClasses;
import learnersacademy.LAStudents;
import learnersacademy.LASubjects;
import learnersacademy.LATeachers;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = null;
		Configuration con = new Configuration().configure("/hibernate/hibernate.cfg.xml").addAnnotatedClass(PassengerDetails.class).addAnnotatedClass(Admin.class);
		
		SessionFactory sf = con.buildSessionFactory();
				
		Session session = sf.openSession();
		List<Admin> l = session.createQuery("from Admin").list();
		for(Admin a : l)
		{
			password=a.getPassword();
			
		}
		if((request.getParameter("username").equals("admin"))&&(request.getParameter("password").equals(password)))
		{
		
			
			List<PassengerDetails> list = session.createQuery("from PassengerDetails").list();
			for(PassengerDetails ll : list)
			{
				request.setAttribute("passengerName", ll.getPassengerName());
				request.setAttribute("emailId", ll.getEmailId());
				request.setAttribute("source",ll.getSource() );
				request.setAttribute("destination",ll.getDestination() );
				request.setAttribute("date",ll.getDate() );
				request.setAttribute("airline",ll.getAirline() );
				RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
				rd.forward(request, response);
			}
			
			Transaction tx = session.beginTransaction();
					
		
		

			tx.commit();

		}
	}

}
