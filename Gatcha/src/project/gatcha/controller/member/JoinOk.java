package project.gatcha.controller.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.gatcha.helper.BaseController;
import project.gatcha.helper.FileInfo;
import project.gatcha.helper.RegexHelper;
import project.gatcha.helper.UploadHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.model.Member;
import project.gatcha.service.MemberService;
import project.gatcha.service.impl.MemberServiceImpl;

@WebServlet("/member/join_ok.do")
public class JoinOk extends BaseController {
	private static final long serialVersionUID = -5017670312983929539L;
	
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
	// --> import project.gatcha.mysite.service.MemberService;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import project.gatcha.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		upload = UploadHelper.getInstance();
		// 회원가입 처리를 위한 Service객체
		// --> import project.gatcha.mysite.service.impl.MemberServiceImpl;
		memberService = new MemberServiceImpl(sqlSession, logger);

		/** (3) 로그인 여부 검사 */
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") != null) {
			// 이미 SqlSession 객체를 생성했으므로, 데이터베이스 접속을 해제해야 한다.
			sqlSession.close();
			web.redirect(web.getRootPath() + "/main.do", "이미 로그인 하셨습니다.");
			return null;
		}

		/** (4) POST 파라미터 받기 */
		String nickname = web.getString("nickname");
		String email = web.getString("email");
		String userPw = web.getString("userPw");
		String birthdate = web.getString("birthdate");
		String gender = web.getString("gender");
		String[] gn=web.getStringArray("genre",new String[0] );
		int[] genres= new int[gn.length];
		if(gn.length>0){
		for(int i=0;i<gn.length;i++){
		genres[i] = Integer.parseInt( gn[i] );
		}
		}
		// 전달받은 파라미터는 값의 정상여부 확인을 위해서 로그로 확인
		logger.debug("nickname=" + nickname);
		logger.debug("email=" + email);
		logger.debug("userPw=" + userPw);
		logger.debug("birthdate=" + birthdate);
		logger.debug("gender=" + gender);

		/** (5) 입력값의 유효성 검사 */
		// 아이디 검사
		if (!regex.isValue(nickname)) {
			sqlSession.close();
			web.redirect(null, "닉네임을 입력하세요.");
			return null;
		}
		if (nickname.length() > 16) {
			sqlSession.close();
			web.redirect(null, "닉네임은 숫자와 영문의 조합으로 16자까지만 가능합니다.");
			return null;
		}
		// 이메일 검사
		if (!regex.isValue(email)) {
			sqlSession.close();
			web.redirect(null, "이메일을 입력하세요.");
			return null;
		}
		if (!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일의 형식이 잘못되었습니다.");
			return null;
		}
		// 비밀번호 검사
		if (!regex.isValue(userPw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력하세요.");
			return null;
		}
		if (!regex.isEngNum(userPw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}
		if (userPw.length() > 20) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자까지만 가능합니다.");
			return null;
		}
		// 비밀번호 확인
		if (!userPw.equals(userPw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
			return null;
		}
		// 생년월일 검사
		if (!regex.isValue(birthdate)) {
			sqlSession.close();
			web.redirect(null, "생년월일을 입력하세요.");
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
		// 선호 영화 장르 검사
		if (genres.length==0) {
			sqlSession.close();
			web.redirect(null, "선호장르 선택은1개이상 3개 이하입니다.");
			return null;
			}
		if (genres.length !=0) {
			if(genres.length>3){
			sqlSession.close();
			web.redirect(null, "선호장르 선택은1개이상 3개 이하입니다.");
			return null;
			}
		}
		/** (7) 전달받은 파라미터를 Beans 객체에 담는다. */
		Member member = new Member();
		member.setNickname(nickname);
		member.setEmail(email);
		member.setUserPw(userPw);
		member.setGender(gender);
		member.setBirthdate(birthdate);
		/** (8) Service를 통한 데이터베이스 저장 처리 */
 	    try {
			memberService.insertMember(member);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			// 예외가 발생한 경우이므로, 더이상 진행하지 않는다.
			return null;
		  }
 	    
 	    int id = member.getId();
 	    System.out.println("---------아이디값------"+id+"-이다---------------");
 	    for(int i=0;i<genres.length;i++){
 		try {
 			int genre=genres[i];
 			member.setId(id);
 			member.setGenre(genre); 			
			memberService.insertMemberHasGenre(member);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			// 예외가 발생한 경우이므로, 더이상 진행하지 않는다.
			return null;
		  }
 	    }
 	    
		/** (9) 가입이 완료되었으므로 메인페이지로 이동 */
		sqlSession.close();
		web.redirect(web.getRootPath() + "/index.do", "회원가입이 완료되었습니다. 로그인 해 주세요.");

		// INSERT,UPDATE,DELETE 처리를 수행하는 action 페이지들은
		// 자체적으로 View를 갖지 않고 결과를 확인할 수 있는
		// 다른 페이지로 강제 이동시켜야 한다. (중복실행 방지)
		// 그러므로 View의 경로를 리턴하지 않는다.
		return null;
	}

}
