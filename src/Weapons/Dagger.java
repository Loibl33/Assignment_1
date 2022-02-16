// Code by Philipp Loibl, 2022
// Dagger.java
//
// This class defines the weapon type dagger



package Weapons;


import Base.Weapon;

public class Dagger extends Weapon {
    public Dagger(String name, int requiredLevel, int damage, int attackSpeed) {
        super(name, requiredLevel, damage, attackSpeed);
    }
}
