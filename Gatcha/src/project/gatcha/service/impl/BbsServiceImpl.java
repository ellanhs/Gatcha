package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Bbs;
import project.gatcha.service.BbsService;


public class BbsServiceImpl implements BbsService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public BbsServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertBbs(Bbs bbs) throws Exception {
		try {
			int result=0;
//			for(int i=0; i<100;i++){
			 result += sqlSession.insert("BbsMapper.insertBbs", bbs);
//			}
			
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
	public Bbs selectBbs(Bbs bbs) throws Exception {
		Bbs result = null;

		try {
			result = sqlSession.selectOne("BbsMapper.selectBbs", bbs);
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
	public void updateBbsHit(Bbs bbs) throws Exception {
		try {
			int result = sqlSession.update("BbsMapper.updateBbsHit", bbs);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("조회수 갱신에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Bbs> selectBbsList(Bbs bbs) throws Exception {

		List<Bbs> result = null;

		try {
			result = sqlSession.selectList("BbsMapper.selectBbsList", bbs);
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
	public void deleteBbs(Bbs bbs) throws Exception {
		try {
			int result = sqlSession.delete("BbsMapper.deleteBbs", bbs);
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
	public void updateBbs(Bbs bbs) throws Exception {
		try {
			int result = sqlSession.update("BbsMapper.updateBbs", bbs);
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
	public void updateBbsComment(Bbs bbs) throws Exception {
		try {
			int result = sqlSession.update("BbsMapper.updateBbsComment", bbs);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("덧글 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}
	

	@Override
	public Bbs selectPrevBbs(Bbs bbs) throws Exception {
		Bbs result = null;
		try {
			//이전글이 없는 경우도 있으므로,리턴 값이 null인 경우 예외를 발생시키지 않는다.
			result=sqlSession.selectOne("BbsMapper.selectPrevBbs", bbs);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("이전글 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Bbs selectNextBbs(Bbs bbs) throws Exception {
		Bbs result = null;
		try {
			//다음글이 없는 경우도 있으므로,리턴 값이 null인 경우 예외를 발생시키지 않는다.
			result=sqlSession.selectOne("BbsMapper.selectNextBbs", bbs);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("다음글 조회에 실패했습니다.");
		}
		return result;
	}



	@Override
	public List<Bbs> selectBbsJoinList(Bbs bbs) throws Exception {

		List<Bbs> result = null;

		try {
			result = sqlSession.selectList("BbsMapper.selectBbsJoinList", bbs);
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
	public int selectBbsJoinCount(Bbs bbs) throws Exception {
		int result = 0;

		try {
			// 게시물 수가 0건인 경우도 있으므로, 
			// 결과값이 0인 경우에 대한 예외를 발생시키지 않는다.
			result = sqlSession.selectOne("BbsMapper.selectBbsJoinCount", bbs);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public Bbs selectJoinBbs(Bbs bbs) throws Exception {
		Bbs result = null;

		try {
			result = sqlSession.selectOne("BbsMapper.selectJoinBbs", bbs);
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
	public int selectBbsCountByMemberId(Bbs bbs) throws Exception {
		int result = 0;

		try {
			// 자신의 게시물이 아닌 경우도 있으므로,
			// 결과값이 0인 경우에 대한 예외를 발생시키지 않는다.
			result = sqlSession.selectOne(
					"BbsMapper.selectBbsCountByMemberId", bbs);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void updateBbsMemberOut(Bbs bbs) throws Exception {
		try {
			// 게시글을 작성한 적이 없는 회원도 있을 수 있기 때문에,
			// NullPointerException을 발생시키지 않는다.
			sqlSession.update("BbsMapper.updateBbsMemberOut", bbs);
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("참조관계 해제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteBbsMemberOut(Bbs bbs) throws Exception {
		try {
			// 게시글을 작성한 적이 없는 회원도 있을 수 있기 때문에,
			// NullPointerException을 발생시키지 않는다.
			sqlSession.delete("BbsMapper.deleteBbsMemberOut", bbs);
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("참조된 게시물 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}
	
	
}
