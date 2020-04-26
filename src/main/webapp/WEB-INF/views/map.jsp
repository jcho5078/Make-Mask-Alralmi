<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@page import="org.json.simple.JSONArray"
		import="com.fasterxml.jackson.databind.ObjectMapper" %>
<html> 
	<head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the Window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>	</head>
	<body> 
		<div id="map"></div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
	
 		var json = JSON.parse('${storeInfos}');//json 데이터를 받아오면 구조상 객체로 받아들이기에 파싱해줘야 요소 접근 가능. 
 		
      	var map, infoWindow;
      	
      	function initMap(){
      	infoWindow = new google.maps.InfoWindow;
      	
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 0, lng: 0},
          zoom: 12});
		
        var marker;
        for(var i=0; i<json.length; i++){
        	marker = new google.maps.Marker({
                position: new google.maps.LatLng(json[i].lat, json[i].lng),
                map: map
            });
        	google.maps.event.addListener(marker, 'click', (function(marker, i) {
                return function() {
                  infoWindow.setContent(json[i].name);
                  infoWindow.open(map, marker);
                }
            })(marker, i));
        }
        
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
              var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
              };

              infoWindow.setPosition(pos);
              infoWindow.setContent('나의 위치.');
              infoWindow.open(map);
              map.setCenter(pos);
            }, function() {
              handleLocationError(true, infoWindow, map.getCenter());
            });
          } else {
            // 브라우저가 구글지도api 지원 안할시.
            handleLocationError(false, infoWindow, map.getCenter());
          }
      }
    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=API키 입력&callback=initMap">
	</script>
	</body> 
</html>