package org.project.object.armors;

public class KnightArmor extends Armor {
    private static final String DEFAULT_NAME = "Knight's Armor";
    private static final int DEFAULT_DEFENSE = 30;
    private static final int DEFAULT_DURABILITY = 100;

    public KnightArmor(String name, int defense, int durability) {
        super(name, defense, durability);
    }

    public KnightArmor() {
        super(DEFAULT_NAME, DEFAULT_DEFENSE, DEFAULT_DURABILITY);
    }
}
