import java.util.Scanner;

public class Flights {
}

class Flight {
    private String flightNo;
    private String srcAirPort;
    private String dstAirPort;
    private String timeOfDeparture;

    public Flight(String flightNo, String srcAirPort, String dstAirPort, String timeOfDeparture) {
        this.flightNo = flightNo;
        this.srcAirPort = srcAirPort;
        this.dstAirPort = dstAirPort;
        this.timeOfDeparture = timeOfDeparture;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getSrcAirPort() {
        return srcAirPort;
    }

    public String getDstAirPort() {
        return dstAirPort;
    }

    public String getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void printFlight() {
        System.out.printf("%s - %s - %s - %s\n", flightNo, srcAirPort, dstAirPort, timeOfDeparture);
    }

}

class Dispatch {
    private Flight[] flights;

    public Dispatch() {
        Scanner in = new Scanner(System.in);

        System.out.print("How many flights?: ");
        int n = in.nextInt();

        flights = new Flight[n];

        System.out.println("Enter flight details: ");
        for (int i = 0; i< n; i++) {
            System.out.print("Flight No: ");
            String flightNo = in.nextLine();
            System.out.println();

            System.out.print("Source Air Port: ");
            String srcAirPort = in.nextLine();
            System.out.println();

            System.out.print("Destination Air Port: ");
            String dstAirPort = in.nextLine();
            System.out.println();

            System.out.print("Time of Departure: ");
            String timeOfDeparture = in.nextLine();
            System.out.println();

            flights[i] = new Flight(flightNo, srcAirPort, dstAirPort, timeOfDeparture);
        }
    }

    public void searchAirports(String flightNo) {
        for (Flight flight : flights) {
            if (flight.getSrcAirPort().equals(flightNo)) {
                flight.printFlight();
            }
        }
    }

    public void showFlightInfo() {
        System.out.println("FlightNo\tSrcDst Departure\n");
        for (Flight flight : flights) {
            flight.printFlight();
        }
    }
}

class AirPort {
    public static void main(String[] args) {
        Dispatch dispatch = new Dispatch();
        Scanner in = new  Scanner(System.in);
        System.out.println("Enter flight no: ");
        String flightNo = in.nextLine();
        dispatch.searchAirports(flightNo);
    }
}