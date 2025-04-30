import java.util.Scanner; 


public class Player {

     //Attributes 
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

   //   public void assignGuest(Guest guest, Room room) {
         //access guest class finding arrived guests in guest arraylist and get size of party then find available room with matching room size to assign guests to
         
   //   }
 
 
 
   //   public double spendMoney(double amount) {
   //    //remove this and spend money in build method?
   //   }

     public double earnMoney(double amount) {
         //check leaving guest's satisfaction level using checkOutGuest method
         //if guest satisfication is good :D --> $30
         //if guest is okay :| --> $20
         //if guest is unsatisfied >:( --> $0
         
     }

   //   public String grabObject(String object){

   //   }

   //   public String giveObject(String object, Guest guest){

   //   }

     public int goToRoom(int roomNum) {
      if (this.activeFloor == 2) {
         throw new RuntimeException("You are already in the room floor.");
      }
      if (roomNum < 1 || roomNum > this.rooms.size()) {
            throw new RuntimeException("Invalid room number. Valid range for the hotel is 1-" + this.rooms.size() + ".");
      }
      this.activeFloor = 2;
      System.out.println("You are now at room #" + roomNum + ".");
      }

     public void goToLobby() {
      if (this.activeFloor == 1) {
         throw new RuntimeException("You are already in the lobby.");
      }
      this.activeFloor = 1;
      System.out.println("You are now in the lobby.");
     }

     public void build(String buildingName) {
      if (buildingName.equals("Cafe") && money < 100){
         throw new RuntimeException("You do not have enough money to build a cafe.");
         //lose --> hotel is in debt?
      }
      //create Cafe instance Cafe hotelCafe = new Cafe(cafeName);
      System.out.println("Congratulations, you have successfully built a cafe!");
      //ask user to name cafe
      this.money = money - 100;
      System.out.println("You now have $ " + this.money + " remaining.");

      if (buildingName.equals("Library") && money < 150) {
         throw new RuntimeException("You do not have enough money to build a library.");
         //lose --> hotel is in debt?

      }
      //create Library instance Library hotelLibrary = new Library(libName);
      System.out.println("Congratulations, you have successfully built a library!");
      //ask user to name library
      this.money = money - 150;
      System.out.println("You now have $ " + this.money + " remaining.");

      if (buildingName.equals("Pool") && money < 200) {
         throw new RuntimeException("You do not have enough money to build a pool.");
         //lose --> hotel is in debt?

      }
      //create Pool instance Pool hotelPool = new Pool(poolName);
      System.out.println("Congratulations, you have successfully built a pool!");
      //ask user to name pool
      this.money = money - 200;
      System.out.println("You now have $ " + this.money + " remaining.");
     }

     public void loseChance() {
      //if (Task task.equals("failed"))
         chances = this.chances - 1;
     }

     public void checkGameOver() {
      if (chances == 0) {
         System.out.println("You lost! Unfortuantely you are fired from your manager position. :(");
      }
      else if (chances > 0) { //&& satisfaction level for all 10 guests is happy)
         System.out.println("Yay, you won! You survived a day as a manager.");
      }
     }
 
    
    public static void main(String[] args) {
    }
}