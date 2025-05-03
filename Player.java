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

    public void addMoney(double amount) {
        this.money += amount;
    }

    
    public void deductMoney(double amount) {
        this.money -= amount;
    }

    public double getMoney() {
        return this.money;
    }

    public void displayMoney() {
        System.out.println("Current Balance: $" + String.format("%.2f", this.money));
    }
    
    public static void main(String[] args) {
        Player testPlayer = new Player("TestUser");
        testPlayer.addMoney(30);
        testPlayer.displayMoney(); // this should display $30.00 test this later once the money for guests are set up
    }
}