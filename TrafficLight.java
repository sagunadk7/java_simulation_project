import java.util.Random;
enum Lights {
    Red, Green, Yellow
}

public class TrafficLight {
    static Random random = new Random();
    static void pedestriansCrossRoad() {
        System.out.println("Pedestrians crossing the road");
    }
    static void pedestriansWait() {
        System.out.println("Pedestrians Waiting");
    }
    static void vehiclePass() {
        System.out.println("Vehicle Passing the road");
    }
    static void slowVehicle () {
        System.out.println("Slow Down Speed, Red light about to turn on..");
    }
    static void vehicleWait() {
        System.out.println("Vehicle Waiting");
    }
    
    public static void main(String[] args) throws InterruptedException {
        int round = 5;
        int cars = 0;
        int pedestriansWaitTime = 0;
        Lights[] l =  Lights.values();
        while(round>=1) {
            for(Lights elements: l) {
                switch(elements) {
                    case Red:
                        pedestriansCrossRoad();
                        vehicleWait(); 
                        Thread.sleep(1000);
                        break;
                    case Yellow:
                        slowVehicle();
                        Thread.sleep(500);
                        pedestriansWaitTime+=1;
                        break;
                    
                    case Green:
                        pedestriansWait();
                        vehiclePass();
                        cars+=random.nextInt(100);
                        Thread.sleep(1000);
                        pedestriansWaitTime+=1;
                        break;
                }
        }
        round--;
        }
System.out.println("Numbers of Cars Crossed: "+cars);
System.out.println("Pedestrians Wait Time: "+pedestriansWaitTime+" Seconds.");

    }
}
