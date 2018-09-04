package 原型模式;

public class Test {

	
	@org.junit.Test
	public void test001()
	{
		Student s=new Student("luo","1");
		System.out.println(s);
		Student a=(Student)s.clone();
		a.setName("li");
		System.out.println(a);
		System.out.println(s);
	}
}
