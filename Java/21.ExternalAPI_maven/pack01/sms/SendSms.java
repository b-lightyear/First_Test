package pack01.sms;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SendSms {
	//한번 초기화해놓고 절대로 값이 변하면 안 됨 : final 키워드 쓰기
	//상수는 대문자로 바꿔준다
	static final String api_key = "NCSKPFGUHSRWW1RX";	//coolsms에서 받은 key와 secret을 각각 넣어 준다.
	static final String api_secret = "IZNYLMSIDWDJRTV0MUVZV4HIHBTFQBXX";
	
	public static void main(String[] args) {
		//https://console.coolsms.co.kr/ : API 연습용 300포인트를 줘서 문자보내기를 테스트 해 볼 수 있다.
		
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<>();	//API 서버에 요청할 정보를 보내기 위한 변수
		params.put("to", "010-dddd-dddd");
		params.put("from", "010-dddd-dddd");
		params.put("type", "SMS");	//SMS, LMS, MMS ...
		params.put("text", "존중하며 버티기");
		params.put("app_version", "JAVA SDK v1.2");
		
		//예외처리
		try {
			JSONObject obj = coolsms.send(params);
			System.out.println(obj.toJSONString());
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}//try
		
	}//main()
}//class