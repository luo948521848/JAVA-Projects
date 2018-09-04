package 单例模式;



public class SingleB
{

	public static SingleB singleB=new SingleB();
	
	private SingleB()
	{
		System.out.println("这是饥汉单例模式");
	}

	public static SingleB getSingleB() {
		return singleB;
	}

	
	
}