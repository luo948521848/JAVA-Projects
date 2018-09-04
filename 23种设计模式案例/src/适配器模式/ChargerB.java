package 适配器模式;

public class ChargerB implements Charger {

	@Override
	public void GetPower() {
		// TODO Auto-generated method stub
		System.out.println("使用200V进行充电");
	}

}
