package com.naver;

public class CommandAction {
	private String where;
	private boolean isRedirect;
	
	public CommandAction() {
		// TODO Auto-generated constructor stub
	}

	public CommandAction(boolean isRedirect,String where) {
		super();
		this.where = where;
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

		
}
