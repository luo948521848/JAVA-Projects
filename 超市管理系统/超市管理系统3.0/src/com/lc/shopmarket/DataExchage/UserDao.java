package com.lc.shopmarket.DataExchage;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lc.shopmarket.JavaBean.User;

/*
*该类的功能以及特点描述：超市管理系统的用户注册查询的Dao数据交互层


*该类是否被编译测试：否
*@see(与之相关联的类)：   来源：
*                     中间：
*                     去处：
*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：1.0
*@数据库查询方式：mysql+Hibernate
*@date(开发日期)：2018/5/20
*改进：
*利用懒汉单例模式进行优化
*最后更改日期：
*/

public class UserDao {
	
	private static Session session;
	private static UserDao userDao=null;
	public UserDao()
	{

	}
	
	
	public static UserDao getUserDao() {
		userDao=new UserDao();
		session=Getsession.getSession();
		return userDao;
	}


	//查询VIP
	public User look(String CardID)
	
	{
		
		User u=null;
		
		String hql="from User u where u.cardId=:id ";
		
		Query query=session.createQuery(hql);
		query.setParameter("id",CardID);

		u=(User)query.uniqueResult();
		session.close();
 
		return u;
		
	}
	
	//添加VIP
	public void add(User u)
	{
		
		
		System.out.println("执行存储");
		try {
			session.beginTransaction();
			
			session.save(u);
			//提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	
		

		
	}
	
	//修改用户
	public void update(User u)
	{
		
		try {
			session.beginTransaction();
			User user=(User) session.get(User.class,u.getCardId());
			
			//只有3种属性可能会改变
			
			user.setUserName(u.getUserName());
			user.setIdcard(u.getIdcard());
			user.setPassword(u.getPassword());
			
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		finally
		{
			
			session.close();
		}
		
		
	}
	
	
	//注销VIP
	public void removeUser(String id)
	
	{
		
		
		
		try {
			session.beginTransaction();
			User user=(User) session.get(User.class,id);

			
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		finally
		{
			
			session.close();
		}
		
		
		
		
		
		
	}
	
	
	
	

}
