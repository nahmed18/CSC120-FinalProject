import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a hotel guest with personal details, party size, and a satisfaction level that can change based on task outcomes
 */
public class Guest {

    // Guest Attributes
    String name;
    String age;
    String pets;
    String kids;
    String description; //guest's profile or backstory
    String note; //notices or warnings about guest
    int partySize; //number of people in guest's party

    /**
     * Constructs new Guest with specified details
     * @param name the guest's name or names of guests in a party
     * @param age the guest's age(s) as a string
     * @param pets description of any pets
     * @param kids description of any children
     * @param description backstory of the guest(s)
     * @param note additional notes or warnings
     * @param partySize number of people in guest's party
     */
    public Guest(String name, String age, String pets, String kids, String description, String note, int partySize) {
        this.name = name;
        this.age = age;
        this.pets = pets;
        this.kids = kids;
        this.description = description;
        this.note = note;
        this.partySize = partySize;
    }

    /**
     * Returns size of guest's party
     * @return partySize
     */
    public int getPartySize() {
        return partySize;
    }

    /**
     * Prints guest's full information
     */
    public void displayGuest() {
        System.out.println("-------------------------------------------------");
        System.out.println("Guest(s): " + name);
        System.out.println("Age(s): " + age);
        System.out.println("Pets: " + pets);
        System.out.println("Kids: " + kids);
        System.out.println("Description: " + description);
        System.out.println("Note: " + note);
        System.out.println("Party Size: " + partySize);
        System.out.println("-------------------------------------------------");
    }

    /**
     * Simulates handling a guest-requested task
     * Random task is chosen, displayed, and either completed or failed
     * If task is failed, guest's satisfaction decreases
     */
    public void handleTask() {
        Tasks guestTask = Tasks.getRandomTask("guest");
        guestTask.displayTask();

        Random rand = new Random();
        boolean success = rand.nextBoolean(); // 50% chance of failing the task

        if (success) {
            guestTask.completeTask();
        } else {
            guestTask.failTask();
        }

        System.out.println("Updated Guest Status:");
        this.displayGuest();
    }

    /**
     * Returns the guest's name as this object's string representation
     * @return the name
     */
    public String toString() {
        return name;
    }

    /**
     * Main method for demonstration and testing
     * Creates list of Guests, selects one randomly, displays their info, and runs through a task
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        // ArrayList<Guest> guestList = new ArrayList<>();

        // guestList.add(new Guest("Amelia and Don", "21", "None", "None", "A young couple celebrating their three-year anniversary on a sweet 'bae-cation.' They’re energetic, affectionate, and looking for a cozy getaway spot to make memories.", "Amelia is a bit of a clean freak. You might be called frequently for room cleaning.", 2));
        // guestList.add(new Guest("Sally", "58", "2 cats (one is rowdy and has sharp claws!)", "None", "Freshly single after a messy divorce, Sally is treating herself to luxury... and so are her mischievous cats. One of them has quite a temper and very sharp claws, so prepare for a wild stay!", "Risk having furniture damaged and extra room cleaning. Might hear complaints from certain guests…", 1));
        // guestList.add(new Guest("Riley, Matthew, Tilda, Tildy, and Sunny", "20, 28, 25, 25, 29", "None", "None", "A lively group of friends backpacking across the nation, looking to crash for a bit of relaxation. They’re extremely high on energy, adventurous, and definitely ready to bring the party wherever they stay.", "Could be noisy guests but they might attract other travelers!", 5));
        // guestList.add(new Guest("Harold, Lina, Sarah, and Walter", "40, 25", "None", "Sarah (19), Walter (4)", "What a complicated family this is! Rumor has it Harold cheated on Sarah’s mother for Lina and now they’re traveling together with Harold’s teenage daughter, Sarah, and young son, Walter… That’s besides the point though. Tension simmers just under the surface, but they’re trying hard to act like a happy family vacation.", "Family drama might spill over, especially between Sarah and Lina. Risk of arguments and awkward scenes in public areas.", 4));
        // guestList.add(new Guest("Jasmine", "27", "Small parrot named Kawa", "None", "Jasmine is an aspiring social media influencer on a mission to document her 'solo self-love journey' but really she just exploits her parrot for content. Kawa, her parrot, loves shouting random words at strangers.", "Expect constant selfies, live streams, and noise complaints from other guests.", 1));
        // guestList.add(new Guest("Ilhan and Lila", "30", "None", "None", "A newlywed couple on their peaceful honeymoon. They crave quiet, relaxation, and intimate moments. In other words, as far away from noise, kids, or chaos.", "Easily disturbed if the hotel is too rowdy. Otherwise, very low maintenance guests.", 2));
        // guestList.add(new Guest("Derek", "35", "None", "None", "Derek claims he's an 'entrepreneur' but guests whisper that he’s got quite the knack of scamming people into buying his “Make Money Fast!” courses. Let’s just hope he isn’t wanted anywhere but, hey! At least you know he’ll definitely pay a pretty penny for that hotel room.", "Could be on the run. Who knows though. It’s just a bunch of rumors.", 1));
        // guestList.add(new Guest("Mona", "23", "None", "None", "Fresh from a bad breakup, Mona is on a 'revenge glow-up tour.' She’s determined to have the time of her life and maybe make her ex jealous by posting non-stop about her fabulous hotel stay.", "May be demanding about room aesthetics.", 1));
        // guestList.add(new Guest("Olivia and Max", "31 34", "One nervous chihuahua named Sprinkles", "None", "Olivia and Max are celebrating five years together. But Olivia's main focus seems to be her anxious dog, Sprinkles, who barks at everything... even shadows. Max is just fed up with her dog and seems to be really eager to let the dog out of their sight…", "Guests near them may complain about the constant barking.", 2));
        // guestList.add(new Guest("Priya and Ethan", "29", "None", "One on the way!", "Priya and Ethan just eloped after Priya found out that she was pregnant out of wedlock. The kicker?: They got married after 2 months of dating. The REAL kicker?: They eloped without telling their families and are hiding out from angry relatives but can’t resist snapping dramatic 'wedding shots' all over the hotel grounds.", "They’re pretty low-maintenance unless someone from their family finds them! Let’s just hope no one comes by asking about this couple…", 2));
        // guestList.add(new Guest("Bernard and Lorraine", "74 71", "None", "All grown, not traveling with them", "Long-retired and longtime sweethearts, Bernard and Lorraine are here to enjoy a nostalgic getaway. They're sweet, quiet, and always dressed to the nines for dinner. They even slow dance in the hotel courtyard some evenings. It’s kinda cute when you see it.", "Very low maintenance but expect long, chatty conversations.", 2));
        // guestList.add(new Guest("Malik", "34", "None", "One daughter (not traveling)", "This guy is a boring one. Not much too him, wife left because of how much of a work-a-holic he is, daughter seems to always fight for his attention, but you can’t deny he is a hard worker. All he asks for is no disruptions from the staff and good wifi connection.", "Very low maintenance. Very boring.", 1));
        // guestList.add(new Guest("Leah, JaNa, and Serena", "24, 27, 24", "None", "Never that", "There’s. No. Flipping. WAY! The most famous cast members from Love Island are coming to stay at YOUR hotel of all places?? You can always tell these girls are here for a good time with a bunch of money in their wallet, loaded up suitcases, cute outfits to put everyone to shame, and a lot of laughter and love to share at the bar. Are you up for hosting these babes?", "Might try to persuade staff to grab a drink with them during work hours. Might want to keep an eye on these girls in case of any mischief…", 3));
        // guestList.add(new Guest("Hugo", "27", "None", "None", "Hugo is pretty charismatic and friendly, but keeps asking strange questions about the building’s layout, security systems, and guest check-in times. Says he’s 'just fascinated by hotel design.' He seems to be a little too much on the 'safe' side.", "You and staff will have to keep a close eye on him. It would be advised not to leave him alone near the front desk or security office.", 1));
        // guestList.add(new Guest("Reema", "21", "None", "None", "This guest seems to want to try and convince you that she’s 21 but looks much younger than her age. She has no ID on her, only enough cash to pay for her stay here at your hotel. What do you think?", "She seems to look quite anxious and wary. ", 1));
        // guestList.add(new Guest("Charity and Damien", "24", "None", "None", "Charity caught Damien cheating three days before their vacation but STILL decided to go since they bought the tickets for their stay. The worst part is that Damien cheated on her with Charity’s sister, Casey. The two seem to be really distant but Damien seems to have some hope that this vacation will make Charity forgive him. Charity, however, seems to be insisting on separate beds.", "You and staff will have to keep a close eye on him. It would be advised not to leave him alone near the front desk or security office.", 1));
        // guestList.add(new Guest("Laurel", "17", "None", "Expecting!", "Laurel is young and pregnant! She seems to be extremely stressed out and wants to stay at your hotel for the night after her boyfriend Matt (17) didn’t defend her during last night’s family dinner at his place. His mom told Laurel her tuna noodle casserole was horrendous in front of the whole family. To add salt to the burn, Matt’s mom spat out the food right into the casserole pot. This girl is in DEEP need of some alone time. Also, screw Matt!", "What if her water breaks during her stay?", 1));
        // guestList.add(new Guest("Alex, Deuce, and Renee", "29, 32, 35", "None", "None (though they talk about it a lot)", "This group is a polyamorous throuple trying to have a relaxing weekend together. However, it's clear this relationship isn’t exactly in harmony. Alex and Renee have been together for years, and Deuce is the obvious “new addition”. Alex is overly accommodating, Deuce feels left out, and Renee keeps passive-aggressively correcting them both in front of strangers.", "Occasionally very affectionate in public, but then starts arguing the next moment. Staff never quite know which version of them they’ll get that day.", 3));
        // guestList.add(new Guest("Mrs. Winifred ", "87", "None", "4 estranged kids, not staying with her", "Mrs. Delacroix is the kind of old woman who insists on being called “Madam” and leaves behind the scent of lavender and menthol wherever she goes. She is a former stage actress and self-proclaimed psychic who speaks in metaphors, always wears silk gloves, and carries a weathered scrapbook labeled 'My Secrets.'", "She claims to be writing her memoirs and constantly drops disturbing family anecdotes like, 'That was the year Charles set the garden on fire to get attention'.", 1));
        // guestList.add(new Guest("Tom and Aicha", "33", "None", "None", "Tom and Aisha are a down-to-earth married couple celebrating their anniversary with a quiet weekend away. They’re friendly, respectful, and genuinely appreciative of every small gesture.", "Almost no trouble. Occasionally asks for recommendations for local bakeries or hiking trails.", 2));
        
        // // a random guest interacting with the hotel hopefully
        // Random rand = new Random();
        // Guest selectedGuest = guestList.get(rand.nextInt(guestList.size()));

        // selectedGuest.displayGuest();
        // selectedGuest.handleTask();
    }
}
