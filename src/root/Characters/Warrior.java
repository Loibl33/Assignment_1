// Code by Philipp Loibl, 2022
// Warrior.java
//
// This class defines the character Rogue


package root.Characters;

import root.Base.Character;
import root.Base.PrimaryAttribute;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setBasePrimaryAttribute(new PrimaryAttribute(5, 2, 1));
        this.setTotalPrimaryAttribute(this.getBasePrimaryAttribute());
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.getTotalPrimaryAttribute().getStrength() + 3;
        int newDexterity = this.getTotalPrimaryAttribute().getDexterity() + 2;
        int newIntelligence = this.getTotalPrimaryAttribute().getIntelligence() + 1;
        int newDamage = this.getDamage() + 3;
        int newLevel = this.getLevel() + 1;
        this.setTotalPrimaryAttribute(new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
