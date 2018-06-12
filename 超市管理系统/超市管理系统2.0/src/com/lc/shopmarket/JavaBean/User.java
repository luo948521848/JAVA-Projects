package com.lc.shopmarket.JavaBean;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */
/*
*该类的功能以及特点描述：超市管理系统的 User的实体类


*该类是否被编译测试：否
*@see(与之相关联的类)：   来源：
*                     中间：
*                     去处：
*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：1.0
*@数据库查询方式：mysql+Hibernate
*@date(开发日期)：2018/5/20
*改进：
*最后更改日期：
*/

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3628379991870401201L;
	private String cardId;//用户ID号，主键
	private String userName;//用户名
	private String idcard;//证件号
	private String password;//密码
	private String cardDate;//办卡日期
	private String userGrade;//用户类别
	private String term;//期限
	private String integral;//积分
	private String agio;//折扣

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String cardId) {
		this.cardId = cardId;
	}

	/** full constructor */
	public User(String cardId, String userName, String idcard, String password, String cardDate,
			String userGrade, String term, String integral, String agio) {
		this.cardId = cardId;
		this.userName = userName;
		this.idcard = idcard;
		this.password = password;
		this.cardDate = cardDate;
		this.userGrade = userGrade;
		this.term = term;
		this.integral = integral;
		this.agio = agio;
	}

	// Property accessors

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardDate() {
		return this.cardDate;
	}

	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}

	public String getUserGrade() {
		return this.userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getIntegral() {
		return this.integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getAgio() {
		return this.agio;
	}

	public void setAgio(String agio) {
		this.agio = agio;
	}

}