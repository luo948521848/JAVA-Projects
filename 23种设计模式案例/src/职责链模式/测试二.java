package 职责链模式;

import 职责链模式.雁过拔毛.Handler1;

public class 测试二 {

	public  static void main(String[] args)
	{
		雁过拔毛 zk =new 雁过拔毛();
		
		Handler1 a=zk.new A();//底层
		Handler1 b=zk.new B();//中层
		Handler1 c=zk.new C();//高层
		
		a.setLender(b);
		b.setLender(c);
		
		a.handleRequest(3);
		a.handleRequest(1);
		
		
	}
	
}
