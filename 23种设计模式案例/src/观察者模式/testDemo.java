package 观察者模式;

public class testDemo {

	public static void main(String[] args) {
		
		Soldier a =new Soldier();
		Soldier b=new Soldier();
		
		Observer observer=new Observer();
		
		//雇佣观察者
		observer.add(a);
		observer.add(b);
		
		//发出进攻指令
		observer.setState(new StartState());
		observer.inform();//进行通知
		System.out.println(a.getState());
		System.out.println(b.getState());
		
		
		//发出进攻指令
		observer.setState(new StopState());
		observer.inform();//进行通知
		System.out.println(a.getState());
		System.out.println(b.getState());
	}
}
