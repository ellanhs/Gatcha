package project.gatcha.controller.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.gatcha.helper.BaseController;
import project.gatcha.helper.WebHelper;




@WebServlet("/bbs/document_write.do")
public class DocumentWrite extends BaseController {

	private static final long serialVersionUID = -6403818664938758784L;
	
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;


	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		web = WebHelper.getInstance(request, response);

		/** (3) 로그인 여부 검사 */
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}


		
		return "bbs/write";
	}

}
