package com.lc.shopmarket.DataExchage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 *该类的功能以及特点描述：超市管理系统的session获取


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
 *改进：利用单例模式对资源获取进行优化
 *最后更改日期：
 */
public class Getsession {

	//利用懒汉单例模式对session的调用进行优化
	private static Session session=null;
	private static SessionFactory sf=null;

	public Getsession() {


	}

	//修改的话要提交事务
	//懒汉模式 在调用setSession()对Session进行初始化，并且其他类就不需要再重复初始化了
	public static Session getSession() {
		sf =new Configuration().configure().buildSessionFactory();
		session = sf.openSession();
		return session;
	}



}
