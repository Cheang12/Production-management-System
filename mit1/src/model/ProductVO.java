package model;

public class ProductVO {
	private String code; //제품코드
	private String pname; // 제품이름
	private int cost; //제품원가
	private int pnum; // 목표수량
	private int jnum; //재고수량
	private int sale; //출고가
	private String gcode; //그룹코드(외래키)
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getJnum() {
		return jnum;
	}
	public void setJnum(int jnum) {
		this.jnum = jnum;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", pname=" + pname + ", cost=" + cost + ", pnum=" + pnum + ", jnum=" + jnum
				+ ", sale=" + sale + ", gcode=" + gcode + "]";
	}
	
	

}
