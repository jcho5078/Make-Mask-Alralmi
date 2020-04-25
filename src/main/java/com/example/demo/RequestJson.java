package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class RequestJson {
	//@RequestMapping(value = "/map")
	public String request() throws Exception {
		
		String line = null;
		String res = null;
		String json = null;
		
		String addr = null;
		double lat = 0;
		double lng = 0;
		String name = null;
		String type = null;
		
		String pluspage = "page=";
		String pluspr = "&perPage=5000";
		
		JsonList jsonList = new JsonList();
		
		System.out.println("간다간다뿅간다");
		for(int i=2; i<=6; i++) {
			String urlstr = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?";
			String temp = urlstr;
			
			urlstr = urlstr + pluspage + i + pluspr;
			System.out.println(i+"번째 링크 출력:" + urlstr);
			
			try{
				URL url = new URL(urlstr);
				BufferedReader bf = null;
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");//GET방식으로 json인자 받아옴
				bf = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				//utf-8 인코딩으로 해당 url읽기
				
				while((line = bf.readLine()) != null) {
	                res = res + line + "\n";
	            }//json값 한 라인씩 받아오기
				json = res;
//				jsonList.jsonParse(res);
//				
//				addr = jsonList.getAddr();
//				lat = jsonList.getLat();
//				lng = jsonList.getLng();
//				name = jsonList.getName();
//				type = jsonList.getType();
//				
//				model.addAttribute("addr", addr);
//				model.addAttribute("lat", lat);
//				model.addAttribute("lng", lng);
//				model.addAttribute("name", name);
//				model.addAttribute("type", type);
				
			}catch (Exception e){
			     e.printStackTrace();
			     throw e;
			}
			res = null;
			urlstr = temp;
			System.out.println("json값 받아오기 성공");
			
			JSONParser paser = new JSONParser();//json 파싱위한 객체
			JSONObject obj = (JSONObject) paser.parse(json);//해당 문자열 데이터를 json데이터로 변환
			JSONArray storeInfos = (JSONArray) obj.get("storeInfos");//json데이터에서 storeInfos추출.
			for(int j=0; j<storeInfos.size(); j++) {//해당 속성(storeInfos)에서 차례로 데이터 추출.
				
				JSONObject data = (JSONObject) storeInfos.get(j);//추출한 속성에서 데이터 하나씩 접근하기위한 json객체 생성.
				if(data.get("name").equals(null)) {
					name += "";
				}else {
					name += (String) data.get("name");
				}
			}
			System.out.println(name);
			System.out.println(i+"번째 끝");
			name = null;
		}
		
//		JSONParser paser = new JSONParser();//json 파싱위한 객체
//		JSONObject obj = (JSONObject) paser.parse(json);//해당 문자열 데이터를 json데이터로 변환
//		JSONArray storeInfos = (JSONArray) obj.get("storeInfos");//json데이터에서 storeInfos추출.
//		for(int i=0; i<storeInfos.size(); i++) {//해당 속성(storeInfos)에서 차례로 데이터 추출.
//			JSONObject data = (JSONObject) storeInfos.get(i);//추출한 속성에서 데이터 하나씩 접근하기위한 json객체 생성.
//			name += (String) data.get("name");
//		}
		
		//model.addAttribute("json", name);
		//addAttribute는 속성, 값 나만 담을 때.
		//setAttribute는 리스트를 통째로 담을 때.
		return "map2";
	}
}

