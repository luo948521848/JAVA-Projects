package com.luo;

import java.util.Scanner;

public class demo002 {
	
	
	public static void main(String []args)
	{
		
		int a=0;
		int number =(int)(Math.random()*100);
		while(true)
		{
		
		
		System.out.println("输入你猜的数");
		
		Scanner scanner =new Scanner(System.in);
		int cai =scanner.nextInt();
		
		a++;
		
		if(cai==number)
		{
			System.out.println("恭喜你答对了");
			if(a==1)
			{
				System.out.println("你真太聪明了");
				break;
			}
			if(a>=2&&a<=5)
			{
				
				System.out.println("不错，再接再厉");
				break;
			}
			else
			{
				System.out.println("要努力啊");
				break;
			}
		}
		else
		{
			System.out.println("错啦");
		}
		}
		
	}

}
