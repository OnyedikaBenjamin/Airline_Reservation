import Airline.Airline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ClassType.ClassType.*;

class PassengerTest {

    private Passenger passenger;
    private Airline airline;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        passenger = new Passenger();
        airline = new Airline();
    }

    @Test
    void testThatIfAPassengerEnters1_FirstClassWillBeTheClassType(){
        passenger.selectClassType(1);
        assertEquals(FIRST, passenger.getClassType());
    }

    @Test
    void testThatIfAPassengerEnters2_EconomyWillBeTheClassType(){
        passenger.selectClassType(2);
        assertEquals(ECONOMY, passenger.getClassType());
    }

    @Test
    void testThatIfAPassengerClassIsFirst_SeatNumberIsBetweenOneToFiveWhenThePassengerBooksFlight(){
        passenger.selectClassType(1);
        passenger.bookFlight(airline);
        assertEquals(1, passenger.getSeatNumber());

        passenger.selectClassType(1);
        passenger.bookFlight(airline);
        assertEquals(2, passenger.getSeatNumber());
    }

    @Test
    void testThatIfAPassengerClassIsEconomy_SeatNumberIsBetweenSixToTenWhenThePassengerBooksFlight(){
        passenger.selectClassType(2);
        passenger.bookFlight(airline);
        assertEquals(6, passenger.getSeatNumber());

        passenger.selectClassType(2);
        passenger.bookFlight(airline);
        assertEquals(7, passenger.getSeatNumber());
    }
}