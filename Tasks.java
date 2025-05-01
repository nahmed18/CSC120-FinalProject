import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Arrays; 

public class Tasks {

    String name;
    String type; // is it a task that the hotel needs or a guest is requesting for
    boolean isCompleted;

    private static boolean taskInProgress = false; // Only one task at a time!!
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public Tasks(String name, String type) {
        this.name = name;
        this.type = type;
        this.isCompleted = false;
    }

    public void displayTask() {
        System.out.println("📋 Task: " + name + " | Type: " + type + " | Status: " + (isCompleted ? "Completed" : "Incomplete"));
    }

    public boolean completeTask() {
        this.isCompleted = true;
        taskInProgress = false;
        System.out.println("✅ Task Completed: " + name);
        return true;
    }

    public void failTask() {
        this.isCompleted = false;
        taskInProgress = false;
        System.out.println("❌ Task Failed: " + name);
    }

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

    private boolean playMiniGame() {
        int gameType = random.nextInt(2); // 0 or 1
        if (gameType == 0) {
            return playWhackAMole();
        } else {
            return playRockPaperScissors();
        }
    }

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
//THANK YOU SO MUCH CAITLYN !!!!!
    public static void main(String[] args) {
        Tasks task = Tasks.getRandomTask("guest");
        task.displayTask();
        task.startTask();

        Tasks task2 = Tasks.getRandomTask("hotel");
        task2.displayTask();
        task2.startTask();
    }




}