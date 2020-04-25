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
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>	</head>
	<body> 
		<div id="map"></div>
	<% 
		String json = (String) request.getAttribute("storeInfos");
		request.getAttribute("storeInfos");
		
	%>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
 		var json = JSON.parse('${storeInfos}');
 		var jsonArray = JSON.parse(json);
 		
 		var markerArray = [];
 		var markerName = [];
 		var uluru = [];
 		
 		for(var i=0; i<jsonArray.length; i++) {
 			var jsArray = [];
 			jsArray[0] = jsonArray[i].addr;
 			jsArray[1] = jsonArray[i].lat;
 			jsArray[1] = jsonArray[i].lng;
 			jsArray[1] = jsonArray[i].name;
 			jsArray[1] = jsonArray[i].code;
 			jsArray[1] = jsonArray[i].type;
 			uluru.push({lat: jsArray[i].lat, lng: jsArray[i].lat});
 			markerArray.push(jsonArray[i].lat, jsonArray[i].lng);
 			markerName.push(jsonArray[i].name);
 		}
      	var map, infoWindow;
      	function initMap() {
    	
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 0, lng: 0},
          zoom: 8});
        
        var marker = new google.maps.Marker({position: markerArray, map: map, title: markerName});
        infoWindow = new google.maps.InfoWindow;
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
              var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
              };

              infoWindow.setPosition(pos);
              infoWindow.setContent('Location found.');
              infoWindow.open(map);
              map.setCenter(pos);
            }, function() {
              handleLocationError(true, infoWindow, map.getCenter());
            });
          } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
          }
      }
    </script>
    <script async defer
    	src="https://maps.googleapis.com/maps/api/js?key=key&callback=initMap">
	</script>
	</body> 
</html>