package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonList {
	private String addr = null;
	private double lat;
	private double lng;
	private String name = null;
	private String type = null;
	
	public void jsonParse(String json) throws ParseException {
		
		JSONParser paser = new JSONParser();//json 파싱위한 객체
		JSONObject obj = (JSONObject) paser.parse(json);//해당 문자열 데이터를 json데이터로 변환
		JSONArray storeInfos = (JSONArray) obj.get("storeInfos");//json데이터에서 storeInfos추출.
		////storeInfos객체안에 원하는 데이터들이 다 들어 있으니 얘만 추출. '['부터 시작하므로 jsonarry 형식.
		try {
			for(int i=0; i<storeInfos.size(); i++) {//해당 속성(storeInfos)에서 차례로 데이터 추출.
				JSONObject data = (JSONObject) storeInfos.get(i);//추출한 속성에서 데이터 하나씩 접근하기위한 json객체 생성.
				addr = (String) data.get("addr");//원하는 속성 하나씩 추출.
				lat = (double) data.get("lat");
				lng = (double) data.get("lng");
				name = (String) data.get("name");
				type = (String) data.get("type");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//Getter 메서드들.
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
	
	public String getType() {
		return type;
	}
}
