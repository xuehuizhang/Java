package org.coding.domain;

public class UserInfo {
	private String uid;
	private String ueamil;
	private String unick;
	private String upwd;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUeamil() {
		return ueamil;
	}
	public void setUeamil(String ueamil) {
		this.ueamil = ueamil;
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
		return "UserInfo [uid=" + uid + ", ueamil=" + ueamil + ", unick=" + unick + ", upwd=" + upwd + "]";
	}
	
}
