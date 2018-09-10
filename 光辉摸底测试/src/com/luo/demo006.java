package com.luo;

import java.util.ArrayList;

public class demo006 {

	
	
	public static void main(String []args)
	{
		
	
		ArrayList a = new ArrayList<>();
	
	
	for(int i=0;i<10;i++)
	{
		a.add(((int)(Math.random()*100)+1));
	}
	
	
	int min=(int)a.get(0);
	int max=(int)a.get(0);
	for(int i=1;i<10;i++)

	{
			
			if(min>(int)a.get(i))
			{
				
				min =(int)a.get(i);
			}
			
			
			}
	
	for(int i=1;i<10;i++)

	{
			
			if(max<(int)a.get(i))
			{
				
				max =(int)a.get(i);
			}
			
			
			}
				
			
	System.out.println("最小值为："+min +"最大值为"+max);
		
			 
	 
	}
	
	}

