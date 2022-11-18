package flyaway;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class FlightDao {

	List<FlightDetails> searchFlights(String d,String source,String destination,String persons)
	{
		Configuration con = new Configuration().configure("/hibernate/hibernate.cfg.xml").addAnnotatedClass(FlightDetails.class);
		
		SessionFactory sf = con.buildSessionFactory();
				
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		tx.commit();
		
		List<FlightDetails> list = session.createQuery("from FlightDetails").list();
		return list;
	
	}
	
}
