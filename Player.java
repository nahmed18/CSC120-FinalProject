import java.util.Scanner; 


public class Player {

     //Attributes 
     private String name; 
     private double money; 
     private int chances; 
 
 
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

   //   public int goToRoom(int roomNumber){

   //   }

   //   public void goToLobby(){

   //   }

     public String build(String buildingName){
      if (buildingName.equals("Cafe") && money >= 100){
         //create Cafe instance
      }
      else if (buildingName.equals("Library") && money >= 150){
         //create Library instance
      }
      else if (buildingName.equals("Pool") && money >= 200){
         //create Pool instance
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