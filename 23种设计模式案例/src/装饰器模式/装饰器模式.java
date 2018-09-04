package 装饰器模式;

import org.junit.Test;

public class 装饰器模式 {

	
	@Test
	public void test()
	{
		Soldier s=new SmallSoldier();
		BigSoldier b=new BigSoldier();
		b.setSoldier(s);
		b.fighting();
	}
	
	
}
interface Soldier
{
	void fighting();
}

class SmallSoldier implements Soldier
{

	@Override
	public void fighting() {
		// TODO Auto-generated method stub
		System.out.println("普通士兵在战斗");
	}
	}

class BigSoldier implements Soldier
{
	
	private Soldier soldier;
	

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}


	@Override
	public void fighting() {
		// TODO Auto-generated method stub
		soldier.fighting();
		System.out.println("配置了远程兵在辅助");
	}
	}