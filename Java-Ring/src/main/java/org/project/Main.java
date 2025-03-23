package org.project;

import org.project.entity.enemies.Enemy;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.location.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Locations
        List<Location> locations = new ArrayList<>();
        Location darkForest = new Location("Dark Forest", null, null);
        Location ancientRuins = new Location("Ancient Ruins", null, null);
        Location crystalCave = new Location("Crystal Cave", null, null);
        locations.add(darkForest);
        locations.add(ancientRuins);
        locations.add(crystalCave);

        System.out.println("Welcome to Java-Ring!");
        System.out.println("Choose your character:");
        System.out.println("1. Knight");
        System.out.println("2. Assassin");
        System.out.println("3. Wizard");
        System.out.print("Enter your choice (1-3): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

    Knight player;
    switch (choice) {
        case 1:
            System.out.print("Enter Knight's name: ");
            String knightName = scanner.nextLine();
            player = new Knight(knightName, choice, choice, null, null);
            break;
        case 2:
            System.out.print("Enter Assassin's name: ");
            String assassinName = scanner.nextLine();
            player = new Knight(assassinName, choice, choice, null, null); // Corrected line
            break;
        case 3:
            System.out.print("Enter Wizard's name: ");
            String wizardName = scanner.nextLine();
            player = new Knight("AssassinName", choice, choice, null, null);

            break;
        default:
            System.out.println("Invalid choice. Defaulting to Knight.");
            player = new Knight("knightName", choice, choice, null, null);
            break;
    }
    
        System.out.println("Welcome, " + player.getName() + "!");

        // Choose starting location
        System.out.println("Choose your starting location:");
        for (int i = 0; i < locations.size(); i++) {
            System.out.println((i + 1) + ". " + locations.get(i).getName());
        }
        System.out.print("Enter your choice (1-" + locations.size() + "): ");
        int locationChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Location currentLocation = locations.get(locationChoice - 1);
        System.out.println("You enter the " + currentLocation.getName() + ".");

        // Game loop
        while (player.isAlive()) {
            Enemy enemy = currentLocation.generateRandomEnemy();
            System.out.println("A " + enemy.getName() + " appears!");

            // Combat loop
            while (player.isAlive() && enemy.isAlive()) {
                // Player's turn
                System.out.println("\nYour turn:");
                System.out.println("1. Attack");
                System.out.println("2. Special Ability");
                System.out.print("Enter your choice (1-2): ");
                int action = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (action) {
                    case 1:
                        player.attack(enemy);
                        break;
                    case 2:
                        player.specialAbility(enemy);
                        break;
                    default:
                        System.out.println("Invalid action. You lose your turn.");
                        break;
                }

                if (!enemy.isAlive()) {
                    System.out.println(enemy.getName() + " is defeated!");
                    // Reward player (e.g., increase health)
                    player.setHealth(player.getHealth() + 20);
                    System.out.println("You gained 20 health. Your current health: " + player.getHealth());
                    break;
                }

                // Enemy's turn
                System.out.println("\nEnemy's turn:");
                enemy.attack(player);

                if (!player.isAlive()) {
                    System.out.println(player.getName() + " is defeated!");
                    break;
                }
            }

            // After combat
            if (player.isAlive()) {
                System.out.println("\nWhat do you want to do?");
                System.out.println("1. Move to another location");
                System.out.println("2. Quit");
                System.out.print("Enter your choice (1-2): ");
                int nextAction = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (nextAction == 1) {
                    // Choose new location
                    System.out.println("Choose your next location:");
                    for (int i = 0; i < locations.size(); i++) {
                        System.out.println((i + 1) + ". " + locations.get(i).getName());
                    }
                    System.out.print("Enter your choice (1-" + locations.size() + "): ");
                    locationChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    currentLocation = locations.get(locationChoice - 1);
                    System.out.println("You enter the " + currentLocation.getName() + ".");
                } else {
                    System.out.println("Thanks for playing!");
                    break;
                }
            } else {
                System.out.println("Game Over!");
            }
        }

        System.out.println("Game Over!");
        scanner.close();
    }
}
