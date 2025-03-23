package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Knight implements Entity {
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private Weapon weapon;
    private Armor armor;

    public Knight(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
        this.weapon = weapon;
        this.armor = armor;
    }

    public Knight(String wizardName) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage - armor.getDefense();
        if (actualDamage > 0) {
            hp -= actualDamage;
            if (hp < 0) {
                hp = 0;
            }
        } else {
            System.out.println("The knight's armor absorbed the attack!");
        }
    }

    @Override
    public int getHealth() {
        return hp;
    }

    @Override
    public int getMana() {
        return mp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxHP() {
        return maxHp;
    }

    @Override
    public int getMaxMP() {
        return maxMp;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        hp = Math.min(health, maxHp);
    }

    public void setMana(int mana) {
        mp = Math.min(mana, maxMp);
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        target.takeDamage(damage);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    @Override
    public void defend() {
        System.out.println(name + " is defending!");
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHp) {
            hp = maxHp;
        }
        System.out.println(name + " heals for " + health + " HP.");
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMp) {
            mp = maxMp;
        }
        System.out.println(name + " fills " + mana + " MP.");
    }

    public void specialAbility(Enemy enemy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'specialAbility'");
    }
}
