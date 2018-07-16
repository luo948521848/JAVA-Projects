package com.lc.shopmarket.JavaBean;
// default package

/**
 * AbstractStaff entity provides the base persistence definition of the Staff
 * entity. @author MyEclipse Persistence Tools
 */
/*
*该类的功能以及特点描述：超市管理系统的职工的实体类


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
public  class Staff implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7065295579906161039L;
	private String staffId;//职工号
	private String name;//职工姓名
	private String userName;//用户名
	private String userPassword;//密码
	private String userGrade;//职工类型
	private Double saleAmount;//销售金额

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** minimal constructor */
	public Staff(String staffId) {
		this.staffId = staffId;
	}

	/** full constructor */
	public Staff(String staffId, String name, String userName, String userPassword, String userGrade,
			Double saleAmount) {
		this.staffId = staffId;
		this.name = name;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userGrade = userGrade;
		this.saleAmount = saleAmount;
	}

	// Property accessors

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGrade() {
		return this.userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public Double getSaleAmount() {
		return this.saleAmount;
	}

	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

}