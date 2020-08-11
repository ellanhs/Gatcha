package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.MovieHasGenre;
import project.gatcha.service.MovieHasGenreService;

public class MovieHasGenreServiceImpl implements MovieHasGenreService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public MovieHasGenreServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception {
		try {
			int result = sqlSession.insert("MovieHasGenreMapper.insertMovieHasGenre", movieHasGenre);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 게시물이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 정보 등록에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public MovieHasGenre selectMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception {
		MovieHasGenre result = null;

		try {
			result = sqlSession.selectOne("MovieHasGenreMapper.selectMovieHasGenre", movieHasGenre);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 게시물이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 조회에 실패했습니다.");
		}

		return result;
	}



	@Override
	public List<MovieHasGenre> selectMovieHasGenreList(MovieHasGenre movieHasGenre) throws Exception {

		List<MovieHasGenre> result = null;

		try {
			result = sqlSession.selectList("MovieHasGenreMapper.selectMovieHasGenreList", movieHasGenre);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 글 목록이 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("글 목록 조회에 실패했습니다.");
		}

		return result;
	}

	
	@Override
	public void deleteMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception {
		try {
			int result = sqlSession.delete("MovieHasGenreMapper.deleteMovieHasGenre", movieHasGenre);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception {
		try {
			int result = sqlSession.update("MovieHasGenreMapper.updateMovieHasGenre", movieHasGenre);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<MovieHasGenre> selectMovieHasGenreListByKfaId(MovieHasGenre movieHasGenre) throws Exception {
		List<MovieHasGenre> result = null;
		try{
			result = sqlSession.selectList("MovieHasGenreMapper.selectMovieHasGenreListById",movieHasGenre);
	
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 영화장르가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("해당 영화의 장르조회에 실패하였습니다.");
		} finally{
			sqlSession.commit();
		}
		
		return result;
	}

}
