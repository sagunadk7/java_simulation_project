package AdvancedLibrary;
import java.util.ArrayList;
class User {
    String userName;
    Book currentlyBorrowedBook;
    int borrowedTime;
    private int fines;
    int userMaxBorrow;
    ArrayList<Book> userTotalBorrowedBook = new ArrayList<>();
    User(String userName){
        this.userName = userName;
    }
    public void setFine(int fine){
        this.fines = fine;
    }
    public String toString(){
        return this.userName;
    }
    public int getFines() {
        return fines;
    }
}