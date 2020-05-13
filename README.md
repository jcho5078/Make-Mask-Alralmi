# Mask-Alralmi-Clone
## 마스크 알리미 만들기.

공공데이터를 활용한 마스크알리미 클론 작업입니다.
구글 지도 api를 사용하여 마스크 판매점들을 표시하는 기능을 가지고 있습니다.<br>
JSON데이터는 Jackson을 사용하여 처리하였습니다.

코드 곳곳에 주석 처리를 해놓았으니, SpringBoot경험이 없으신분들도 적은 수고로도 코드 파악에 무리없을거라 생각합니다.

### 개발환경

* IDE : STS 4.6.0
* OS : Windows
* SpringBoot 2.2.6
* Java8
* Maven

[Postman](https://www.postman.com/) 을 사용하면 공공데이터 같은 큰 데이터 사용을 테스트하는데 편리하더군요.

### 구동 화면

index.html 화면에서 해당 초라한 버튼을 누르면 현재 사용자 위치에 기반으로 마스크 판매점 위치가 나타납니다.
![시작 화면](https://user-images.githubusercontent.com/60742556/80295047-344ef000-87aa-11ea-80e7-ede9d6313098.PNG)
구글 지도에 마스크 판매점 위치에 마커 표시.

해당 마커를 클릭하면 판매점 이름이 나옵니다.

마스크 재고는 기입하지 않았습니다.

추가하고싶으신 부분은 pullrequest 언제든지 해주세요.

![구동1](https://user-images.githubusercontent.com/60742556/80295055-4b8ddd80-87aa-11ea-84c3-7b7bef539049.PNG)
![구동2](https://user-images.githubusercontent.com/60742556/80295057-50eb2800-87aa-11ea-8249-22dde1f79791.PNG)
![구동3](https://user-images.githubusercontent.com/60742556/80295058-521c5500-87aa-11ea-9a85-8dcd0feda600.PNG)
