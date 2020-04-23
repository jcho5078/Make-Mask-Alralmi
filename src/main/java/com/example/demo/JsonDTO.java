package com.example.demo;

public class JsonDTO {
	private String count;
	private String page;
	private String totalCount;
	private String totalPages;
	
	private String addr;
	private String lat;
	private String lng;
	private String name;
	
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public String getLat(){
		return lat;
	}

	public String getLng(){
		return lng;
	}
	
	public String getName() {
		return name;
	}
}
