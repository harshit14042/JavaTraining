
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book bFirst=new Book(101,"Book1","Author1",50);
		Book bSecond=new Book(102,"Book2","Author2",100);
		Book bThird=new Book(103,"Book3","sashi",1000);
		
		Book[] bookList=new Book[3];
		
		bookList[0]=bFirst;
		bookList[1]=bSecond;
		bookList[2]=bThird;
		
		BookManager mgr=new BookManager();
		System.out.println(Book.publisher);
		mgr.display(bookList);
		
		mgr.display(bFirst);
		mgr.display(bFirst,bSecond);
	}

}
