package com.example.demo;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
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
		
		// URL 에 있는 JSON String 을 Map으로 변환하기.
//		Map<String, Object> data = mapper.readValue(
//                new URL("https://gturnquist-quoters.cfapps.io/api/random"),
//                new TypeReference<Map<String,Object>>(){});
		//Map<String, Object> data;
		JsonDTO data = new JsonDTO();
		for(int i=1; i<=6; i++) {
			temp = urlstr + pluspage + i + pluspr;
			System.out.println(temp);
			data = mapper.readValue(
	                new URL(temp),
	                JsonDTO.class);
			System.out.println(i+"번째");

			System.out.println(data.getStoreInfos());
			System.out.println("출력완료");
			temp = null;
		}
		//mapper.writerWithDefaultPrettyPrinter().writeValue(new File("json.json"), data.getStoreInfos());
//		System.out.println(data);
//		System.out.println(data.get("value"));//해당 url의 json 배열 값 가지기.
//		
//		// Map을 JSON String 으로 변환. 자바스크립트에 데이터 넘겨줄 때 유용.
//        System.out.println(mapper.writeValueAsString(data));
//        
//       //Map을 보기쉬운 JSON String 으로 변환
//       System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
		
		//model.addAttribute("storeInfos",data.getStoreInfos());
		//model.addAttribute("storeInfos",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
		String val = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.getStoreInfos());
		
		model.addAttribute("storeInfos", val);
		//파일로 변환.
		//mapper.writerWithDefaultPrettyPrinter().writeValue(new File("json.json"), data.get("value"));
		return "map";
	}
}
