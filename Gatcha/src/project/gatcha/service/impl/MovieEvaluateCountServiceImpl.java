package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.MovieEvaluateCount;
import project.gatcha.service.MovieEvaluateCountService;

public class MovieEvaluateCountServiceImpl implements MovieEvaluateCountService  {
	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

		public MovieEvaluateCountServiceImpl(SqlSession sqlSession,Logger logger) {
			this.sqlSession = sqlSession;
			this.logger = logger;
		}

		@Override
		public List<MovieEvaluateCount> selectMovieEvaluateCountList(MovieEvaluateCount movieEvaluateCount) throws Exception {
			List<MovieEvaluateCount> result = null;
			
			try{
				result = sqlSession.selectList("MovieEvaluateCountMapper.selectMEC_List", movieEvaluateCount);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}
		
		@Override
		public List<MovieEvaluateCount> selectMovieEvaluateCountList2(MovieEvaluateCount movieEvaluateCount) throws Exception {
			List<MovieEvaluateCount> result = null;
			
			try{
				result = sqlSession.selectList("MovieEvaluateCountMapper.selectMEI_List", movieEvaluateCount);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}
		
		

}
