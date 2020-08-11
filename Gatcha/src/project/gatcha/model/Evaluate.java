package project.gatcha.model;

public class Evaluate {
	private int id;
	private String myStarpoint;
	private String myStarpointTotal;
	private String myStarpointMean;
	private String view;
	private String likes;
	private String dislike;
	private String diary;
	private String regDate;
	private String editDate;
	private int memberId;
	private String memberIdCount;
	private String movieKfaId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMyStarpoint() {
		return myStarpoint;
	}
	public void setMyStarpoint(String myStarpoint) {
		this.myStarpoint = myStarpoint;
	}
	public String getMyStarpointTotal() {
		return myStarpointTotal;
	}
	public void setMyStarpointTotal(String myStarpointTotal) {
		this.myStarpointTotal = myStarpointTotal;
	}
	public String getMyStarpointMean() {
		return myStarpointMean;
	}
	public void setMyStarpointMean(String myStarpointMean) {
		this.myStarpointMean = myStarpointMean;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getDislike() {
		return dislike;
	}
	public void setDislike(String dislike) {
		this.dislike = dislike;
	}
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberIdCount() {
		return memberIdCount;
	}
	public void setMemberIdCount(String memberIdCount) {
		this.memberIdCount = memberIdCount;
	}
	public String getMovieKfaId() {
		return movieKfaId;
	}
	public void setMovieKfaId(String movieKfaId) {
		this.movieKfaId = movieKfaId;
	}
	
	@Override
	public String toString() {
		return "Evaluate [id=" + id + ", myStarpoint=" + myStarpoint + ", myStarpointTotal=" + myStarpointTotal
				+ ", myStarpointMean=" + myStarpointMean + ", view=" + view + ", likes=" + likes + ", dislike="
				+ dislike + ", diary=" + diary + ", regDate=" + regDate + ", editDate=" + editDate + ", memberId="
				+ memberId + ", memberIdCount=" + memberIdCount + ", movieKfaId=" + movieKfaId + "]";
	}
	
}
