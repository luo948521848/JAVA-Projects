package ״̬ģʽ;

public class StartState implements State {

	@Override
	public void doAction(Soldier soldier) {
		// TODO Auto-generated method stub
		System.out.println("ʿ����ʼ����");
		soldier.setState(this);
	}

	@Override
	public String toString() {
		return "ʿ�����ڹ���";
	}

	
}
