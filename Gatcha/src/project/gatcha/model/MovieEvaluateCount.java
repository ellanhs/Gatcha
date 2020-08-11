package project.gatcha.model;

public class MovieEvaluateCount {
	
	private String kfaId;
	private String title;
	private String view;
	private String like;
	private String dislike;
	private String myStarpoint;
	private String diary;
	private String year;
	private String month;
	private String country;
	private int memberId;
	private String movieKfaId;
	
	
	public String getKfaId() {
		return kfaId;
	}
	public void setKfaId(String kfaId) {
		this.kfaId = kfaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getDislike() {
		return dislike;
	}
	public void setDislike(String dislike) {
		this.dislike = dislike;
	}
	public String getMyStarpoint() {
		return myStarpoint;
	}
	public void setMyStarpoint(String myStarpoint) {
		this.myStarpoint = myStarpoint;
	}
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMovieKfaId() {
		return movieKfaId;
	}
	public void setMovieKfaId(String movieKfaId) {
		this.movieKfaId = movieKfaId;
	}
	@Override
	public String toString() {
		return "MovieEvaluateCount [kfaId=" + kfaId + ", title=" + title + ", view=" + view + ", like=" + like
				+ ", dislike=" + dislike + ", myStarpoint=" + myStarpoint + ", diary=" + diary + ", year=" + year
				+ ", month=" + month + ", country=" + country + ", memberId=" + memberId + ", movieKfaId=" + movieKfaId
				+ "]";
	}

	
	
}