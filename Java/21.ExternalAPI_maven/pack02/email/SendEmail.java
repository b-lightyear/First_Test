package pack02.email;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	int aa = 0;
	public static void main(String[] args) {
		//1. 라이브러리(API) : maven repository에서 대부분 가져옴
		//경우에 따라서 kakao의 경우 별도의 콘솔을 제공한다.
		//org.apache,commons email 사용 → SMTP(네이버 메일 서버)를 이용해서 자바코듣로 이메일을 보낼 수 있는 API
		System.out.println("aa");
		
		//SendEmail email = new SendEmail();
		//email.SendSimple();
		
		//SendAttach();
		
		sendHtml();
		
	}//main()
	
	
	//메일 종류 : 파일 첨부 메일, HTML 메일, 그냥 이메일 등 종류 많음
	/*
	private void SendSimple() {
		SimpleEmail mail = new SimpleEmail();	//문자열만 보내는 이메일 형태의 객체를 초기화
		
		mail.setHostName("smtp.naver.com"); //어떤 서비스의 SMTP를 빌려서 사용할 건지 써야 함.
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		mail.setAuthentication("blindspot_", "gksthf4257@");
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("blindspot_@naver.com", "한솔");	//보내는 사람
			
			mail.addTo("blindspot_@naver.com", "한솔");		//받는 사람, 여러번 쓰면 여러명에게 감
			mail.addTo("youngmoon525@naver.com", "한솔");
			
			mail.setSubject("회원가입 ㅊㅋ");
			mail.setMsg("암튼 축하 완전 축하");
			
			mail.send(); //실행
		} catch (EmailException e) {
			e.printStackTrace();
		}//try
	}//SendSimple() */
	
	/*
	private static void SendAttach() { 
		MultiPartEmail mail = new MultiPartEmail();	//Multipart형태로 파일첨부도 가능한 이메일
		
		mail.setHostName("smtp.naver.com"); //어떤 서비스의 SMTP를 빌려서 사용할 건지 써야 함.
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		mail.setAuthentication("blindspot_", "gksthf4257@");
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("blindspot_@naver.com", "한솔");	//보내는 사람
			
			mail.addTo("blindspot_@naver.com", "한솔");		//받는 사람, 여러번 쓰면 여러명에게 감
			//mail.addTo("youngmoon525@naver.com", "한솔");
			
			mail.setSubject("안녕하세용");
			mail.setMsg("우와");
			
			//파일 첨부
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Study_Java\\workspace\\21.ExternalAPI_maven\\src\\pack02\\email\\s.jpg");
			mail.attach(file);
			
			try {
				file.setURL(new URL("https://mblogthumb-phinf.pstatic.net/MjAyMDAzMTNfMjA2/MDAxNTg0MDI3MzA1MTM1.ziQdHXjoSVpswgl7MkBXPOamMHIiKQKPpqjtQNkw6IMg.rkebY82ViYlYz83X1y5B7Fm6qyQkC2ZZlmHgRyJw1vAg.JPEG.d_hye97/1.jpg?type=w800"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}//try
			
			mail.attach(file);
			mail.send(); //실행
		} catch (EmailException e) {
			e.printStackTrace();
		}//try
	}//SendAttach() */
	
	
	private static void sendHtml() {	//메소드 복붙하고 sendHtml로 바꾸기
		HtmlEmail mail = new HtmlEmail();	//문자열만 보내는 이메일 형태의 객체를 초기화
		
		mail.setHostName("smtp.naver.com"); //어떤 서비스의 SMTP를 빌려서 사용할 건지 써야 함.
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		mail.setAuthentication("blindspot_", "dddd");
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("blindspot_@naver.com", "한솔");	//보내는 사람
			
			mail.addTo("blindspot_@naver.com", "한솔");		//받는 사람, 여러번 쓰면 여러명에게 감
			//mail.addTo("youngmoon525@naver.com", "한솔");
			
			mail.setSubject("메일 보내는중");
			StringBuffer msg = new StringBuffer();
			msg.append("<html> <head>");
			msg.append("<style type=\"text/css\"> body { color:green; text-shadow: 3px 3px 3px gray; } </style></head>");
			msg.append("<body>");
			msg.append("<font color: blue>");
			msg.append("😎✨😜🤭 이건 에이태그입니다 😎✨😜🤭");
			msg.append("</body>");
			msg.append("</html>");
			
			mail.setMsg(msg.toString());
			
			mail.send(); //실행
		} catch (EmailException e) {
			e.printStackTrace();
		}//try
	}//sendHtml()
	
	
}//class