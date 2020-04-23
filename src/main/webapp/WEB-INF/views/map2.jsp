<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
		<div id="map_ma"></div>
			<script type="text/javascript">
				$(document).ready(function() {
				var myLatlng = new google.maps.LatLng(35.837143,128.558612); // 위치값 위도 경도
				var Y_point			= 35.837143;		// Y 좌표
				var X_point			= 128.558612;		// X 좌표
				var zoomLevel		= 18;				// 지도의 확대 레벨 : 숫자가 클수록 확대정도가 큼
				var markerTitle		= "대구광역시";		// 현재 위치 마커에 마우스를 오버을때 나타나는 정보
				var markerMaxWidth	= 300;				// 마커를 클릭했을때 나타나는 말풍선의 최대 크기
			
				var contentString	= '<div>' +
				'<h2>대구남구</h2>'+
				'<p>안녕하세요. 구글지도입니다.</p>' +
				
				'</div>';
				var myLatlng = new google.maps.LatLng(Y_point, X_point);
				var mapOptions = {
									zoom: zoomLevel,
									center: myLatlng,
									mapTypeId: google.maps.MapTypeId.ROADMAP
								}
				var map = new google.maps.Map(document.getElementById('map_ma'), mapOptions);
				var marker = new google.maps.Marker({
														position: myLatlng,
														map: map,
														title: markerTitle
				});
				var infowindow = new google.maps.InfoWindow(
															{
																content: contentString,
																maxWizzzdth: markerMaxWidth
															}
						);
				google.maps.event.addListener(marker, 'click', function() {
					infowindow.open(map, marker);
				});
			});
		</script>
	</body> 
</html>