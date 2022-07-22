package notice;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtil;

public class NoticeInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//첨부파일 업로드
		HashMap<String, String> map = new CommonUtil().fileUpload(request, "notice");
		
		//화면에서 입력한 정보를 DB에 신규 저장(비즈니스 로직(커맨드처리))
		NoticeDTO dto = new NoticeDTO();
		dto.setFilename( map.get("filename") );
		dto.setFilepath( map.get("filepath") );
		dto.setWriter( request.getParameter("writer") );
		dto.setTitle( request.getParameter("title") );
		dto.setContent( request.getParameter("content") );
		
		//DB연결
		new NoticeDAO().notice_insert(dto);
		
	}//service
}//class