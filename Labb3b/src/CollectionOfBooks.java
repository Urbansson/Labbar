/** Objects of this class reprisent a collection of books
 * 	that you can use to search for titel, isbn and authurs 
 * 	and also sort the list after titels
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionOfBooks{

	private ArrayList<Book> books = new ArrayList<Book>();
	
	public CollectionOfBooks(){	
	}
	
	/** Used to add a object of book to the collection
	 */
	public void addBook(Book book){
		books.add(book);
	}
	
	/** Used to remove a book to the collection
	 * 	with help of a id
	 */
	public void removeBook(int index){
		books.remove(index);
	}
	
	/** Used to get a object of book from the collection
	 */
	public Book getBook(int index){
		return books.get(index);
	}
	
	
	/** Used to see how many books there is in the collection
	 */
	public int size(){
		return books.size();
	}
	
	
	/** Returns the entire collection of the books
	 */
	public ArrayList<Book> getList(){
		return books;
	}
	
	/** Used to Search in the collection of books after titels
	 */
	public ArrayList<Book> searchTitel(String titel){
		ArrayList<Book> title = new ArrayList<Book>();
		for(int i=0; i < books.size(); i++){
			if(titel.compareTo(books.get(i).getTitel()) == 0){
				title.add(books.get(i));
			}
		}
		return this.sort(title);
	}
	
	/** Used to Search in the collection of books after ISBN
	 */
	public ArrayList<Book> searchIsbn(String isbn){
		ArrayList<Book> isbnList = new ArrayList<Book>();
		for(int i=0; i < books.size(); i++){
			if(isbn.compareTo(books.get(i).getIsbn()) == 0){
				isbnList.add(books.get(i));
			}
		}
		return this.sort(isbnList);
	}
	
	/** Used to Search in the collection of books after Authors
	 */
	public ArrayList<Book> searchAuthor(String Author){
		
		ArrayList<Author> authorTemp = new ArrayList<Author>();
		ArrayList<Book> authorList = new ArrayList<Book>();
		
		for(int i=0; i < books.size(); i++){
			authorTemp = books.get(i).getAuthors();
			for(int k=0; k < authorTemp.size(); k++){
				if(Author.compareTo(authorTemp.get(k).getName()) == 0){
						authorList.add(books.get(i));
					}
				}
		}
		return this.sort(authorList);
	}
	
	
	public String toString(){
		String temp = "";
		for(int i=0; i < books.size();i++){
			temp += books.get(i).toString() + "\n";
		}
		return temp;
	}
	
	/** Saves the collection to a file with name 
	 */
	public void saveToFile(String Name) throws IOException{
		ObjectOutputStream oos = null;

		try{
			FileOutputStream fop = new FileOutputStream(Name);
			oos = new ObjectOutputStream(fop);
			oos.writeObject(books);
		}
		finally {
			oos.close();
		}
	}
	
	/** Loads a file with specific name
	 */
	@SuppressWarnings("unchecked")
	public void loadFromFile(String Name) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = null;

		try{
			FileInputStream fin = new FileInputStream(Name);
			ois = new ObjectInputStream(fin);

			books = (ArrayList<Book>) ois.readObject();
		}
		catch(ClassNotFoundException e){
			saveToFile(Name);
			throw e;
		}
		catch(FileNotFoundException fe){
			saveToFile(Name);
			throw fe;
		}
		catch(IOException e){
			saveToFile(Name);
			throw e;
		}
		finally{
			if (ois != null)
				ois.close();
		}
		
	}
	
	
	/** Sorts the collection with help of compareTo
	 */
	public ArrayList<Book> sort(ArrayList<Book> List){
		Collections.sort(List);
		return List;
	}
}
