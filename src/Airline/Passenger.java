import Airline.Airline;
import ClassType.ClassType;

import static ClassType.ClassType.*;

public class Passenger {
    private int seatNumber;
    private ClassType classType;

    public void selectClassType(int classNumber) {
        if (classNumber == 1)classType = FIRST;
        if (classNumber == 2)classType = ECONOMY;
    }

    public void bookFlight(Airline airline){
        seatNumber = -1;
        var seats = airline.getSeats();
        firstClassBooking(seats);
        economyBooking(seats);
    }

    private void firstClassBooking(boolean[] seats) {
        if (classType == FIRST){
            for (int i = 0; i < 5; i++) {
                if (!seats[i]) {
                    seatNumber = i + 1;
                    seats[i] = true;
                    break;
                }
            }
        }
    }

    private void economyBooking(boolean[] seats) {
        if (classType == ECONOMY){
            for (int i = 5; i < 10; i++) {
                if (!seats[i]) {
                    seatNumber = i + 1;
                    seats[i] = true;
                    break;
                }
            }
        }
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void generateAirlinePass(){
        System.out.printf("Class type is: %s%nYour seat Number is: %d",classType,seatNumber);
    }
}
