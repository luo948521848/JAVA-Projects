package my.lc.library.interfaces;

import my.lc.library.librarys.User;

/*
*该类的功能以及特点描述：这是关于用户的操作的接口  这是一些静态抽象函数
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
public interface UserInterface {

	//登录
	public User Login(String name,String password);
	//注册
	public void AddUser(String name,String password,String usertype);
	//用户修改
	public void UpdateUser(String name,String newpassword);
	
}
