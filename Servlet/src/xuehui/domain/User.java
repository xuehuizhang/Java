package xuehui.domain;

public class User {
	private int uid;
	private String upwd;
	private String uName;
	
	public void setUid(int uid) {
		this.uid=uid;
	}
	public int getUid() {
		return this.uid;
	}
	
	public void setUpwd(String upwd) {
		this.upwd=upwd;
	}
	public String getUpwd() {
		return this.upwd;
	}
	public void setUname(String uname) {
		this.uName=uname;
	}
	public String getUname() {
		return this.uName;
	}
	@Override
	public String toString() {
		return this.uName+":"+this.upwd;
	}
}
