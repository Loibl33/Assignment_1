// Code by Philipp Loibl, 2022
// Rogue.java
//
// This class defines the character Rogue


package Characters;

import Base.Character;
import Base.PrimaryAttribute;

public class Rogue extends Character {
    public Rogue(String name) {
        super(name);
        this.setBasePrimaryAttribute(new PrimaryAttribute(2, 6, 1));
        this.setTotalPrimaryAttribute(this.getBasePrimaryAttribute());
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.getTotalPrimaryAttribute().getStrength() + 1;
        int newDexterity = this.getTotalPrimaryAttribute().getDexterity() + 4;
        int newIntelligence = this.getTotalPrimaryAttribute().getIntelligence() + 1;
        int newDamage = this.getDamage() + 4;
        int newLevel = this.getLevel() + 1;
        this.setTotalPrimaryAttribute(new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
