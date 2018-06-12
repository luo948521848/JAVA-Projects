package my.lc.library.interfaces;

import my.lc.library.librarys.Record;
import my.lc.library.librarys.User;
import my.lc.library.librarys.book;

/*
*该类的功能以及特点描述：用户服务的接口
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
public interface UserServiceInterface {

	//用户行为
	//登录
	public User ImpLogin(String name,String password);
	//用户注册
	public void ImpAddUser(String name,String password,String usertype);
	//用户修改
	public void ImpUpdateUser(String name,String newpassword);
	
	//图书行为
	//查询
	public book ImpLookBook(String bookname);
	//图书新建
	public void ImpAddBook(book b);
	//图书下架
	public void ImpRemoveBook(String bookname);
	//图书借阅时数量变化
	public void ImpLendBookNum(String bookname);
	//图书归还时的数量变化
	public void ImpSendBookNum(String bookname);
	
	
	//借阅行为
	//借阅
	public void ImpAddRecord(Record r);
	//归还
	public void ImpUpdateRecord(String name,String bookname);
	
	
	
	
}
