import java.util.ArrayList;
import java.util.Scanner;
enum SeatStatus {
    AVAILABLE,BOOKED
}
class Seat {
    int seatNumber;
    SeatStatus status;
    Seat(int seatNumber,SeatStatus status){
        this.seatNumber=seatNumber;
        this.status=status;
    }

    boolean book(){
        if(!isAvailable()) return false;
        status = SeatStatus.BOOKED;
        return true;
    }
    boolean cancel(){
        if(isAvailable()) return false;
        status = SeatStatus.AVAILABLE;
        return true;
    }
    boolean isAvailable(){
        return status == SeatStatus.AVAILABLE;
    }
}

class Theater {
    ArrayList<Seat>seats  = new ArrayList<>();
    int totalSeat;
    int totalBookedSeats; 
    int totalFailedBooking;
    int totalAvailableSeats;
    
    
    Theater(int numberOfSeats){
        this.totalSeat = numberOfSeats;
        for(int i=1;i<=numberOfSeats;i++){
            seats.add(new Seat(i,SeatStatus.AVAILABLE));
        }
    }
    void displaySeats(){
        for(Seat s: seats) {
            System.out.println("Seat Number: "+s.seatNumber+ " STATUS: "+s.status);
        }
    }
    boolean bookSeat(int seatNumber){
            System.out.println();
            System.out.println("---------------------------------------------");
            if((seatNumber<1) || (seatNumber>totalSeat)) {
                    totalFailedBooking++;
                    System.out.println("Invalid seat number");
                    System.out.println();
                    return false;
            }
            Seat s = seats.get(seatNumber-1);
            if(s.book()){
                    System.out.println("---------------------------------------------");
                    System.out.println("Seat booked: " + seatNumber);
                    System.out.println("---------------------------------------------");
            }
            else {
                    totalFailedBooking++;
                    System.out.println("Seat already booked! Choose another Seat.");
                    System.out.println();
                    return false;
            }
            return true;
        }
    boolean cancelSeats(int seatNumber){
        if(seatNumber < 1 || seatNumber>totalSeat) {
            totalFailedBooking++;
            System.out.println("Invalid seat number");
            return false;
        }
        Seat s = seats.get(seatNumber-1);
        if(!s.cancel()){
            totalFailedBooking++;
            System.out.println("Seat is not booked yet. Cannot cancel.");
            return false;
        }
        System.out.println("Booking cancelled: "+seatNumber);
        return true;
    }
    void showStatistics(){
        totalBookedSeats=0; 
        totalAvailableSeats=0;
        for(Seat s: seats) {
            if(s.status==SeatStatus.AVAILABLE) totalAvailableSeats++;
            if(s.status==SeatStatus.BOOKED) totalBookedSeats++;
        }
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("Total Seats: "+totalSeat);
        System.out.println("Total Available Seats: "+ totalAvailableSeats);
        System.out.println("Total Booked Seats: "+totalBookedSeats);
        System.out.println("Total Failed Booking/Cancel attempts: "+totalFailedBooking);
        System.out.println("---------------------------------------------");
        System.out.println();

    }

    

}
public class BookingSystem {
    public static void main(String[] args) {
        int min = 1;
        int max = 20;
        Theater t = new Theater(max);
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
       while(condition) {
        System.out.println("----Menu----\n"+
            "1. View Seats\n" + 
            "2. Book Seat\n"+
            "3. Cancel Seat\n" +
            "4. Show Statistics\n" +
            "5. Exit\n"               
        );
        System.out.println("---------------------------------");
        System.out.print("Choose 1,2,3,4,5 as your need: ");
        if(sc.hasNextInt()) {
            int userChoice = sc.nextInt();
            System.out.println("---------------------------------");
            switch(userChoice) {
                case 1:
                    t.displaySeats();
                    System.out.println();
                    System.out.println("---------------------------------");
                    continue;
                case 2:
                    System.out.format("Choose seat from %d to %d: ",min,max);
                    int seatNo = sc.nextInt();
                    t.bookSeat(seatNo);
                    continue;
                case 3:
                        System.out.format("Choose seat to cancel: ",min,max);
                        int seatNo1 = sc.nextInt();
                        t.cancelSeats(seatNo1);
                        continue;
                case 4:
                    t.showStatistics();
                    continue;

                case 5:
                    sc.close();
                    condition=false;
                    System.out.println("---------------------------------------");
                    System.out.println("Thanks For Visiting Us.");
                    System.out.println();
                    continue;
                default:
                    System.out.println("Select given option only : 1,2,3,4,5");
                    continue;
            }
        } 
        else {
            System.out.println("Select given option only : 1,2,3,4,5");
            sc.next();
            continue;
        }
       }

    }
}
