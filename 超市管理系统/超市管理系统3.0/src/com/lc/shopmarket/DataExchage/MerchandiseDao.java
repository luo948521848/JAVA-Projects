package com.lc.shopmarket.DataExchage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lc.shopmarket.JavaBean.Merchandise;

/*
 *该类的功能以及特点描述：超市管理系统的商品上下架的Dao数据交互层


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
public class MerchandiseDao {

	private static Session session;

	private static MerchandiseDao merchandiseDao=null;
	public MerchandiseDao()
	{


	}


	public static MerchandiseDao getMerchandiseDao() {
		session=Getsession.getSession();
		merchandiseDao=new MerchandiseDao();
		return merchandiseDao;
	}





	//商品上架


	public void AddMerchandiseDao(List <Merchandise>list)
	{





		System.out.println("执行存储");
		try {
			session.beginTransaction();

			for(Merchandise m:list)
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

	//根据商品编码查询商品




	public Merchandise lookMerchandise(String MerdiseID)

	{

		Merchandise  m=null;

		String hql="from Merchandise  u where u.merchandiseNumber=:id ";

		Query query=session.createQuery(hql);
		query.setParameter("id",MerdiseID);
		session.beginTransaction();
		m=(Merchandise)query.uniqueResult();
		session.close();

		return m;

	}


	//商品下架
	//先查后删
	public void removeMerchandise(String MerdiseID)
	{


		try {
			session.beginTransaction();
			String hql="from Merchandise  u where u.merchandiseNumber=:id ";

			Query query=session.createQuery(hql);
			query.setParameter("id",MerdiseID);

			Merchandise  m=(Merchandise)query.uniqueResult();
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
	public void updateMerchandise(Merchandise m)
	{

		try {
			session.beginTransaction();

			Merchandise m1=(Merchandise) session.get(Merchandise.class,m.getSequenceNumber());

			m1.setRetailPrice(m.getRetailPrice());
			m1.setPurchasePrice(m.getPurchasePrice());
			m1.setRemark(m.getRemark());
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
