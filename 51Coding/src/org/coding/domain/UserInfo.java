package org.coding.domain;

public class UserInfo {
	private String uid;
	private String uemail;
	private String unick;
	private String upwd;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUnick() {
		return unick;
	}
	public void setUnick(String unick) {
		this.unick = unick;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", ueamil=" + uemail + ", unick=" + unick + ", upwd=" + upwd + "]";
	}
	
}
