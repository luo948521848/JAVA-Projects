package 代理模式;

import org.junit.Test;
public class AgentFactory implements FactoryInterface{
	FactoryInterface f =new Factory();

	@Override
	public void Breakmaking() {
		// TODO Auto-generated method stub
		f.Breakmaking();
	}
	
	
	
	
	@Test
	public void test()
	{
		new AgentFactory().Breakmaking();
	}
}
