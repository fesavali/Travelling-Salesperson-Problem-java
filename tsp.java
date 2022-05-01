// import required classes and packages  
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap; 
  
// create TSPExample class to implement TSP code in Java  
class tsp   
{  
    static int V = 4;
    // create findHamiltonianCycle() method to get minimum weighted cycle   
    static int findHamiltonianCycle(int[][] distance, boolean[] visitCity, int currPos, int cities, int count, int cost, int hamiltonianCycle)   
    {  
    
        if (count == cities && distance[currPos][0] > 0)   
        {  
            hamiltonianCycle = Math.min(hamiltonianCycle, cost + distance[currPos][0]);  
            return hamiltonianCycle;  
        }  
    
        // BACKTRACKING STEP  
        for (int i = 0; i < cities; i++)   
        {  
            if (visitCity[i] == false && distance[currPos][i] > 0)   
            {  
    
                // Mark as visited  
                visitCity[i] = true;  
                hamiltonianCycle = findHamiltonianCycle(distance, visitCity, i, cities, count + 1, cost + distance[currPos][i], hamiltonianCycle);  
    
                // Mark ith node as unvisited  
                visitCity[i] = false;  
            }  
        }  
        return hamiltonianCycle;  
    }  
    
    // main() method start  
    public static void main(String[] args)  
    {  
        //call the greedy method
        System.out.println("Using Greedy Method:");
        //excecution time
        tsp obj = new tsp();
        long start1 = System.nanoTime();
        obj.greedy();
        long end1 = System.nanoTime();      
        System.out.println("Excecution Time in nano seconds: "+ (end1-start1));   
        // greedy();

        //call the random method
        System.out.println("Using Random Method:");
        long start = System.nanoTime();
        obj.random();
        long end = System.nanoTime();      
        System.out.println("Excecution Time in nano seconds: "+ (end-start));
        // random();


        //call the RL method
        System.out.println("Using RL Method:");
        int graph[][] = 
        {{0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}};
        int s = 0;
        long start2 = System.nanoTime();
        System.out.println("RL Method Minimum travel cost: " + obj.RL(graph, s)); 
        long end2 = System.nanoTime();      
        System.out.println("Excecution Time in nano seconds: "+ (end2-start2));
        // System.out.println("RL Method Minimum travel cost: " + RL(graph, s));        
    }

    private int RL(int[][] graph, int s) {
        // store all vertex apart
            // from source vertex
            ArrayList<Integer> vertex =
            new ArrayList<Integer>();

            for (int i = 0; i < V; i++)
            if (i != s)
            vertex.add(i);

            // store minimum weight
            // Hamiltonian Cycle.
            int min_path = Integer.MAX_VALUE;
            do
            {
            // store current Path weight(cost)
            int current_pathweight = 0;

            // compute current path weight
            int k = s;

            for (int i = 0;
            i < vertex.size(); i++)
            {
            current_pathweight +=
                graph[k][vertex.get(i)];
            k = vertex.get(i);
            }
            current_pathweight += graph[k][s];

            // update minimum
            min_path = Math.min(min_path,
                        current_pathweight);

            } while (findNextPermutation(vertex));

            return min_path;
    }

    private static boolean findNextPermutation(ArrayList<Integer> data) 
        {                    
            // If the given dataset is empty
            // or contains only one element
            // next_permutation is not possible
            if (data.size() <= 1)
            return false;

            int last = data.size() - 2;

            // find the longest non-increasing
            // suffix and find the pivot
            while (last >= 0)
            {
            if (data.get(last) <
                data.get(last + 1))
            {
                break;
            }
            last--;
            }

            // If there is no increasing pair
            // there is no higher order permutation
            if (last < 0)
            return false;

            int nextGreater = data.size() - 1;

            // Find the rightmost successor
            // to the pivot
            for (int i = data.size() - 1;
                    i > last; i--) {
            if (data.get(i) >
                data.get(last))
            {
                nextGreater = i;
                break;
            }
            }

            // Swap the successor and
            // the pivot
            data = swap(data,
                        nextGreater, last);

            // Reverse the suffix
            data = reverse(data, last + 1,
                        data.size() - 1);

            // Return true as the
            // next_permutation is done
            return true;
    }

    private static ArrayList<Integer> reverse(ArrayList<Integer> data, int left, int right) 
    {
        // Reverse the sub-array
        while (left < right)
        {
            int temp = data.get(left);
            data.set(left++,
                    data.get(right));
            data.set(right--, temp);
        }
 
        // Return the updated array
        return data;
    }

    private static ArrayList<Integer> swap(ArrayList<Integer> data, int left, int right) 
    {
                // Swap the data
        int temp = data.get(left);
        data.set(left, data.get(right));
        data.set(right, temp);
        
        // Return the updated array
        return data;
    }

    private void random() {
        TreeMap<String, Map<String, Integer>> routes = new TreeMap<String, Map<String, Integer>>();
        // create some input
        String[] routeStrings ={"Miami : Florida : 10", "Miami : Toronto : 3", "Miami : Texas : 30", "Texas : Miami : 7", "Texas : Florida : 5"};
        // parse and populate map
        for (String route: routeStrings){
            String[] sourceDestinationCost = route.split(" : ");
            String source = sourceDestinationCost[0];
            String destination = sourceDestinationCost[1];
            Integer cost = Integer.parseInt(sourceDestinationCost[2]);
    
            // create entry for source if needed
            if (!routes.containsKey(source)){
                routes.put(source, new TreeMap<String, Integer>());
            }
            routes.get(source).put(destination, cost);
        }
    
        // see result
        System.out.println("Random Method Minimum travel cost: "+ routes.toString());
    }

    private int greedy() {
        int cities;  
        String names; 
        ArrayList<String> LIST = new ArrayList<String>(); 
        try (//create scanner class object to get input from user  
        Scanner sc = new Scanner(System.in)) {
            // get total number of cities from the user  
            System.out.println("Enter total number of cities to visit");  
            cities = sc.nextInt();
             
            while(LIST.size() <= cities){
                System.out.println("Enter City Name:");  
                names = sc.next().toString();
                LIST.add(names); 
            }
            //get distance of cities from the user  
            int distance[][] = new int[cities][cities];
            for( int s = 0; s < cities; s++){  
                for( int t = 0; t < cities; t++){ 
                    System.out.println(" Enter Distance from: " + LIST.get(s+0).toString() +" to: "+ LIST.get(t+1).toString() +": ");  
                    distance[s][t] = sc.nextInt();  
                }  
            }  

            // create an array of type boolean to check if a node has been visited or not  
            boolean[] visitCity = new boolean[cities];  

            // by default, we make the first city visited  
            visitCity[0] = true;  
            
            
            int Q = Integer.MAX_VALUE;  

            // call findHamiltonianCycle() method that returns the minimum weight Hamiltonian Cycle
            Q = findHamiltonianCycle(distance, visitCity, 0, cities, 1, 0, Q);  

            //print starting city
            System.out.println("Starting City: " + LIST.get(0).toString());
            //print starting city
            System.out.println("Ending City: " + LIST.get(LIST.size() - 1).toString());

            //print cities visited
            //Visited Cities
            System.out.println("List of Visited Cities: ");
            for (int i = 0; i < LIST.size();i++) 
            { 		      
                System.out.println(LIST.get(i)); 		
            }  
            // print the minimum weighted Hamiltonian Cycle  
            System.out.println("Greedy Method Minimum travel cost: " + Q);

            return Q;
        }
    }  
}  