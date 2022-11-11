import Airline.Airline;

import java.util.Scanner;
import static java.lang.System.exit;

public class Main {

    private static final Passenger passenger = new Passenger();
    private static final Airline airline = new Airline();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        airlineBookingSystem();
    }

    private static void airlineBookingSystem() {
        prompt("""
                Airline seat reservation system.
                Kindly select an option:
                1. Book Flight
                2. Exit""");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> bookFlight();
            case 2 -> exit(2);
            default -> {
                prompt("Enter a valid option");
                airlineBookingSystem();
            }
        }
    }

    private static void bookFlight(){
        prompt("""
                Kindly select an option:
                1. first class
                2. economy""");
        int classOption = scanner.nextInt();
        switch (classOption) {
            case 1 -> firstClassBooking();
            case 2 -> economyBooking();
            default -> {
                prompt("Enter a valid option");
                bookFlight();
            }
        }
    }

    private static void economyBooking() {
        passenger.selectClassType(2);
        passenger.bookFlight(airline);
        if (passenger.getSeatNumber() != -1)successfulBooking();
        else economyToFirstOption();
    }

    private static void economyToFirstOption() {
        prompt("Economy is occupied.\nWould you like to book first class? ");
        String answer = scanner.next();
        scanner.nextLine();
        if (answer.equalsIgnoreCase("yes"))firstClassBookingAlternative();
    }

    private static void successfulBooking() {
        passenger.generateAirlinePass();
        System.out.println();
        bookFlight();
    }

    private static void firstClassBookingAlternative() {
        passenger.selectClassType(1);
        passenger.bookFlight(airline);
        if (passenger.getSeatNumber() != -1)successfulBooking();
        else {
            prompt("First is occupied.\nKindly wait for the next available flight which will arrive in the next 3hrs.");
            exit(2);
        }
    }

    private static void firstClassBooking() {
        passenger.selectClassType(1);
        passenger.bookFlight(airline);
        if (passenger.getSeatNumber() != -1){
            successfulBooking();
        }
        else firstToEconomyOption();
    }

    private static void firstToEconomyOption() {
        prompt("First class is occupied.\nWould you like to book economy class? ");
        String answer = scanner.next();
        scanner.nextLine();
        if (answer.equalsIgnoreCase("yes"))economyBookingAlternative();
    }
    private static void economyBookingAlternative() {
        passenger.selectClassType(2);
        passenger.bookFlight(airline);
        if (passenger.getSeatNumber() != -1)successfulBooking();
        else {
            prompt("Economy class is occupied.\nkindly wait for the next available flight which will arrive in the next 3hrs");
            exit(2);
        }
    }
    private static void prompt(String message) {
        System.out.println(message);
    }

}