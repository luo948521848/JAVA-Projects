package ×´Ì¬Ä£Ê½;

public class StopState implements State{

	@Override
	public void doAction(Soldier soldier) {
		// TODO Auto-generated method stub
		System.out.println("Ê¿±øÍ£Ö¹¹¥»÷");
		soldier.setState(this);
	}

	@Override
	public String toString() {
		return "Ê¿±øÒÑÍ£Ö¹¹¥»÷";
	}

}
