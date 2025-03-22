package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    private int healingAmount;

    public Flask(String name, int quantity, int healingAmount) {
        super(name, quantity);
        this.healingAmount = healingAmount;
    }

    public Flask() {
        super( "Flask" , 1 ); // Default name, quantity, and healing amount
        this.healingAmount = 20;
    }

    @Override
    public void consume(Entity target) {
        if (this.getQuantity() > 0) {
            target.heal(healingAmount);
            this.decreaseQuantity(1);
            System.out.println(target.getName() + " consumed a " + this.getName() + " and healed for " + healingAmount + " HP.");
        } else {
            System.out.println("No more " + this.getName() + " available.");
        }
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }
}
