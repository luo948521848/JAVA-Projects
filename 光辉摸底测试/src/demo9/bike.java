package demo9;

public class bike {
	
	private String cheluncolor;
	private int chelunnum;
	
	public void run()
	{
		
		System.out.println("等着跑" +cheluncolor +chelunnum);
	}

	
	
	public class car
	{
		private int  lunzinum;
		private String lunzicolor;
		private String dichi;
		
		private bike b =new bike();
		public void run()
		{
			
			if(dichi!=null)
			{
				this.run();
				System.out.println("开着跑");
			}
			else
			{
				
				b.run();
			}
			
		}
		
	}
}
