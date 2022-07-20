package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	private static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
		}//try
	}//static
	
	public List<CustomerDTO> list() {
		List<CustomerDTO> list = sql.selectList("cus.customerList");
		return list;
	}
	
	public int delete(String id) {
		int result = sql.delete("cus.delete", id);
		
		return result;
	}
	
}//class