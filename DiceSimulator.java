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
                System.out.println((i+1) + " appeared " + count[i]+" times");
            }
    }
}