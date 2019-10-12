package com.chenxue.bean;

public class Student {
	private int sid;
	private String sName;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Student(int sid, String sName) {
		super();
		this.sid = sid;
		this.sName = sName;
	}
}
