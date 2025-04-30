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
 
 
 
     public double spendMoney(double amount){
      //remove this and spend money in build method?
     }

     public double earnMoney(double amount){
         earn money via
         
     }

   //   public String grabObject(String object){

   //   }

   //   public String giveObject(String object, Guest guest){

   //   }

     public int goToRoom(int roomNum){
   //    if (this.activeFloor == -1) {
   //       throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
   //   }
     if (roomNum < 1 || roomNum > this.nRooms) {
         throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
     }
     System.out.println("You are now on floor #" + roomNum + " of " + this.name);
     this.activeFloor = roomNum;
     }

     public void goToLobby(){
      System.out.println("You are now in the lobby.");
      this.activeFloor = 1;
     }

     public void build(String buildingName){
      if (buildingName.equals("Cafe") && money < 100){
         throw new RuntimeException("You do not have enough money to build a cafe.");
         //lose --> hotel is in debt?
      }
      //create Cafe instance Cafe hotelCafe = new Cafe(cafeName);
      //you created a cafe!
      this.money = money - 100;
      System.out.println("You now have $ " + this.money + " remaining.");

      if (buildingName.equals("Library") && money < 150){
         throw new RuntimeException("You do not have enough money to build a library.");
         //lose --> hotel is in debt?

      }
      //create Library instance Library hotelLibrary = new Library(libName);
      //you created a library!
      this.money = money - 150;
      System.out.println("You now have $ " + this.money + " remaining.");

      if (buildingName.equals("Pool") && money < 200){
         throw new RuntimeException("You do not have enough money to build a pool.");
         //lose --> hotel is in debt?

      }
      //create Pool instance Pool hotelPool = new Pool(poolName);
      //you created a pool!
      this.money = money - 200;
      System.out.println("You now have $ " + this.money + " remaining.");
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