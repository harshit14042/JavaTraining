
public class BookManager {
	
	public void display(Book... bookList){
		/*for(Book eachBook:bookList){
			double discount=eachBook.findDiscount();
			double newAmount=eachBook.getRatePerUnit()*(1-discount);
			System.out.println(eachBook.getBookName());
			System.out.println(eachBook.getAuthor());
			System.out.println(eachBook.getRatePerUnit());
			System.out.println(eachBook.findDiscount());
			System.out.println(newAmount);
		}*/
		displayBooks(bookList);
	}
	
	private void displayBooks(Book[] bookList){
		for(Book eachBook:bookList){
			double discount=eachBook.findDiscount();
			double newAmount=eachBook.getRatePerUnit()*(1-discount);
			System.out.println(eachBook.getBookName());
			System.out.println(eachBook.getAuthor());
			System.out.println(eachBook.getRatePerUnit());
			System.out.println(eachBook.findDiscount());
			System.out.println(newAmount);
			System.out.println(Book.publisher);
			System.out.println(eachBook.toString());
			
		}
	}
}