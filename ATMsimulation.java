import java.util.Scanner;
import java.util.ArrayList;

class Bank{
    protected Scanner sc; 
    private int balance = 0;
    private String accountNumber;
    protected String userOTP;
    protected int FailedAttempt = 0;
    protected ArrayList<String> history = new ArrayList<>();
    Bank(String accountNumber, Scanner sc) {
        this.accountNumber = accountNumber;
        this.sc = sc;
    }
    void withdraw(int amount) {
        int attempt=1,attemptLimit = 3;
        while(attempt<=attemptLimit) {
            System.out.print("To withdraw ");
            if(verifyOTP()){
                if(amount<=this.balance) {
                this.balance-=amount;
                this.history.add("You withdraw: " + amount+ " Your remaining balance: " + this.balance);
                System.out.println("You withdraw: " + amount + " Your remaining balance: " + this.balance);
                return;
                }
                else {
                    this.FailedAttempt++;
                    System.out.println("Not enough balance.");
                    return;
                }
            }
            else{
                System.out.println("Inavlid OTP");
            }
            attempt++;
        }
        System.out.println("Attempt Limit Exceeded!..");
    }
    void deposit(int amount) {
        int attempt=1,attemptLimit = 3;
        while(attempt<=attemptLimit) {
            System.out.print("To deposit ");
            if(verifyOTP()){
                if(amount>=0) {
                    this.balance+=amount;
                    this.history.add("You  deposit: "+amount+" Your new balance: "+this.balance);
                    System.out.println("You  deposit: "+amount+" Your new balance: "+this.balance);
                    return;
                }
                else {
                    this.FailedAttempt++;
                    System.out.println("Invalid ammount.");
                    return;
                }
            }
            else{
                System.out.println("Inavlid OTP");
            }
            attempt++;
        }
        this.FailedAttempt++;
        System.out.println("Attempt Limit Exceeded!..");
    }
    void myAccountnumber() {
        System.out.println("Your account number: "+this.accountNumber);
    }

    void myBalance() {
        System.out.println("Your Balance: "+this.balance);
    }
    void allHistory() {
        for(String element: this.history) {
            System.out.println(element);
        }
        System.out.println("Your total failed attempt: "+this.FailedAttempt);
    }
    protected boolean verifyOTP() {
        System.out.println("Enter OTP: ");
        String otp = sc.next();
        if(otp.equals(userOTP)) {
            return true;
        }
        FailedAttempt++;
        System.out.println("Invalid OTP.");
        return false;
    }

}

class ATM extends Bank {
    ATM(String accountNumber,Scanner sc) {
        super(accountNumber,sc);
    }
    void createOTP() {
        int attempt = 1,tryLimit=5;
        while(attempt<=tryLimit){
            System.out.println("Attempt: "+attempt+" Remaining attempt: "+ (tryLimit-attempt));
            System.out.print("Create 4 digit otp: ");
            String otp = sc.next();
            if(otp.length()!=4) {
                super.FailedAttempt++;
                System.out.println("Invalid OTP length. USE 4 DIGIT."); 
            }
            else{
                System.out.println("Confirm OTP: ");
                String otp2 = sc.next();
                if(otp.equals(otp2)) {
                    super.userOTP = otp2;
                    System.out.println("Remeber Your OTP is: " + super.userOTP);
                    return;
                }
                else  {
                    super.FailedAttempt++;
                    System.out.println("Try Again!!. OTP and Confirmation OTP didnot matched..");
                }
            }
            attempt++;
        }
        super.FailedAttempt++;
        System.out.println("Attempt Limit exceeded!");
    }
}

public class ATMsimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM b1 = new ATM("45656574544",sc);
        b1.createOTP();
        b1.deposit(-6000);
        b1.myBalance();
        // b1.myBalance();
        // b1.myAccountnumber();
        b1.withdraw(5000);
        b1.myBalance();
        b1.allHistory();
        sc.close();
    }
}
