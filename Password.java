package flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class Password
 */
@WebServlet("/Password")
public class Password extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		Configuration con = new Configuration().configure("/hibernate/hibernate.cfg.xml").addAnnotatedClass(PassengerDetails.class);
		
		SessionFactory sf = con.buildSessionFactory();
				
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery(
			    "update Admin set password = :docname" + " where username = :docId");
			query.setParameter("docname", request.getParameter("password"));
			query.setParameter("docId", "admin");
			int result = query.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("Password Changed successfully");
			response.sendRedirect("Login.html");
		
		

		tx.commit();
		
	}


}
