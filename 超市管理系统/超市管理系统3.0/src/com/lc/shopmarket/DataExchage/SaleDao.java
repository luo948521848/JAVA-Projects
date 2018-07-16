package com.lc.shopmarket.DataExchage;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lc.shopmarket.JavaBean.Sale;
import com.lc.shopmarket.JavaBean.Staff;
/*
 *该类的功能以及特点描述：超市管理系统的销售订单的Dao数据交互层


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
 *对资源获取层采用单例模式进行优化
 *
 *最后更改日期：
 */
public class SaleDao {
	private static Session session;
	private static SaleDao saleDao=null;
	public SaleDao()
	{
		
		
	}
	
	public static SaleDao getSaleDao()
	{
		saleDao=new SaleDao();
		session=Getsession.getSession();
		return saleDao;
	}
	
	public List<Sale> looklast()
	{
		List <Sale>list=new ArrayList<Sale>();
		String hql="select count(*)from Sale";
		Query query=session.createQuery(hql);

		int size=new Integer(query.uniqueResult().toString());
		
		System.out.println("数据库有"+size);
		
		if(size>10)
		{
			
			
			String hql3="from Sale";
			Query query3=session.createQuery(hql3);
			
			query3.setFirstResult(size-9);
			query3.setMaxResults(size);
			list=(List<Sale>)query3.list();
			
			
		}
		else
		{
			
			String hql2="from Sale";
			Query query2=session.createQuery(hql2);
			
			list=(List<Sale>)query2.list();
			
		}
		
		
		return list;
	}
	

}
