package my.lc.library.dataExchange;
/*
*该类的功能以及特点描述：用于图书操作的数据交互层

*该类是否被编译测试：否
*@see(与之相关联的类)：   来源：
*                     中间：
*                     去处：
*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：

*@date(开发日期)：2018/3/8
*改进：
*最后更改日期：
*/

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import my.lc.library.interfaces.bookInterface;
import my.lc.library.librarys.book;

public class BookDao extends HibernateDaoSupport implements bookInterface{

	//查询图书
	/*
	  不考虑图书重复的情况，在数据库就避免数据重复
	  
	 */
	private Session session;
	@Override
	public book LookBook(String name) {
		// TODO 自动生成的方法存根
		
		session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="from book b where b.bookname=:name";
		
		Query query=session.createQuery(hql);

		query.setParameter("name",name);
		return (book) query.uniqueResult();
		
		
		//return this.getHibernateTemplate().get(book.class,name);
	}
    //新建图书
	@Override
	public void AddBook(book b) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(b);
	}
    //删除图书
	@Override
	public void RemoveBook(String name) {
		// TODO 自动生成的方法存根
		
		//先获取
		book b=this.getHibernateTemplate().get(book.class,name);
		this.getHibernateTemplate().delete(b);
		
		
	}
    //借阅图书产生的数量变化
	@Override
	public void LendBookNum(String name) {
		// TODO 自动生成的方法存根
		//这里是一个修改的思想
		book b=this.getHibernateTemplate().get(book.class,name);
		b.setNum(b.getNum()-1);
		this.getHibernateTemplate().update(b);
	}
    //归还图书产生的图书数量的变化
	@Override
	public void SendBookNum(String name) {
		// TODO 自动生成的方法存根
		book b=this.getHibernateTemplate().get(book.class,name);
		b.setNum(b.getNum()+1);
		this.getHibernateTemplate().update(b);
	}

}
