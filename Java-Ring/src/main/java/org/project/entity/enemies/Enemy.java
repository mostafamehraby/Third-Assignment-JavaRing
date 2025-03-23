package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public abstract class Enemy implements Entity {
    private String name; // اضافه کردن نام برای دشمن
    private int hp;
    private int mp;
    private Weapon weapon;

    public Enemy(String name, int hp, int mp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage(); // فرض کنید Weapon دارای متدی به نام getDamage است
        target.takeDamage(damage);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    @Override
    public void defend() {
        // منطق دفاع (اختیاری: می‌توانید پیاده‌سازی خاصی برای دشمن ها داشته باشید)
        System.out.println(name + " is defending!");
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > getMaxHP()) {
            hp = getMaxHP(); // اطمینان از اینکه hp بیشتر از MaxHP نباشد
        }
        System.out.println(name + " heals for " + health + " HP.");
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > getMaxMP()) {
            mp = getMaxMP(); // اطمینان از اینکه mp بیشتر از MaxMP نباشد
        }
        System.out.println(name + " fills " + mana + " MP.");
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0; // اطمینان از اینکه hp منفی نشود
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
        return hp; // حداکثر HP می‌تواند مقداری مشخص باشد؛ می‌توانید این قسمت را تغییر دهید
    }

    @Override
    public int getMaxMP() {
        return mp; // حداکثر MP نیز به همین شکل
    }

    @Override
    public boolean isAlive() {
        return hp > 0; // بررسی زنده بودن بر اساس hp
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public abstract void reset();
}
