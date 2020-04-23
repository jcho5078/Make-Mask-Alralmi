package com.example.demo;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = "/")
@ResponseBody
public class JsonList {
	String addr = null;
	double lat;
	double lng;
	String name = null;
	String type = null;
	
	public void test(String json) throws ParseException {
		ObjectMapper objectMapper = new ObjectMapper();
		
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
				
				DTO(addr, lat, lng, name, type);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void DTO(String addr, double lat, double lng, String name, String type) {
		//클래스 새로 만들기 귀찮아서 만든 Setter역할 메서드.
		this.addr = addr;
		this.lat = lat;
		this.lng = lng;
		this.name = name;
		this.type = type;
	}
}
