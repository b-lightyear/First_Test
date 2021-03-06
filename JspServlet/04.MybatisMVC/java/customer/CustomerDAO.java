package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	//JDBC api(lib)사용해서 Connection 초기화, statement(전송)초기화 쿼리 넣기 => 전송 => resultset(결과), int(결과)
	
	//Mybatis(이용, 관리, 가독성 등등의 장점을 추가한 api)
	//환경설정이 좀 까다롭다는 단점이 있다.
	//xml 파일로 환경설정, string sql x => xml mapper라는 쿼리의 집합 파일을 만들어서 관리 *****
	//자바 파일이나 여러가지 방식으로 환경 설정을 할 수가 있으나 제일 간단한 방법은 xml(선생님 생각에)이용
	
	//환경설정
	//1.maven에서 해당하는 api를 프로젝트에 넣어주기(jar) pom.xml 사용
		//*프로젝트에 JDBC(ojdbc11)sms 반드시 있어야 함*
	//2.mybatis 
	
	private static SqlSession sql;	//전송 결과 처리를 하는 객체(sqlSessinoFactiory를 이용해서 초기화
	
	static {
		try {
			String resource = "mybatis/config.xml";	//mybatis dtd 설정이 들어있는 파일(이 파일을 이용해서 환결설정을 로딩
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession();
		} catch (IOException e) {
		}//try
	}//static
	
	public void test() { //sql.selectOne("mapperNamespace.sql(id)")
		int result = sql.selectOne("test.selectTest"); //목록이 아니라 데이터 베이스 조회햇을 때 행의 갯수가 1개인 것 조회
		System.out.println(result);
	}//test()
	
	public List<CustomerDTO> getList() {
		//sql.update, sap.delete, sal.selectone, selectlist(return타입이 list)
		List<CustomerDTO> list = sql.selectList("cus.listSelect");
		//System.out.println(list.size());
		return list;
	}//getList()

	public int insert(CustomerDTO dto) {
		//sql mqpper에 파라매터(사용할 변수)를 보내는 방법, 하나마 넘길 수 있다. string, hashmap, arraylist 모두 하나로 인식
		int result = sql.insert("cus.insert", dto);
		sql.commit(); //mybatis는 오토커밋이 불가능하다. 속성의 기본값이 false라서
		
		return result;
	}//insert()
	
	public int update(CustomerDTO dto) {
		int result = sql.update("cus.update", dto);
		sql.commit();
		return result;
	}//update()
	
}//class