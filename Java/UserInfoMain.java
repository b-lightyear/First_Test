package pack05.ojdbc2;

import java.util.Scanner;

public class UserInfoMain {
	public static void main(String[] args) {
		//자바 코드로만 콘솔창에 다음과 같은 결과가값 뜨게 구현
		//메뉴보여주기 (1. 전체학생조회  2. 로그인 3. 회원가입  4. 종료 그 외에는 잘못된 입력)
		//로그인을 했을 때 로그인 완료 (회원정보 보기, 수정, 삭제)
		
		Scanner scn = new Scanner(System.in);
		
		StudentDAO stuDao = new StudentDAO();
		UserInfoDAO userDao = new UserInfoDAO();
		UserInfoDTO dto = null;
		UserInfoDTO upDto = null;
		
		while (true) {
			if (dto == null || dto.getUser_id() == null) {
				System.out.println("<메뉴>");
				System.out.println("1. 전체학생 조회 2. 로그인 3. 회원가입 4. 종료");
				System.out.println("------------------------------------------------------------");
				int inputMenu = Integer.parseInt(scn.nextLine());	//메소드로 숫자만 입력하게 바꾸기
				
				if (inputMenu == 1) {
					System.out.println("전체 학생 조회");
					stuDao.viewList(stuDao.getStudentList());
					
				}else if(inputMenu == 2) {
					System.out.println("로그인");
					System.out.println("아이디를 입력해주세요");	//inputType
					String id = scn.nextLine();
					System.out.println("비밀번호를 입력해주세요");	//input type = 'password'
					String pw = scn.nextLine();
					dto = userDao.loginUser(id, pw);	//회원 정보를 수정할 때 키(학생번호, 아이디)가 필요
					
				}else if (inputMenu == 3) {
					System.out.println("회원가입");
					UserInfoDTO joinDto = new UserInfoDTO();
					joinDto.setUser_id(userDao.rtnStrMsg(scn, "아이디를 입력하세요"));
					joinDto.setUser_pw(userDao.rtnStrMsg(scn, "비밀번호를 입력하세요"));
					joinDto.setLast_name(userDao.rtnStrMsg(scn, "성을 입력하세요"));
					joinDto.setFirst_name(userDao.rtnStrMsg(scn, "이름을 입력하세요"));
					dto = userDao.joinUser(joinDto);
					
				}else if (inputMenu == 4) {
					System.out.println("종료");
					break;
				}//if
				
			}else {
				System.out.println("로그인 성공!!");
				System.out.println("1.회원정보 보기 2.수정 3.삭제 4.로그아웃");
				int loginMenu = Integer.parseInt(scn.nextLine());
				
			
				//회원정보
				if(loginMenu == 1 ) {
					System.out.println("회원정보보기");
					if(upDto == null) {
						userDao.info(dto);
					}else {
						userDao.info(upDto);
					}//if
					
				//수정
				}else if(loginMenu == 2) {
					upDto = new UserInfoDTO();
					upDto.setUser_id(dto.getUser_id());
					upDto.setStudent_no(dto.getStudent_no());
					
					System.out.println("회원 정보를 수정합니다.");
					System.out.println("아무것도 입력하지 않으면 기존값을 유지합니다.");
					String user_pw = userDao.rtnStrMsg(scn, "새 비밀번호를 입력해주세요");
					if(user_pw.trim().length() == 0) {
						//항을 이용해서 if문을 만들지 않고 간단하게 조건 처리를 하는 로직
						upDto.setUser_pw(dto.getUser_pw());
					}else {
						upDto.setUser_pw(user_pw);
					}//if
					upDto.setLast_name(userDao.rtnStrMsg(scn, "수정하실 성을 입력하세요"));
					upDto.setFirst_name(userDao.rtnStrMsg(scn, "수정하실 이름을 입력하세요"));
					userDao.infoUpdate(upDto);
				
				//회원탈퇴
				}else if (loginMenu == 3) {
					//Upper : 대문자 아크키코드표 65, 128
					String flag = userDao.rtnStrMsg(scn, "정말 삭제하시겠습니까? Y.삭제, 그외입력 취소");
					if(flag.toUpperCase().equals("Y")) {
						
						if(userDao.quit(dto)) {
							dto = null;
						}//if
					}//if
				
				//로그아웃
				}else if (loginMenu == 4) {
					//로그아웃(web == session)
					//dto가 null또는 getid를 했을 때 id가 없다면 로그인 된 상태가 아니라고 판단함.
					dto = null;
					
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}//if
			}//if
				System.out.println("------------------------------------------------------------");
		}//while
		scn.close();
	}//main()
}//class
