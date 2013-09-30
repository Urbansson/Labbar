import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	private Scanner scan = new Scanner(System.in);
	private CollectionOfBooks database = new CollectionOfBooks();
	private boolean running = true;
	
	public UserInterface(){
		
	}

	public void run(){
		try{
			loadFile();
		}
		catch(ClassNotFoundException e){
			System.out.println("Currupted savefile all data is lost");
		}
		catch(FileNotFoundException e){
			System.out.println("No save file found!");
		}
		catch(IOException e){
			System.out.println("Error while loading file, all data is lost");
		}
		while(running){
			menu();
		}
		
	}
	
	private void menu(){
		int choice;
		
		System.out.println("---MENU---");
		System.out.println("1. Add Book");
		System.out.println("2. Remove Book");
		System.out.println("3. Search Books");
		System.out.println("4. List all Books");
		System.out.println("5. Save and Exit");
		choice = scan.nextInt();
		switch(choice){
		case 1:
			addBook();
			break;
		case 2:
			removeBook();
			break;
		case 3:
			searchMenu();
			break;
		case 4:
			listBooks();
			break;
		case 5:
			saveAndExit();
			break;
		default:
			break;
		
		}

	}
	
	private void searchMenu(){
		int choice;
		
		System.out.println("--- Search Menu---\n");
		System.out.println("1. Search Titel");
		System.out.println("2. Search Author");
		System.out.println("3. Search ISBN");
		System.out.println("4. Exit");
		choice = scan.nextInt();
		
		System.out.print("Enter Search Word: ");
		switch(choice){
		case 1:
			getBooksByTitle(scan.next());
			break;
		case 2:
			getBooksByAuthor(scan.next());
			break;
		case 3:
			getBooksByIsbn(scan.next());
			break;
		case 4:
			break;
		default:
			break;
		
		}

	}
	
	private void addBook(){
		String titel;
		String isbn;
		int edition;
		double price;
		String author;		
		
		System.out.println("---Add Book---");
		System.out.println("Enter Titel: ");
		titel = scan.next();
		System.out.println("Enter ISBN: ");
		isbn = scan.next();
		System.out.println("Enter Edition: ");
		edition = scan.nextInt();
		System.out.println("Enter Price: ");
		price = scan.nextDouble();
		System.out.println("Enter Author: ");
		author = scan.next();
		
		database.addBook(new Book(titel, isbn, edition, price, author));
		System.out.println("Add Additional Athours? (1/0)");
		while(scan.nextInt() == 1){
			System.out.println("Enter Author: ");
			database.getBook(database.size()-1).addAuthor(scan.next());
			
			System.out.println("Add Additional Athours? ");
		}
		System.out.println("Book Added");
	}
	
	private void removeBook(){
		listBooks();
		int choice;
		System.out.println("Which book do you want to remove: ");
		choice = scan.nextInt();
		System.out.println(database.getBook(choice).toString());
		System.out.println("Delete: (1/0) ");
		if(scan.nextInt() == 1){
			database.removeBook(choice);
			System.out.println("Book Removed");
		}
		else{
			System.out.println("Book not removed");
		}	
	}
	
	private void listBooks(){
		System.out.println("---Books in Database---\n");
		
		for(int i=0; i < database.size();i++ ){
			System.out.println(i + ". " + database.getBook(i).toString());
		}
		
	}
	
	private void printSearch(ArrayList<Book> searchResults){
		System.out.println("---Search Results---");

		for(int i = 0; i < searchResults.size();i++){
			System.out.println(searchResults.get(i).toString());
		}
	}
	
	private void getBooksByTitle(String title){
		printSearch(database.searchTitel(title));		
	}
	
	private void getBooksByIsbn(String isbn){
		printSearch(database.searchIsbn(isbn));		
	}
	
	private void getBooksByAuthor(String author){
		printSearch(database.searchAuthor(author));
	}
			
	private void saveAndExit(){
		try{
		database.saveToFile();
		}
		catch(IOException e){
			System.out.println("Error while saving file\n try again? (1/0)");
			if(scan.nextInt() == 1){
				saveAndExit();
			}
		}
		running = false;		
	}
	
	private void loadFile() throws IOException, ClassNotFoundException{
		database.loadFromFile();
	}
	
	
	
}
