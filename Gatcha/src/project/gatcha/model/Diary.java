package project.gatcha.model;

public class Diary {
	
	private int id;	
	private String diary;
	private String my_starpoint;
	private String edit_date;
	private String poster;
	private String title;
	private int member_id;
	private String movie_kfd_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	public String getMy_starpoint() {
		return my_starpoint;
	}
	public void setMy_starpoint(String my_starpoint) {
		this.my_starpoint = my_starpoint;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getMovie_kfd_id() {
		return movie_kfd_id;
	}
	public void setMovie_kfd_id(String movie_kfd_id) {
		this.movie_kfd_id = movie_kfd_id;
	}
	
	@Override
	public String toString() {
		return "Diary [id=" + id + ", diary=" + diary + ", my_starpoint=" + my_starpoint + ", edit_date=" + edit_date
				+ ", poster=" + poster + ", title=" + title + ", member_id=" + member_id + ", movie_kfd_id="
				+ movie_kfd_id + "]";
	}
	
}
