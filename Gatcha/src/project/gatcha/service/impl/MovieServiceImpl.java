package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Movie;
import project.gatcha.service.MovieService;

public class MovieServiceImpl implements MovieService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public MovieServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	

	

}
	/** 영화 목록을 조회할때 사용하기 위해 만듬, 참조에 의한 제약조건을 안넣었기때문에, 완성본까지 사용할 기능은 아님 */
	@Override
	public List<Movie> selectMovieList() throws Exception {
		List<Movie> result = null;
		
		try{
			result = sqlSession.selectList("MovieMapper.selectMovieList");
			
			// 개별 검색이 아니라 전체 조회이므로 출력이 없을경우에 예외를 발생시킨다.
			if(result ==null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("조회된 영화목록이 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("조회수 갱신에 실패하였습니다.");
		}finally{
			sqlSession.commit();
		}
		
		return result;
	}
	
	/** 영화목록을 조회하기전 selectMovieList 의 수를 조회하여 1미만이면 실행되지 않도록 유도하기 위해 구현한 기능입니다. */
	@Override
	public int selectMovieListCount(Movie movie) throws Exception {
		
		int result = 0;
		
		try{
			result = sqlSession.selectOne("MovieMapper.selectMovieListCount", movie);
				
			
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("영화 조회에 실패하였습니다.");
		}
		return result;
	}
	
	/** 모달창에 정보를 띄우기 위한 정보를 조회 */
	@Override
	public Movie selectMovieInfo(Movie movie) throws Exception {
		Movie result = null;
		try{
			result = sqlSession.selectOne("MovieMapper.selectMovieOne",movie);
			if(result ==null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			e.getLocalizedMessage();
			throw new Exception("영화 조회 실패 ");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("영화 조회에 실패하였습니다.");
		}
		
		return result;
	}
	@Override
	public void updateEvaluateStar(Movie movie) throws Exception {
		try {
			int result = sqlSession.update("MovieMapper.updateEvaluateStar", movie);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 영화에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("별점 정보 등록에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}
	
}
