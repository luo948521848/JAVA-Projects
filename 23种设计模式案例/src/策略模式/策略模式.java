package 策略模式;

import org.junit.Test;
public class 策略模式 {

	private Factory factory;

	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	
	//方法名可以不同
	public void run()
	{
		this.factory.runMechine();
	}
	
	
	@Test
	public void test001()
	{
		策略模式 c=new 策略模式();
		c.setFactory(new FactoryA());
		c.run();
	}
	
}

interface Factory
{
void runMechine();
}

class FactoryA implements Factory
{

	@Override
	public void runMechine() {
		// TODO Auto-generated method stub
		System.out.println("A工厂进行生产");
	}
	
	}

class FactoryB implements Factory
{

	@Override
	public void runMechine() {
		// TODO Auto-generated method stub
		System.out.println("B工厂进行生产");
	}
	}