package project.gatcha.model;

public class Bbs {
	private int id;
	private String subject;
	private String content;
	private String comment;
	private String regDate;
	private String editDate;
	private int memberId;

	// 페이지 구현을 위해서 추가된 값
	private int limitStart;
	private int listCount;

	// 닉네임 검색을 위해서 추가된 값
	private String nickname;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public int getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Bbs [id=" + id + ", subject=" + subject + ", content=" + content + ", comment=" + comment + ", regDate="
				+ regDate + ", editDate=" + editDate + ", memberId=" + memberId + ", limitStart=" + limitStart
				+ ", listCount=" + listCount + ", nickname=" + nickname +  "]";
	}

	
}
