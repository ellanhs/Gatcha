package project.gatcha.model;

public class GenreTemp {
	private String genreId;
	private int counter;
	public String getGenreId() {
		return genreId;
	}
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	@Override
	public String toString() {
		return "GenreTemp [genreId=" + genreId + ", counter=" + counter + "]";
	}
	
	
	

}
