package project.gatcha.model;

public class MemberHasGenre {
	private int id;
	private String regDate;
	private String editDate;
	private int memberId;
	private int genreId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	@Override
	public String toString() {
		return "MemberHasGerne [id=" + id + ", regDate=" + regDate + ", editDate=" + editDate + ", memberId=" + memberId
				+ ", genreId=" + genreId + "]";
	}
	
	
	
	
	

}
