package LIbrarys;

public class book {
	
	
	private String b_name=null;
	private String b_writer=null;
	private Integer b_num=0;
	//³ö°æÉç
	private String b_publish=null;
	private String br_date=null;
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Integer getB_num() {
		return b_num;
	}
	public void setB_num(Integer b_num) {
		this.b_num = b_num;
	}
	public String getB_publish() {
		return b_publish;
	}
	public void setB_publish(String b_publish) {
		this.b_publish = b_publish;
	}
	public String getBr_date() {
		return br_date;
	}
	public void setBr_date(String br_date) {
		this.br_date = br_date;
	}
	public book(String b_name, String b_writer, Integer b_num, String b_publish, String br_date) {
		super();
		this.b_name = b_name;
		this.b_writer = b_writer;
		this.b_num = b_num;
		this.b_publish = b_publish;
		this.br_date = br_date;
	}
	public book() {
		super();
	}
	@Override
	public String toString() {
		return "book [b_name=" + b_name + ", b_writer=" + b_writer + ", b_num=" + b_num + ", b_publish=" + b_publish
				+ ", br_date=" + br_date + "]";
	}
	
	
	

}
