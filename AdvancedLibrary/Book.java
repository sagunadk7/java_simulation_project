package AdvancedLibrary;

class Book {
    String bookName;
    User currentOwner;
    BookState state;
    private int returnTime;
    private int borrowedTime;
    Book(String bookName,BookState state){
        this.bookName = bookName;
        this.state = state;
    }
    boolean isAvailable(){
        return state == BookState.AVAILABLE;
    }

    boolean borrow(User currentOwner,int borrowedTime){
        if(currentOwner.userTotalBorrowedBook.size()>=2){
            System.out.println("Maximum borrow limit reached for user.");
            return false;
        }
        if(!isAvailable()) {
            System.out.println("This book is already Booked.");
            return false;
        }
        this.borrowedTime = borrowedTime;
        state = BookState.BORROWED;
        this.currentOwner = currentOwner;
        this.currentOwner.userMaxBorrow+=1;
        currentOwner.userTotalBorrowedBook.add(this);
        return true;
    }

    boolean returnB(int returnTime){
        if(isAvailable()) return false;
        state = BookState.AVAILABLE;
        this.returnTime = returnTime;
        this.currentOwner = null;
        return true;
    }

    public String toString(){
        return bookName;
    }

    int getUsedTime(){
        return (this.returnTime-this.borrowedTime);
    }
    int getReturnTime(){
        return this.returnTime;
    }
    int getBorrowedTime(){
        return  this.borrowedTime;
    }
}