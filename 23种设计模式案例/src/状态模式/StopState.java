package ״̬ģʽ;

public class StopState implements State{

	@Override
	public void doAction(Soldier soldier) {
		// TODO Auto-generated method stub
		System.out.println("ʿ��ֹͣ����");
		soldier.setState(this);
	}

	@Override
	public String toString() {
		return "ʿ����ֹͣ����";
	}

}
