package 备忘录模式;

import org.junit.Test;
public class Manager {

	private Game game;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
	@Test
	public void test()
	{
		Manager manager=new Manager();
		Game game=new Game("luo", 99, 3);
		//保存记录
		manager.setGame(game);
		
		//读取记录
		System.out.println(manager.getGame());
		
	}
	
	
}
