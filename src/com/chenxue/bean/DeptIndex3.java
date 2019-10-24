package com.chenxue.bean;

public class DeptIndex3 {
	
	private String dName;
	private String jobName;
	private int jobNum;
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getJobNum() {
		return jobNum;
	}
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}
	public DeptIndex3(String dName, String jobName, int jobNum) {
		super();
		this.dName = dName;
		this.jobName = jobName;
		this.jobNum = jobNum;
	}
	
	
}
