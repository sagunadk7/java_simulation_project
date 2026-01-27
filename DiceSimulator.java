import java.util.Random;
public class DiceSimulator {
    static Random random = new Random();
    static int  rollDice() {
        int randomValue = random.nextInt(6)+1;
        return randomValue;
    } 
    static String checkWinner(int userWin,int computerWin) {
        return (userWin>computerWin)?"Congratulation!! You Won!!" : "You loose!!";
    }
    public static void main(String[] args) {
            int [] count = new int [6];

            int round = 5;
            int userWin = 0;
            int computerWin=0;
            for(int i = 0; i<=round; i++) {
                int userRoll = rollDice();
                int computerRoll = rollDice();
                if(userRoll>computerRoll) {
                    userWin++;
                } else if(computerRoll>userRoll) {
                    computerWin++;
                }
                count[userRoll-1]++;
                count[computerRoll-1]++;
            }
            for(int i = 0; i<=round;i++) {
                double probability = (count[i]/100.0) *100; 
               System.out.printf("%d appeared %d times Probability: %.2f%%%n",i + 1, count[i], probability);

            }

            System.out.println(checkWinner(userWin, computerWin));
    }
}