package DataExchange;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import Interface.Getsession;
import LIbrarys.book;

public class CreateBook {

	private Session session=null;
	private String b_name=null;
	private book b=null;
	
	public CreateBook(book n)
	
	{
		this.b=n;
		try {
			session=new Getsession().getSession();
			//开始上传事务
			session.beginTransaction();
			
			session.save(b);
			//提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			
			session.close();
			
		}
	
	}
}
