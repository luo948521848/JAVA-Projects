package my.lc.library.librarys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
*该类的功能以及特点描述：这是用户的实体类
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
*改进点：
*最后更改日期：
*/

public class User implements Serializable{
	//生成唯一的识别码便于数据交互
	private static final long serialVersionUID = 4730366564607709566L;
	//用户名

	private String name=null;
	//密码
	private String password=null;
	//用户类型
	private String usertype=null;
   
	//默认构造函数
	public User()
	{
		
	}
	//构造函数

	public User(String name, String password, String usertype) {
		super();
		this.name = name;
		this.password = password;
		this.usertype = usertype;
	}
	
	//生成Set、get函数
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", usertype=" + usertype + "]";
	}

	
	
	
}
