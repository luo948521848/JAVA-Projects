package 适配器模式;

public class ChargerA implements Charger {

	@Override
	public void GetPower() {
		// TODO Auto-generated method stub
		System.out.println("使用220V经行充电");
	}

}
