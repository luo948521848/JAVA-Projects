package com.luo;

import java.util.Scanner;

import org.junit.Test;

public class demo005 {

	@Test
	public void test()
	{
	
		if(get())
		{
			System.out.println("输入年份是闰年");
		}
		else
		{
			
			System.out.println("输入年份不是闰年");
		}

	}
	
	public boolean get()
	{
		
		System.out.println("输入你查询的年份");
		Scanner scanner =new Scanner(System.in);
		
		int year =scanner.nextInt();
		
		if(year%100!=0&&year%4==0)
		{
			 if(year>400)
			 {
			if(year%400==0)
			{
				return true;
			}
			return false;
			 }
			 
			 return true;
			
		}	
		return false;
	}
	

}
