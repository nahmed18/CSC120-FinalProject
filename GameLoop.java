import java.util.Scanner;

public class GameLoop{
    
    public static void main(String[] args) {
        //"flag" to inform us when loop should stop
        boolean stillPlaying = true;

        //get input from user
        Scanner userInput = new Scanner(System.in);
        System.out.print("Hi what is your name? ");

        //stores user's name
        String userName = userInput.nextLine();
        String userResponse = "";
        System.out.println("Hi " + userName + "! Welcome to Hotel Mania.");

        //opening where Shahrin, Nazifa, and Caitlyn explain the plot of the game
        System.out.print("Press Enter to continue" );
        userInput.nextLine();
        System.out.println("******************");
        System.out.println("Shahrin: ..... ");
        System.out.print("Press Enter to continue");
        userInput.nextLine();
        System.out.println("Nazifa: ....");
        System.out.print("Press Enter to continue");
        userInput.nextLine();
        System.out.println("Caitlyn: .....");
        System.out.println("******************");


        //
        // do {

        // } while (stillPlaying);

        userInput.close();

        //possible stopping conditions after loop ends
        if (userResponse.equals("WIN")) {
            System.out.println("Yay, you won! You survived a day as a manager.");
        } else {//userResponse.equals("LOSE")
            System.out.println("You lost! Unfortuantely you are fired from your manager position.");
        }
    }
}