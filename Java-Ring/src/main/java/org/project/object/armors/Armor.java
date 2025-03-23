package org.project.object.armors;

public abstract class Armor {
    private String name;
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;
    private boolean isBroke;

    public Armor(String name, int defense, int durability) {
        this.name = name;
        this.defense = defense;
        this.maxDefense = defense;
        this.durability = durability;
        this.maxDurability = durability;
        this.isBroke = false;
    }

    public void takeDamage(int damage) {
        durability -= damage;
        if (durability < 0) {
            durability = 0;
        }
        checkBreak();
        System.out.println(name + " takes " + damage + " damage. Durability: " + durability);
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
            System.out.println(name + " is broken!");
        }
    }

    public void repair() {
        isBroke = false;
        defense = maxDefense;
        durability = maxDurability;
        System.out.println(name + " has been repaired. Defense: " + defense + ", Durability: " + durability);
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public boolean isBroke() {
        return isBroke;
    }
}
