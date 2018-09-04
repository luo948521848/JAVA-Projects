package 模板方法模式;

import org.junit.Test;
public class 实现接口 implements FactoryA{

	@Override
	public void runMechine() {
		// TODO Auto-generated method stub
		System.out.println("开始生产");
	}

	
	@Test
	public  void test()
	{
		FactoryA factory=new 实现接口();
		factory.runMechine();
	}
}

interface FactoryA
{
 void  runMechine();	
}