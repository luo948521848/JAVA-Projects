package 模板方法模式;

import org.junit.Test;

public class 继承父类 extends Factory {

	@Override
	void runMechine() {
		// TODO Auto-generated method stub
		System.out.println("进行生产");
	}

	
	@Test
	public void test()
	{
	  
		继承父类 factory=new 继承父类();
		factory.runMechine();
	}
}
