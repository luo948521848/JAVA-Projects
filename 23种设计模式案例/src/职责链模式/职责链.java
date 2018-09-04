package 职责链模式;

public class 职责链 {

	//抽象的处理接口
	public abstract class Handler
	{

		protected Handler lender;
		//设定领导
		public void setLender(Handler lender) {
			this.lender = lender;
		}

		//处理方法
		public abstract void handleRequest(int request);


	}



	//底层   只能处理级别1 的请求
	public class  A  extends Handler
	{
       
		public A()
		{}
		
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
				this.lender.handleRequest(request);
				}
			}

		}

	}




	//中层  处理 1、2请求



	public class B extends Handler
	{

		@Override
		public void handleRequest(int request) {
			// TODO 自动生成的方法存根
			
			
			
			if(request<=2)
			{
				System.out.print("中层处理了事件"+request);
				
			}
			else
			{
				if(this.lender!=null)
				{
				System.out.println("中层无法处理事件"+request+"交给了领导");
				this.lender.handleRequest(request);
				}
			}

		}

	}



	//上层处理1、2、3级别的请求
	public class C extends Handler
	{

		@Override
		public void handleRequest(int request) {
			// TODO 自动生成的方法存根
			
			System.out.println("上层领导处理了请求"+request);

		}


	}
	
	
	
	
	


}
