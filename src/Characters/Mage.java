// Code by Philipp Loibl, 2022
// Mage.java
//
// This class defines the character Mage



package Characters;

import Base.Character;
import Base.PrimaryAttribute;

public class Mage extends Character {
    public Mage(String name) {
        super(name);
        this.setBasePrimaryAttribute(new PrimaryAttribute(1, 1, 8));
        this.setTotalPrimaryAttribute(this.getBasePrimaryAttribute());
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.getTotalPrimaryAttribute().getStrength() + 1;
        int newDexterity = this.getTotalPrimaryAttribute().getDexterity() + 1;
        int newIntelligence = this.getTotalPrimaryAttribute().getIntelligence() + 5;
        int newDamage = this.getDamage() + 5;
        int newLevel = this.getLevel() + 1;
        this.setTotalPrimaryAttribute(new PrimaryAttribute(newStrength, newDexterity, newIntelligence));
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
