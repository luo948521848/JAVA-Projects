package 外观模式;

import org.junit.Test;
public class 外观模式{

	private FactoryA a=new FactoryA();
	private FactoryB b=new FactoryB();
	public void lookplay()
	{
		a.funcA();
		b.funcB();
	}
	
	
	@Test
	public void test()
	{
		new 外观模式().lookplay();
	}
}

class FactoryA
{

	public void funcA()
	{
		System.out.println("向别人表白");	
	}

}

class FactoryB
{

	public void funcB()
	{

		System.out.println("答应别人的表白");
	}
}