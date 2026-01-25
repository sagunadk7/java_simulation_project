public class TrafficLightSimulator {
    enum Lights {
        RED(5),YELLOW(5),GREEN(3);
        private int duration;
        Lights(int duration) {
            this.duration = duration;
        }
        public int getDuration() {
            return duration;
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Lights[] l = Lights.values();
        int index = 0;
        while(true) {
            Lights currenLights = l[index];
            System.out.println("\n🚦"+ currenLights+" LIGHT");
            for(int i = currenLights.getDuration();i>0;i--) {
                System.out.println("Changing in " + i+ " seconds...");
                Thread.sleep(1000);
            }
            index = (index+1)%l.length;
        }

    }
}
