package notice;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtil;

public class NoticeUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//원래 첨부된 파일정보를 DB에서 조회
		Integer id = Integer.valueOf(request.getParameter("id") ); //parseInt는 타입이 int, valuseOf는 타입이 Integer
		String filename = request.getParameter("filename");
		
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO notice = dao.notice_detail(id);
		
		HashMap<String, String> map = new CommonUtil().fileUpload(request, "notice");
		
		String filepath = request.getServletContext().getRealPath("/"+ notice.getFilepath() );
		
		
		//화면에서 변경입력한 정보를 DB에 변경저장 : 비지니스로직
		//화면에서 변경입력한 정보를 수집한다.
		NoticeDTO dto = new NoticeDTO();
		dto.setId( id );
		dto.setTitle( request.getParameter("title"));
		dto.setContent( request.getParameter("content") );
	
		//파일을 첨부하지 않은 경우
		if(map.isEmpty()) {
			//원래 없었던 경우
			if(filename.isEmpty()) {
				//원래 있었는데 삭제한 경우
				if(notice.getFilename()!=null) {
					//서버에 물리적으로 존재하는 파일을 삭제
					File file = new File(filepath);
					if(file.exists()) file.delete();
				}				
			}else {
			//원래 있던 첨부파일을 그대로 사용하는 경우
				dto.setFilename(notice.getFilename());
				dto.setFilepath(notice.getFilepath());
				
			}
			
		//파일을 첨부한 경우
		}else {
			//원래 없었는데 신규 첨부
			dto.setFilename(map.get("filename"));
			dto.setFilepath(map.get("filepath"));
		
			//원래 첨부된 파일이 있었는데 바꿔 첨부
			//서버에 물리적으로 존재하는 파일을 삭제
			if(notice.getFilename() != null) {
				File file = new File(filepath);
				if(file.exists()) file.delete();
			}
		}
		
	
		dao.notice_update(dto);		
	}//execute()
}//class