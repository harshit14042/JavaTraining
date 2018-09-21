
public class Book {
	private int bookNumber;
	private String bookName;
	private String author;
	private int ratePerUnit;
	static String publisher="Orilley";
	
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double findDiscount(){
		double discount=0.1;
		if(author.equals("sashi")){
			discount=0.2;
		}
		return discount;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(int ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

	public Book(int bookNumber, String bookName, String author, int ratePerUnit) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.ratePerUnit = ratePerUnit;
	}
	/*public Book(int bookNumber, String bookName, String author) {
		//super();
		this(bookNumber,bookName,author,0.0);
	}*/

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.bookName;
		//return super.toString();
	}
	
	
	
}
