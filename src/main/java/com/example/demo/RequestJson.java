package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
@Controller
public class RequestJson {
	@RequestMapping(value = "/map")
	public String request(Model model) throws Exception {
		String urlstr = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=6&perPage=5000";
		
		String line = "";
		String res = "";
		
		String addr = null;
		double lat;
		double lng;
		String name = null;
		
		String pluspage = "page=";
		String pluspr = "&perPage=5000";
//		for(int i=1; i<=6; i++) {
//			urlstr = urlstr + pluspage + i + pluspr;
//		}
		try{
			URL url = new URL(urlstr);
			BufferedReader bf = null;
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");//GET방식으로 json인자 받아옴
			bf = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			//utf-8 인코딩으로 해당 url읽기
			//JsonParser parser = new JsonParser();이거이용
			JsonList jsonList = new JsonList();
			while((line = bf.readLine()) != null) {
                res = res + line + "\n";
                //System.out.println(line);
            }//json값 한 라인씩 받아오기
			jsonList.test(res);
			//JsonList jsonList = new JsonList();
			//jsonList.test(lineadd);
			
			model.addAttribute("","");
		}catch (Exception e){
		     e.printStackTrace();
		     throw e;
		}
		
		return "map";
	}
}

