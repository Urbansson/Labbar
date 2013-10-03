/** Objects of this class represents a UserInteraface 
 *	So that  a user can interact with the object CollectionOfBooks
 */


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

	
	/** This method is the main running loop that you call when you want to run the user interface
	 */
	public void run(){
		System.out.print("Do you want to load a file?(1/0)");
		if(scan.nextInt() == 1){
			try{
				loadFile();
			}
			catch(ClassNotFoundException e){
				System.out.println("Currupted savefile all data is lost");
			}
			catch(FileNotFoundException e){
				System.out.println("Save file not found, creating new.");
			}
			catch(IOException e){
				System.out.println("Error while loading file, all data is lost");
			}
		}
		while(running){
			menu();
		}

	}

	/*The main menu of the interface where all choises are made
	*/
	private void menu(){
		int choice;
		
		System.out.println("---MENU---");
		System.out.println("1. Add Book");
		System.out.println("2. Remove Book");
		System.out.println("3. Search Books");
		System.out.println("4. List all Books");
		System.out.println("5. Sort books");
		System.out.println("6. Save and Exit");
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
			database.sort(database.getList());
			break;
		case 6:
			saveAndExit();
			break;
		default:
			break;
		
		}

	}
	
	/*The Search menu where you enter your search word and what to search after
	*/
	private void searchMenu(){
		int choice;
		
		System.out.println("--- Search Menu---\n");
		System.out.println("1. Search Titel");
		System.out.println("2. Search Author");
		System.out.println("3. Search ISBN");
		System.out.println("4. Exit");
		choice = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter Search Word: ");
		switch(choice){
		case 1:
			getBooksByTitle(scan.nextLine());
			break;
		case 2:
			getBooksByAuthor(scan.nextLine());
			break;
		case 3:
			getBooksByIsbn(scan.nextLine());
			break;
		case 4:
			break;
		default:
			break;
		
		}

	}
	
	/*Adds a b00k in the Collectionofbooks object
	*/
	private void addBook(){
		String titel;
		String isbn;
		int edition;
		double price;
		String author;		
		
		scan.nextLine();
		System.out.println("---Add Book---");
		System.out.println("Enter Titel: ");
		titel = scan.nextLine();
		System.out.println("Enter ISBN: ");
		isbn = scan.nextLine();
		System.out.println("Enter Edition: ");
		edition = scan.nextInt();
		System.out.println("Enter Price: ");
		price = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter Author: ");
		author = scan.nextLine();
		
		database.addBook(new Book(titel, isbn, edition, price, author));
		System.out.println("Add Additional Athours? (1/0)");
		while(scan.nextInt() == 1){
			scan.nextLine();
			System.out.println("Enter Author: ");
			database.getBook(database.size()-1).addAuthor(scan.nextLine());
			
			System.out.println("Add Additional Athours? ");
		}
		System.out.println("Book Added");
	}
	
	/*Asks for the id and removes the book
	*/
	private void removeBook(){
		listBooks();
		int choice;
		System.out.println("Which book do you want to remove: ");
		choice = scan.nextInt();
		if(choice < database.size()){
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
		else{
			System.out.println("Book does not exist");
		}
	}
	
	/*Lists all of the books inside of the collection
	*/
	private void listBooks(){
		System.out.println("---Books in Database---\n");
		
		for(int i=0; i < database.size();i++ ){
			System.out.println(i + ". " + database.getBook(i).toString());
		}
		
	}
	
	/*Prints the search results
	*/
	private void printSearch(ArrayList<Book> searchResults){
		System.out.println("---Search Results---");

		for(int i = 0; i < searchResults.size();i++){
			System.out.println(searchResults.get(i).toString());
		}
	}
	
	/*Sends the search word to the right method depending on what you want to search after
	*/
	private void getBooksByTitle(String title){
		printSearch(database.searchTitel(title));		
	}
	
	private void getBooksByIsbn(String isbn){
		printSearch(database.searchIsbn(isbn));		
	}
	
	private void getBooksByAuthor(String author){
		printSearch(database.searchAuthor(author));
	}
			
	
	/*Saves the database object to a file
	*/
	private void saveAndExit(){
		String Name;
		System.out.print("Name of save: ");
		Name = scan.next();
		try{
		database.saveToFile(Name);
		}
		catch(IOException e){
			System.out.println("Error while saving file\n try again? (1/0)");
			if(scan.nextInt() == 1){
				saveAndExit();
			}
		}
		running = false;		
	}
	
	
	/*Loads a object of CollectionOfBooks and stores it in database.
	*/
	private void loadFile() throws IOException, ClassNotFoundException{
		System.out.print("Name of save: ");

		database.loadFromFile(scan.next());
	}
	
	
	
}
