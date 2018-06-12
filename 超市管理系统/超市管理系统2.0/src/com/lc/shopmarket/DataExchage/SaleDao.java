package com.lc.shopmarket.DataExchage;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lc.shopmarket.JavaBean.Sale;
import com.lc.shopmarket.JavaBean.Staff;

public class SaleDao {
	private Session session;
	
	public SaleDao()
	{
		//获取session
		session=new Getsession().getSession();
		
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
