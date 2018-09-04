package 建造模式;

public class teacher {

	private static Student a=new StudentA();
	private static Student b=new StudentB();
	private static teacher t=new teacher();
	
	public static void main(String[] args) {
		
		System.out.println("指导A类学生");
		t.conductA();
		System.out.println("指导B类学生");
		t.conductB();
		
	}
	
	//指导A类学生 先学数学后学英语
	public static void conductA()
	{
		a.learnMath();
		a.learnEnglish();
	}
	
	//指导B类学生  先学英语后学数学
	public static void conductB()
	{
		b.learnEnglish();
		b.learnMath();
		
	}
	
	
}
