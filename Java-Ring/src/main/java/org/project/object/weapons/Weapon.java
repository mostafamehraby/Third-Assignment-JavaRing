package org.project.object.weapons;

import org.project.entity.Entity;

public abstract class Weapon {
    private int damage;
    private int manaCost;
    private int durability; // Amount of damage the weapon can take before breaking
    private String name; // Name of the weapon type
    private String weaponType; // e.g., 'Melee', 'Ranged'

    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    public Weapon(String name, int damage, int manaCost, int durability, String weaponType) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.durability = durability;
        this.weaponType = weaponType;
    }

    public abstract void use(Entity target); // Implemented by subclasses

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void reduceDurability(int amount) {
        durability -= amount;
        if (durability < 0) {
            durability = 0; // Ensure durability does not go negative
        }
    }

    public boolean isBroken() {
        return durability == 0; // Returns true if the weapon is broken
    }

    public void repair(int amount) {
        durability += amount; // Repair the weapon
        System.out.println(name + " repaired by " + amount + ". Current durability: " + durability);
    }

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
