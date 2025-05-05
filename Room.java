/**
 * Represents a hotel room with a room number, capacity, occupancy status, and an optionally assigned current guest
 * Each Room can report its number, capacity, if it is occupied, and allows checking in or out a Guest
 */
public class Room {

    //Attributes 
    int roomNumber;
    int roomCapacity;
    boolean isOccupied;
    Guest currentGuest;


    /**
     * Constructs a new Room with the specified number, capacity, and pccupancy
     * Current guest is initialized to null
     * @param roomNumber the unique identifier for room
     * @param roomCapacity the maximum number of guests allowed
     * @param isOccupied if true, room starts occupied; if false room doesn't start occupied
     * */ 
    public Room(int roomNumber, int roomCapacity, boolean isOccupied) {
        this.roomNumber = roomNumber; 
        this.roomCapacity = roomCapacity;
        this.isOccupied = isOccupied; 
        this.currentGuest = null;
    }


    /**
     * Returns room's number
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns room's capacity
     * @return the roomCapacity
     */
    public int getRoomCapacity() {
        return roomCapacity;
    }

    /**
     * Checks whether room is occupied
     * @return true if occupied; false otherwise
     */
    public boolean isOccupied() {
        return isOccupied;
    }
    
    /**
     * Returns a user-friendly availability status, returns "Yes" when room is available and "No" when unavailable
     * @return "Yes" if room is available; "No" if it is occupied
     */
    public String availabilityStatus() {
        if (!isOccupied) {
            return("Yes");
        } else {
            return("No");
        } 
    }

    /**
     * Sets room's occupancy status
     * @param isOccupied if true mark as occupied; if false mark as available
     */
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * Returns the guest currently checked into this room
     * @return the currentGuest or null if there is no guest
     */
    public Guest getCurrentGuest() {
        return currentGuest; 
    }

    /**
     * Assigns a guest to this room
     * @param currentGuest the Guest to check in; could be null
     */
    public void setCurrentGuest(Guest currentGuest) {
        this.currentGuest = currentGuest; 
    }
}
