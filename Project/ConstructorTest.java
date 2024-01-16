import java.util.*;

public class ConstructorTest {

    static String line_separator = "\n////////////////////////////////////////\n";

    static void printLine() {
        System.out.print(line_separator);
    }

    public static void Testall() {
        Location timisoara = new Location("Timisoara", "Romania", new Vector3(0, 0, 0));
        Location bucuresti = new Location("Bucuresti", "Romania", new Vector3(1, 1, 1));
        Flight flight = new Flight("1", timisoara, bucuresti);
        Passenger passenger = new Passenger("Bogdan", 19, "1", "p1");
        Ticket ticket = new Ticket(1, passenger, flight);
        Plane plane = new Plane("001", "Boeing", 240, 1250);
        plane.addPassenger(passenger);
        List<Terminal> terminals = new ArrayList<>();
        terminals.add(new Terminal("01", null, null));
        List<Plane> planes = new ArrayList<>();
        planes.add(plane);
        Airport airport = new Airport("T", terminals, planes);

        // printing all
        System.out.print(timisoara);
        printLine();
        System.out.print(bucuresti);
        printLine();
        System.out.print(flight);
        printLine();
        System.out.print(passenger);
        printLine();
        System.out.print(ticket);
        printLine();
        System.out.print(plane);
        printLine();
        System.out.print(airport);
    }

     //@Test
    // public void testLocation() {
    //     Location timisoara = new Location("Timisoara", "Romania", new Vector3(0, 0, 0));
    //     assertNotNull(timisoara);
    // }

    // //@Test
    // public void testFlight() {
    //     Location timisoara = new Location("Timisoara", "Romania", new Vector3(0, 0, 0));
    //     Location bucuresti = new Location("Bucuresti", "Romania", new Vector3(1, 1, 1));
    //     Flight flight = new Flight("1", timisoara, bucuresti);
    //     assertNotNull(flight);
    // }

    // //@Test
    // public void testPassenger() {
    //     Passenger passenger = new Passenger("Bogdan", 19, "1", "p1");
    //     assertNotNull(passenger);
    // }

    // public static void main(String[] args) {
    //     Testall();
    // }
}
