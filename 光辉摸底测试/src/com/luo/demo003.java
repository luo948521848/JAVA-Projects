package com.luo;

import java.util.Scanner;

public class demo003 {
	
	public static void main(String []args)
	{
		
		System.out.println("请输入第一个数");
		Scanner scanner =new Scanner(System.in);
		int a =scanner.nextInt();
		System.out.println("请输入第二个数");
		int b=scanner.nextInt();
		
		
		
		System.out.println("num1="+a);
		System.out.println("num2="+b);
		System.out.println("num1+num2="+(a+b));
		System.out.println("num1-num2="+(a-b));
		System.out.println("num1*num2="+(a*b));
		System.out.println("num1/num2="+(a/b));
		
	}

}
