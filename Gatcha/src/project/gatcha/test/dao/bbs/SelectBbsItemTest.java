package project.gatcha.test.dao.bbs;

import org.apache.ibatis.session.SqlSession;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.model.Bbs;
//단일 항목 조회 Mybatis 테스트베드
public class SelectBbsItemTest {
	public static void main(String[] args) {
		
		/** (1) 데이터베이스 접속처리 */
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.jsp.myschool.dao.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		/** (2) 데이터 조회 기능 호출하기 */
		// 9901번 교수의 정보를 조회하기 위해서 조건값을 포함한 Beans를 준비한다.
		// --> import study.jsp.myschool.model.Bbs;
		Bbs bbs = new Bbs();
		bbs.setId(1);
		
		// 조회 결과가 저장될 Beans 선언하기
		Bbs item = null;
		
		try {
			// BbsMapper.selectBbsItem 기능을 호출한다.
			// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
			// 조회 결과가 단일행을 리턴하기 때문에 Beans객체 형태로 리턴된다
			item = sqlSession.selectOne("BbsMapper.selectBbs", bbs);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 조회에 실패했습니다.");
			return;
		} finally {
			// 데이터베이스 접속 해제하기
			// try~catch의 finally 블록은 catch에서의 리턴문보다 우선 실행된다.
			sqlSession.close();
		}
		
		/** (3) 조회 결과 출력하기 */
		System.out.println(item.toString());
	}
}
