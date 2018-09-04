package ÊÊÅäÆ÷Ä£Ê½;

import org.junit.Test;

public class MultCharger implements Charger {

	
	private Charger charger;
	
	public void setCharger(Charger charger) {
		this.charger = charger;
	}




	@Override
	public void GetPower() {
		// TODO Auto-generated method stub
		this.charger.GetPower();
	}

	
	
	@Test
	public void test()
	{
		Charger a=new ChargerA();
		Charger b=new ChargerB();
		
		MultCharger Multcharger=new MultCharger();
		Multcharger.setCharger(a);
        Multcharger.GetPower();
        Multcharger.setCharger(b);
        Multcharger.GetPower();
	}
}
