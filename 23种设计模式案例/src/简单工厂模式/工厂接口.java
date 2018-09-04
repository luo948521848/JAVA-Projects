package 简单工厂模式;

import org.junit.Test;

public class 工厂接口 implements FactoryInterface{

	
	 @Test
	 public void test()
	 {
		
		//静态方法不能直接实例化内部类
		FactoryInterface a=new FactoryA();
		FactoryInterface b=new FactoryB();
		a.runMechine();
		b.runMechine();
	 }


	class FactoryA implements FactoryInterface
	{

		@Override
		public void runMechine() {
			// TODO Auto-generated method stub
			System.out.println("这是工厂A");
		}
		
	}
	
	
	class FactoryB implements FactoryInterface
	{

		@Override
		public void runMechine() {
			// TODO Auto-generated method stub
			System.out.println("这是工厂B");
		}
		
	}


	@Override
	public void runMechine() {
		// TODO Auto-generated method stub
		
	}



	
}
