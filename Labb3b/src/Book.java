import java.util.ArrayList;

public class Book implements Comparable<Book>{
	
	private String isbn;
	private String title;
	private int edition;
	private double price;
	private ArrayList<Author> author = new ArrayList<Author>();

	
	public Book(String isbn, String title, int edition, double price, String name){
		this.isbn = isbn;
		this.title = title;
		this.edition = edition;
		this.price = price;
		addAuthor(name);
	}
	
	public void addAuthor(String name){
		author.add(new Author(name));
	}
	
	public ArrayList<Author> getAuthors(){
		return author;
	}
	
	public String getTitel(){
		return title;
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public String toString(){
		String string;
		string =  "ISBN: " + isbn + "\nTitle: " + title + "\nEdition: " + edition + "\nPrice: " + price +"\nAthors:\n";
		for(int i = 0; i < author.size();i++){
			string += author.get(i).getName() + "\n";
		}
		return string;
	}
	
	@Override
	public int compareTo(Book other) {
		if(this.title.compareTo(other.title) == 0)
			return 0;
		else if(this.title.compareTo(other.title) < 0)
			return -1;
		else
			return 1;
	}
	
}
