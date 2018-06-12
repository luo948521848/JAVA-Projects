package my.lc.library.librarys;

import java.io.Serializable;

import javax.persistence.Embeddable;


/*
*该类的功能以及特点描述：这是用户借阅记录的查询的联合主键
*该类是否被编译测试：
*@see(与之相关联的类)：   来源：
*                     中间： 
*                     去处：record实体类

*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：

*@date(开发日期)：2018/3/9
*改进点：
*最后更改日期：
*/
@Embeddable
public class RecordKey implements Serializable{

	private static final long serialVersionUID = -4850775451117216020L;
    
	private String name=null;
	private String bookname=null;
	
	//get、set方法
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
	
	//其他
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordKey other = (RecordKey) obj;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
