package com.lc.shopmarket.JavaBean;

import java.math.BigDecimal;

/**
 * AbstractPurchase entity provides the base persistence definition of the
 * Purchase entity. @author MyEclipse Persistence Tools
 */
/*
*该类的功能以及特点描述：超市管理系统的采购信息（进货、退货）的的实体类


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
public  class Purchase implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4109417570590782037L;
	private String backSaleId;//进货订单
	private String productId;//商品编号
	private String productName;//商品名称
	private BigDecimal number;//数量
	private BigDecimal price;//价格
	private String jtDate;//时间
	private BigDecimal superMarket;//进货价
	private String nextBack;//类别
	private String reason;//制单人
	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(String backSaleId) {
		this.backSaleId = backSaleId;
	}

	/** full constructor */
	public Purchase(String backSaleId, String productId, String productName, BigDecimal number,
			BigDecimal price, String jtDate, BigDecimal superMarket, String nextBack, String reason) {
		this.backSaleId = backSaleId;
		this.productId = productId;
		this.productName = productName;
		this.number = number;
		this.price = price;
		this.jtDate = jtDate;
		this.superMarket = superMarket;
		this.nextBack = nextBack;
		this.reason = reason;
	}

	// Property accessors

	public String getBackSaleId() {
		return this.backSaleId;
	}

	public void setBackSaleId(String backSaleId) {
		this.backSaleId = backSaleId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getJtDate() {
		return this.jtDate;
	}

	public void setJtDate(String jtDate) {
		this.jtDate = jtDate;
	}

	public BigDecimal getSuperMarket() {
		return this.superMarket;
	}

	public void setSuperMarket(BigDecimal superMarket) {
		this.superMarket = superMarket;
	}

	public String getNextBack() {
		return this.nextBack;
	}

	public void setNextBack(String nextBack) {
		this.nextBack = nextBack;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}