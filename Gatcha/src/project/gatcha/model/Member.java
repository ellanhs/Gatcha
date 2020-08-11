package project.gatcha.model;

public class Member {
	private int id;
	private String nickname;
	private String email;
	private String userPw;
	private int level;
	private String gender;
	private String birthdate;
	private int genre;
	private String regDate;
	private String editDate;
	private String newUserPw;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
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
	public String getNewUserPw() {
		return newUserPw;
	}
	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", nickname=" + nickname + ", email=" + email + ", userPw=" + userPw + ", level="
				+ level + ", gender=" + gender + ", birthdate=" + birthdate + ", genre=" + genre + ", regDate="
				+ regDate + ", editDate=" + editDate + ", newUserPw=" + newUserPw + "]";
	}
	
	
}
