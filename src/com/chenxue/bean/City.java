package com.chenxue.bean;

public class City {
	private int cityId;
	private String cityName;
	private int pId;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public City(int cityId, String cityName, int pId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.pId = pId;
	}
	
}
