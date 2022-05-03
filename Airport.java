import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Airport {
    private ArrayList<String> atTerminal;
    private ArrayList<Boeing787> boeing787Runway;
    private ArrayList<AirBus319> airBus319Runway;
    private ArrayList<Airplane> departed; 
    // ArrayList<Airplane> atTerminal = new ArrayList<Airplane>();
    // ArrayList<Boeing787> boeing787Runway = new ArrayList<Boeing787>();
    // ArrayList<AirBus319> airBus319Runway = new ArrayList<AirBus319>();
    // ArrayList<Airplane> departed = new ArrayList<Airplane>();
    Scanner airportName;

    public Airport(Scanner scan) {
        this.atTerminal = new ArrayList<String>();
        this.boeing787Runway = new ArrayList<Boeing787>();
        this.airBus319Runway = new ArrayList<AirBus319>();
        this.departed = new ArrayList<Airplane>();
        this.airportName = scan;
    }

    public void initializeAirport() {
        for (int i = 0; i < 20; i++) {
            if (i % 4 == 0) atTerminal.addAll(Boeing787.str);
            else atTerminal.addAll(AirBus319.str);
        }
    }

    public void runAirport(int simTime) {
        int minCounter = 1;
        while (!atTerminal.isEmpty() || !boeing787Runway.isEmpty() || !airBus319Runway.isEmpty()) {
            // If still within simTime add more planes
            if ((minCounter <= simTime) && (minCounter % 5 == 0)) {
                for (int i = 0; i < 7; i++) {
                    if (i % 3 == 0) {
                        atTerminal.addAll((Collection<? extends String>) new Boeing787());
                    } else {

                        atTerminal.addAll((Collection<? extends String>) new AirBus319());
                    }
                }
            }
            // Process Planes
            for (int i = 0; i < atTerminal.size(); i++) {
                String tempAirplane = atTerminal.get(i);
                 
                    if (tempAirplane != null) {
                        Boeing787 tempAirplane2 = new Boeing787();
                        Boeing787 tempBoeing787 = tempAirplane2;
                        boeing787Runway.add(tempBoeing787);

                    } else {
                        AirBus319 tempAirplane1 = new AirBus319();
                        AirBus319 tempAirBus319 = tempAirplane1;
                        airBus319Runway.addAll((Collection<? extends AirBus319>) tempAirBus319);
                    }
                    atTerminal.remove(tempAirplane);
                    i = i - 1;
                
            }
            // Manage Departures
            // Jumbo Runway
            if (!boeing787Runway.isEmpty() && minCounter % 5 == 0) {
                Boeing787 tempBoeing787 = boeing787Runway.remove(0);
                tempBoeing787.setLiftOffTime(minCounter);
                departed.addAll((Collection<? extends Airplane>) tempBoeing787);
            }

            // Narrow Runway
            if (!airBus319Runway.isEmpty() && minCounter % 4 == 0) {
                AirBus319 tempAirBus319 = airBus319Runway.remove(0);
                tempAirBus319.setLiftOffTime(minCounter);
                departed.addAll((Collection<? extends Airplane>) tempAirBus319);
            }
            minCounter = minCounter + 1;
        }
    }

    public void generateAirportOutput(String outputFileName) throws IOException {
        File outputFile = new File(outputFileName);
        PrintWriter outputWriter = new PrintWriter(outputFile);
        outputWriter.printf("Takeoffs at %s\n", airportName);
        outputWriter.printf(
                "%-22s%16s%10s%14s\n",
                "    Flight ID", "Lift Off Time", "Gallons", " Ticket Price");
        double totalBoeing787TicketSales = 0.0, totalAirBus319TicketSales = 0.0;
        int totalBoeing787 = 0, totalAirBus319 = 0;
        Airplane tempAirplane;
        Iterator<Airplane> departedAirplane = departed.iterator();
        while (departedAirplane.hasNext()) {
            tempAirplane = departedAirplane.next();
            if (tempAirplane != null) {
                totalBoeing787++;
                totalBoeing787TicketSales =
                        totalBoeing787TicketSales + tempAirplane.getTicketPrice();
            } else {
                totalAirBus319++;
                totalAirBus319TicketSales =
                        totalAirBus319TicketSales + tempAirplane.getTicketPrice();
            }
            outputWriter.printf(
                    "%-22s%12d%12d%13.2f\n",
                    tempAirplane.getAirplaneID(),
                    tempAirplane.getLiftOffTime(),
                    tempAirplane.getGallonsFuelLoaded(),
                    tempAirplane.getTicketPrice());
        }
        outputWriter.printf(
                "\nAverage Boeing787 ticket price is $%4.2f\n",
                totalBoeing787TicketSales / totalBoeing787);
        outputWriter.printf(
                "Average AirBus319 ticket price is $%4.2f\n",
                totalAirBus319TicketSales / totalAirBus319);
        outputWriter.close();
    }

}