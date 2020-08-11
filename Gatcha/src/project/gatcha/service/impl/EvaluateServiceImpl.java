package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Evaluate;
import project.gatcha.service.EvaluateService;

public class EvaluateServiceImpl implements EvaluateService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public EvaluateServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertEvaluate(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.insert("EvaluateMapper.insertEvaluate", evaluate);
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
	public Evaluate selectEvaluate(Evaluate evaluate) throws Exception {
		Evaluate result = null;

		try {
			result = sqlSession.selectOne("EvaluateMapper.selectEvaluate", evaluate);
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
	public List<Evaluate> selectEvaluateList(Evaluate evaluate) throws Exception {

		List<Evaluate> result = null;

		try {
			result = sqlSession.selectList("EvaluateMapper.selectEvaluateList", evaluate);
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
	public void deleteEvaluate(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.delete("EvaluateMapper.deleteEvaluate", evaluate);
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
	public void updateEvaluate(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluate", evaluate);
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
	public void selectCheckEvaluate(Evaluate evaluate) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	/** 이하 구현자 최준혁 */
	@Override
	public int selectEvaluateCount(Evaluate evaluate) throws Exception {

		int result = 0;
		
		try{
			result = sqlSession.selectOne("EvaluateMapper.selectEvaluateCount", evaluate);
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가수 조회에 실패하였습니다.");
		}
		System.out.println("selectEvaluateCount"+"----------------return???/-------------"+result+"-------");
		return result;
	}

	@Override
	public void updateEvaluateChoice(Evaluate evaluate) throws Exception {
		
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluateChoice", evaluate);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 평가에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void insertEvaluateMayNoOne(Evaluate evaluate) throws Exception {
		try{
			int result = sqlSession.insert("EvaluateMapper.insertEvaluateMayNoOne", evaluate);
		if (result == 0) {
			throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				sqlSession.rollback();
				throw new Exception("평가가 반영되지 않았습니다.");
			} catch (Exception e) {
				sqlSession.rollback();
				logger.error(e.getLocalizedMessage());
				throw new Exception("평가 등록에 실패하였습니다.");
			} finally {
				sqlSession.commit();
			}
		}

	@Override
	public void choiceExcuete(Evaluate evaluate) throws Exception {
		int count = 0;
		count= this.selectEvaluateCount(evaluate);
		System.out.println("-----------------------------------------------");
		if(count !=0){
			this.updateEvaluateChoice(evaluate);
		}else if(count==0){
			this.insertEvaluateMayNoOne(evaluate);
		}
		
	}

	@Override
	public void updateEvaluateLikes(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluateLikes", evaluate);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 평가에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public void updateEvaluateMyStarPoint(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluateMyStarPoint", evaluate);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 평가에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public void updateEvaluateDislike(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluateDislike", evaluate);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 평가에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public Evaluate selectEvaluateOneByMemberKFAId(Evaluate evaluate) throws Exception {
		Evaluate result =null;
		
		try {
			result = sqlSession.selectOne("EvaluateMapper.selectEvaluateOneByMemberKFAId", evaluate);
			//Null 허용
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public Evaluate selectEvaluateOneByMemberId(Evaluate evaluate) throws Exception {
		Evaluate result =null;
		
		try {
			result = sqlSession.selectOne("EvaluateMapper.selectEvaluateOneByMemberId", evaluate);
			//Null 허용
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		
		return result;
	}
	
	@Override
	public void updateEvaluateDiary(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluateDiary", evaluate);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 평가에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}
	
	@Override
	public void updateEvaluateDiaryNull(Evaluate evaluate) throws Exception {
		try {
			int result = sqlSession.update("EvaluateMapper.updateEvaluateDiaryNull", evaluate);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 다이어리에 대한 요청입니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}
	@Override
	public void insertEvaluateDiary(Evaluate evaluate) throws Exception {
		try{
			int result = sqlSession.insert("EvaluateMapper.insertEvaluateDiary", evaluate);
		if (result == 0) {
			throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				sqlSession.rollback();
				throw new Exception("평가가 반영되지 않았습니다.");
			} catch (Exception e) {
				sqlSession.rollback();
				logger.error(e.getLocalizedMessage());
				throw new Exception("평가 등록에 실패하였습니다.");
			} finally {
				sqlSession.commit();
			}
		
	}

	@Override
	public Evaluate selectEvaluateStar(Evaluate evaluate) throws Exception {
		
		Evaluate result =null;
		
		try {
			result = sqlSession.selectOne("EvaluateMapper.selectEvaluateStar", evaluate);
			//Null 허용
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("평가 별점의 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public int selectEvaluateCountLikes(Evaluate evaluate) throws Exception {
		int result =0;
		
		try {
			result = sqlSession.selectOne("EvaluateMapper.selectEvaluateCountLikes", evaluate);
			//Null 허용
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("좋아요의 조회에 실패했습니다.");
		}
		return result;
	}

}//end of serviceImpl
