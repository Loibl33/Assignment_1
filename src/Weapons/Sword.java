// Code by Philipp Loibl, 2022
// Sword.java
//
// This class defines the weapon type sword



package Weapons;

import Base.Weapon;

public class Sword extends Weapon {
    public Sword(String name, int requiredLevel, int damage, int attackSpeed) {
        super(name, requiredLevel, damage, attackSpeed);
    }
}
