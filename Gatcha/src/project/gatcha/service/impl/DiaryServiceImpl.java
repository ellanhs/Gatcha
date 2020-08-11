package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Diary;
import project.gatcha.service.DiaryService;


public class DiaryServiceImpl implements DiaryService  {
	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

		public DiaryServiceImpl(SqlSession sqlSession,Logger logger) {
			this.sqlSession = sqlSession;
			this.logger = logger;
		}

		public List<Diary> selectDiarylist(Diary diary) throws Exception {
			List<Diary> result = null;
			
			try {
				result = sqlSession.selectList("DiaryMapper.selectDiarylist", diary);
				if (result == null) {
					throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				throw new Exception("조회된 다이어리가 없습니다.");
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				throw new Exception("다이어리 조회에 실패했습니다.");
			}
			return result;
		}

		@Override
		public Diary selectDiaryOne(Diary diary) throws Exception {
			Diary result = null;
			
			try {
				result = sqlSession.selectOne("DiaryMapper.selectDiaryOne", diary);
				if (result == null) {
					throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				throw new Exception("조회된 다이어리가 없습니다.");
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				throw new Exception("다이어리 조회에 실패했습니다.");
			}
			return result;
		}

		@Override
		public Diary updateDiary(Diary diary) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		

}
