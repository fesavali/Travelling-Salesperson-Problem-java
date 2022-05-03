import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

interface TimeAtTerminal1 {
    void getStartTimeAtTerminal();

    void setStartTimeAtTerminal();
}

class TimeAtTerminal implements TimeAtTerminal1{
    public void getStartTimeAtTerminal (){
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
        
        for (String s : str) 
     { 
         System.out.println(s); 
     }
        // System.out.println("Hello");
    }

    public void setStartTimeAtTerminal(){
        return;
    }
    public static void main(String args[]){
        TimeAtTerminal obj = new TimeAtTerminal();
    obj.getStartTimeAtTerminal();
     }
    }
