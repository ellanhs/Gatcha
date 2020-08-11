package project.gatcha.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.helper.BaseController;
import project.gatcha.helper.WebHelper;


@WebServlet("/index.do")
public class Index extends BaseController {

	private static final long serialVersionUID = 2235516610603393120L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,
			IOException {

		//  View 사용한다.
		return "index";
	}
}
