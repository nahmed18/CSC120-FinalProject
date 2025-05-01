import java.util.Scanner; 


public class Player {

     //Attributes 
     private HotelBuilding hotel;
     private String name; 
     private double money; 
     private int chances;
     protected int activeFloor = 1; //default value indicating player is in lobby 
 
 
     //Constructor receives name from GameLoop class
      public Player(String name) {
        this.name = name;
        this.money = 0;      
        this.chances = 3;
     } 

      public String getName() {
         return name;
      }

      public int getChances() {
         return chances; 
      }

   //   public void assignGuest(Guest guest) {
   //       //access guest class finding arrived guests in guest arraylist and get size of party then find available room with matching room size to assign guests to
   //       Room room = hotel.getAvailableRoom(guest.getPartySize());
   //       if (room != null) {
   //          room.setCurrentGuest(guest);
   //          room.setOccupied(true);
   //          System.out.println(guest.name + " assigned to room # " + room.getRoomNumber());
   //       } else {
   //          System.out.println("No rooms available for " + guest.name);
   //       }
   //   }
 

   //   public void earnMoney(Guest guest) {
   //    if ("😀".equals(guest.satisfactionLevel)) {
   //       money += 30;
   //    } else if ("😐".equals(guest.satisfactionLevel)) {
   //       money += 20;
   //    } else { //covers "😡"
   //       money += 0;
   //    }
         
   //   }

   //   public String grabObject(String object){

   //   }

   //   public String giveObject(String object, Guest guest){

   //   }

   //   public int goToRoom(int roomNum) {
   //    if (this.activeFloor == 2) {
   //       throw new RuntimeException("You are already in the room floor.");
   //    }
   //    if (roomNum < 1 || roomNum > hotel.getTotalRooms()) {
   //          throw new RuntimeException("Invalid room number. Valid range for the hotel is 1-" + hotel.getTotalRooms() + ".");
   //    }
   //    this.activeFloor = 2;
   //    System.out.println("You are now at room #" + roomNum + ".");
   //    return roomNum;
   //    }

   //   public void goToLobby() {
   //    if (this.activeFloor == 1) {
   //       throw new RuntimeException("You are already in the lobby.");
   //    }
   //    this.activeFloor = 1;
   //    System.out.println("You are now in the lobby.");
   //   }

   //   public void build(String buildingName) {
   //    if (buildingName.equals("Cafe") && money < 100){
   //       throw new RuntimeException("You do not have enough money to build a cafe.");
   //       //lose --> hotel is in debt?
   //    }
   //    //create Cafe instance Cafe hotelCafe = new Cafe(cafeName);
   //    System.out.println("Congratulations, you have successfully built a cafe!");
   //    //ask user to name cafe
   //    this.money = money - 100;
   //    System.out.println("You now have $ " + this.money + " remaining.");

   //    if (buildingName.equals("Library") && money < 150) {
   //       throw new RuntimeException("You do not have enough money to build a library.");
   //       //lose --> hotel is in debt?

   //    }
   //    //create Library instance Library hotelLibrary = new Library(libName);
   //    System.out.println("Congratulations, you have successfully built a library!");
   //    //ask user to name library
   //    this.money = money - 150;
   //    System.out.println("You now have $ " + this.money + " remaining.");

   //    if (buildingName.equals("Pool") && money < 200) {
   //       throw new RuntimeException("You do not have enough money to build a pool.");
   //       //lose --> hotel is in debt?

   //    }
   //    //create Pool instance Pool hotelPool = new Pool(poolName);
   //    System.out.println("Congratulations, you have successfully built a pool!");
   //    //ask user to name pool
   //    this.money = money - 200;
   //    System.out.println("You now have $ " + this.money + " remaining.");
   //   }

    //public void loseChance() {
     //   chances--;
      //  System.out.println("❌ You lost a chance. Remaining chances: " + chances);
    //}

    //public void updateGuestSatisfaction(Guest guest, boolean taskCompleted) {
       // String current = guest.satisfactionLevel;

       // if (taskCompleted) {
        //    if (current.equals("😡")) guest.satisfactionLevel = "😒";
         //   else if (current.equals("😒")) guest.satisfactionLevel = "😀";
       // } else {
         //   if (current.equals("😀")) guest.satisfactionLevel = "😒";
        //    else if (current.equals("😒")) guest.satisfactionLevel = "😡";
       // }
    //}



   //   }

   //   public void checkGameOver() {
   //    if (chances == 0) {
   //       System.out.println("You lost! Unfortuantely you are fired from your manager position. :(");
   //    }
   //    else if (chances > 0) { //&& satisfaction level for all 10 guests is happy)
   //       System.out.println("Yay, you won! You survived a day as a manager.");
   //    }
   //   }
 

    
    public static void main(String[] args) {
    }
}