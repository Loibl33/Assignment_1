// Code by Philipp Loibl, 2022
// Ranger.java
//
// This class defines the character Ranger


package root.Characters;

import root.Base.Character;
import root.Base.PrimaryAttribute;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name);
        this.basePrimaryAttribute = new PrimaryAttribute(1, 7, 1);
        this.totoalPrimaryAttribute = this.basePrimaryAttribute;
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.totoalPrimaryAttribute.getStrength() + 1;
        int newDexterity = this.totoalPrimaryAttribute.getDexterity() + 5;
        int newIntelligence = this.totoalPrimaryAttribute.getIntelligence() + 1;
        int newDamage = this.getDamage() + 5;
        int newLevel = this.getLevel() + 1;
        this.totoalPrimaryAttribute = new PrimaryAttribute(newStrength, newDexterity, newIntelligence);
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
