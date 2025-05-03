import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class GameLoop{

    //Attributes
    private static ArrayList<Guest> guestList = new ArrayList<>(); 
    private static Random rand = new Random();
    private static int failedTasks = 0;

    private static void intializeGuestList() {
        guestList.add(new Guest("Amelia and Don", 21, "None", "None", "A young couple celebrating their three-year anniversary on a sweet 'bae-cation.' They’re energetic, affectionate, and looking for a cozy getaway spot to make memories.", "Amelia is a bit of a clean freak. You might be called frequently for room cleaning.", 2));
        guestList.add(new Guest("Sally", 58, "2 cats (one is rowdy and has sharp claws!)", "None", "Freshly single after a messy divorce, Sally is treating herself to luxury... and so are her mischievous cats. One of them has quite a temper and very sharp claws, so prepare for a wild stay!", "Risk having furniture damaged and extra room cleaning. Might hear complaints from certain guests…", 1));
        guestList.add(new Guest("Riley, Matthew, Tilda, Tildy, and Sunny", 20, "None", "None", "A lively group of friends backpacking across the nation, looking to crash for a bit of relaxation. They’re extremely high on energy, adventurous, and definitely ready to bring the party wherever they stay.", "Could be noisy guests but they might attract other travelers!", 5));
        guestList.add(new Guest("Harold, Lina, Sarah, and Walter", 40, "None", "Sarah (19), Walter (4)", "What a complicated family this is! Rumor has it Harold cheated on Sarah’s mother for Lina and now they’re traveling together with Harold’s teenage daughter, Sarah, and young son, Walter… That’s besides the point though. Tension simmers just under the surface, but they’re trying hard to act like a happy family vacation.", "Family drama might spill over, especially between Sarah and Lina. Risk of arguments and awkward scenes in public areas.", 4));
        guestList.add(new Guest("Jasmine", 27, "Small parrot named Kawa", "None", "Jasmine is an aspiring social media influencer on a mission to document her 'solo self-love journey' but really she just exploits her parrot for content. Kawa, her parrot, loves shouting random words at strangers.", "Expect constant selfies, live streams, and noise complaints from other guests.", 1));
        guestList.add(new Guest("Ilhan and Lila", 30, "None", "None", "A newlywed couple on their peaceful honeymoon. They crave quiet, relaxation, and intimate moments. In other words, as far away as possible from noise, kids, and chaos.", "Easily disturbed if the hotel is too rowdy. Otherwise, very low maintenance guests.", 2));
        guestList.add(new Guest("Derek", 35, "None", "None", "Derek claims he's an 'entrepreneur' but guests whisper that he’s got quite the knack of scamming people into buying his “Make Money Fast!” courses. Let’s just hope he isn’t wanted anywhere but, hey! At least you know he’ll definitely pay a pretty penny for that hotel room.", "Could be on the run. Who knows though. It’s just a bunch of rumors.", 1));
        guestList.add(new Guest("Mona", 23, "None", "None", "Fresh from a bad breakup, Mona is on a 'revenge glow-up tour.' She’s determined to have the time of her life and maybe make her ex jealous by posting non-stop about her fabulous hotel stay.", "May be demanding about room aesthetics.", 1));
        guestList.add(new Guest("Olivia and Max", 31, "One nervous chihuahua named Sprinkles", "None", "Olivia and Max are celebrating five years together. But Olivia's main focus seems to be her anxious dog, Sprinkles, who barks at everything... even shadows. Max is just fed up with her dog and seems to be really eager to let the dog out of their sight…", "Guests near them may complain about the constant barking.", 2));
        guestList.add(new Guest("Priya and Ethan", 29, "None", "One on the way!", "Priya and Ethan just eloped after Priya found out that she was pregnant out of wedlock. The kicker?: They got married after 2 months of dating. The REAL kicker?: They eloped without telling their families and are hiding out from angry relatives — but can’t resist snapping dramatic 'wedding shots' all over the hotel grounds.", "They’re pretty low-maintenance unless someone from their family finds them! Let’s just hope no one comes by asking about this couple…", 2));
    }

    private static Guest getRandomGuest() {
        return guestList.get(rand.nextInt(guestList.size()));
    }
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        intializeGuestList();

        //stores user's name
        String userResponse = "";
       
        //Intro: Narrators introduce the game 
        System.out.print("\nPress Enter to continue ");
        userInput.nextLine();
        System.out.println("\n******************");
        System.out.println("Caitlyn: Welcome to Grand Hotel Mania! We've been waiting for your arrival.");
        System.out.println("******************");
        System.out.print("\nPress Enter to continue ");
        userInput.nextLine();

        //User Inputs Name
        System.out.print("\nNazifa: You're about to become the newest Hotel Manager! But first, we need to know: ");
        System.out.print("What’s your name, Manager? ");
        String playerName = userInput.nextLine(); //collect the person's name
        Player player = new Player(playerName); 
        System.out.println(); //do i need this ask caitlyn n nazifa

        System.out.println("Shahrin: Nice to meet you, " + player.getName() + "!");
        System.out.println("We are your hosts Shahrin, Caitlyn, and Nazifa.");
        System.out.println("\n******************");
        System.out.println("Nazifa: Before we open the doors, what would you like to name your hotel?");
        System.out.print("Enter your hotel name: ");
        String hotelName = userInput.nextLine();

        //create a hotel with the name the user provided 
        HotelBuilding hotel = new HotelBuilding(hotelName, "Luther St",1);

        System.out.println();

        System.out.println("Caitlyn: Great choice! Welcome to " + hotelName + " — the future best hotel in town!");
        System.out.println("******************");
        
        
        //Main game loop 
        do {
            // Check if all guests have been welcomed (WIN CONDITION)
            if (guestList.isEmpty()) {
                System.out.println("\nAll guests have been welcomed!");
                System.out.println("Congratulations " + player.getName() + "! You've successfully managed " + hotelName + "!");
                break; // Exit the loop (player wins)
            }

            //Guests arriving 
            System.out.println("\n ----GUEST ARRIVAL----");
            int numNewGuests = rand.nextInt(3) + 1; //1-3 random guests arrive 
            ArrayList<Guest> arrivingGuests = new ArrayList<>(); 

            for (int i = 0; i < numNewGuests; i++) {
                Guest newGuest = getRandomGuest(); 
                System.out.println("\nA guest has arrived:");
                newGuest.displayGuest();
                System.out.println("Would you like to accept them into your hotel? (yes/no)");
                String accept = userInput.nextLine().toLowerCase();

                if (accept.equals("yes")) {
                    arrivingGuests.add(newGuest); 
                    guestList.remove(newGuest); //removes the guest from initial list 
                    System.out.println("\n" + newGuest.name + " has been accepted!");

                    boolean assigned = false; //this is for room size too small/ doesn't equal number of guests
                    while (!assigned) {
                        System.out.println("\nAssign a room for " + newGuest.name);
                        System.out.println("Party size: " + newGuest.partySize + "\n");
                        hotel.displayRooms();
                        System.out.print("\nEnter room number to assign them: ");
                        int roomNumber = Integer.parseInt(userInput.nextLine());

                        assigned = hotel.checkInGuest(newGuest, roomNumber);

                        if (!assigned) {
                            System.out.println("This room will not work for your guests. Please try again.");
                        }
                    }                          
                } else {
                    System.out.println(newGuest.name + " has been turned away.");
                }
            }
            
            //Tasks 
            System.out.println("\n----ALERT!!! AN ISSUE HAS AROSE COMPLETE THE TASK----");
            Tasks task = Tasks.getRandomTask("guest");
            task.displayTask();
            task.startTask();
             // ---------------------

            
            // if (guestList.isEmpty()) //way to win 
            //     System.out.println("\nAll guests have been welcomed!");
            //     System.out.println("Congratulations " + player.getName() + "! You've successfully managed " + hotelName + "!");

            
            if (!task.isCompleted){
                failedTasks += 1; 
            
                if (failedTasks >= 3) {
                    System.out.println("You call yourself a manager, " + player.getName() + "? You've failed 3 tasks. Consider yourself fired!");
                    System.out.println("GAME OVER.");
                    break;
                }
            }


        } while (failedTasks < 3);


        

        userInput.close();

        //possible stopping conditions after loop ends
        if (userResponse.equals("WIN")) {
            System.out.println("Yay, you won! You survived a day as a manager.");
        } else {//userResponse.equals("LOSE")
            System.out.println("You call yourself a manager? You couldn't even complete 3 tasks. Consider yourself FIRED! ");
            System.out.println("GAME OVER.");
        }
    }
}