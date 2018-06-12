package my.lc.library.dataExchange;
/*
*该类的功能以及特点描述：用于借阅记录的数据交互层

*该类是否被编译测试：
*@see(与之相关联的类)：   来源：
*                     中间：
*                     去处：
*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：

*@date(开发日期)：2018/3/9
*改进：
*最后更改日期：
*/

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import my.lc.library.interfaces.Recordinterface;
import my.lc.library.librarys.Record;
import my.lc.library.librarys.RecordKey;
import my.lc.library.librarys.book;

public class RecordDao extends HibernateDaoSupport implements Recordinterface{

	@Override
	public void AddRecord(Record r) {
		// TODO 自动生成的方法存根

		this.getHibernateTemplate().save(r);
	}

	@Override
	public void UpdateDate(String name, String bookname) {
		// TODO 自动生成的方法存根
		//联合主键
		RecordKey recordkey=new RecordKey();
		recordkey.setName(name);
		recordkey.setBookname(bookname);
		Record record= this.getHibernateTemplate().get(Record.class,recordkey);
		//获取当前时间并且转换成String格式
		Date date=new Date();
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		String Senddate= format.format(date);
		//获取的记录进行更新操作
		record.setSendDate(Senddate);
		this.getHibernateTemplate().update(record);
		
	}

}
