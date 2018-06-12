package Interface;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Getsession {

	private Session session=null;
	private SessionFactory sf=null;
	
	
	
	//修改的话要提交事务
	
	public Getsession() {
		super();
		
		 sf =new Configuration().configure().buildSessionFactory();
		 session = sf.openSession();
	    }
	    public Session getSession() {
		return session;
	   }
	public void setSession(Session session) {
		this.session = session;
	}

			
}
