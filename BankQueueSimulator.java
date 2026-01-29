import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BankQueueSimulator {
    static Random random = new Random();
    static void teller(String customer,int timetaken) {
        try{
            System.out.println(customer+" turns");
            System.out.println(customer+" using teller.");
            Thread.sleep(timetaken);
            System.out.println(customer+" Finished works.");
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        

    } 
    public static void main(String[] args){
        Queue<String> queue = new LinkedList<>();
        int customers = random.nextInt(1,51);
        int totalWaitingTime = 0;
        int currentWaitTime = 0;
        for(int i = 1;i<=customers;i++) {
            queue.add("Customer "+i);
        }
        while(!queue.isEmpty()) {
            String currentCustomer = queue.poll();
            int serviceTime = random.nextInt(1000,5000);
            System.out.println(currentCustomer+" waited " + currentWaitTime+ " ms.");
            totalWaitingTime+=currentWaitTime;
            teller(currentCustomer,serviceTime);
            currentWaitTime+= serviceTime;
            System.out.println("Queue length now: "+queue.size());
            System.out.println("---------------------------------------");
            }
            double averageTime = (double) totalWaitingTime/customers;
            System.out.println("Total Customer this time: "+ customers);
            System.out.println("The queue length: "+customers);
            System.out.println("Average waiting time: "+averageTime);
        }
    }    
