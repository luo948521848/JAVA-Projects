package com.lc.shopmarket.JavaBean;

import java.math.BigDecimal;

/**
 * AbstractSale entity provides the base persistence definition of the Sale
 * entity. @author MyEclipse Persistence Tools
 */
/*
*该类的功能以及特点描述：超市管理系统的销售信息的实体类


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
public  class Sale implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8288802944480117814L;
	private String saleId;//销售ID号，主键
	private String productId;//商品ID
	private String saleDate;//销售日期
	private BigDecimal number;//数量
	private BigDecimal price;//价格
	private String discount;//折扣
	private String vipId;//Vip号
	private String productName;//商品名称
	private String cashier;

	// Constructors

	/** default constructor */
	public Sale() {
	}

	/** minimal constructor */
	public Sale(String saleId) {
		this.saleId = saleId;
	}

	/** full constructor */
	public Sale(String saleId, String productId, String saleDate, BigDecimal number, BigDecimal price,
			String discount, String vipId, String productName,String cashier) {
		this.saleId = saleId;
		this.productId = productId;
		this.saleDate = saleDate;
		this.number = number;
		this.price = price;
		this.discount = discount;
		this.vipId = vipId;
		this.productName = productName;
		this.cashier=cashier;
	}

	// Property accessors

	
	
	
	public String getSaleId() {
		return this.saleId;
	}

	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public BigDecimal getNumber() {
		return this.number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getVipId() {
		return this.vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}