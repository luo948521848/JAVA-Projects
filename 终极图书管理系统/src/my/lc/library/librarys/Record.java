package my.lc.library.librarys;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
*该类的功能以及特点描述：这是借阅的实体类
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

public class Record implements Serializable{

	private static final long serialVersionUID = 6232574194691968432L;
	//基本属性   使用联合主键
    private String name=null;
    private String bookname=null;
	private String LendDate=null;
	private String SendDate=null;
	
	//默认构造函数
	public Record()
	{
		
	}
	//Set、get函数



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	
	public String getLendDate() {
		return LendDate;
	}






	public void setLendDate(String lendDate) {
		LendDate = lendDate;
	}

	public String getSendDate() {
		return SendDate;
	}

	public void setSendDate(String sendDate) {
		SendDate = sendDate;
	}



	@Override
	public String toString() {
		return "Record [name=" + name + ", bookname=" + bookname + ", LendDate=" + LendDate + ", SendDate=" + SendDate
				+ "]";
	}
	

	
	
	
	
	
	
	
	
}
