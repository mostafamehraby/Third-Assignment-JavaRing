package org.project.location;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Location {
    private String name;
    private ArrayList<Location> locations;
    private ArrayList<Enemy> enemies;

    public Location(String name, ArrayList<Location> locations, ArrayList<Enemy> enemies) {
        this.name = name;
        this.locations = locations;
        this.enemies = enemies;
    }

    /*
    TODO: (BONUS) RESET EACH LOCATION AFTER PLAYER LEAVES
    */
    public void resetEnemies() {
        // Reset each enemy's state (e.g., health, etc.) to the default state.
        for (Enemy enemy : enemies) {
            enemy.reset(); // Assuming there's a reset method in the Enemy class
        }
        System.out.println("Enemies in " + name + " have been reset.");
    }

    public String getName() {
        return name;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        System.out.println(enemy.getName() + " has been added to " + name + ".");
    }

    public void removeEnemy(Enemy enemy) {
        if (enemies.remove(enemy)) {
            System.out.println(enemy.getName() + " has been removed from " + name + ".");
        } else {
            System.out.println(enemy.getName() + " is not present in " + name + ".");
        }
    }

    public Enemy generateRandomEnemy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateRandomEnemy'");
    }
}
