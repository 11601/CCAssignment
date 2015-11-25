import java.util.Date;
import java.util.List;

/**
 * Created by Hakim on 10/23/15.
 */

class ParkingLot{
    private int numberOfSpots;
    private double maxVehicleLength;
    private double maxVehicleWidth;
    private double maxVehicleHeight;
    List<ParkingSpot> spots;
    public ParkingLot(int nSpots, double lenLimit, double widthLimit, double heightLimit){}
    public int getNumvAvailableSpots(){}
    public boolean canFitCar(Car car){}
}

class Car{
    private double length;
    private double width;
    private double height;

    public void park(ParkingSpot ps) {}
}

class ParkingSpot{
    private double length;
    private double width;
    private boolean isAvailable;
    private Car car;
    public void parkCar(){}
    public void removeCar(){}
}

class Ticket{
    private Date issueDate;
    private double duration;

    public Ticket(){}

}

class AutomaticRegister{

    void returnChange(){}
    void acceptCoins(){}
    Ticket printTicket(){return new Ticket();}
}

class TicketReader{
    private static TicketReader _instance = null;
    protected TicketReader(){}

    public static TicketReader getInstance(){
        if (_instance == null){
            _instance = new TicketReader();
        }
        return _instance;
    }

    public boolean isValid(){}
    public boolean openBarrier(){}
    public void callOperator(){}
}

class Barrier{
    private static Barrier _instance = null;
    protected Barrier(){}
    public static Barrier getInstance(){
        if (_instance == null){
            _instance = new Barrier();
        }
        return _instance;
    }

    public void lift(){}
    public void putDown(){}
}


public class Solution04 {
}
