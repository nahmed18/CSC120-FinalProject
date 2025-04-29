public class Room {

    //Attributes 
    int roomNumber;
    int roomCapacity;
    boolean isOccupied;
    Guest currentGuest;


    //Constructor 
    public Room(int roomNumber, int roomCapacity, boolean isOccupied) {
        this.roomNumber = roomNumber; 
        this.roomCapacity = roomCapacity;
        this.isOccupied = isOccupied; 
        this.currentGuest = null;
    }


    //Methods - setters and getters 
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    } 

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Guest getCurrentGuest() {
        return currentGuest; 
    }

    public void setCurrentGuest(Guest currentGuest) {
        this.currentGuest = currentGuest; 
    }
}
