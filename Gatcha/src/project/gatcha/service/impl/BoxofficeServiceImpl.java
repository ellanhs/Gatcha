package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.Boxoffice;
import project.gatcha.service.BoxofficeService;

public class BoxofficeServiceImpl implements BoxofficeService  {
	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

		public BoxofficeServiceImpl(SqlSession sqlSession,Logger logger) {
			this.sqlSession = sqlSession;
			this.logger = logger;
		}

		@Override
		public Boxoffice selectMovieList(Boxoffice boxoffice) throws Exception {
			Boxoffice result = null;
			try{
				result = sqlSession.selectOne("BoxofficeMapper.selectMEF_List", boxoffice);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}
		@Override
		public List<Boxoffice> selectMovieListByLike(Boxoffice boxoffice) throws Exception {
			List<Boxoffice> result = null;
			try{
				result = sqlSession.selectList("BoxofficeMapper.selectMEF_ListByLike", boxoffice);

			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}
		@Override
		public List<Boxoffice> selectMovieListByDislike(Boxoffice boxoffice) throws Exception {
			List<Boxoffice> result = null;
			try{
				result = sqlSession.selectList("BoxofficeMapper.selectMEF_ListByDislike", boxoffice);

			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}


		@Override
		public Boxoffice selectPosterStilcut(Boxoffice boxoffice) throws Exception {
			Boxoffice result = null;
			try{
				result = sqlSession.selectOne("BoxofficeMapper.selectMEF_fileByKfaId", boxoffice);
					if(result == null){
						throw new NullPointerException();
					}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}

		@Override
		public List<Boxoffice> selectMovieListByKeyword(Boxoffice boxoffice) throws Exception {

			List<Boxoffice> result = null;
			try{
				result = sqlSession.selectList("BoxofficeMapper.selectMEF_ListByTitle", boxoffice);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}

		@Override
		public List<Boxoffice> selectMovieListByActorKeyWord(Boxoffice boxoffice)throws Exception {
			
			List<Boxoffice> result = null;
			try{
				result = sqlSession.selectList("BoxofficeMapper.selectMEF_ListSearchByActor", boxoffice);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}

		@Override
		public List<Boxoffice> boxofficeCarousel() throws Exception {
			List<Boxoffice> result = null;
			try{
				result = sqlSession.selectList("BoxofficeMapper.boxofficeCarousel", null);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}

		@Override
		public List<Boxoffice> boxofficeList(Boxoffice boxoffice) throws Exception {
			List<Boxoffice> result = null;
			try{
				result = sqlSession.selectList("BoxofficeMapper.boxofficeList", boxoffice);
				if(result ==null){
					throw new NullPointerException();
				}
			}catch(NullPointerException e){
				
				throw new Exception("존재하지 않는 게시물에 대한 요청입니다.");
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}
		
		



	

}
