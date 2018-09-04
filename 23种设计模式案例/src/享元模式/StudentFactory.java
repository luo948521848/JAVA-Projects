package ÏíÔªÄ£Ê½;

import java.util.HashMap;
import org.junit.Test;
public class StudentFactory {

	static HashMap <String,Student>map=new HashMap<>();
	
	public static Student getStudent(String name)
	{
		
		if(map.get(name)!=null)
		{
			return map.get(name);
		}
		return null;
		
	}
	
	public static void addStudent(Student s)
	{
		map.put(s.getName(), s);
	}
	
	public static void display()
	{
		System.out.println(map.entrySet());
	}
	
	@Test
	public void test001()
	{
	StudentFactory.addStudent(new Student("luo", 18));	
	StudentFactory.addStudent(new Student("li", 17));	
    Student s=	StudentFactory.getStudent("luo");
	System.out.println(s);
     StudentFactory.display();
	}
	
}
