package 职责链模式;

import 职责链模式.职责链.Handler;

public class 测试一 {
	public static void main(String[] args)
	{
		职责链 zk=new 职责链();
		Handler a=zk.new A();//底层
		Handler b=zk.new B();//中层
		Handler c=zk.new C();//高层
		
		a.setLender(b);
		b.setLender(c);
		
		a.handleRequest(3);
		a.handleRequest(1);
		
		
		
		
	}
}
