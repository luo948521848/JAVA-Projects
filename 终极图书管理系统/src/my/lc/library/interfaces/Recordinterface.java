package my.lc.library.interfaces;

import my.lc.library.librarys.Record;

/*
*该类的功能以及特点描述：这是图书借阅归还操作的接口  函数都是静态抽象函数
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
public interface Recordinterface {
	//借阅 新建借阅记录
	public void AddRecord(Record r);
	
	//归还 修改借阅记录
	public void UpdateDate(String name,String bookname);
	
}
