package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Evaluate;

/**
 * 평가 관련 기능을 제공하기 위한 Service 계층
 */
public interface EvaluateService {
	/**
	 * 평가을 저장한다.
	 * 
	 * @param evaluate
	 *            - 평가 데이터
	 * @throws Exception
	 */
	public void insertEvaluate(Evaluate evaluate) throws Exception;

	/**
	 * 하나의 평가을 읽어들인다.
	 * 
	 * @param evaluate
	 *            - 읽어들일 평가 일련번호가 저장된 Beans
	 * @return EvaluateEvaluate - 읽어들인 평가 내용
	 * @throws Exception
	 */
	public Evaluate selectEvaluate(Evaluate evaluate) throws Exception;

	
	/**
	 * 게시글 목록 조회
	 * 
	 * @param evaluate
	 *            - 정보가 저장된 Beans
	 * @return List - 평가 목록
	 * @throws Exception
	 */
	public List<Evaluate> selectEvaluateList(Evaluate evaluate) throws Exception;


	/**
	 * 평가항목 삭제한다.
	 * 
	 * @param evaluate
	 * @throws Exception
	 */
	public void deleteEvaluate(Evaluate evaluate) throws Exception;
	
	/**
	 * 평가항목 수정한다.
	 * @param evaluate - 평가 데이터
	 * @throws Exception
	 */
	public void updateEvaluate(Evaluate evaluate) throws Exception;
	
	/**
	 * 클릭한 평가 항목에 대하여 사용자의 선택을 반영하고 상호 반응한다.
	 * @param evaluate
	 * @throws Exception
	 */
	public void selectCheckEvaluate(Evaluate evaluate)  throws Exception;
	
	
	/**
	 *  순서도 :  selectEvaluateCount ---(1)----->updateEvaluateChoice
	 * 							   ---(0)----> insertEvaluateMayNoOne
	 * 
	 * @param evaluate -멤버 아이디와 선택된 영화의 코드가 셋된 evaluate객체
	 * @return 1이면 그 영화에 대한 해당 선택이 있는것,  0이면  기존에 할당한 평가가 없음
	 * @throws Exception
	 */
	public int selectEvaluateCount(Evaluate evaluate) throws Exception;
	
	
	/**
	 * 순서도 :  selectEvaluateCount ---(1)----->updateEvaluateChoice
	 * 							   ---(0)----> insertEvaluateMayNoOne
	 * 
	 * 결과값이 이미 존재하는 회원을 대상으로 버튼 기능을 지원하기 위한 구현체
	 * @param evaluate - 회원 아이디와 영화코드가 셋팅된 Beans
	 * @throws Exception
	 */
	public void updateEvaluateChoice(Evaluate evaluate) throws Exception;
	
	public void updateEvaluateLikes(Evaluate evaluate) throws Exception;
	
	public void updateEvaluateMyStarPoint(Evaluate evaluate) throws Exception;
	
	public void updateEvaluateDislike(Evaluate evaluate) throws Exception;
	
	public void updateEvaluateDiary(Evaluate evaluate) throws Exception;
	
	public void updateEvaluateDiaryNull(Evaluate evaluate) throws Exception;
	/**
	 *	순서도 :  selectEvaluateCount ---(1)----->updateEvaluateChoice
	 * 							   ---(0)----> insertEvaluateMayNoOne
	 *  selectEvaluateCount가 0일경우 수행될 추가문. 0이라는뜻은 평가를 수립한적이 없다는 뜻이므로 ...
	 * @param evaluate - selectEvaluateCount를 수행하는데 사용했던 멤버 아이디값과 영화 코드값
	 * @throws Exception
	 */
	public void insertEvaluateMayNoOne(Evaluate evaluate) throws Exception;
	
	public void insertEvaluateDiary(Evaluate evaluate) throws Exception;

	
	/**
	 *	순서도 :  selectEvaluateCount ---(1)----->updateEvaluateChoice
	 * 							   ---(0)----> insertEvaluateMayNoOne
	 * 순서도에 나온 메서드들을 하나로 묶어 기능하는 메서드.
	 * @param evaluate 버튼으로부터 해당하는 평가의 값들, 영화 코드, 회원아이디값이 셋된 Beans
	 * @throws Exception
	 */
	public void choiceExcuete(Evaluate evaluate) throws Exception;
	
	/**
	 * Evaluate 테이블에서 멤머 ID와 KFA ID로 한개 조회
	 * @param evaluate
	 * @return Evaluate
	 * @throws Exception
	 */
	public Evaluate selectEvaluateOneByMemberKFAId(Evaluate evaluate) throws Exception;
	
	/**
	 * Evaluate 테이블에서 멤머 ID로 한개 조회
	 * @param evaluate
	 * @return Evaluate
	 * @throws Exception
	 */
	public Evaluate selectEvaluateOneByMemberId(Evaluate evaluate) throws Exception;
	
	/**
	 * Evaluate 테이블에서 멤머 ID로 한개 조회
	 * @param evaluate
	 * @return Evaluate에서 각 member_id가 체크하는 별점에 대한 beans를 리턴
	 * @throws Exception
	 */
	public Evaluate selectEvaluateStar(Evaluate evaluate) throws Exception;
	
	/**
	 * 
	 * @param evaluate
	 * @return
	 * @throws Exception
	 */
	public int selectEvaluateCountLikes(Evaluate evaluate) throws Exception;
}
