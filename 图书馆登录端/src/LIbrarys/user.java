package LIbrarys;

import java.io.Serializable;

public class user implements Serializable {
	
	/**
	 * 
	 */
	//0是普通用户 1是管理员
	enum usertype{
	user,
	root	
	}
	private static final long serialVersionUID = -5939096012046004055L;
	//用户登录
	private String  name=null;
	private String password=null;
	private String userType=null;
	

	
	public user() {
		super();
	}
   


	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public user(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [name=" + name + ", password=" + password + "]";
	}


	
}
