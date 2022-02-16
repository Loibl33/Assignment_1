// Code by Philipp Loibl, 2022
// Wand.java
//
// This class defines the weapon type wand



package Weapons;

import Base.Weapon;

public class Wand extends Weapon {
    public Wand(String name, int requiredLevel, int damage, int attackSpeed) {
        super(name, requiredLevel, damage, attackSpeed);
    }
}
