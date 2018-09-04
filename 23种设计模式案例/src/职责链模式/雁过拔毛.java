package 职责链模式;



public class 雁过拔毛 {
	
	   //抽象的处理接口
		public abstract class Handler1
		{

			protected Handler1 lender;
			protected String  remakes;
			
			//设置备注
			public String setremakes(String r)
			{
				if(this.remakes==null)
				{
					this.remakes=r;
				}
				else
				{
					
					this.remakes=this.remakes+"/n"+r;
				}
				
				return this.remakes;
			}
		
			
			//设定领导
			public void setLender(Handler1 lender) {
				this.lender = lender;
			}


			//处理方法
			public abstract void handleRequest(int request);


		}



		//底层   只能处理级别1 的请求
		public class  A  extends Handler1
		{
	      
			
			@Override
			public void handleRequest(int request) {
				// TODO 自动生成的方法存根

				if(request==1)
				{
					System.out.print("底层处理了事件"+request);
					
				}
	
				else
				{
					if(this.lender!=null)
					{
					System.out.println("底层无法处理事件"+request+"交给了领导");
					
					//并提交意见
					this.lender.setremakes("底层员工对请求"+request+"的意见");
					this.lender.handleRequest(request);
					}
					
				}
				

			}

		

		}




		//中层  处理 1、2请求



		public class B extends Handler1
		{

			@Override
			public void handleRequest(int request) {
				// TODO 自动生成的方法存根
				
				
				
				if(request<=2)
				{
					System.out.println("中层查看备忘：");
					System.out.println(this.remakes);
					System.out.print("中层处理了事件"+request);
					
				}
				else
				{
					if(this.lender!=null)
					{
					System.out.println("中层无法处理事件"+request+"交给了领导");
					//并提交意见
					
					this.lender.setremakes(this.remakes+"中层员工对请求"+request+"的意见");
					this.lender.handleRequest(request);
					}
				}

			}

		}



		//上层处理1、2、3级别的请求
		public class C extends Handler1
		{

			@Override
			public void handleRequest(int request) {
				// TODO 自动生成的方法存根
				System.out.println("高层查看备忘：");
				System.out.println(this.remakes);
				System.out.println("上层领导处理了请求"+request);

			}


		}
		
		
}
