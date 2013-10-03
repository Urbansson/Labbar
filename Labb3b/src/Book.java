/** Objects of this class represents books 
 * 	in which you can store a titel. isbn number, edition, price
 * 	and several authors
 */


import java.util.ArrayList;
import java.io.Serializable;

public class Book implements Comparable<Book>,Serializable{
	
	private String isbn;
	private String title;
	private int edition;
	private double price;
	private ArrayList<Author> author = new ArrayList<Author>();

	/** To create a book object you need to input
	 * The title of the book
	 * ISBN number
	 * Edition
	 * Price 
	 * And a author
	 */
	
	public Book(String title, String isbn, int edition, double price, String name){
		this.isbn = isbn;
		this.title = title;
		this.edition = edition;
		this.price = price;
		addAuthor(name);
	}
	/** Adds a author to to the book
	 */
	
	public void addAuthor(String name){
		author.add(new Author(name));
	}
	
	/** Return a ArrayList of the authors
	 */
	public ArrayList<Author> getAuthors(){
		return author;
	}
	/** Returns the title of the book
	 */
	public String getTitel(){
		return title;
	}
	
	/** Returns the ISBN of the book
	 */
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
			return this.title.compareTo(other.title);
		/*
		if(this.title.compareTo(other.title) == 0)
			return 0;
		else if(this.title.compareTo(other.title) < 0)
			return -1;
		else
			return 1;
			*/
	}
	
    private static final long serialVersionUID = 1L;

}
