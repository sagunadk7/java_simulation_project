import java.util.ArrayList;
import java.util.Scanner;
enum BookState {
    AVAILABLE,BORROWED
}
class Book {
    int id;
    String title;
    BookState status;
    Book(int id,String title,BookState status){
        this.id=id;
        this.title=title;
        this.status=status;
    }
    boolean isAvailable(){
        return status==BookState.AVAILABLE;
    }
    boolean borrow(){
        if(!isAvailable()) return false;
        status=BookState.BORROWED;
        return  true;
    }
    boolean returnB(){
        if(isAvailable()) return false;
        status = BookState.AVAILABLE;
        return true;
    }
}
class Library{
    private int totalBooks;
    private int totalBorrowedBooks;
    private int totalAvailableBooks;
    private int totalFailedAttempts;
    ArrayList<Book> library = new ArrayList<>();

    Library(int numberOfBooks){
        totalBooks=numberOfBooks;
        for(int i=1;i<=numberOfBooks;i++){
            library.add(new Book(i,("Book "+i),BookState.AVAILABLE));
        }
    }
    void showBooks(){
        for(Book b:library ){
            System.out.format("ID: %d Books: (%s)  Status: %s \n",b.id,b.title,b.status);
        }
        System.out.println("-----------------------------------------");
        System.out.println();
    }
    boolean borrowBook(int BookNo){
        if((BookNo<1) || (BookNo>totalBooks)) {
            System.out.println("Invalid Book.");
            System.out.println("---------------------------------------");
            totalFailedAttempts++;
            return false;
        }
        Book book = library.get(BookNo-1);

        if(book.borrow()) {
            System.out.println("---------------------------------------");
            System.out.println("You Borrowed the book: "+book.title);
            System.out.println("---------------------------------------");
            return true;
        }
        totalFailedAttempts++;
        System.out.println("Error Borrowing book");
        System.out.println("---------------------------------------");
        return false;
    }
    boolean returnBook(int BookNo) {
        if((BookNo<1) || (BookNo>totalBooks)) {
            System.out.println("Invalid Book.");
            System.out.println("---------------------------------------");
            totalFailedAttempts++;
            return false;
        }
        Book book = library.get(BookNo-1);

        if(!book.returnB()) {
            totalFailedAttempts++;
            System.out.println("This book is not Booked Yet.");
            System.out.println("---------------------------------------");
            return false;
        }
        System.out.println("---------------------------------------");
        System.out.println("You returned the book: "+book.title);
        System.out.println("---------------------------------------");
        return true;
    }
    void statistics(){
        totalAvailableBooks = 0;
        totalBorrowedBooks = 0;
        for(Book b:library ){
            if(b.status==BookState.AVAILABLE)totalAvailableBooks++;
            else if (b.status==BookState.BORROWED)totalBorrowedBooks++;
        }
        System.out.println("Total Book: "+totalBooks);
        System.out.println("Total Borrowed Books: "+totalBorrowedBooks);
        System.out.println("Total Available Books: "+totalAvailableBooks);
        System.out.println("Total Faile Attempts: "+totalFailedAttempts);
        System.out.println("---------------------------------------");
        System.out.println();

    }

}
public class BookLendingSystem {
    public static void main(String[] args) {
        int books = 10;
        Library l = new Library(books);
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while (condition){
            System.out.println("Welcome to the library");
            System.out.println(
                "1.Total Books\n"+
                "2.Borrow a Book\n"+
                "3.Return a Book\n"+
                "4.View Statistics\n"+
                "5.Exit"
            );
            System.out.println("-----------------------------------------");

            System.out.print("Choose valid option only \"For eg, 1 for Total Books\": ");
            if(sc.hasNextInt()){
                int userChoice = sc.nextInt();
                if((userChoice>=1)&&(userChoice<=5)){
                    switch (userChoice) {
                        case 1:
                            l.showBooks();
                            continue;
                        case 2:
                            System.out.println("---------------------------------------");
                            System.out.printf("To borrow, Choose book using id from 1 to %d: ",books);
                            int userChoice1 = sc.nextInt();
                            l.borrowBook(userChoice1);
                            continue;
                        case 3:
                            System.out.printf("To return, Choose book using id from 1 to %d\n",books);
                            System.out.println("---------------------------------------");
                            int userChoice2 = sc.nextInt();
                            l.returnBook(userChoice2);
                            continue;
                        case 4:
                            l.statistics();
                            continue;
                        case 5:
                            condition=false;
                            System.out.println();
                            System.out.println("-----------------------------------------");
                            System.out.println("Thank You For Using Library.");
                            System.out.println("-----------------------------------------\n");
                            break;  
                    }
                }
                else {
                    System.out.println("-----------------------------------------");
                    System.out.println("Choose the valid option.");
                    System.out.println("-----------------------------------------");
                    continue;  
                }
            }
            else {
                sc.next();
                System.out.println("Choose the valid option.");
                System.out.println("-----------------------------------------");
            }
        }
        sc.close();
    }
}
