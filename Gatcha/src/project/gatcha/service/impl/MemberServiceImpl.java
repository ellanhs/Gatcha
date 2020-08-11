package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Member;
import project.gatcha.service.MemberService;

public class MemberServiceImpl implements MemberService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public MemberServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public Member insertMember(Member member) throws Exception {
		// 아이디( 이메일) 중복검사 호출
		selectUserIdCount(member);
		
		try {
			int result = sqlSession.insert("MemberMapper.insertMember", member);
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
		return member;
	}
	
	@Override
	public Member insertMemberHasGenre(Member member) throws Exception {

		
		try {
			int result = sqlSession.insert("MemberMapper.insertMemberHasGenre", member);
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
		return member;
	}

	
	@Override
	public void selectUserIdCount(Member member) throws Exception {
		try {
			int result = sqlSession.selectOne("MemberMapper.selectUserIdCount", member);
			
			// 중복된 데이터가 존재한다면?
			if (result > 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("이미 사용중인 아이디 입니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("아이디 중복검사에 실패했습니다.");
		}
	}
	
	
	@Override
	public Member selectMember(Member member) throws Exception {
		Member result = null;

		try {
			result = sqlSession.selectOne("MemberMapper.selectMember", member);
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
	public List<Member> selectMemberList(Member member) throws Exception {
		List<Member> result = null;

		try {
			result = sqlSession.selectList("MemberMapper.selectMemberList", member);
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
	public void deleteMember(Member member) throws Exception {
		try {
			int result = sqlSession.delete("MemberMapper.deleteMember", member);
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
	public void updateMember(Member member) throws Exception {
		try {
			int result = sqlSession.update("MemberMapper.updateMember", member);
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

	public void selectMemberPasswordCount(Member member) throws Exception {

	try {
		int result = sqlSession.selectOne("MemberMapper.selectMemberPasswordCount", member);
		//회원번호와 비밀번호가 일치하는 데이터가 0이라면, 비밀번호가 잘못된 상태
		if (result == 0) {
			throw new NullPointerException();
		}
	} catch (NullPointerException e) {
		throw new Exception("잘못된 비밀번호입니다.");
	} catch (Exception e) {
		logger.error(e.getLocalizedMessage());
		throw new Exception("비밀번호 검사에 실패했습니다.");
	  }
	}
	@Override
	public Member selectLoginInfo(Member member) throws Exception {
		Member result = null;

		try {
			result = sqlSession.selectOne("MemberMapper.selectLoginInfo", member);

			// 조회된 데이터가 없다는 것은 WHERE절 조건에 맞는 데이터가 없다는 것.
			// --> WHERE절은 아이디와 비밀번호가 일치하는 항목을 지정하므로,
			// 조회된 데이터가 없다는 것은 아이디나 비밀번호가 잘못되었음을 의미한다.
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("아이디나 비밀번호가 잘못되었습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("로그인에 실패했습니다.");
		}

		return result;
	}

	@Override
	public void updateMemberPasswordByEmail(Member member) throws Exception {
		try{
			int result = sqlSession.update("MemberMapper.updateMemberPasswordByEmail",member);
			//수정된 행의 수가 없다는 것은 WHERE절 조건이 맞지 않기 때문이다.
			//즉, 입력한 이메일과 일치하는 데이터가 없다는 의미
			System.out.println("result-----------------------------"+result);
			if(result==0) {
				throw new NullPointerException();
			}
		}catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("가입된 이메일이 아닙니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("비밀번호 변경에 실패하였습니다.");
		}finally {
			sqlSession.commit();
			}
		}
		
	}


