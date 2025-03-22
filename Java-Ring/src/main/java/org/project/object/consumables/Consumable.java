package org.project.object.consumables;

import org.project.entity.Entity;

public abstract class Consumable {
    protected String name;
    protected int quantity;

    public Consumable(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public abstract void consume(Entity target);

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
        if (this.quantity < 0) {
            this.quantity = 0;
        }
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }
}
