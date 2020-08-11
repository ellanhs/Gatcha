package project.gatcha.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.service.MovieEvaluateFileService;

public class MovieEvaluateFileServiceImpl implements MovieEvaluateFileService  {
	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	SqlSession sqlSession;

		public MovieEvaluateFileServiceImpl(SqlSession sqlSession,Logger logger) {
			this.sqlSession = sqlSession;
			this.logger = logger;
		}

		@Override
		public List<MovieEvaluateFile> selectMovieList(MovieEvaluateFile movieEvaluateFile) throws Exception {
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.selectMEF_List", movieEvaluateFile);
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
		public List<MovieEvaluateFile> selectMovieListByLike(MovieEvaluateFile movieEvaluateFile) throws Exception {
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.selectMEF_ListByLike", movieEvaluateFile);

			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}
		@Override
		public List<MovieEvaluateFile> selectMovieListByDislike(MovieEvaluateFile movieEvaluateFile) throws Exception {
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.selectMEF_ListByDislike", movieEvaluateFile);

			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("알수없는 오류!!");
			} finally{
				sqlSession.commit();
			}
			return result;
		}


		@Override
		public MovieEvaluateFile selectPosterStilcut(MovieEvaluateFile movieEvaluateFile) throws Exception {
			MovieEvaluateFile result = null;
			try{
				result = sqlSession.selectOne("MovieEvaluateFileMapper.selectMEF_fileByKfaId", movieEvaluateFile);
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
		public List<MovieEvaluateFile> selectMovieListByKeyword(MovieEvaluateFile movieEvaluateFile) throws Exception {

			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.selectMEF_ListByTitle", movieEvaluateFile);
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
		public List<MovieEvaluateFile> selectMovieListByActorKeyWord(MovieEvaluateFile movieEvaluateFile)throws Exception {
			
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.selectMEF_ListSearchByActor", movieEvaluateFile);
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
		public List<MovieEvaluateFile> boxofficeCarousel() throws Exception {
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.boxofficeCarousel", null);
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
		public List<MovieEvaluateFile> boxofficeList(MovieEvaluateFile movieEvaluateFile) throws Exception {
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.boxofficeList", movieEvaluateFile);
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
		public List<MovieEvaluateFile> selectMovieListByDirectorKeyWord(MovieEvaluateFile movieEvaluateFile) throws Exception{
			
			List<MovieEvaluateFile> result = null;
			try{
				result = sqlSession.selectList("MovieEvaluateFileMapper.selectMovieListByDirectorKeyWord", movieEvaluateFile);
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
		public int selectEvaluateGenreCount(MovieEvaluateFile movieEvaluateFile) throws Exception {

			int result = 0;
			
			try{
				result = sqlSession.selectOne("MovieEvaluateFileMapper.selectEvaluateGenreCount", movieEvaluateFile);
			}catch(Exception e){
				logger.error(e.getLocalizedMessage());
				throw new Exception("회원 평가 장르갯수  숫자산출에 에 실패하였습니다.");
			}
			System.out.println("selectEvaluateCount"+"----------------return???/-------------"+result+"-------");
			return result;
		}
		
		



	

}
