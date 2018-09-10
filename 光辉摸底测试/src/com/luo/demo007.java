package com.luo;

public class demo007 {
	
	
	
	public static void main(String []args)
	{
		
		int i=100;
		
		while(i<1000)
			
		{
			
			int a=i%100;
			int b=(i/10)%10;
			int c=i/100;
			
			
			int num= a*a*a +b*b*b+c*c*c;
		
			if(num==i)
			{
				System.out.println(i);
			}
			
			i++;
			
		}
		
		
		
	}

}
