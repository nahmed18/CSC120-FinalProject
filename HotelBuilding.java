import java.util.ArrayList;
import java.util.List;

public class HotelBuilding{

    public String name;
    public String address;
    public int floors;
    private List<Room> rooms; 

    public HotelBuilding(String name, String address, int floors) {
        this.name = name;
        this.address = address; 
        this.floors = floors; 
        this.rooms = new ArrayList<>();
        initializeRooms();
    }

    public void initializeRooms() {
        //rooms 1-4 have a capacity of 1
        for (int i = 1; i <= 4; i++) {
            rooms.add(new Room(i, 1, false));
        }

        //rooms 5-8 have a capacity of 2
        for (int i = 5; i <= 8; i++) {
            rooms.add(new Room(i, 2, false));
        }

        //rooms 9-11 have a capacity of 3,4,5 
        rooms.add(new Room(9, 3, false));
        rooms.add(new Room(10, 4, false));
        rooms.add(new Room(11, 5, false));
    }

    public void getAvailableRoom(int size) {

    }

    public void checkInGuest(Guest guest) {
        
    }

    public void checkOutGuest(int roomNumber) {

    }




    
    
    public static void main(String[] args) {
    }
}