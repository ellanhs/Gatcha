package project.gatcha.controller.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.helper.BaseController;
import project.gatcha.helper.RegexHelper;
import project.gatcha.helper.UploadHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Member;
import project.gatcha.service.MemberService;
import project.gatcha.service.impl.MemberServiceImpl;

@WebServlet("/member/edit_ok.do")
public class EditOk extends BaseController {
	private static final long serialVersionUID = 6105880445587447360L;

	/** (1) 사용하고자 하는 Helper + Service 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import project.gatcha.helper.WebHelper;
	WebHelper web;
	// --> import project.gatcha.helper.RegexHelper;
	RegexHelper regex;
	// --> import project.gatcha.helper.UploadHelper;
	UploadHelper upload;
	// --> import project.gatcha.service.MemberService;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import project.gatcha.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		upload = UploadHelper.getInstance();
		// 회원가입 처리를 위한 Service객체
		// --> import project.gatcha.service.impl.MemberServiceImpl;
		memberService = new MemberServiceImpl(sqlSession, logger);

		/** (3) 로그인 여부 검사 */
		Member loginInfo = (Member) web.getSession("loginInfo");
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}

		/** (4) 파일이 포함된 POST 파라미터 받기 */
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}

		// UploadHelper에서 텍스트 형식의 파라미터를 분류한 Map을 리턴받아서 값을 추출한다.
		Map<String, String> paramMap = upload.getParamMap();
		String nickname = paramMap.get("nickname");
		String email = paramMap.get("email");
		String userPw = paramMap.get("userPw");
		String newUserPw = paramMap.get("newUserPw");
		String newUserPwRe = paramMap.get("newUserPwRe");
		String gender = paramMap.get("gender");
		String birthdate = paramMap.get("birthdate");
		String editDate = paramMap.get("editDate");


		// 전달받은 파라미터는 값의 정상여부 확인을 위해서 로그로 확인
		logger.debug("nickname=" + nickname);
		logger.debug("email=" + email);
		logger.debug("userPw=" + userPw);
		logger.debug("newUserPw=" + newUserPw);
		logger.debug("newUserPwRe=" + newUserPwRe);
		logger.debug("birthdate=" + birthdate);

		/** (5) 입력값의 유효성 검사 (아이디 검사 수행안함) */
		// 현재 비밀번호 검사
		if (!regex.isValue(userPw)) {
			sqlSession.close();
			web.redirect(null, "현재 비밀번호를 입력하세요.");
			return null;
		}
		
		// 신규 비밀번호 검사
		// --> 신규 비밀번호가 입력된 경우는 변경으로 간주하고, 입력하지 않은 경우는
		//     변경하지 않도록 처리한다. 그러므로 입력된 경우만 검사해야 한다.
		if (regex.isValue(newUserPw)) {
			if (!regex.isEngNum(newUserPw) || newUserPw.length() > 20) {
				sqlSession.close();
				web.redirect(null, "새로운 비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
				return null;
			}
		// 비밀번호 확인
		if (!newUserPw.equals(newUserPwRe)) {
		sqlSession.close();
				web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
					return null;
			}
		}
			// 닉네임 검사
			if (!regex.isValue(nickname)) {
				sqlSession.close();
				web.redirect(null, "닉네임을 입력하세요.");
				return null;
			}


			if (nickname.length() < 2 || nickname.length() > 8) {
				sqlSession.close();
				web.redirect(null, "닉네임은 2~8글자 까지만 가능합니다.");
				return null;
			}

		
			// 성별검사
			if (!regex.isValue(gender)) {
				sqlSession.close();
				web.redirect(null, "성별을 입력하세요.");
				return null;
			}

			if (!gender.equals("M") && !gender.equals("F")) {
				sqlSession.close();
				web.redirect(null, "성별이 잘못되었습니다.");
				return null;
			}

		
		/** (8) 전달받은 파라미터를 Beans 객체에 담는다. */
		//  아이디는 변경할 수 없으므로 제외한다.
		Member member = new Member();
		// WHERE절에 사용할 회원번호는 세션에서 취득
		member.setId(loginInfo.getId());
		member.setEmail(email);
		member.setNickname(nickname);
		member.setUserPw(userPw);
		member.setGender(gender);
		member.setBirthdate(birthdate);
		member.setEditDate(editDate);
		// 변경할 신규 비밀번호
		member.setNewUserPw(newUserPw);
		
		

		/** (9) Service를 통한 데이터베이스 저장 처리 */
		// 변경된 정보를 저장하기 위한 객체
		Member editInfo = null;
		try {
			memberService.selectMemberPasswordCount(member);
			memberService.updateMember(member);
			editInfo = memberService.selectMember(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}


		// 세션을 갱신한다.
		web.removeSession("loginInfo");
		web.setSession("loginInfo", editInfo);

		/** (11) 수정이 완료되었으므로 다시 수정페이지로 이동 */
		web.redirect(web.getRootPath() + "/member/edit.do", 
				"회원정보가 수정되었습니다.");

		
		// INSERT,UPDATE,DELETE 처리를 수행하는 action 페이지들은 자체적으로 View를
		// 갖지 않고 결과를 확인할 수 있는 다른 페이지로 강제 이동시켜야 한다. 
		// 그러므로 View의 경로를 리턴하지 않는다.(중복실행 방지)
		return null;
	}

}
