package com.naver;

public class CA {
	private boolean isRedirect;
	private String where;
	
	public CA() {
		// TODO Auto-generated constructor stub
	}

	public CA(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
}
