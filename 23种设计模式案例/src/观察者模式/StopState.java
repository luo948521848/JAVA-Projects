package 观察者模式;

public class StopState implements State{

	@Override
	public void doAction(Soldier soldier) {
		// TODO Auto-generated method stub
		System.out.println("士兵停止攻击");
		soldier.setState(this);
	}

	@Override
	public String toString() {
		return "士兵已停止攻击";
	}

}
