package project.gatcha.test.dao.bbs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.model.Bbs;
import project.gatcha.service.BbsService;
import project.gatcha.service.impl.BbsServiceImpl;
//목록 조회 ServiceLayer 테스트베드
public class SelectBbsListServiceTest {
	public static void main(String[] args) {
		
		/**처리 결과를 기록할 Log4J 객체 생성*/
		
		// 파라미터는 현재 클래스의 이름(String)
		//-->import org.apache.logging.log4j.LogManager;
		//-->import org.apache.logging.log4j.Logger;
		Logger logger= LogManager.getFormatterLogger(SelectBbsListServiceTest.class.getName());
		

		
		/**데이터 베이스 접속*/
		//-->import org.apache.ibatis.session.SqlSession;
		SqlSession sqlSession=MyBatisConnectionFactory.getSqlSession();
		
		/**데이터 처리 수행*/
		//비지니스 로직을 위한 Service 객체 생성
		//import study.java.myschool.service.BbsService;
		//import study.java.myschool.service.impl.BbsServiceImpl;
		BbsService bbsService =new BbsServiceImpl(sqlSession, logger);
		// 조회 결과가 저장될 Beans 객체
		List<Bbs> list=null;
		
		
		try {
			//게시물 조회하기
			list=bbsService.selectBbsList(null);
			//처리 결과를 로그에 기록하기
			for(int i=0; i<list.size();i++){
			logger.debug("조회된 데이터>> "+list.get(i).toString());
			}
		} catch (Exception e) {
			//사실상 에러메시지는 이미 ServiceImpl 내에서 하고 여기서는 원래 page전환만 하면 되지만 catch error문으로 대신함
			logger.error("데이터 조회에 실패했습니다." +e.getMessage());
		}
		
		
		/**데이터베이스 접속 해제*/
		sqlSession.close();
		
	}
}
