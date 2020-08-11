package project.gatcha.model;

public class MovieHasGenre {

	private int id;
	private String movieKfaId;
	private int genreId;
	private String genreList;
	private String regDate;
	private String editDate;
	
	
	public String getGenreList() {
		return genreList;
	}
	public void setGenreList(String genreList) {
		this.genreList = genreList;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieKfaId() {
		return movieKfaId;
	}
	public void setMovieKfaId(String movieKfaId) {
		this.movieKfaId = movieKfaId;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
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
	@Override
	public String toString() {
		return "MovieHasGenre [id=" + id + ", movieKfaId=" + movieKfaId + ", genreId=" + genreId + ", genreList="
				+ genreList + ", regDate=" + regDate + ", editDate=" + editDate + "]";
	}
	
	
	
	
	
	
}
