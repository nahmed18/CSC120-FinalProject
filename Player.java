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

      public String getName(){
         return name;
      }

   //   public void assignGuest(Guest guest, Room room) {

         
   //   }
 
 
 
   //   public double spendMoney(double amount){

   //   }

   //   public double earnMoney(double amount){

   //   }

   //   public String grabObject(String object){

   //   }

   //   public String giveObject(String object, Guest guest){

   //   }

     public int goToRoom(int roomNum){
   //    if (this.activeFloor == -1) {
   //       throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
   //   }
     if (floorNum < 1 || floorNum > this.nFloors) {
         throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
     }
     System.out.println("You are now on floor #" + roomNum + " of " + this.name);
     this.activeFloor = roomNum;
     }

     public void goToLobby(){
      System.out.println("You are now in the lobby.");
      this.activeFloor = 1;
     }

     public String build(String buildingName){
      if (buildingName.equals("Cafe") && money >= 100){
         //create Cafe instance Cafe hotelCafe = new Cafe(cafeName);
      }
      else if (buildingName.equals("Library") && money >= 150){
         //create Library instance Library hotelLibrary = new Library(libName);
      }
      else if (buildingName.equals("Pool") && money >= 200){
         //create Pool instance Pool hotelPool = new Pool(poolName);
      }
     }

     public void loseChance(){
      //if (Task task.equals("failed"))
         chances = this.chances - 1;
     }

     public void checkGameOver(){
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