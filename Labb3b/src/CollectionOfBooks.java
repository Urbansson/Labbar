import java.io.*;
import java.util.ArrayList;

public class CollectionOfBooks{

	private ArrayList<Book> books = new ArrayList<Book>();
	
	public CollectionOfBooks(){	
	}
	
	public void addBook(Book book){
		books.add(book);
	}
	
	public void removeBook(int index){
		books.remove(index);
	}
	
	public Book getBook(int index){
		return books.get(index);
	}
	
	public int size(){
		return books.size();
	}
	
	public ArrayList<Book> searchTitel(String titel){
		ArrayList<Book> title = new ArrayList<Book>();
		for(int i=0; i < books.size(); i++){
			if(titel.compareTo(books.get(i).getTitel()) == 0){
				title.add(books.get(i));
			}
		}
		return title;
	}
	
	public ArrayList<Book> searchIsbn(String isbn){
		ArrayList<Book> isbnList = new ArrayList<Book>();
		for(int i=0; i < books.size(); i++){
			if(isbn.compareTo(books.get(i).getIsbn()) == 0){
				isbnList.add(books.get(i));
			}
		}
		return isbnList;
	}
	
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
		return authorList;
	}
	
	public String toString(){
		String temp = "";
		for(int i=0; i < books.size();i++){
			temp += books.get(i).toString() + "\n";
		}
		return temp;
	}
	
	public void saveToFile() throws IOException{
		ObjectOutputStream oos = null;

		try{
			FileOutputStream fop = new FileOutputStream("savefile.save");
			oos = new ObjectOutputStream(fop);
			oos.writeObject(books);
		}
		finally {
			oos.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void loadFromFile() throws IOException, ClassNotFoundException{
		ObjectInputStream ois = null;

		try{
			FileInputStream fin = new FileInputStream("savefile.save");
			ois = new ObjectInputStream(fin);

			books = (ArrayList<Book>) ois.readObject();
		}
		catch(ClassNotFoundException e){
			saveToFile();
			throw e;
		}
		catch(FileNotFoundException fe){
			saveToFile();
			throw fe;
		}
		catch(IOException e){
			saveToFile();
			throw e;
		}
		finally{
			if (ois != null)
				ois.close();
		}
		
	}
}
