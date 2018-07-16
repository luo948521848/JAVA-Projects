package com.lc.shopmarket.JavaBean;

import java.math.BigDecimal;

/**
 * AbstractMerchandise entity provides the base persistence definition of the
 * Merchandise entity. @author MyEclipse Persistence Tools
 */
/*
*该类的功能以及特点描述：超市管理系统的 商品信息的的实体类


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
public  class Merchandise implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5732715502264514362L;
	// Fields

	private int sequenceNumber;//序列号，主键
	private String merchandiseNumber;//商品编码
	private String treatyCode;//条码
	private String sortNumber;//类别编号
	private String merchandiseName;//商品名称
	private BigDecimal retailPrice;//零售价
	private String merchandiseSpec;//商品规格
	private String units;//单位
	private BigDecimal purchasePrice;//进货价
	private BigDecimal checkTerm;//保质期
	private String remark;//备注

	// Constructors

	/** default constructor */
	public Merchandise() {
	}

	/** minimal constructor */
	public Merchandise(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	/** full constructor */
	public Merchandise(int sequenceNumber, String merchandiseNumber, String treatyCode, String sortNumber,
			String merchandiseName, BigDecimal retailPrice, String merchandiseSpec, String units,
			BigDecimal purchasePrice, BigDecimal checkTerm, String remark) {
		this.sequenceNumber = sequenceNumber;
		this.merchandiseNumber = merchandiseNumber;
		this.treatyCode = treatyCode;
		this.sortNumber = sortNumber;
		this.merchandiseName = merchandiseName;
		this.retailPrice = retailPrice;
		this.merchandiseSpec = merchandiseSpec;
		this.units = units;
		this.purchasePrice = purchasePrice;
		this.checkTerm = checkTerm;
		this.remark = remark;
	}

	// Property accessors

	public int getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getMerchandiseNumber() {
		return this.merchandiseNumber;
	}

	public void setMerchandiseNumber(String merchandiseNumber) {
		this.merchandiseNumber = merchandiseNumber;
	}

	public String getTreatyCode() {
		return this.treatyCode;
	}

	public void setTreatyCode(String treatyCode) {
		this.treatyCode = treatyCode;
	}

	public String getSortNumber() {
		return this.sortNumber;
	}

	public void setSortNumber(String sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getMerchandiseName() {
		return this.merchandiseName;
	}

	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}

	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getMerchandiseSpec() {
		return this.merchandiseSpec;
	}

	public void setMerchandiseSpec(String merchandiseSpec) {
		this.merchandiseSpec = merchandiseSpec;
	}

	public String getUnits() {
		return this.units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getCheckTerm() {
		return this.checkTerm;
	}

	public void setCheckTerm(BigDecimal checkTerm) {
		this.checkTerm = checkTerm;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}