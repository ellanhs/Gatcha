package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.MemberHasGenre;
import project.gatcha.service.MemberHasGenreService;

public class MemberHasGenreServiceImpl implements MemberHasGenreService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public MemberHasGenreServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception {
		try {
			int result = sqlSession.insert("MemberHasGenreMapper.insertMemberHasGenre", memberHasGenre);
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
	public MemberHasGenre selectMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception {
		MemberHasGenre result = null;

		try {
			result = sqlSession.selectOne("MemberHasGenreMapper.selectMemberHasGenre", memberHasGenre);
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
	public List<MemberHasGenre> selectMemberHasGenreList(MemberHasGenre memberHasGenre) throws Exception {

		List<MemberHasGenre> result = null;

		try {
			result = sqlSession.selectList("MemberHasGenreMapper.selectMemberHasGenreList", memberHasGenre);
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
	public void deleteMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception {
		try {
			int result = sqlSession.delete("MemberHasGenreMapper.deleteMemberHasGenre", memberHasGenre);
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
	public void updateMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception {
		try {
			int result = sqlSession.update("MemberHasGenreMapper.updateMemberHasGenre", memberHasGenre);
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
