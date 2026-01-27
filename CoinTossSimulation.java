import java.util.Random;
import java.util.Scanner;

public class CoinTossSimulation {

    static Random random = new Random();

    static int tossCoin() {
        return random.nextInt(2); // 0 = head, 1 = tail
    }

    static void checkResult(String userChoice, int head, int tail) {
        if (head == tail) {
            System.out.println("It's a tie!");
        } else if (userChoice.equalsIgnoreCase("head") && head > tail) {
            System.out.println("Congratulations! You Win!");
        } else if (userChoice.equalsIgnoreCase("tail") && tail > head) {
            System.out.println("Congratulations! You Win!");
        } else {
            System.out.println("Sorry! You Lose!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tosses: ");
        int tosses = sc.nextInt();
        if(tosses <= 0) {
            System.out.println("Number of tosses must be a positive integer.");
            sc.close();
            return;
        }   
        System.out.print("Choose Head or Tail: ");
        String userChoice = sc.next();
        if (!userChoice.equalsIgnoreCase("head") &&
        !userChoice.equalsIgnoreCase("tail")) {
        System.out.println("Invalid choice! Please choose Head or Tail.");
        sc.close();
        return;
        }
        int head = 0, tail = 0;

        for (int i = 0; i < tosses; i++) {
            if (tossCoin() == 0) {
                head++;
            } else {
                tail++;
            }
        }

        sc.close();

        System.out.println("Total Heads: " + head);
        System.out.println("Total Tails: " + tail);

        checkResult(userChoice, head, tail);
    }
}
