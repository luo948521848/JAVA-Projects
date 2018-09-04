package 桥接模式;

import org.junit.Test;

public class 桥接模式 {

	@Test
	public void test()
	{
		ColocalateFactory a=new BlackFactory();
		a.ColocalateMarking();
		ColocalateFactory b=new WhilteFactory();
		b.ColocalateMarking();
	}
	
	
	
}
interface ColocalateFactory
{
void ColocalateMarking();	
}

class BlackFactory implements ColocalateFactory
{

	@Override
	public void ColocalateMarking() {
		// TODO Auto-generated method stub
		System.out.println("生产黑色巧克力");
	}
	
}
class WhilteFactory implements ColocalateFactory
{

	@Override
	public void ColocalateMarking() {
		// TODO Auto-generated method stub
		System.out.println("生产白色巧克力");
	}
	
}