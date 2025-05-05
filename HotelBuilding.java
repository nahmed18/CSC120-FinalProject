import java.util.ArrayList;
import java.util.List;

/**
 * Represents hotel building with a name, address, floors, and list of rooms
 */
public class HotelBuilding{

    //Hotel attributes
    public String name;
    public String address;
    public int floors;
    private ArrayList<Room> rooms;

    /**
     * Constructs a HotelBuilding with specified name, address, and floors
     * Initializes room list and populates rooms by calling initializeRooms()
     * @param name hotel name
     * @param address hotel address
     * @param floors number of floors in hotel
     */
    public HotelBuilding(String name, String address, int floors) {
        this.name = name;
        this.address = address; 
        this.floors = floors; 
        this.rooms = new ArrayList<>();
        initializeRooms();
    }

    /**
     * returns total number of rooms in hotel
     * @return number of rooms
     */
    public int getTotalRooms() {
        return rooms.size(); //returns size of rooms list
    }

    /**
     * returns list of rooms in hotel
     * @return rooms list
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Initalizes rooms list with default room numbers and capacities
     * - Rooms 1-4: capacity 1
     * - Rooms 5-7: capacity 2
     * - Rooms 8, 9, 10: capacities 3, 4, 5
     */
    public void initializeRooms() {
        //rooms 1-4 have a capacity of 1
        for (int i = 1; i <= 4; i++) {
            rooms.add(new Room(i, 1, false));
        }

        //rooms 5-8 have a capacity of 2
        for (int i = 5; i <= 7; i++) {
            rooms.add(new Room(i, 2, false));
        }

        //rooms 9-10 have a capacity of 3,4,5
        rooms.add(new Room(8, 3, false));
        rooms.add(new Room(9, 4, false));
        rooms.add(new Room(10, 5, false));
    }

    /**
     * Displays each room's number, capacity, and availability status
     * If occupied, also displays current guest
     */
    public void displayRooms() {
        for (Room room : rooms) {
            System.out.println("\nRoom Number: " + room.getRoomNumber() + " | Capacity: " + room.getRoomCapacity() + " | Availability: " + room.availabilityStatus());
            if (room.isOccupied) {
                System.out.println("Guest/s: " + room.getCurrentGuest());
            }
        }
    }

    /**
     * Attempts to check a guest into the specified room number
     * Validates room existence, occupancy, and capacity
     * 
     * @param guest Guest to check in
     * @param roomNumber target room number (which is subtracted by 1)
     * @return true if check-in succeeded; false otherwise
     */
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
            System.out.println("\nRoom " + roomNumber + " is too small for " + guest.name);
            return false; 
        }

        room.setCurrentGuest(guest);
        room.setOccupied(true);
        System.out.println("\n" + guest.name + " assigned to Room #" + room.getRoomNumber());
        return true;
    }

    /**
     * Checks out guest from specified room number
     * Displays message if room is already empty
     * @param roomNumber the room number to check out (which is subtracted by 1)
     */
    public void checkOutGuest (int roomNumber) {
        Room room = rooms.get(roomNumber - 1);

        if (!room.isOccupied()) {
            System.out.println("Room " + roomNumber + " is already empty.");
        }

        Guest guest = room.getCurrentGuest(); 
        System.out.println(guest.name + " has checked out of Room #" + roomNumber + ", their stay has come to an end.");
        room.setCurrentGuest(guest); 
        room.setOccupied(false); 
    }

    
    public static void main(String[] args) {
        // HotelBuilding Hilton = new HotelBuilding("Hilton", "elm st", 4);
        // Hilton.displayRooms();

        // Guest Bob = new Guest("Bob", 30, "none", "none", "Is very rude", "YAY", 1);
        // Guest Al = new Guest("Al", 40, "none", "none", "Is very rude", "YAY", 3);
        // Hilton.checkInGuest(Bob, 1);
        // Hilton.checkInGuest(Al, 3);


        // Hilton.displayRooms();

        // Hilton.checkOutGuest(1);
        // Hilton.displayRooms();
    }
}