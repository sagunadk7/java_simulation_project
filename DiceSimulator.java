import java.util.Random;
public class DiceSimulator {
    static Random random = new Random();
    static int  rollDice() {
        int randomValue = random.nextInt(6)+1;
        return randomValue;
    } 
    public static void main(String[] args) {
            int [] count = new int [6];
            for(int i = 0; i< 100; i++) {
                int roll = rollDice();
                count[roll-1]++;
            }
            for(int i = 0; i<=5;i++) {
                double probability = (count[i]/100.0) *100; 
               System.out.printf("%d appeared %d times Probability: %.2f%%%n",i + 1, count[i], probability);

            }
    }
}