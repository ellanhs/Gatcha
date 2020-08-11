package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Filmography;
import project.gatcha.service.FilmographyService;

public class FilmographyServiceImpl implements FilmographyService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public FilmographyServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertFilmography(Filmography filmography) throws Exception {
		try {
			int result = sqlSession.insert("FilmographyMapper.insertFilmography", filmography);
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
	public Filmography selectFilmography(Filmography filmography) throws Exception {
		Filmography result = null;

		try {
			result = sqlSession.selectOne("FilmographyMapper.selectFilmography", filmography);
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
	public List<Filmography> selectFilmographyList(Filmography filmography) throws Exception {

		List<Filmography> result = null;

		try {
			result = sqlSession.selectList("FilmographyFilmographyMapper.selectFilmographyList", filmography);
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
	public void deleteFilmography(Filmography filmography) throws Exception {
		try {
			int result = sqlSession.delete("FilmographyMapper.deleteFilmography", filmography);
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
	public void updateFilmography(Filmography filmography) throws Exception {
		try {
			int result = sqlSession.update("FilmographyMapper.updateFilmography", filmography);
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
	public Filmography selectFilmographyPeople(Filmography filmography) throws Exception {
		Filmography result = null;
		
		
		
		try{
			result = sqlSession.selectOne("FilmographyMapper.selectFilmographyPeople",filmography);
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("사람 조회 준비과정에 실패하였습니다.");
		} finally {
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public List<Filmography> selectStatEvaluate(Filmography filmography) throws Exception {
		List<Filmography> result = null;

		try{
			result = sqlSession.selectList("FilmographyMapper.selectStatFilmo",filmography);
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("선호 배우,감독 조회에 실패하였습니다.");
		} finally {
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public List<Filmography> selectStatFilmoActor(Filmography filmography) throws Exception {
		
		List<Filmography> result = null;
		
		try{
			result = sqlSession.selectList("FilmographyMapper.selectStatFilmoActor",filmography);
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("선호 배우,감독 조회에 실패하였습니다.");
		} finally {
			sqlSession.commit();
		}
		return result;
	}
	
}
