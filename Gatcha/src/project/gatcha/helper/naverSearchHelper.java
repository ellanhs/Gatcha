package project.gatcha.helper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class naverSearchHelper {

	// ----------- 싱글톤 객체 생성 시작 ----------
		private static naverSearchHelper current = null;

		public static naverSearchHelper getInstance() {
			if (current == null) {
				current = new naverSearchHelper();
			}
			return current;
		}

		public static void freeInstance() {
			current = null;
		}

		private naverSearchHelper() {
			super();
		}


	    public void blogSearch(String keyword) {
	        String clientId = "NxBgbW_Ximmnq9aPkCE8";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "UytYxNEwOk";//애플리케이션 클라이언트 시크릿값";
	        try {
	            String text = URLEncoder.encode(keyword, "UTF-8");
	            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
	            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    
	    public void movieSearch(String keyword, int yearfrom, int yearto) {
	        String clientId = "NxBgbW_Ximmnq9aPkCE8";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "UytYxNEwOk";//애플리케이션 클라이언트 시크릿값";
	        try {
	            String text = URLEncoder.encode(keyword, "UTF-8");
	            String apiURL = "https://openapi.naver.com/v1/search/movie.json?query="+ text+"&yearfrom="+yearfrom+"&yearto"+yearto; // json 결과
	            //String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query="+ text; // xml 결과
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	

}
