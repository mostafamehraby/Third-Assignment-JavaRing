package org.project.entity;

import org.project.object.weapons.Sword;

public interface Entity {
    String getName(); // اسم موجودیت

    int getHealth();  // میزان سلامتی
    void setHealth(int health); // تنظیم میزان سلامتی

    int getMana();    // میزان مانا
    void setMana(int mana);   // تنظیم میزان مانا

    void attack(Entity target); // حمله به هدف

    void defend();   // دفاع کردن

    void heal(int health);   // افزایش سلامتی

    void fillMana(int mana);  // پر کردن مانا

    void takeDamage(int damage);  // دریافت خسارت

    int getMaxHP();   // حداکثر سلامتی

    int getMaxMP();   // حداکثر مانا

    boolean isAlive();  // بررسی زنده بودن

    default void attack(Sword sword) {
        int damageDealt = sword.getDamage();
        takeDamage(damageDealt);
        System.out.println(sword.getName() + " attacks " + getName() + " for " + damageDealt + " damage.");
    }

    //TODO: ADD OTHER REQUIRED AND BONUS METHODS
}
