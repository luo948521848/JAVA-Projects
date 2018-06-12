package DataExchange;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import Interface.Getsession;
import JDialog.BookDialog;
import LIbrarys.book;

public class Look_book {

	private Session session=null;
	private String b_name=null;
	private book b=null;
	private String name=null;
	private List<String>list;
	
	public Look_book() {
		super();
	}

	public Look_book(String bn,String n) {
		super();
		this.b_name = bn;
		name=n;
		try {
			session=new Getsession().getSession();
			String hql="from book b where b.b_name=:name";
			
			Query query=session.createQuery(hql);

			query.setParameter("name",b_name);
			b=(book) query.uniqueResult();
			new BookDialog(b,name).setVisible(true);
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			
			session.close();
		}
		}
		
	public List<String> lookbooks()
	{
		session=new Getsession().getSession();
		String hql="from book b";
	
		Query query=session.createQuery(hql);
		List<book>list1=query.list();
		list=new ArrayList<String>();
		for(book bk:list1)
	
		{
		System.out.println(bk);
		list.add(bk.getB_name());
		}
		return list;
		
	}

		
	
	public book getB() {
		return b;
	}
	public void setB(book b) {
		this.b = b;
	}
	
	
	
	
}
