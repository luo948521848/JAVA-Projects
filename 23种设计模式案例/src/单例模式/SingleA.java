package 单例模式;

public class SingleA
{
	
	public static SingleA singleA=null;
	private SingleA()
	{
		System.out.println("这是懒汉单例模式");
	}
	
	
	public static synchronized SingleA getSingleA() {
		
		
		if(singleA==null)
		{
		singleA=new SingleA();
		
		}
		
		return singleA;
	}
	
	
	
}

