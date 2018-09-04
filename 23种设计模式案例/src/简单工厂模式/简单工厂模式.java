package 简单工厂模式;

public class 简单工厂模式 {

		 public static void main(String[] args) {
			
			 Factory a=new FactoryA();
			 Factory b=new FactoryB();
			 a.runMechine();
			 b.runMechine();
			
			 
		}
	
}
	
	 class Factory
	{
		
		public void runMechine()
		{
			System.out.println("这是父类工厂");
		}
		
	}
	
	 class FactoryA extends Factory
	{
		public void runMechine()
		{
			System.out.println("这是工厂A");
		}
	}
	 class FactoryB extends Factory
	{
		
		public void runMechine()
		{
			
			System.out.println("这是工厂B");
		}
	}
	

