package 中介模式;

public class Artisan {

	public void solution(Custom custom)
	{
	 System.out.println("技术人员与顾客进行沟通");
	 custom.setArtisan(this);	
	}
}
