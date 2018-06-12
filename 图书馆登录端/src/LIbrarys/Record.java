package LIbrarys;

import java.util.Date;

public class Record {
	

	private String r_name=null;
	private String rb_name=null;
	
	private String LendDate=null;
	
    //注意选择格式化输出格式
	private String SendDate=null;

	public Record() {
		super();
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getRb_name() {
		return rb_name;
	}

	public void setRb_name(String rb_name) {
		this.rb_name = rb_name;
	}

	public String getLendDate() {
		return LendDate;
	}

	public void setLendDate(String lendDate) {
		LendDate = lendDate;
	}

	public String getSendDate() {
		return SendDate;
	}

	public void setSendDate(String sendDate) {
		SendDate = sendDate;
	}

	
	
	

}
