public class Guests{
    
    //Attributes
    String name;
    int age; 
    String pets;
    String kids;
    String description;
    String note; //this inidcates highs and lows of a guest
    String satisfactionLevel;

    public Guests(String name, int age, String pets, String kids, String description, String note) {
        this.name = name;
        this.age = age;
        this.pets = pets;
        this.kids = kids;
        this.description = description;
        this.note = note;
        this.satisfactionLevel = "😀"; // Initial satisfaction level all guests start off happy
    }

    public void decreaseSatisfaction() {
        // if (this.satisfactionLevel.equals)
    }

     public void displayGuest() {
        System.out.println("-------------------------------------------------");
        System.out.println("Guest(s): " + name);
        System.out.println("Age: " + age);
        System.out.println("Pets: " + pets);
        System.out.println("Kids: " + kids);
        System.out.println("Description: " + description);
        System.out.println("Note: " + note);
        System.out.println("Current Satisfaction: " + satisfactionLevel);
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        // This is the guest list
        ArrayList<Guests> guestList = new ArrayList<>();

        guestList.add(new Guests("Amelia and Don", 21, "None", "None", "A young couple celebrating their three-year anniversary on a sweet 'bae-cation.' They’re energetic, affectionate, and looking for a cozy getaway spot to make memories.", "Amelia is a bit of a clean freak. You might be called frequently for room cleaning."));
        guestList.add(new Guests("Sally", 58, "Two cats (one rowdy with sharp claws)", "None", "Freshly single after a messy divorce, Sally is treating herself to luxury... and so are her mischievous cats.", "Risk having furniture damaged and extra room cleaning. Might hear complaints from other guests."));
        guestList.add(new Guests("Riley, Matthew, Tilda, Tildy, and Sunny", 20, "None", "None", "A lively group of friends backpacking across the nation, extremely high on energy and adventurous.", "Could be noisy guests but might attract other travelers!"));
        guestList.add(new Guests("Harold, Lina, Sarah, and Walter", 40, "None", "Sarah (19), Walter (4)", "A complicated family trying hard to act like a happy vacation after some serious drama.", "Family drama might spill over, especially between Sarah and Lina."));
        guestList.add(new Guests("Jasmine", 27, "Small parrot named Kawa", "None", "An aspiring social media influencer documenting her solo journey with her loud parrot.", "Expect constant selfies, live streams, and noise complaints."));
        guestList.add(new Guests("Ilhan and Lila", 30, "None", "None", "A newlywed couple craving quiet, relaxation, and intimate moments on their honeymoon.", "Easily disturbed if the hotel is too rowdy. Otherwise, very low maintenance."));
        guestList.add(new Guests("Derek", 35, "None", "None", "Claims to be an entrepreneur but might actually be a scam artist selling 'Make Money Fast' courses.", "Could be on the run. Just rumors though..."));
        guestList.add(new Guests("Mona", 23, "None", "None", "Fresh from a bad breakup, Mona is determined to make her ex jealous by posting about her fabulous trip.", "Loves the cafe and pool areas; may be demanding about room aesthetics."));
        guestList.add(new Guests("Olivia and Max", 31, "One nervous chihuahua named Sprinkles", "None", "Celebrating five years together, but Olivia's anxious dog might bark at every little thing.", "Nearby guests might complain about constant barking."));
        guestList.add(new Guests("Priya and Ethan", 29, "None", "One on the way!", "Just eloped after finding out Priya was pregnant — hiding out from angry family members while snapping dramatic wedding photos.", "Pretty low-maintenance unless someone from their family shows up."));

        // Random guest selector
        Random rand = new Random();
        int randomIndex = rand.nextInt(guestList.size());

        // Select and display a random guest
        Guests selectedGuest = guestList.get(randomIndex);
        selectedGuest.displayGuest();

        // Example of decreasing satisfaction
        System.out.println("\nOh no! A task was incomplete...");
        selectedGuest.decreaseSatisfaction();
        selectedGuest.displayGuest();
    }
}