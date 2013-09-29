import java.io.Serializable;
import java.util.ArrayList;

public class CollectionOfBooks implements Serializable{

	private ArrayList<Book> books = new ArrayList<Book>();
	
	public CollectionOfBooks(){	
	}
	
	public void addBook(Book book){
		books.add(book);
	}
	
	public void removeBook(int index){
		books.remove(index);
	}
	
	public ArrayList<String> searchTitel(String titel){
		ArrayList<String> title = new ArrayList<String>();
		for(int i=0; i < books.size(); i++){
			if(titel.compareTo(books.get(i).getTitel()) == 0){
				title.add(books.get(i).getTitel());
			}
		}
		return title;
	}
	
	public ArrayList<String> searchIsbn(String isbn){
		ArrayList<String> isbnList = new ArrayList<String>();
		for(int i=0; i < books.size(); i++){
			if(isbn.compareTo(books.get(i).getIsbn()) == 0){
				isbnList.add(books.get(i).getIsbn());
			}
		}
		return isbnList;
	}
	
	public ArrayList<String> searchAuthor(String Author){
		
		return null;
	}
	
	public ArrayList<Book> getBooksByTitle(String title){
	
		return null;
	}
	
	public String toString(){
		String temp = "";
		for(int i=0; i < books.size();i++){
			temp += books.get(i).toString() +"/n";
		}
		return temp;
	}
	
	public void saveToFile(){
		
	}
	
	
	private static final long serialVersionUID = 1L;

}
