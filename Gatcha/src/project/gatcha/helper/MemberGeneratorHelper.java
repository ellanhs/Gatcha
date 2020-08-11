package project.gatcha.helper;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class MemberGeneratorHelper {

	// ----------- 싱글톤 객체 생성 시작 ----------
	private static MemberGeneratorHelper current = null;

	public static MemberGeneratorHelper getInstance() {
		if (current == null) {
			current = new MemberGeneratorHelper();
		}
		return current;
	}

	public static void freeInstance() {
		current = null;
	}

	private MemberGeneratorHelper() {
		super();
	}

	// Email 생성기 영문 소문 대문 숫자 섞기
	public String getEmail() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String[] earray = { "naver.com", "gmail.com", "hanmail.net" };
		int eindex = (int) ((Math.random() * 3.0));
		String saltStr = salt.toString() + "@" + earray[eindex];
		return saltStr;
	}

	// 닉네임생성기 한글로
	public String getNickname() {
		String SALTCHARS = "황금독수리온세상을놀라게하다김수한무거북이와두루미삼천갑자동박삭치치카포사리사리센타워리워리세브리캉무드셀라구름이허리케인담벼락서생원에고양이고양이는바둑이바둑이는돌돌이민준지훈현우준서우진서연지민서서윤난장이가쏘아올린작은공지원현서영수호식철정수프라이인드로스테쭈젠댄마리소피아수인레나테엘리자벳피아루이제박하늘별님구름햇님보다사랑스러우리1234567890박명수하찮은찮은이형흑채개그맨1기거성소년명수박사장악마의아들2인자쩜오쿨거성벼멸구고유명수꼴뚜기호통명수산유국여드름브레이크아이오브살쾡이아버지큰형님4집가수박반장나쁜놈깨방정민서애비나이많아매남민두래곤기부천사늙은악마칠성이박형명수옹박아더장군치킨CEO박스타버럭명수쭈구리외계인쇠독맨뉴요커다지기명장박장금대변인인간믹서기쩍벌춘향어르신추메가가멜유재석국민mcmc유날유메뚜기유반장1인자요다햇님무한재석교교주유거성뚝사마진행중독아나만나착한놈뚝마에헬스유노홍철노간신사기꾼러시아인노찌롱돌아이퀵마우스소녀들의대통령뉴뚱럭키가이비난계의꿈나무외국인돌아이스키3세나타샤싼티아나농촌의아들근본없는놈털춘향마법의구두매튜돌크호건노하관노홍칠몸개그신동이상한놈건방진노랑머리간신2도우너충남의아들노칠홍또라이예프스키30세위인긴코원숭이워터보이毛나리자고학력자무한도전공식몸치노출증(신)악마정준하동네바보형식신어머니쩌리짱정주나안정주나늘정주는정준하정중앙뚱뚱보괴물헬멧우수교보재센터정01톤시바스대갈대갈맞나준하인스워드바보연기전문가3인자질펀한엉덩이밉상모자란형알콜CEO대갈상정발장소나무쩌바타정형돈뚱보항돈이어린뚱보도니건방진뚱보진상댄뚱mc빡돈달님말하나마나똔똔정마담족발당수소름쟁이여장전문어색한놈하하석사상꼬맹이단신간신호빗땅꼬마무한재석교신도무한단신작은아이동네꼬마피나마나전진잔진날쌘돌이굴러들어온놈잔스틴댄스머신백만돌이길이간길길메오문어민머리요리신동꺼메오무한명수교신도꿀단지비료";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		int eindex = (int) ((Math.random() * 7.0) + 2.0);
		while (salt.length() < eindex) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public String getGender() {
		String salt = "F";
		if (Math.random() * 2089.0 + 1.0 <= 1071) { // 2089명중 1071명이 남자
			salt = "M";
		}
		String saltStr = salt;
		return saltStr;
	}

	public String getAge() {
		// 10대 241명 20대 347명 30대 472명 40대 528명 50대 501명
		// 누적 10대 241명 20대 588명 30대 1060명 40대 1588명 50대 2089명
		Calendar ca = Calendar.getInstance();
		int ageyear = 0;
		int agemonth = 0;
		int ageday = 0;
		String agem;
		String aged;
		int ageband = 10;
		int agePerson = (int) (Math.random() * 2089.0 + 1.0);
		int thisyearplus = ca.get(Calendar.YEAR) + 1;
		if (agePerson <= 241) {
			ageyear = thisyearplus - randomage(ageband + 5, ageband + 9);
		} else if ((241 < agePerson) && (agePerson <= 588)) {
			ageband = 20;
			ageyear = thisyearplus - randomage(ageband, ageband + 9);
		} else if ((588 < agePerson) && (agePerson <= 1060)) {
			ageband = 30;
			ageyear = thisyearplus - randomage(ageband, ageband + 9);
		} else if ((1060 < agePerson) && (agePerson <= 1588)) {
			ageband = 40;
			ageyear = thisyearplus - randomage(ageband, ageband + 9);
		} else if ((1588 < agePerson) && (agePerson <= 2089)) {
			ageband = 50;
			ageyear = thisyearplus - randomage(ageband, ageband + 9);
		}

		agemonth = randomage(1, 12);
		if (agemonth <= 9) {
			agem = "0" + agemonth;
		} else {
			agem = "" + agemonth;
		}

		ageday = randomage(1, 28);
		if (ageday <= 9) {
			aged = "0" + ageday;
		} else {
			aged = "" + ageday;
		}

		String saltStr = "" + ageyear + "-" + agem + "-" + aged;

		return saltStr;
	}

	// 장르 1 2 3 4 5 6 7 8 sum
	// 전 체 (2000) 56.6 20.7 15.1 35.9 7.9 47.5 25.4 16.8 225.7
	// 성별 남자 (1024) 70.3 20.9 9.8 37.0 8.9 54.5 19.5 14.4 235.3
	// 여자 (976) 42.2 20.4 20.6 34.6 6.8 40.1 31.6 19.4 215.6
	// 연령별1 15~18세 (187) 48.7 32.6 15.0 24.6 16.6 39.6 19.8 27.3 224.1
	// 19~23세 (202) 57.4 27.2 11.4 29.2 9.9 42.6 24.3 21.3 223.3
	// 24~29세 (183) 55.2 24.6 14.8 44.3 2.7 54.6 21.9 10.4 228.4
	// 30~34세 (215) 59.5 20.9 16.3 40.0 5.1 47.4 24.2 12.6 226.0
	// 35~39세 (224) 58.9 23.2 13.4 34.8 8.5 48.7 31.7 20.1 239.3
	// 40~49세 (507) 58.2 16.8 13.6 35.7 6.3 54.2 27.0 24.1 235.9
	// 50~59세 (482) 55.8 14.5 18.5 38.6 8.1 42.1 25.3 6.0 208.9
	// 남자 15~18세 (97) 68.0 34.0 12.4 19.6 16.5 42.3 16.5 24.7 234.0
	// 19~23세 (108) 68.5 31.5 8.3 25.9 12.0 47.2 22.2 17.6 233.3
	// 24~29세 (95) 57.9 24.2 12.6 41.1 4.2 62.1 14.7 10.5 227.4
	// 30~34세 (111) 66.7 21.6 12.6 40.5 9.0 45.0 24.3 13.5 233.3
	// 35~39세 (114) 75.4 21.1 12.3 43.0 8.8 57.9 21.9 14.9 255.3
	// 40~49세 (257) 75.5 16.7 5.1 37.0 7.4 67.3 20.6 20.6 250.2
	// 50~59세 (242) 70.7 13.6 10.7 43.0 7.9 48.8 16.9 3.7 215.3
	// 여자 15~18세 (90) 27.8 31.1 17.8 30.0 16.7 36.7 23.3 30.0 213.3
	// 19~23세 (94) 44.7 22.3 14.9 33.0 7.4 37.2 26.6 25.5 211.7
	// 24~29세 (88) 52.3 25.0 17.0 47.7 1.1 46.6 29.5 10.2 229.5
	// 30~34세 (104) 51.9 20.2 20.2 39.4 1.0 50.0 24.0 11.5 218.3
	// 35~39세 (110) 41.8 25.5 14.5 26.4 8.2 39.1 41.8 25.5 222.7
	// 40~49세 (250) 40.4 16.8 22.4 34.4 5.2 40.8 33.6 27.6 221.2
	// 50~59세 (240) 40.8 15.4 26.3 34.2 8.3 35.4 33.8 8.3 202.5
	public int[] getGenre() {
		int[] result = new int[randomage(1, 3)];
		int[] prob = { 566, 207, 151, 359, 79, 475, 254, 168 };
		int i = 0;
		int j = 0;
		do {
			Double genrePerson = Math.random() * 2257.0 + 1.0;
			int step = 0;
			int nextstep;
			for (j = 0; j < prob.length; j++) {
				nextstep = step + prob[j];
				if (step < genrePerson && genrePerson <= nextstep) {
					result[i] = j + 1;
					break;
				}
				step = nextstep;
			}
			if (i == 0) {
				i++;
			} else if (i == 1 && result[0] != result[1]) {
				i++;
			} else if (i == 2 && result[0] != result[2] && result[1] != result[2]) {
				i++;
			} else if (i >= 3) {
				break;
			}
		} while (i < result.length);
		Arrays.sort(result);
		return result;
	}

	public int[] getGenre(String gender) {
		int[] result = new int[randomage(1, 3)];
		int[][] prob = { { 703, 209, 98, 370, 89, 545, 195, 144 }, { 422, 204, 206, 346, 68, 401, 316, 194 } };
		int k = 0;
		if (gender.equals("F")) {
			k = 1;
		}
		double[] sum = { 2353.0, 2156.0 };
		int i = 0;
		int j = 0;
		do {
			Double genrePerson = Math.random() * sum[k] + 1.0;
			int step = 0;
			int nextstep;
			for (j = 0; j < prob[k].length; j++) {
				nextstep = step + prob[k][j];
				if (step < genrePerson && genrePerson <= nextstep) {
					result[i] = j + 1;
					break;
				}
				step = nextstep;
			}
			if (i == 0) {
				i++;
			} else if (i == 1 && result[0] != result[1]) {
				i++;
			} else if (i == 2 && result[0] != result[2] && result[1] != result[2]) {
				i++;
			} else if (i >= 3) {
				break;
			}
		} while (i < result.length);
		Arrays.sort(result);
		return result;
	}

	public int[] getGenre(String gender, String age) {
		Calendar ca = Calendar.getInstance();
		int ageInt = ca.get(Calendar.YEAR) - Integer.parseInt((age.substring(0, 4))) + 1;
		int[] result = new int[randomage(1, 3)];
		int[][][] prob = {
				{ { 680, 340, 124, 196, 165, 423, 165, 247 }, { 685, 315, 83, 259, 120, 472, 222, 176 },
						{ 579, 242, 126, 411, 42, 621, 147, 105 }, { 667, 216, 126, 405, 90, 450, 243, 135 },
						{ 754, 211, 123, 430, 88, 579, 219, 149 }, { 755, 167, 51, 370, 74, 673, 206, 206 },
						{ 707, 136, 107, 430, 79, 488, 169, 37 } },
				{ { 278, 311, 178, 300, 167, 367, 233, 300 }, { 447, 223, 149, 330, 74, 372, 266, 255 },
						{ 523, 250, 170, 477, 11, 466, 295, 102 }, { 519, 202, 202, 394, 10, 500, 240, 115 },
						{ 418, 255, 145, 264, 82, 391, 418, 255 }, { 404, 168, 224, 344, 52, 408, 336, 276 },
						{ 408, 154, 263, 342, 83, 354, 338, 83 } } };
		int k = 0;
		if (gender.equals("F")) {
			k = 1;
		}
		int l = 0;
		if (15 <= ageInt && ageInt < 19) {
			l = 0;
		} else if (19 <= ageInt && ageInt < 24) {
			l = 1;
		} else if (24 <= ageInt && ageInt < 30) {
			l = 2;
		} else if (30 <= ageInt && ageInt < 35) {
			l = 3;
		} else if (35 <= ageInt && ageInt < 40) {
			l = 4;
		} else if (40 <= ageInt && ageInt < 50) {
			l = 5;
		} else if (50 <= ageInt) {
			l = 6;
		}
		double[][] sum = { { 2340.0, 2333.0, 2274.0, 2333.0, 2553.0, 2502.0, 2153.0 },
				{ 2133.0, 2117.0, 2295.0, 2183.0, 2227.0, 2212.0, 2025.0 } };
		int i = 0;
		int j = 0;
		do {
			Double genrePerson = Math.random() * sum[k][l] + 1.0;
			int step = 0;
			int nextstep;
			for (j = 0; j < prob[k][l].length; j++) {
				nextstep = step + prob[k][l][j];
				if (step < genrePerson && genrePerson <= nextstep) {
					result[i] = j + 1;
					break;
				}
				step = nextstep;
			}
			if (i == 0) {
				i++;
			} else if (i == 1 && result[0] != result[1]) {
				i++;
			} else if (i == 2 && result[0] != result[2] && result[1] != result[2]) {
				i++;
			} else if (i >= 3) {
				break;
			}
		} while (i < result.length);
		Arrays.sort(result);
		return result;
	}

	public double getMystarpoint(double mean) {
		Random rnd = new Random();
		double result = 0.0;
//		double[] point={0.0d, 0.5d, 1.0d, 1.5d, 2.0d, 2.5d, 3.0d, 3.5d, 4.0d, 4.5d, 5.0d};
//		int index=randomage(0,11);
//		int index=(int)Math.abs(rnd.nextGaussian()*2.0+mean);//mean~8.0
//		if (index > 11){index = 11;}
//		result= point[index];
		result=rnd.nextGaussian()*2.0+mean;
		if(result<0){result=0.0d;}
		else if(result>5.0){result=5.0d;}
		result=(Math.round(2.0*result)/2.0);
		return result;
	}

	public int randomage(int m, int n) {
		int result = 0;
		if (m >= n) {
			result = (int) (Math.random() * (m - n + 1) + n);
		} else if (n > m) {
			result = (int) (Math.random() * (n - m + 1) + m);
		}
		return result;
	}
}
