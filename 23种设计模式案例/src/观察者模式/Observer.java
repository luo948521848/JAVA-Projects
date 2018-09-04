package 观察者模式;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Observer {

	
	private List <Soldier>list=new ArrayList<>();
	
	private State state;
	
	//进入观察
	public void add(Soldier soldier)
	{
		list.add(soldier);
	}
    //离开观察
	public void  remove(Soldier soldier)
	{
		list.remove(soldier);
	}
	//设置情报
	public State getState() {
		return state;
	}
	//获取情报
	public void setState(State state) {
		this.state = state;
	}
   
	
	//通知获取情报
	public void inform()
	{
		for(Soldier s :list)
		{
			
			if(this.state!=null)
			{
			this.state.doAction(s);
			}else
			{
				System.out.println("请先设置状态");
			}
		}
		
	}
	
	
}
