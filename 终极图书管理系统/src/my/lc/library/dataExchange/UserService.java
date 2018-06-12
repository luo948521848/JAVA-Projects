package my.lc.library.dataExchange;

import my.lc.library.interfaces.Recordinterface;
import my.lc.library.interfaces.UserInterface;
import my.lc.library.interfaces.UserServiceInterface;
import my.lc.library.interfaces.bookInterface;
import my.lc.library.librarys.Record;
import my.lc.library.librarys.User;
import my.lc.library.librarys.book;

/*
*该类的功能以及特点描述：用于用户的服务层
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
public class UserService implements UserServiceInterface{
	
//通过Set的方法注入数据交互层
//这里只要注入接口就行
private UserInterface userinterface=null;
private bookInterface bookinterface=null;
private Recordinterface recordinterface=null;

//Set 会在Spring容器中被执行
public void setUserinterface(UserInterface userinterface) {
	this.userinterface = userinterface;
}
public void setBookinterface(bookInterface bookinterface) {
	this.bookinterface = bookinterface;
}
public void setRecordinterface(Recordinterface recordinterface) {
	this.recordinterface = recordinterface;
}


//重写继承服务接口的函数来调用Dao层的成员函数  
//用户行为
@Override
public User ImpLogin(String name, String password) {
	// TODO 自动生成的方法存根
	return userinterface.Login(name, password);
}
@Override
public void ImpAddUser(String name, String password,String usertype) {
	// TODO 自动生成的方法存根
	userinterface.AddUser(name, password,usertype);
}
@Override
public void ImpUpdateUser(String name, String newpassword) {
	// TODO 自动生成的方法存根
	userinterface.UpdateUser(name, newpassword);
}


//图书行为
@Override
public book ImpLookBook(String bookname) {
	// TODO 自动生成的方法存根
	
	
	return bookinterface.LookBook(bookname);
}
@Override
public void ImpAddBook(book b) {
	// TODO 自动生成的方法存根
	bookinterface.AddBook(b);
}
@Override
public void ImpRemoveBook(String bookname) {
	// TODO 自动生成的方法存根
	bookinterface.RemoveBook(bookname);
}
@Override
public void ImpLendBookNum(String bookname) {
	// TODO 自动生成的方法存根
	bookinterface.LendBookNum(bookname);
}
@Override
public void ImpSendBookNum(String bookname) {
	// TODO 自动生成的方法存根
	bookinterface.SendBookNum(bookname);
}

//借阅行为
@Override
public void ImpAddRecord(Record r) {
	// TODO 自动生成的方法存根
	recordinterface.AddRecord(r);
}
@Override
public void ImpUpdateRecord(String name, String bookname) {
	// TODO 自动生成的方法存根
	recordinterface.UpdateDate(name, bookname);
}












	
	
	

	
	
	
}
