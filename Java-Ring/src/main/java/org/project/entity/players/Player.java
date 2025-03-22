package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public abstract class Player implements Entity {
    protected String name;
    protected Weapon weapon;
    protected Armor armor;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.maxHP = hp;  // Set maxHP to initial hp value
        this.mp = mp;
        this.maxMP = mp;  // Set maxMP to initial mp value
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void defend() {
        System.out.println(name + " is defending using " + armor.getName() + "!");
        // Here, you can implement a bonus to armor's defense for a limited time, for instance.
    }

    @Override
    public void takeDamage(int damage) {
        int damageReduction = armor.getDefense();
        int actualDamage = Math.max(1, damage - damageReduction); // Ensure at least 1 damage is taken

        hp -= actualDamage;

        System.out.println(name + " takes " + actualDamage + " damage! Armor reduced " + damageReduction + " damage.");

        if (hp < 0) {
            hp = 0; // Prevent health from dropping below zero
            System.out.println(name + " has been defeated!");
        }
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
        System.out.println(name + " heals for " + health + " HP. Current HP: " + hp);
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
        System.out.println(name + " fills " + mana + " MP. Current MP: " + mp);
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public int getHealth() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public int getMana() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    @Override
    public boolean isAlive() {
        return hp > 0; // Implement the isAlive method
    }

    public void setHealth(int health) {
        this.hp = health;
    }

    public void setMana(int mana) {
        this.mp = mana;
    }

    public abstract void specialAbility(Enemy enemy);
}
