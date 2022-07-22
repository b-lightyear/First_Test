package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.CommonUtil;

public class NoticeDownload implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt( request.getParameter("id") );
		NoticeDTO dto = new NoticeDAO().notice_detail(id);
		
		//다운로드 처리
		new CommonUtil().fileDownload(request, response, dto.getFilename(), dto.getFilepath());
		
	}

}