import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class ModelAirport {
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;

    public ModelAirport(Scanner scan) {
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
        this.reader = scan;
    }

    public void start() {
        startAirportPanel();
    }

    public void startAirportPanel() {

        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            String input = this.reader.nextLine();

            if (input.toLowerCase().equals("x")) {
                break;

            } else if (Integer.parseInt(input) == 1) {
                System.out.println("Give plane ID: ");
                String planeID = this.reader.nextLine();

                System.out.println("Give plane capacity: ");
                int planeCapacity = Integer.parseInt(this.reader.nextLine());

                addPlane(planeID, planeCapacity);

            } else if (Integer.parseInt(input) == 2) {
                System.out.println("Give plane ID: ");
                String planeID = this.reader.nextLine();

                System.out.println("Give departure airport code: ");
                String departure = this.reader.nextLine();

                System.out.println("Give destination airport code: ");
                String destination = this.reader.nextLine();

                addFlight(planeID, departure, destination);
            }

        }
        startFlightPanel();
    }

    public void startFlightPanel() {
        System.out.println();
        System.out.println("Flight service"
                + "\n------------");
        System.out.println();
        while (true) {
            String input = this.reader.nextLine();

            if (input.toLowerCase().equals("x")) {
                break;

            } else if (Integer.parseInt(input) == 1) {
                printPlanes();

            } else if (Integer.parseInt(input) == 2) {
                printFlights();

            } else if (Integer.parseInt(input) == 3) {
                System.out.println("Give plane ID: ");
                String planeID = this.reader.nextLine();

                printPlane(planeID);
            }
        }

    }

    public void addPlane(String planeID, int planeCapacity) {
        Plane plane = new Plane(planeID, planeCapacity);

        this.planes.add(plane);
    }

    public void addFlight(String id, String departure, String destination) {

        Flight flight = new Flight(getPlaneInList(id), departure, destination);

        this.flights.add(flight);
    }

    public Plane getPlaneInList(String id) {
        Plane plane = null;
        for (Plane p : this.planes) {
            if (p.getID().equals(id));
            plane = p;
        }
        return plane;
    }

    public void printPlanes() {
        for (Plane p : this.planes) {
            System.out.println(p);
        }
    }

    public void printFlights() {
        for (Flight f : this.flights) {
            System.out.println(f);
        }
    }

    public void printPlane(String id) {
        for (Plane p : this.planes) {
            if (p.getID().equals(id)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        String name;
        System.out.println("Enter Airport Name: ");
        Scanner sc1 = new Scanner(System.in);
        name = sc1.next();
        if ( name != "JFK"){
            System.out.print("Use a valid Airport Name:");
            System.exit(0);
        }
        String time;
        System.out.print("Please enter the number of minutes to allow new flights to move to the terminal:");
        Scanner sc = new Scanner(System.in);
        time = sc.next();
        File file = new File("airport.txt");
        ArrayList<String> str = new ArrayList<>();
        try (BufferedReader br= new BufferedReader(new FileReader(file))) {
               // Declaring a string variable
               String st;
               // Condition holds true till
               String heading = br.readLine();
               while ((st = br.readLine()) != null)
               str.add(st);
            br.close();
            System.out.println(heading);
        } catch (IOException e) {
            System.out.print("An Error Occured.");
            System.exit(0);
        }
        for (String s : str) 
        { 
            System.out.println(s); 
        }
        String input = "1\n" + "HA-LOL\n" + "42\n"
        + "1\n" + "G-OWAC\n" + "101\n"
        + "2\n" + "HA-LOL\n" + "HEL\n"
        + "BAL\n" + "2\n" + "G-OWAC\n"
        + "JFK\n" + "BAL\n" + "2\n" + "HA-LOL\n"
        + "BAL\n" + "HEL\n" + "x\n" + "1\n" + "2\n"
        + "3\n" + "G-OWAC\n" + "x\n";
      
        // I also implemented the automatic testing they teach about before to mimic their example. Not sure if its properly formatted
        Scanner scan = new Scanner(input);
        ModelAirport air = new ModelAirport(scan);

        air.start();
    }

}
