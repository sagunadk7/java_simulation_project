import java.util.ArrayList;
import java.util.Random;

class Library {
    private static final int DEFAULT_BORROW_DAY = 1;
    private static final int DEFAULT_RETURN_DAY = 20;
    Book book;
    int finePerDay = 50;
    Random random;
    int maxStorage;
    int totalAvailableBook;
    int totalBorrowedBook;
    int totalFailedAttempts;


    User user;
    private int maxTime = 15;
    BorrowRecord borrowRecord;
    ArrayList<BorrowRecord> borrowHistory = new ArrayList<>();
    ArrayList<Book> bookStorage = new ArrayList<>();
    Library(int maxStorage,User user,Random random){
        this.maxStorage=maxStorage;
        this.user = user;
        this.random = random;
        for(int i = 1;i<=10;i++){
            bookStorage.add(new Book(("Book "+i),BookState.AVAILABLE));
        }
    }

    void showAllBooks(){
        int i = 1;
        for(Book b: bookStorage){
            System.out.println(b+" STATUS: "+ b.state);
            i++;
        }
    }

    boolean borrowBook(int bookNo) {
        if((bookNo<1) || (bookNo>this.maxStorage)) {
            totalFailedAttempts++;
            System.out.println("Invalid option");
            return false;
        }
        Book b = bookStorage.get(bookNo-1);
         if(b.borrow(this.user,DEFAULT_BORROW_DAY)) {
             this.user.currentlyBorrowedBook = b;
             this.user.borrowedTime = random.nextInt(2,7);
             int borrowTime = 7;
             this.borrowRecord = new BorrowRecord(this.user,b);
             borrowHistory.add(this.borrowRecord);
             System.out.println("You borrowed: "+b);
             return true;
         }
         else {
             totalFailedAttempts++;
             return false;
         }
    }

    boolean returnBook(int bookNo){
        if((bookNo<1) || (bookNo>maxStorage)) {
            System.out.println("Invalid book. Enter Valid book id.");
            totalFailedAttempts++;
            return false;
        }
        Book b = bookStorage.get(bookNo-1);
        if(b.currentOwner!=null  && this.user.equals(b.currentOwner)){
            b.returnB(DEFAULT_RETURN_DAY);
            this.user.userTotalBorrowedBook.remove(b);
            if(b.getUsedTime()>maxTime) {
                int f = (b.getUsedTime()-maxTime)*finePerDay;
                this.user.setFine(f);
            }
            System.out.println("You successfully returned the book");
            return true;
        }
        else {
            totalFailedAttempts++;
            System.out.println("Either book is not borrowed or you're not the owner.");
            return false;
        }
    }
    void viewBorrowHistory(){
        for(BorrowRecord b: borrowHistory){
            System.out.printf("%s has borrowed %s on %d and returned on %d and fine is %d\n",b.user,b.book.bookName,b.book.getBorrowedTime(),b.book.getReturnTime(),b.user.getFines());
        }
    }
    void showStatistics(){
        totalAvailableBook = 0;
        totalBorrowedBook = 0;
        for(Book b: bookStorage ){
            if(b.state==BookState.AVAILABLE) totalAvailableBook++;
            if(b.state == BookState.BORROWED) totalBorrowedBook++;
        }
        System.out.println("Total Books: "+maxStorage);
        System.out.println("Total available books: "+totalAvailableBook);
        System.out.println("Total Borrowed books: "+totalBorrowedBook);
        System.out.println("Total failed attempts: "+ totalFailedAttempts);
    }

}
