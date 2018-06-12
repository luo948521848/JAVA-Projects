package my.lc.library.dataExchange;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import my.lc.library.interfaces.UserInterface;
import my.lc.library.librarys.User;
/*
*该类的功能以及特点描述：用于用户的数据交互层
*该类是否被编译测试：
*@see(与之相关联的类)：   来源：
*                     中间：
*                     去处：
*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：

*@date(开发日期)：2018/1/25
*改进：
*最后更改日期：
*/
//这是数据交互的底层
public class UserDao extends HibernateDaoSupport implements UserInterface{

	//注入Session从而与数据库进行连接
	/*
	 * 可以获取session 
	 * 也可以直接执行查询语句 this.getHibernateTemplate().save(u);
    */	
	
	
	//用户登录
	@Override
	public User Login(String name, String password) {
		// TODO 自动生成的方法存根
		String hql= "from User u where u.name=? and u.password=?";
		User user=null;
		List<User>list=this.getHibernateTemplate().find(hql,new String[]{name,password});
		
		if(list!=null)
		{
			//登录成功
			for(User u:list)
			{
			user=u;
			}
		}
		
		
			//登录失败
	    return user;
	
	}
	//用户注册
	@Override
	public void AddUser(String name, String password ,String usertype) {
		// TODO 自动生成的方法存根
		User u=new User(name,password,usertype);
		this.getHibernateTemplate().save(u);
		//及时将内存释放
		u=null;
		
	}
    //修改密码
	@Override
	public void UpdateUser(String name, String newpassword) {
		// TODO 自动生成的方法存根
		//这里使用get函数而不是新建一个对象
		User u =this.getHibernateTemplate().get(User.class,name);  
		u.setPassword(newpassword);
		this.getHibernateTemplate().update(u);
		
	}

}
