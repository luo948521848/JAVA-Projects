package my.lc.library.interfaces;

import java.awt.print.Book;

import my.lc.library.librarys.book;

/*
*该类的功能以及特点描述：这是图书操作的接口  函数都是静态抽象函数
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
public interface bookInterface {

	//图书查询
	public book LookBook(String name);

	//图书新建
	public void AddBook(book b);
	
	//图书下架
	public void RemoveBook(String name);
	
	//图书借阅时的数量变化
	public void LendBookNum(String name);
	
	//图书归还时的数量变化
	public void SendBookNum(String name);
	
}
