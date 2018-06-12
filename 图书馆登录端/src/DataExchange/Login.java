package DataExchange;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import Frame.UserFrame;
import Interface.Getsession;
import LIbrarys.user;
public class Login {


    private List<user>list=null;
	private org.hibernate.Session session=null;
	public Login() {
		super();

		
	}
	

	public void test(String name,String password)
	{
		
		try {
			session=new Getsession().getSession();
			
			String hql="from user u";
			Query query=session.createQuery(hql);
			list=query.list();
			System.out.println("ss");
			for(user m:list)
			{
				System.out.println(m);
				System.out.println("mmm");
				String n=m.getName();
				String p=m.getPassword();
				if(n.equals(name))
				{
					if(p.equals(password))	
					{
						//用户存在且密码正确
						
						
						new UserFrame(m.getUserType(),m.getName()).setVisible(true);
						
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "密码输入错误", "警告", JOptionPane.ERROR_MESSAGE);
						
					}

				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "用户不存在", "警告", JOptionPane.ERROR_MESSAGE);

				}
					
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
