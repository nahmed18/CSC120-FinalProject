import java.util.Scanner;

public class GameLoop{
    
    public static void main(String[] args) {
        //"flag" to inform us when loop should stop
        boolean stillPlaying = true;

        //get input from user
        Scanner userInput = new Scanner(System.in);

        //stores user's name
        //String userName = userInput.nextLine();
        String userResponse = "";
        //System.out.println("Hi " + userName + "! Welcome to Hotel Mania.");

        //Intro: Narrators introduce the game 
        System.out.print("Press Enter to continue ");
        userInput.nextLine();
        System.out.println("******************");
        System.out.println("Caitlyn: Welcome to Grand Hotel Mania! We've been waiting for your arrival.");
        System.out.println("******************");
        System.out.print("Press Enter to continue ");
        userInput.nextLine();

        //User Inputs Name
        System.out.print("Nazifa: You're about to become the newest Hotel Manager! But first, we need to know: ");
        System.out.print("What’s your name, Manager? ");
        String playerName = userInput.nextLine(); //collect player name

        Player player = new Player(playerName); //create Player instance with collected name

        System.out.println();

        System.out.println("Shahrin: Nice to meet you, " + player.getName() + "!"); //uses player object
        System.out.println("We are your hosts Shahrin, Caitlyn, and Nazifa.");
        System.out.println("******************");
        System.out.println("Nazifa: Before we open the doors, what would you like to name your hotel?");
        System.out.print("Enter your hotel name: ");
        String hotelName = userInput.nextLine();
        System.out.println();

        System.out.println("Caitlyn: Great choice! Welcome to " + hotelName + " — the future best hotel in town!");
        System.out.println("******************");


        //
        // do {

        // } while (stillPlaying);
        // do {

        // } while (stillPlaying);

        userInput.close();

        //possible stopping conditions after loop ends
        if (userResponse.equals("WIN")) {
            System.out.println("Yay, you won! You survived a day as a manager.");
        } else {//userResponse.equals("LOSE")
            System.out.println("You lost! Unfortuantely you are fired from your manager position. :(");
        }
    }
}