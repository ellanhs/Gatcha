package project.gatcha.service;

import java.util.List;


import project.gatcha.model.Member;

public interface MemberService {
	
	/**
	 *  
	 * 회원 추가시에 수행(이메일, 아이디 중복검사 수행후에 실행 ).
	 * @param member - 회원가입시 필요한 정보가 저장되어 있는 Beans
	 * @throws Exception
	 */
	public Member insertMember(Member member) throws Exception;

	/**
	 *  
	 * 회원 추가시에 수행(이메일, 아이디 중복검사 수행후에 실행 ).
	 * @param member - 회원가입시 필요한 정보가 저장되어 있는 Beans
	 * @throws Exception
	 */
	public Member insertMemberHasGenre(Member member) throws Exception;
	
	
	
	
	
	
	
	/**
	 * 아이디 중복검사
	 * @param member - 아이디
	 * @throws Exception - 중복된 데이터인 경우 예외 발생함
	 */
	public void selectUserIdCount(Member member) throws Exception;
	
	

	/**
	 * 로그인되었을시 세션에 불러오는 정보들
	 * @param member 읽어들일 회원번호가 저장된 Beans
	 * @return Member 읽어들인 회원 한명의 정보
	 * @throws Exception
	 */
	public Member selectMember(Member member)throws Exception;
	
	/**
	 * 비밀번호 검사
	 * @param member  
	 * @throws Exception
	 */
	public void selectMemberPasswordCount(Member member)throws Exception;


	/**
	 * 회원 목록 조회
	 * 
	 * @param member - 회원 정보가 저장된 Beans
	 * @return List - 회원정보 관련 파일 목록
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Member member) throws Exception;

	
	
	/**
	 * 로그인시 이메일과 비밀번호를 조회한다.
	 * 조회된 데이터가 없을시 이메일이나 비밀번호가 잘못되었다는것을 의미합니다.
	 * @param member - 이메일 비밀번호
	 * @return 회원정보
	 * @throws Exception
	 */
	public Member selectLoginInfo(Member member) throws Exception;
	/**
	 * 비밀번호 변경
	 * @param member - 이메일주소. 비밀번호
	 * @throws Exception
	 */
	public void updateMemberPasswordByEmail(Member member) throws Exception;
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @throws Exception
	 */
	public void updateMember(Member member) throws Exception;
	
	/**
	 * 회원탈퇴
	 * @param member - 회원번호, 비밀번호
	 * @throws Exception
	 */
	public void deleteMember(Member member) throws Exception;

	
	
	

}
