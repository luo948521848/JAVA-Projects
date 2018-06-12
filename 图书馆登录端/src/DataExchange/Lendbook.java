package DataExchange;

import java.text.Format;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Interface.Getsession;
import LIbrarys.Record;

public class Lendbook {

	private org.hibernate.Session session;
	private Record record;

	//构造函数
	public Lendbook()
	{
		System.out.println("借书构造成功");
	}
	public void Lend(String name,String bookname)
	{		
		try {
			record=new Record();
			System.out.println(name +bookname);
			Date date=new Date();
			Format format = new SimpleDateFormat("yyyy-MM-dd");
			String Lenddate= format.format(date);
			record.setR_name(name);
			record.setRb_name(bookname);
			record.setLendDate(Lenddate);
			System.out.println(record);
			session=new Getsession().getSession();
			session.beginTransaction();
			session.save(record);
			//提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
		
			JOptionPane.showMessageDialog(null, "您无法借此书，您可能已借阅了", "提示", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
