import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        int attemptCount=1;
        int attemptLimit = 7;
        Random random = new Random();
        Scanner sc  = new Scanner(System.in);
        int secretNumber = random.nextInt(100)+1;
        while(attemptCount<=attemptLimit) {
            System.out.printf("Guess: %d.\n",attemptCount);
            System.out.print("Your Guess: ");
            int playerGuess = sc.nextInt();
            if((playerGuess<=0) || (playerGuess>100)) {
                System.out.println("Invalid guess! Enter a number between 1 and 100.");
                continue;
            }
            if(playerGuess==secretNumber) {
                System.out.println("Your guess is correct!!\n");
                System.out.printf("Your attempt: %d.",attemptCount);
                break;
            } 
            else{
                System.out.println((playerGuess>secretNumber)?"Your guess is too High":"Your guess is too Low.");
            }
            attemptCount++;
        }
        System.out.format("Correct Number is %d.\n",secretNumber);
        sc.close();
    }
}

