package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class commonDAO {
	public static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true); //AutoCommit을 true로 줌
		} catch (IOException e) {
		}//try
	}//static
		
	public void test() {
		int result = sql.selectOne("test.selectOne");
		System.out.println(result);
		//return result;
	}
	
}//class