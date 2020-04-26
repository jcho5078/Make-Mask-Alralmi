package com.example.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Jackson {
	@RequestMapping(value = "/map", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String jackson(Model model) throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
		
		String urlstr = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?";
		String pluspage = "page=";
		String pluspr = "&perPage=5000";
		String temp = urlstr;
		
		ObjectMapper mapper = new ObjectMapper();
		String dataplus = "";
		
		JsonDTO data = new JsonDTO();
		for(int i=1; i<=6; i++) {
			temp = urlstr + pluspage + i + pluspr;
			System.out.println(temp);
			data = mapper.readValue(
	                new URL(temp),
	                JsonDTO.class);
			System.out.println(i+"번째");
			
			temp = mapper.writeValueAsString(data.getStoreInfos());
			//페이지마다 '[]'때문에 객체가 따로 구분이 되어지므로 배열 구분자 없애고 ","추가하여 페이지 데이터 합침.
			if(i==1) {
				dataplus += temp.substring(0, temp.length()-1)+", ";
			}else if(i==6){
				dataplus += temp.substring(1);
			}else {
				dataplus += temp.substring(1, temp.length()-1 )+", ";
			}
			
			temp = null;
		}
//		//해당 url의 json 객체 속성 가져오기.
//		System.out.println(data.get("value"));
//		
//		// Map을 JSON String 으로 변환. 자바스크립트에 데이터 넘겨줄 때 유용.
//        System.out.println(mapper.writeValueAsString(data));
//        
//       //Map을 보기쉬운 JSON String 으로 변환. 데이터 가독성은 높으나 전송용으로는 적합치 않음.
//       System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
		
		String val = dataplus;
		
		model.addAttribute("storeInfos", val);
		
		return "map";
	}
}
