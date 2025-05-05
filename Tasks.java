import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Arrays; 

/**
 * Encapsulates tasks performed by either player or requested by guests
 * Each Task has a name, type (guest or hotel), and completion status
 * Tasks can be started, completed, or failed based on if mini-game is won
 */
public class Tasks {

    //Task attributes 
    String name;
    String type; // is it a task that the hotel needs or a guest is requesting for
    boolean isCompleted;

    private static boolean taskInProgress = false; // Only one task at a time!!
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    /**
     * Constructs a new Tasks instance with given name and type
     * Initially task is marked incomplete
     * @param name the name or description of task
     * @param type the category of task ("guest" or "hotel")
     */
    public Tasks(String name, String type) {
        this.name = name;
        this.type = type;
        this.isCompleted = false;
    }

    /**
     * Displays task details and its current status 
     */
    public void displayTask() {
        System.out.println("📋 Task: " + name + " | Type: " + type + " | Status: " + (isCompleted ? "Completed" : "Incomplete"));
    }

    /**
     * Maarks task as completed and ends in-progress status
     * @return true upon completion of task
     */
    public boolean completeTask() {
        this.isCompleted = true;
        taskInProgress = false;
        System.out.println("✅ Task Completed: " + name);
        return true;
    }

    /**
     * Marks task as failed and ends in-progress status
     */
    public void failTask() {
        this.isCompleted = false;
        taskInProgress = false;
        System.out.println("❌ Task Failed: " + name);
    }

    /**
     * Begins task, allowing only one in-progress at a time
     * then plays mini-game to determine success of task
     */
    public void startTask() {
        if (taskInProgress) {
            System.out.println("⚠️ You must finish your current task before you take on another one."); 
            return;
        }

        taskInProgress = true;
        System.out.println("Starting Task: " + name);

        // Play a random mini-game (either whack-a-mole or rock, paper, scissor)
        boolean wonMiniGame = playMiniGame();

        if (wonMiniGame) {
            completeTask();
        } else {
            failTask();
        }
    }

    /**
     * Selects random task name based on specified task type
     * @param type either "guest" or "hotel" to pick from corresponding lists
     * @return new Tasks object with a random name of given type
     */
    public static Tasks getRandomTask(String type) {
        ArrayList<String> guestTasks = new ArrayList<>(Arrays.asList(
                "Clean the room", "Replace lost keycard", "Bring extra towels"));

        ArrayList<String> hotelTasks = new ArrayList<>(Arrays.asList(
                "Do the laundry", "Replace toiletries", "Clean animal fur", "Stop family arguments in public places"));

        String taskName = type.equalsIgnoreCase("guest") ?
                guestTasks.get(random.nextInt(guestTasks.size())) :
                hotelTasks.get(random.nextInt(hotelTasks.size()));

        return new Tasks(taskName, type);
    }

    /**
     * Chooses and plays one of the mini-games: Whack-a-Mole, Rock-Paper-Scissors, or Unscramble Word
     * @return true if player wins mini-game; false otherwise
     */
    private boolean playMiniGame() {
        int gameType = random.nextInt(3); // either 0, 1 or 2
        switch (gameType) {
            case 0: return playWhackAMole();
            case 1: return playRockPaperScissors();
            case 2: return playUnscrambleWord();
            default: return false;
        }
    }

    /**
     * Plays a Whack-a-Mole-style game: user must identify odd emoji out of a shuffled list
     * @return true if correct index is chosen; false otherwise
     */
    private boolean playWhackAMole() {
        String[] emojis = {"🐶", "🐶", "🐶", "🐱", "🐶", "🐶"};
        int oddIndex = 3;

        List<String> shuffled = new ArrayList<>(Arrays.asList(emojis));
        Collections.shuffle(shuffled);
        for (int i = 0; i < shuffled.size(); i++) {
            if (!shuffled.get(i).equals("🐶")) {
                oddIndex = i;
                break;
            }
        }

        System.out.println("Find the odd one out! :");
        for (int i = 0; i < shuffled.size(); i++) {
            System.out.print((i + 1) + ": " + shuffled.get(i) + "  ");
        }
        System.out.println("\nEnter the number where the odd one is in the sequence:");

        int guess = scanner.nextInt();
        return guess - 1 == oddIndex;
    }

    /**
     * Plays best-of-three Rock-Paper-Scissors game against system
     * @return true if player wins two rounds first; false otherwise
     */
    private boolean playRockPaperScissors() {
        String[] choices = {"rock", "paper", "scissors"};
        int playerWins = 0;
        int systemWins = 0;

        while (playerWins < 2 && systemWins < 2) {
            System.out.println("Rock, Paper, Scissors! (You can type rock, paper, or scissors)");
            String player = scanner.next().toLowerCase();
            if (!Arrays.asList(choices).contains(player)) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            String system = choices[random.nextInt(3)];
            System.out.println("System chose: " + system);

            if (player.equals(system)) {
                System.out.println("Tie!");
            } else if (
                (player.equals("rock") && system.equals("scissors")) ||
                (player.equals("paper") && system.equals("rock")) ||
                (player.equals("scissors") && system.equals("paper"))
            ) {
                playerWins++;
                System.out.println("You win this round! (You: " + playerWins + " | System: " + systemWins + ")");
            } else {
                systemWins++;
                System.out.println("You lost this round. (You: " + playerWins + " | System: " + systemWins + ")");
            }
        }

        if (playerWins == 2) {
            System.out.println("🎉 You win best of 3!");
            return true;
        } else {
            System.out.println("❌ You lost best of 3.");
            return false;
        }
    }

    /**
     * Plays Unscramble-Word game where user must reorder scrambled letters to create correct word
     * @return true if guess matches original word; false otherwise
     */
    private boolean playUnscrambleWord() {
    String[] words = {"hotel", "guest", "lobby", "suite", "rooms", "vacation", "cafe", "library", "unscramble"};
    String original = words[random.nextInt(words.length)];

    // Scramble the word
    List<Character> letters = new ArrayList<>();
    for (char c : original.toCharArray()) {
        letters.add(c);
    }
    Collections.shuffle(letters);

    StringBuilder scrambled = new StringBuilder();
    for (char c : letters) {
        scrambled.append(c);
    }

    System.out.println("Unscramble the word: " + scrambled);

    int attempts = 0;
    while (attempts < 2) {
        System.out.print("Your guess (" + (2 - attempts) + " attempt(s) left): ");
        String guess = scanner.next().toLowerCase();

        if (guess.equals(original)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect.");
            attempts++;
        }
    }

    System.out.println("You've used all attempts. The correct word was: " + original);
    return false;
}


    public static void main(String[] args) {
        // Tasks task = Tasks.getRandomTask("guest");
        // task.displayTask();
        // task.startTask();

        // Tasks task2 = Tasks.getRandomTask("hotel");
        // task2.displayTask();
        // task2.startTask();
    }


}