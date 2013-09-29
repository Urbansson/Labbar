import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1;
		Book book2;
		Book book3;

		ArrayList<Book> books = new ArrayList<Book>();
		
		
		book1 = new Book("1234", "A", 2, 550, "Teddy");
		book2 = new Book("1234", "B", 4, 690, "Ludde");
		book3 = new Book("1234", "C", 2, 550, "Teddy");

		books.add(book1);
		books.add(book2);
		books.add(book3);

		Collections.sort(books);			
		
		System.out.print(books.get(0).toString());
		System.out.print(books.get(1).toString());
		System.out.print(books.get(2).toString());

		
	}

}
