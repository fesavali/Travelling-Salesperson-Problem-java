import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        File file = new File("flights.txt");
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
        }
        String input =  str.toString();
      
        // I also implemented the automatic testing they teach about before to mimic their example. Not sure if its properly formatted
        Scanner scan = new Scanner(input);
        Airport air = new Airport(scan);

        air.initializeAirport();
    }
}
