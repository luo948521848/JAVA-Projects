package com.luo;

public class demo004 {

	public static void main(String []args)
	{
		int[] a={5,2,3,8,9};
		
		
		for(int i=0;i<5;i++)
		 for(int j=i;j<4-i;j++)
		 {
			 if(a[j]>a[j+1])
			 {
				int tmp= a[j];
				a[j]=a[j+1];
				a[j+1]=tmp;
				 
			 }
			 
		 }
		
		System.out.println("≈≈–Ú∫Û");
		
		
		for(int m:a)
		{
			System.out.print(m);
			
		}
		
	}
}
