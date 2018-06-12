package com.lc.shopmarket.DataExchage;

import org.hibernate.Query;

import org.hibernate.Session;

import com.lc.shopmarket.JavaBean.Staff;


/*
*该类的功能以及特点描述：超市管理系统的员工注册查询的Dao数据交互层


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
*最后更改日期：
*/
public class StaffDao {

	private Session session;
	
	public StaffDao()
	{
		//获取session
		session=new Getsession().getSession();
		
	}
	public Staff Login (String name,String password,String usertype)
	
	{
		
	     Staff s=null;
		
		String hql="from Staff u where u.userName=:name and u.userPassword=:password and u.userGrade=:usertype";
		
		Query query=session.createQuery(hql);
		query.setParameter("name",name);
		query.setParameter("password",password);
		query.setParameter("usertype",usertype);
		s=(Staff)query.uniqueResult();
		session.close();
 
		return s;
		
	}
	
	
	
	
	
	
	
}
