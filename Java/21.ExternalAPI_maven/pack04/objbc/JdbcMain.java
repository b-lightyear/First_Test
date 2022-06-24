package pack04.objbc;

public class JdbcMain {
	public static void main(String[] args) {
		
		JdbcDAO dao = new JdbcDAO();
		//dao.getInt();
		
		System.out.println(dao.getInfo());
		System.out.println("==========");
		System.out.println(dao.getAll());		
				
		
		//------------------------------------------------------------------------------------
		//CRUD(Create Read Update Delete) = Insert, Select, Upate, Delete의 기능 수행
		//새글쓰기, 조회하기, 수정, 삭제 등
		//dao.insertUser();
		dao.updateUser();
		
	}//main()	
}//JdbcMain()