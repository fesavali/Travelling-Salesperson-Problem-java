
public class Airplane {

    private String departure;
    private String destination;
    private Plane plane;
    
    public Airplane(Plane plane, String departure, String destination){
        this.departure = departure;
        this.destination = destination;
        this.plane = plane;
    }
    
    @Override
    public String toString(){
        return this.plane.toString() + " (" + this.departure + "-" + this.destination + ")";
    }

    public double getTicketPrice() {
        return 0;
    }

    public Object getAirplaneID() {
        return null;
    }

    public Object getLiftOffTime() {
        return null;
    }

    public Object getGallonsFuelLoaded() {
        return null;
    }

}
