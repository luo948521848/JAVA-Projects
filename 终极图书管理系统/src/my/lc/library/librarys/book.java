package my.lc.library.librarys;

import java.awt.Image;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
*该类的功能以及特点描述：这是书的实体类
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

public class book implements Serializable{

    //生成唯一的序列号
	private static final long serialVersionUID = 6277402594401652752L;
	//书名、作者、出版社、数量、二维码、书

	private String bookname=null;
	private String writer=null;
	private String publish=null;
	private String writedate=null;
	private int num;
	private Image codeimage=null;
	private Image bookimage=null;
	//默认构造函数
	public book()
	{
		
	}
	//Set、Get函数
	
	public String getBookname() {
		return bookname;
	}
	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Image getCodeimage() {
		return codeimage;
	}
	public void setCodeimage(Image codeimage) {
		this.codeimage = codeimage;
	}
	public Image getBookimage() {
		return bookimage;
	}
	public void setBookimage(Image bookimage) {
		this.bookimage = bookimage;
	}

	
	@Override
	public String toString() {
		return "book [bookname=" + bookname + ", writer=" + writer + ", publish=" + publish + ", writedate=" + writedate
				+ ", num=" + num + ", codeimage=" + codeimage + ", bookimage=" + bookimage + "]";
	}
	
	
	
	
	
	
	

}
