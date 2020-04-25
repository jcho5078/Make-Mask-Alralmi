package com.example.demo;

public class storeInfos {
	private String addr;
	private double lat;
	private double lng;
	private String name;
	private String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;
	
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public double getLat(){
		return lat;
	}

	public double getLng(){
		return lng;
	}
	
	public String getName() {
		return name;
	}
}
