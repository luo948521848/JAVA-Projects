package 抽象工厂模式;

import org.junit.Test;

public class TestFactory {

	
	@Test
	public void test()
	{
		
		AbstartFactory a=new FactoryA();
		//AbstartFactory b=new FactoryB();
		
		System.out.println("需要黑面包");
		a.Breakmaking();
		System.out.println("需要白巧克力");
		try {
			Class <?> c=Class.forName("抽象工厂模式.FactoryB");
			a=(AbstartFactory)c.newInstance();
			a.Chocolatmaking();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	

	
	
}
