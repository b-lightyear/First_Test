package pack04.objbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex01_Test {
	//OJDBC(Oracle ↔ JAVA DataBase Java Connection) : 연결
	//DAO, DTO 활용
	//Connection : 연결로를 만드는 객체(연결 객체)
	//PreparedStatement : 어떤 데이터를 전송하기 위한 객체 (연결된 연결객체를 통해서 전송함)
	//ResultSet : 전송하고나서 응답을 받으면 그 결과를 담는 객체 (결과 객체)
	
	public static void main(String[] args) {
		Ex01_Test et = new Ex01_Test();
		et.connTest();
		et.connTest2();
		et.connTest3();
	}//main()
	
	//Connection 연결 객체 사용해서 통신 되는지 체크
	public boolean connTest () {	//url, user, password, Ojdbc Class(동적로딩 = 자주 안 씀)
		
		//oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//필요한 드라이버를 동적으로 로딩함
			Connection conn = DriverManager.getConnection(url, user, password);
			if (conn.isClosed()) {	//is : boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				PreparedStatement ps = conn.prepareStatement("select 1 num from dual");		//세미콜론은 생략하기
				ps.executeQuery();
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getInt("num"));	//안전한 방법
					//System.out.println(rs.getInt(1));		//위험한 방법 : 
				}//while
				
				conn.close(); 	//통신을 닫음 (동시에 접속할 수 있는 숫자가 정해져있다.)
				if(conn.isClosed())
					System.out.println("닫힘(내가 닫음)");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		
		return false;
		
	}//connTest()
	
	
	//Connection 연결 객체 사용해서 통신 되는지 체크
	public boolean connTest2 () {	//url, user, password, Ojdbc Class(동적로딩 = 자주 안 씀)
			
			//oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//필요한 드라이버를 동적으로 로딩함
			Connection conn = DriverManager.getConnection(url, user, password);
			if (conn.isClosed()) {	//is : boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				PreparedStatement ps = conn.prepareStatement("select'SHS' name from dual");		//세미콜론은 생략하기
				ps.executeQuery();
				ResultSet rs = ps.executeQuery();
					
				while(rs.next()) {
					System.out.println(rs.getString("name"));	//안전한 방법
					System.out.println(rs.getString(1));		//위험한 방법 : 
				}//while
				
				conn.close(); 	//통신을 닫음 (동시에 접속할 수 있는 숫자가 정해져있다.)
				if(conn.isClosed())
					System.out.println("닫힘(내가 닫음)");
				}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
			
		return false;
		
	}//connTest2()
		
	//Connection 연결 객체 사용해서 통신 되는지 체크
	public boolean connTest3 () {	//url, user, password, Ojdbc Class(동적로딩 = 자주 안 씀)
					
		//oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
				
		Scanner scn = new Scanner(System.in);
		System.out.print("SQL문을 입력하세요 : ");
		String name = scn.nextLine();
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//필요한 드라이버를 동적으로 로딩함
			Connection conn = DriverManager.getConnection(url, user, password);
			if (conn.isClosed()) {	//is : boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				PreparedStatement ps = conn.prepareStatement("select '" + name + "' as Result from dual");		//세미콜론은 생략하기
				ps.executeQuery();
				ResultSet rs = ps.executeQuery();
						
				while(rs.next()) {
					System.out.println(rs.getString("Result"));	//안전한 방법
					System.out.println(rs.getString(1));		//위험한 방법 : 
				}//while
								
				conn.close(); 	//통신을 닫음 (동시에 접속할 수 있는 숫자가 정해져있다.)
				if(conn.isClosed())
					System.out.println("닫힘(내가 닫음)");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
				
		scn.close();
		return false;
					
	}//connTest()
}//class