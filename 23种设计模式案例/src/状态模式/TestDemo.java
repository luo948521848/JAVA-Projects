package ״̬ģʽ;

public class TestDemo {

	
	
	public static void main(String[] args) {
		
	
	//��ļʿ��
	Soldier soldier =new Soldier();
	//����ָ��
	State start=new StartState();
	start.doAction(soldier);
	System.out.println(soldier.getState());
	//ֹͣ����ָ��
	State stop=new StopState();
	stop.doAction(soldier);
	System.out.println(soldier.getState());
	
	
	}
}
