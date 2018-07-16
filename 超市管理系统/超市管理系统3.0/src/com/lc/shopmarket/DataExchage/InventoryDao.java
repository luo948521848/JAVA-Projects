package com.lc.shopmarket.DataExchage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lc.shopmarket.JavaBean.Merchandise;
import com.lc.shopmarket.JavaBean.Purchase;
/*
 *该类的功能以及特点描述：超市管理系统的商品进退货的Dao数据交互层


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
 *改进： 注意上架商品，一定是在库存中存在的
 *最后更改日期：
 *
 *利用单例模式对程序进行优化处理
 *
 *
 */
public class InventoryDao {
	private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd"; 
	private static Session session;

	private static InventoryDao inventoryDao=null;
	public InventoryDao()
	{
		

	}


	public static InventoryDao getInventoryDao() {
		session=Getsession.getSession();
		inventoryDao=new InventoryDao();
		return inventoryDao;
	}
	
	//进货


	public void PurchaseDao(List <Purchase>list)
	{



		System.out.println("执行进货");
		try {
			session.beginTransaction();

			for(Purchase m:list)
			{

				session.save(m);
			}
			//提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			//发生错误进行数据回滚
			session.getTransaction().rollback();
		}
		finally
		{
			session.close();
		}


	}

	public Purchase lookPurchase(String PurchaseID)

	{

		Purchase m=null;

		String hql="from Purchase  u where u.backSaleId=:id ";

		Query query=session.createQuery(hql);
		query.setParameter("id",PurchaseID);
		session.beginTransaction();
		m=(Purchase)query.uniqueResult();
		session.close();

		return m;

	}

	//商品下架
	//先查后删
	public void removePurchase(String PurchaseID)
	{


		try {
			session.beginTransaction();
			String hql="from Purchase  u where u.backSaleId=:id ";

			Query query=session.createQuery(hql);
			query.setParameter("id",PurchaseID);

			Purchase  m=(Purchase)query.uniqueResult();
			session.delete(m);
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


	//修改商品信息 
	//修改零售价、进货价
	public void updatePurchase(Purchase m)
	{

		try {
			session.beginTransaction();

			Purchase m1=(Purchase) session.get(Purchase.class,m.getBackSaleId());

			m1.setPrice(m.getPrice());
			m1.setSuperMarket(m.getSuperMarket());
			m1.setNumber(m.getNumber());
			Date date=new Date();
			SimpleDateFormat dateFormatter1 = new SimpleDateFormat(  
					DEFAULT_TIME_FORMAT); 
			String time=dateFormatter1.format(date);
			m1.setJtDate(time);
			session.update(m1);
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

}
