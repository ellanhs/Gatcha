package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.MovieFile;
import project.gatcha.service.MovieFileService;

public class MovieFileServiceImpl implements MovieFileService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSessionimpl
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public MovieFileServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertMovieFile(MovieFile movieFile) throws Exception {
		try {
			int result = sqlSession.insert("MovieFileMapper.insertMovieFile", movieFile);
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
	public MovieFile selectMovieFile(MovieFile movieFile) throws Exception {
		MovieFile result = null;

		try {
			result = sqlSession.selectOne("MovieFileMapper.selectMovieFile", movieFile);
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
	public List<MovieFile> selectMovieFileList(MovieFile movieFile) throws Exception {

		List<MovieFile> result = null;

		try {
			result = sqlSession.selectList("MovieFileMapper.selectMovieFileList", movieFile);
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
	public void deleteMovieFile(MovieFile movieFile) throws Exception {
		try {
			int result = sqlSession.delete("MovieFileMapper.deleteMovieFile", movieFile);
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
	public void updateMovieFile(MovieFile movieFile) throws Exception {
		try {
			int result = sqlSession.update("MovieFileMapper.updateMovieFile", movieFile);
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

}
