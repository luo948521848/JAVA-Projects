package 状态模式;

public class StartState implements State {

	@Override
	public void doAction(Soldier soldier) {
		// TODO Auto-generated method stub
		System.out.println("士兵开始攻击");
		soldier.setState(this);
	}

	@Override
	public String toString() {
		return "士兵正在攻击";
	}

	
}
