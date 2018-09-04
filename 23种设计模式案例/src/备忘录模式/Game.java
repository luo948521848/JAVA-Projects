package 备忘录模式;

public class Game {

	private String username;//游戏名
	private int level;//等级
	private int pass;//关卡
	
	public Game(String username, int level, int pass) {
		super();
		this.username = username;
		this.level = level;
		this.pass = pass;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Game [username=" + username + ", level=" + level + ", pass=" + pass + "]";
	}
	
	
}
