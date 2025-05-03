import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class GameLoop{

    //Attributes
    private static ArrayList<Guest> guestList = new ArrayList<>(); 
    private static Random rand = new Random();
    private static int failedTasks = 0;
    private static int nGuestsLeft = 0;
    

    private static void intializeGuestList() {
        guestList.add(new Guest("Amelia and Don", "21", "None", "None", "A young couple celebrating their three-year anniversary on a sweet 'bae-cation.' They’re energetic, affectionate, and looking for a cozy getaway spot to make memories.", "Amelia is a bit of a clean freak. You might be called frequently for room cleaning.", 2));
        guestList.add(new Guest("Sally", "58", "2 cats (one is rowdy and has sharp claws!)", "None", "Freshly single after a messy divorce, Sally is treating herself to luxury... and so are her mischievous cats. One of them has quite a temper and very sharp claws, so prepare for a wild stay!", "Risk having furniture damaged and extra room cleaning. Might hear complaints from certain guests…", 1));
        guestList.add(new Guest("Riley, Matthew, Tilda, Tildy, and Sunny", "20, 28, 25, 25, 29", "None", "None", "A lively group of friends backpacking across the nation, looking to crash for a bit of relaxation. They’re extremely high on energy, adventurous, and definitely ready to bring the party wherever they stay.", "Could be noisy guests but they might attract other travelers!", 5));
        guestList.add(new Guest("Harold, Lina, Sarah, and Walter", "40, 25", "None", "Sarah (19), Walter (4)", "What a complicated family this is! Rumor has it Harold cheated on Sarah’s mother for Lina and now they’re traveling together with Harold’s teenage daughter, Sarah, and young son, Walter… That’s besides the point though. Tension simmers just under the surface, but they’re trying hard to act like a happy family vacation.", "Family drama might spill over, especially between Sarah and Lina. Risk of arguments and awkward scenes in public areas.", 4));
        guestList.add(new Guest("Jasmine", "27", "Small parrot named Kawa", "None", "Jasmine is an aspiring social media influencer on a mission to document her 'solo self-love journey' but really she just exploits her parrot for content. Kawa, her parrot, loves shouting random words at strangers.", "Expect constant selfies, live streams, and noise complaints from other guests.", 1));
        guestList.add(new Guest("Ilhan and Lila", "30", "None", "None", "A newlywed couple on their peaceful honeymoon. They crave quiet, relaxation, and intimate moments. In other words, as far away from noise, kids, or chaos.", "Easily disturbed if the hotel is too rowdy. Otherwise, very low maintenance guests.", 2));
        guestList.add(new Guest("Derek", "35", "None", "None", "Derek claims he's an 'entrepreneur' but guests whisper that he’s got quite the knack of scamming people into buying his “Make Money Fast!” courses. Let’s just hope he isn’t wanted anywhere but, hey! At least you know he’ll definitely pay a pretty penny for that hotel room.", "Could be on the run. Who knows though. It’s just a bunch of rumors.", 1));
        guestList.add(new Guest("Mona", "23", "None", "None", "Fresh from a bad breakup, Mona is on a 'revenge glow-up tour.' She’s determined to have the time of her life and maybe make her ex jealous by posting non-stop about her fabulous hotel stay.", "May be demanding about room aesthetics.", 1));
        guestList.add(new Guest("Olivia and Max", "31 34", "One nervous chihuahua named Sprinkles", "None", "Olivia and Max are celebrating five years together. But Olivia's main focus seems to be her anxious dog, Sprinkles, who barks at everything... even shadows. Max is just fed up with her dog and seems to be really eager to let the dog out of their sight…", "Guests near them may complain about the constant barking.", 2));
        guestList.add(new Guest("Priya and Ethan", "29", "None", "One on the way!", "Priya and Ethan just eloped after Priya found out that she was pregnant out of wedlock. The kicker?: They got married after 2 months of dating. The REAL kicker?: They eloped without telling their families and are hiding out from angry relatives but can’t resist snapping dramatic 'wedding shots' all over the hotel grounds.", "They’re pretty low-maintenance unless someone from their family finds them! Let’s just hope no one comes by asking about this couple…", 2));
        guestList.add(new Guest("Bernard and Lorraine", "74 71", "None", "All grown, not traveling with them", "Long-retired and longtime sweethearts, Bernard and Lorraine are here to enjoy a nostalgic getaway. They're sweet, quiet, and always dressed to the nines for dinner. They even slow dance in the hotel courtyard some evenings. It’s kinda cute when you see it.", "Very low maintenance but expect long, chatty conversations.", 2));
        guestList.add(new Guest("Malik", "34", "None", "One daughter (not traveling)", "This guy is a boring one. Not much too him, wife left because of how much of a work-a-holic he is, daughter seems to always fight for his attention, but you can’t deny he is a hard worker. All he asks for is no disruptions from the staff and good wifi connection.", "Very low maintenance. Very boring.", 1));
        guestList.add(new Guest("Leah, JaNa, and Serena", "24, 27, 24", "None", "Never that", "There’s. No. Flipping. WAY! The most famous cast members from Love Island are coming to stay at YOUR hotel of all places?? You can always tell these girls are here for a good time with a bunch of money in their wallet, loaded up suitcases, cute outfits to put everyone to shame, and a lot of laughter and love to share at the bar. Are you up for hosting these babes?", "Might try to persuade staff to grab a drink with them during work hours. Might want to keep an eye on these girls in case of any mischief…", 3));
        guestList.add(new Guest("Hugo", "27", "None", "None", "Hugo is pretty charismatic and friendly, but keeps asking strange questions about the building’s layout, security systems, and guest check-in times. Says he’s 'just fascinated by hotel design.' He seems to be a little too much on the 'safe' side.", "You and staff will have to keep a close eye on him. It would be advised not to leave him alone near the front desk or security office.", 1));
        guestList.add(new Guest("Reema", "21", "None", "None", "This guest seems to want to try and convince you that she’s 21 but looks much younger than her age. She has no ID on her, only enough cash to pay for her stay here at your hotel. What do you think?", "She seems to look quite anxious and wary. ", 1));
        guestList.add(new Guest("Charity and Damien", "24", "None", "None", "Charity caught Damien cheating three days before their vacation but STILL decided to go since they bought the tickets for their stay. The worst part is that Damien cheated on her with Charity’s sister, Casey. The two seem to be really distant but Damien seems to have some hope that this vacation will make Charity forgive him. Charity, however, seems to be insisting on separate beds.", "You and staff will have to keep a close eye on him. It would be advised not to leave him alone near the front desk or security office.", 1));
        guestList.add(new Guest("Laurel", "17", "None", "Expecting!", "Laurel is young and pregnant! She seems to be extremely stressed out and wants to stay at your hotel for the night after her boyfriend Matt (17) didn’t defend her during last night’s family dinner at his place. His mom told Laurel her tuna noodle casserole was horrendous in front of the whole family. To add salt to the burn, Matt’s mom spat out the food right into the casserole pot. This girl is in DEEP need of some alone time. Also, screw Matt!", "What if her water breaks during her stay?", 1));
        guestList.add(new Guest("Alex, Deuce, and Renee", "29, 32, 35", "None", "None (though they talk about it a lot)", "This group is a polyamorous throuple trying to have a relaxing weekend together. However, it's clear this relationship isn’t exactly in harmony. Alex and Renee have been together for years, and Deuce is the obvious “new addition”. Alex is overly accommodating, Deuce feels left out, and Renee keeps passive-aggressively correcting them both in front of strangers.", "Occasionally very affectionate in public, but then starts arguing the next moment. Staff never quite know which version of them they’ll get that day.", 3));
        guestList.add(new Guest("Mrs. Winifred ", "87", "None", "4 estranged kids, not staying with her", "Mrs. Delacroix is the kind of old woman who insists on being called “Madam” and leaves behind the scent of lavender and menthol wherever she goes. She is a former stage actress and self-proclaimed psychic who speaks in metaphors, always wears silk gloves, and carries a weathered scrapbook labeled 'My Secrets.'", "She claims to be writing her memoirs and constantly drops disturbing family anecdotes like, 'That was the year Charles set the garden on fire to get attention'.", 1));
        guestList.add(new Guest("Tom and Aicha", "33", "None", "None", "Tom and Aisha are a down-to-earth married couple celebrating their anniversary with a quiet weekend away. They’re friendly, respectful, and genuinely appreciative of every small gesture.", "Almost no trouble. Occasionally asks for recommendations for local bakeries or hiking trails.", 2));
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
                 //System.out.println("Congratulations " + player.getName() + "! You've successfully managed " + hotelName + "!");
                 break; // Exit the loop (player wins)
             } 

            //Guests arriving 
            System.out.println("\n ----GUEST ARRIVAL----");
            int maxGuests = Math.min(3, guestList.size()); // don't request more than what exists
            int numNewGuests = rand.nextInt(maxGuests) + 1;
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
            
            if (!task.isCompleted){
                failedTasks += 1; 
            }

            //Guests leaving (create a counter when guests leave increase it )
            System.out.println("----GUEST CHECKOUT----");



         
            if (roomNumber.isOccupied()) {

                nGuestsLeft += 1;

            }
            System.out.println("");











        } while (failedTasks < 3);

        System.out.println("You call yourself a manager, " + player.getName() + "? You've failed 3 tasks. Consider yourself fired!");
        System.out.println("GAME OVER.");


        userInput.close();

        System.out.println();

        //possible stopping conditions after loop ends
        if (guestList.isEmpty()) {
            System.out.println("Congratulations " + player.getName() + "! You've successfully managed " + hotelName + "!");
        } else {//userResponse.equals("LOSE")
             System.out.println("You call yourself a manager, " + player.getName() + "? You've failed 3 tasks. Consider yourself fired!");
             System.out.println("GAME OVER.");
        }
    }
}