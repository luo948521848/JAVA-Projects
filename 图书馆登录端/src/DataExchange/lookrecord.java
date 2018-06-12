package DataExchange;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import Interface.Getsession;
import LIbrarys.Record;
import LIbrarys.book;

public class lookrecord {

	private Session session;
	private Record r;
	
	public lookrecord()
	{
		session=new Getsession().getSession();
	
	}
	public void sendbook(String name,String bookname)
	{
		session.beginTransaction();
		try {
			String hql="from Record r where r.r_name=:name and r.rb_name=:bookname";
			Query query=session.createQuery(hql);
			query.setParameter("name",name);
			query.setParameter("bookname",bookname);
			r=(Record) query.uniqueResult();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请确定您借了此书", "提示", JOptionPane.ERROR_MESSAGE);
		}
		Date date=new Date();
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		String Senddate= format.format(date);
		r.setSendDate(Senddate);
		session.update(r);
		session.getTransaction().commit();
		session.close();
		JOptionPane.showMessageDialog(null, "图书已归还", "提示", JOptionPane.ERROR_MESSAGE);
	}
	
	public List<Record> findallRecord(String name)
	{
		List<Record>list=null;
		try {
			String hql="from Record r where r.r_name=:name";
			Query query=session.createQuery(hql);
			query.setParameter("name",name);
			list=query.list();
			
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		}
		finally{
			
			session.close();
		}
		
		return list;
		
	}
	
	
	
	
	
}
