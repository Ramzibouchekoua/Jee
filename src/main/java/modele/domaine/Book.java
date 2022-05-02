package modele.domaine;

public class Book {
	private String title;
	private String author;
	private String year;
	private int matricStudent ;
	private int categorieId;
	private String categorieLibelle;

	public Book(String title, String author, String year, int matricStudent, int categorieId, String categorieLibelle) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.matricStudent = matricStudent;
		this.categorieId = categorieId;
		this.categorieLibelle = categorieLibelle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getMatricStudent() {
		return matricStudent;
	}

	public void setMatricStudent(int matricStudent) {
		this.matricStudent = matricStudent;
	}

	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public String getCategorieLibelle() {
		return categorieLibelle;
	}

	public void setCategorieLibelle(String categorieLibelle) {
		this.categorieLibelle = categorieLibelle;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", matricStudent=" + matricStudent
				+ ", categorieId=" + categorieId + ", categorieLibelle=" + categorieLibelle + "]";
	}

}
