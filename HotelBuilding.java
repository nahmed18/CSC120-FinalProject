import java.util.ArrayList;
import java.util.List;

public class HotelBuilding{

    public String name;
    public String address;
    public int floors; //floor 1 = lobby, floor 2 = rooms, floor 3 = cafe, floor 4 = library, floor 5 = pool
    private List<Room> rooms;

    public HotelBuilding(String name, String address, int floors) {
        this.name = name;
        this.address = address; 
        this.floors = floors; 
        this.rooms = new ArrayList<>();
        initializeRooms();
    }

    public int getTotalRooms() {
        return rooms.size(); //returns size of rooms list
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

    public void displayRooms() {
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.getRoomNumber() + " | Capacity: " + room.getRoomCapacity() + " | Availability: " + room.occupiedStatus());
            if (room.isOccupied) {
                System.out.println("Guest/s: " + room.getCurrentGuest());
            }
        }
    }


    public boolean checkInGuest(Guest guest, int roomNumber) {
        Room room = rooms.get(roomNumber-1);

        if (roomNumber < 1 || roomNumber > rooms.size()) {
            System.out.println("Room " + roomNumber + " does not exist.");
            return false; 
        }

        if (room.isOccupied()) {
            System.out.println("Room " + roomNumber + " is already occupied.");
            return false; 
        }
        
        if (room.getRoomCapacity() < guest.getPartySize()) {
            System.out.println("Room " + roomNumber + " is too small for " + guest.name);
            
            return false; 
        }

        room.setCurrentGuest(guest);
        room.setOccupied(true);
        System.out.println(guest.name + " assigned to Room #" + room.getRoomNumber());
        return true;
    }

    public void checkOutGuest (int roomNumber) {
        Room room = rooms.get(roomNumber - 1);

        if (!room.isOccupied()) {
            System.out.println("Room " + roomNumber + " is already empty.");
        }

        Guest guest = room.getCurrentGuest(); 
        System.out.println(guest.name + " has checked out of Room #" + roomNumber);
        room.setCurrentGuest(null); 
        room.setOccupied(false); 
    }

    
    public static void main(String[] args) {
        HotelBuilding Hilton = new HotelBuilding("Hilton", "elm st", 4);
        Hilton.displayRooms();

        Guest Bob = new Guest("Bob", 30, "none", "none", "Is very rude", "YAY", 1);
        Guest Al = new Guest("Al", 40, "none", "none", "Is very rude", "YAY", 3);
        Hilton.checkInGuest(Bob, 1);
        Hilton.checkInGuest(Al, 3);


        Hilton.displayRooms();

        Hilton.checkOutGuest(1);
        Hilton.displayRooms();


    }
}