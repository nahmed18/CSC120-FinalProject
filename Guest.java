import java.util.ArrayList;
import java.util.Random;

public class Guest {

    // Guest Attributes
    String name;
    int age;
    String pets;
    String kids;
    String description;
    String note;
    String satisfactionLevel;
    int partySize;

    // Constructor
    public Guest(String name, int age, String pets, String kids, String description, String note, int partySize) {
        this.name = name;
        this.age = age;
        this.pets = pets;
        this.kids = kids;
        this.description = description;
        this.note = note;
        this.satisfactionLevel = "😀"; // All guests start happy
        this.partySize = partySize;
    }

    // Method to decrease satisfaction level
    public void decreaseSatisfaction() {
        if (this.satisfactionLevel.equals("😀")) {
            this.satisfactionLevel = "😒";
        } else if (this.satisfactionLevel.equals("😒")) {
            this.satisfactionLevel = "😡";
        }
    }

    public int getPartySize() {
        return partySize;
    }

    // Display guest information
    public void displayGuest() {
        System.out.println("-------------------------------------------------");
        System.out.println("Guest(s): " + name);
        System.out.println("Age: " + age);
        System.out.println("Pets: " + pets);
        System.out.println("Kids: " + kids);
        System.out.println("Description: " + description);
        System.out.println("Note: " + note);
        System.out.println("Party Size: " + partySize);
        System.out.println("Satisfaction: " + satisfactionLevel);
        System.out.println("-------------------------------------------------");
    }

    // Simulate a guest-requested task
    public void handleTask() {
        Tasks guestTask = Tasks.getRandomTask("guest");
        guestTask.displayTask();

        Random rand = new Random();
        boolean success = rand.nextBoolean(); // 50% chance of failing the task

        if (success) {
            guestTask.completeTask();
        } else {
            guestTask.failTask();
            this.decreaseSatisfaction();
        }

        System.out.println("Updated Guest Status:");
        this.displayGuest();
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        ArrayList<Guest> guestList = new ArrayList<>();

        guestList.add(new Guest("Amelia and Don", 21, "None", "None", "A young couple celebrating their three-year anniversary on a sweet 'bae-cation.' They’re energetic, affectionate, and looking for a cozy getaway spot to make memories.", "Amelia is a bit of a clean freak. You might be called frequently for room cleaning.", 2));
        guestList.add(new Guest("Sally", 58, "2 cats (one is rowdy and has sharp claws!)", "None", "Freshly single after a messy divorce, Sally is treating herself to luxury... and so are her mischievous cats. One of them has quite a temper and very sharp claws, so prepare for a wild stay!", "Risk having furniture damaged and extra room cleaning. Might hear complaints from certain guests…", 1));
        guestList.add(new Guest("Riley, Matthew, Tilda, Tildy, and Sunny", 20, "None", "None", "A lively group of friends backpacking across the nation, looking to crash for a bit of relaxation. They’re extremely high on energy, adventurous, and definitely ready to bring the party wherever they stay.", "Could be noisy guests but they might attract other travelers!", 5));
        guestList.add(new Guest("Harold, Lina, Sarah, and Walter", 40, "None", "Sarah (19), Walter (4)", "What a complicated family this is! Rumor has it Harold cheated on Sarah’s mother for Lina and now they’re traveling together with Harold’s teenage daughter, Sarah, and young son, Walter… That’s besides the point though. Tension simmers just under the surface, but they’re trying hard to act like a happy family vacation.", "Family drama might spill over, especially between Sarah and Lina. Risk of arguments and awkward scenes in public areas.", 4));
        guestList.add(new Guest("Jasmine", 27, "Small parrot named Kawa", "None", "Jasmine is an aspiring social media influencer on a mission to document her 'solo self-love journey' but really she just exploits her parrot for content. Kawa, her parrot, loves shouting random words at strangers.", "Expect constant selfies, live streams, and noise complaints from other guests.", 1));
        guestList.add(new Guest("Ilhan and Lila", 30, "None", "None", "A newlywed couple on their peaceful honeymoon. They crave quiet, relaxation, and intimate moments. In other words, as far away from noise, kids, or chaos.", "Easily disturbed if the hotel is too rowdy. Otherwise, very low maintenance guests.", 2));
        guestList.add(new Guest("Derek", 35, "None", "None", "Derek claims he's an 'entrepreneur' but guests whisper that he’s got quite the knack of scamming people into buying his “Make Money Fast!” courses. Let’s just hope he isn’t wanted anywhere but, hey! At least you know he’ll definitely pay a pretty penny for that hotel room.", "Could be on the run. Who knows though. It’s just a bunch of rumors.", 1));
        guestList.add(new Guest("Mona", 23, "None", "None", "Fresh from a bad breakup, Mona is on a 'revenge glow-up tour.' She’s determined to have the time of her life and maybe make her ex jealous by posting non-stop about her fabulous hotel stay.", "May be demanding about room aesthetics.", 1));
        guestList.add(new Guest("Olivia and Max", 31, "One nervous chihuahua named Sprinkles", "None", "Olivia and Max are celebrating five years together. But Olivia's main focus seems to be her anxious dog, Sprinkles, who barks at everything... even shadows. Max is just fed up with her dog and seems to be really eager to let the dog out of their sight…", "Guests near them may complain about the constant barking.", 2));
        guestList.add(new Guest("Priya and Ethan", 29, "None", "One on the way!", "Priya and Ethan just eloped after Priya found out that she was pregnant out of wedlock. The kicker?: They got married after 2 months of dating. The REAL kicker?: They eloped without telling their families and are hiding out from angry relatives but can’t resist snapping dramatic 'wedding shots' all over the hotel grounds.", "They’re pretty low-maintenance unless someone from their family finds them! Let’s just hope no one comes by asking about this couple…", 2));

        // a random guest interacting with the hotel hopefully
        Random rand = new Random();
        Guest selectedGuest = guestList.get(rand.nextInt(guestList.size()));

        selectedGuest.displayGuest();
        selectedGuest.handleTask();
    }
}
