package DataExchange;

import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import Interface.Getsession;
import LIbrarys.book;

public class RemoveBook {
	private Session session=null;
	private String b_name=null;
	private book b=null;
	
	public RemoveBook(String n)
	{
		b_name=n;
		try {
			session=new Getsession().getSession();

			String hql="from book b where b.b_name=:name";
			
			Query query=session.createQuery(hql);

			query.setParameter("name",b_name);
			
			b=(book) query.uniqueResult();
			
			if(b==null)
			{
				JOptionPane.showMessageDialog(null, "该书不存在", "提示", JOptionPane.ERROR_MESSAGE);
   			}
			else
			{
				session.delete(b);
				
				File f=new File("C://Users/Administrator/Desktop/mylibrary/book/"+b.getB_name()+".jpg");
				if(f.isFile() && f.exists())
				{
					f.delete();
					System.out.println("图片已删除");
				}
				File f1=new File("C://Users/Administrator/Desktop/mylibrary/Code/"+b.getB_name()+".png");
				if(f1.isFile() && f1.exists())
				{
					f1.delete();
					System.out.println("二维码已删除");
				}
				JOptionPane.showMessageDialog(null, "下架成功", "提示", JOptionPane.ERROR_MESSAGE);
			}
		} catch (HeadlessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			
			session.close();
		}
		
	}
	
	

}
