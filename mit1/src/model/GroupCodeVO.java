package model;

public class GroupCodeVO {
	private String gcode; //그룹코드
	private String gname; //그룹이름
	
	
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	
	@Override
	public String toString() {
		return "GroupCodeVO [gcode=" + gcode + ", gname=" + gname + "]";
	}
	
	
	
	
}
