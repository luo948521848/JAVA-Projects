package 测试包;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.lc.library.dataExchange.UserService;
import my.lc.library.interfaces.UserInterface;
import my.lc.library.librarys.User;
import my.lc.library.librarys.book;

public class 关于登录的数据交互 {

	
	
	public static void main(String args[])
	{
		ApplicationContext app= new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		UserService userService=app.getBean("userService",UserService.class);
		/*
		用户登录测试
		User r=userService.ImpLogin("092248", "092248");
		
		*/
		//书籍查询
		book r=userService.ImpLookBook("123");
		System.out.println(r);
		
	}
}
