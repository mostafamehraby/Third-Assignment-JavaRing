package org.project.entity.enemies;

import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Skeleton extends Enemy {
    private static final String NAME = "Skeleton";
    private static final int DEFAULT_HP = 50;
    private static final int DEFAULT_MP = 0;
    private Armor armor;

    public Skeleton(Weapon weapon, Armor armor) {
        super(NAME, DEFAULT_HP, DEFAULT_MP, weapon);
        this.armor = armor;
    }

    //Override takeDamage method to consider armor
    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage - armor.getDefense();
        if (actualDamage > 0) {
            super.takeDamage(actualDamage);
        } else {
            System.out.println("The skeleton's armor absorbed the attack!");
        }
    }

    public Armor getArmor() {
        return armor;
    }

    @Override
    public void setHealth(int health) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHealth'");
    }

    @Override
    public void setMana(int mana) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMana'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }
}
