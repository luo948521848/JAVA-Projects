package ×´Ì¬Ä£Ê½;

public class TestDemo {

	
	
	public static void main(String[] args) {
		
	
	//ÕÐÄ¼Ê¿±ø
	Soldier soldier =new Soldier();
	//½ø¹¥Ö¸Áî
	State start=new StartState();
	start.doAction(soldier);
	System.out.println(soldier.getState());
	//Í£Ö¹¹¥»÷Ö¸Áî
	State stop=new StopState();
	stop.doAction(soldier);
	System.out.println(soldier.getState());
	
	
	}
}
