import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Boeing787 {
    File file = new File("flights.txt");
    String fname = "Boeing787";
    static ArrayList<String> str = new ArrayList<>();
    public ArrayList<String> Boeing787(){
        try (BufferedReader br= new BufferedReader(new FileReader(file))) {
            String st; 
            String heading = br.readLine();
        while ((st = br.readLine()) != null){
           int file = st.indexOf(fname);
            str.addAll(st.lines().skip(file).limit(10).collect(Collectors.toList())); 
        }
        }catch (IOException e) {
            System.out.print("An Error Occured.");
        }
        
        return str;
    }
    public void setLiftOffTime(int minCounter) {
    }
}
