package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;
import java.util.Random;

public class Sword extends Weapon {
    private static final String DEFAULT_NAME = "Basic Sword";
    private static final int DEFAULT_DAMAGE = 10;
    private static final int DEFAULT_DURABILITY = 100;

    private int abilityCharge;
    private Random random = new Random();

    public Sword(String name, int damage, int durability) {
        super(name, damage, durability, durability, name);
        this.abilityCharge = 0;
    }

    public Sword() {
        this(DEFAULT_NAME, DEFAULT_DAMAGE, DEFAULT_DURABILITY);
    }

    public void uniqueAbility(ArrayList<Entity> targets) {
        if (abilityCharge >= 10) {
            System.out.println(getName() + " unleashes a powerful strike!");
            for (Entity target : targets) {
                int bonusDamage = random.nextInt(20) + 10; // Random bonus damage between 10 and 30
                int totalDamage = getDamage() + bonusDamage;
                target.takeDamage(totalDamage);
                System.out.println(getName() + " hits " + target.getName() + " for " + totalDamage + " damage!");
            }
            abilityCharge -= 10;
        } else {
            System.out.println("Not enough ability charge. Need 10 charge to use unique ability.");
        }
    }

    public void chargeAbility() {
        abilityCharge += 5;
        System.out.println(getName() + " charges ability. Current charge: " + abilityCharge);
    }

    public int getAbilityCharge() {
        return abilityCharge;
    }

    public void setAbilityCharge(int abilityCharge) {
        this.abilityCharge = abilityCharge;
    }

    @Override
    public void use(Entity target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
