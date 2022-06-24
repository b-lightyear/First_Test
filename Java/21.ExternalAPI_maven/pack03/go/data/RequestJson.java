package pack03.go.data;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;

public class RequestJson {
	//Request URL : Request(요청). 크롬 혹은 다른 웹 브라우저 사용.
	//주소창에 어떤 주소값을 넣고(ex. www.naver.com) 엔터 키
	//또는 네이버에서 어떤 기사를 클릭(a tag 등을 통해서 URL 요청)
	//Response : 응답 (지금 몰라도 되지만 한 번 들어놓으면 좋음)
	
	public static void main(String[] args) {
		
		//공공데이터를 실제로 요청하기 위한 URL
		//링크 속 ? 뒤에 넘겨줘야 할 변수들(Parametter (ex. 현. page, perPage, ServiceLey))
		String url = "https://api.odcloud.kr/api/3082925/v1/uddi:7c291067-a956-4811-a9ec-942b6979ff77_201709270816";
		
		//JAVA에서 Https, Http로 된 인터넷으로 요청을 보내고 응답을 받아오기 ▶ Jsoup을 이용
		String doc = null;
		try {
			doc = Jsoup.connect(url)
			.data("page", "1")	//String만 가능함
			.data("perPage", "10")
			.data("serviceKey", "/sAzChyHtVR0zj/F/WFlxSbdZT9+7kQ+oEMgKXscLJJvK3tLCZW4iEuMZZjA8nSU4v3rU8ApWqsO35bdXR2iug==")
			.timeout(5000) 		//★ timeout(0) : 어떤 요청을 했을 때, 요청을 받은 서버가 일정시간 응답을 하지 않으면
								//				  요청한 쪽에서 통신을 끊고 다음 처리를 한다.(Read timed out 예외) (1000 = 1초)
			.userAgent("Chrome")
			.ignoreContentType(true)
			.execute()
			.body();
		} catch (IOException e) {
			e.printStackTrace();
		}//try
		
		//System.out.println(doc);
		
		//ArrayList로 바꾸기 doc
		//하나씩 출력하기
	
		/* public class 1 {
			public class currentCount{
				
			}
		} */
		
		//JSONParser : API 어떤 데이터 종류를 Json 형태로 바꿔주는
		//API => 나중에는 Gson 사용할 거임
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject) jsonParser.parse(doc);
			//System.out.println(jsonObj.toString());
			
			JSONArray dataArray = (JSONArray) jsonObj.get("data");	//Object
			for (int i = 0; i < dataArray.size(); i++) {
				JSONObject obj = (JSONObject) dataArray.get(i);
				System.out.print(obj.get("상 호")+ " / ");
				System.out.print(obj.get("소재지")+ " / ");
				System.out.print(obj.get("연락처")+ " / ");
				System.out.print(obj.get("연번")+ " / ");
				System.out.print(obj.get("주메뉴") + "\n");
				//JsonArray <= Elements <= JsonObject
			}//for
			String test = jsonObj.get("") +"";
			//System.out.println(test);
			
			
			/*
			Object obj = new ArrayList<String>();
			obj = 1;
			obj = 123.124;
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try
	}//main()
}//class