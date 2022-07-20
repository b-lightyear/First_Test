package department;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import employees.EmployeeDAO;

public class DepartmentDAO {
private static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/list-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
		}//try
	}//static
	
	public List<DepartmentDTO> list() {
		List<DepartmentDTO> list = sql.selectList("dept.deptList");
		return list;
	}
}
