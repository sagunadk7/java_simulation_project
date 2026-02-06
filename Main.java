import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int books = 10;
        Library l = new Library(books,new User("Sagar"),new Random());
        boolean condition = true;
        while(condition){
            System.out.println("-----------------------------------------------");
            System.out.println("*****WELCOME TO LIBRARY MANAGEMENT SYSTEM*****");
            System.out.println("-----------------------------------------------");
            System.out.println("Welcome to the library");
            System.out.println("""
                                    1. View All Book
                                    2. Borrow a Book
                                    3. Return a Book
                                    4. View Statistics
                                    5. View Borrowed History
                                    6. Exit
                                """);

            System.out.println("-----------------------------------------");
                System.out.print("Choose valid option only \"For eg, 1 for Total Books\": ");
                if(sc.hasNextInt()){
                    int userChoice = sc.nextInt();
                    if((userChoice>=1)&&(userChoice<=6)){
                        switch (userChoice) {
                            case 1:
                                l.showAllBooks();
                                continue;
                            case 2:
                                System.out.println("---------------------------------------");
                                System.out.printf("To borrow, Choose book using id from 1 to %d: ",books);
                                int userChoice1 = sc.nextInt();
                                l.borrowBook(userChoice1);
                                continue;
                            case 3:
                                System.out.printf("To return, Choose book using id from 1 to %d: ",books);
                                int userChoice2 = sc.nextInt();
                                l.returnBook(userChoice2);
                                System.out.println("---------------------------------------");
                                continue;
                            case 4:
                                l.showStatistics();
                                continue;



                            case 5:
                                l.viewBorrowHistory();
                                continue;
                            case 6:
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