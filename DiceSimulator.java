import java.util.Random;
public class DiceSimulator {
    static Random random = new Random();
    static int  rollDice() {
        int randomValue = random.nextInt(6)+1;
        return randomValue;
    } 
    static String checkWinner(int userWin,int computerWin) {
        if (userWin>computerWin) return "Congratulations! You won!";
        if (computerWin>userWin) return "You lost!";
        return "It's a draw";
    }
    public static void main(String[] args) {
            int [] count = new int [6];

            int rounds = 100;
            int userWin = 0;
            int computerWin=0;
            for(int i = 0; i<rounds; i++) {
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
            int totalRolls = 2* rounds;
            for(int i = 0; i<count.length;i++) {
                double probability = (count[i]*100.0) / totalRolls; 
               System.out.printf("%d appeared %d times Probability: %.2f%%%n",i + 1, count[i], probability);

            }

            System.out.println(checkWinner(userWin, computerWin));
    }
}