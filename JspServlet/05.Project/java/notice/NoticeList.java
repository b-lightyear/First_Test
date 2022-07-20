package notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;


public class NoticeList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 공지글 목록을 조회해와야 목룍화면에 출력할 수 있도록 할 수 있다.
		//request에 데이터를 담는다 => 비즈니스 로직
		List<NoticeDTO> list = new NoticeDAO().notice_list();
		
		request.setAttribute("list", list);
		
		
		
		
	}

}
