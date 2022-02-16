package root.Characters;

import root.Base.Character;
import root.Base.PrimaryAttribute;

public class Mage extends Character {
    public Mage(String name) {
        super(name);
        this.basePrimaryAttribute = new PrimaryAttribute(1, 1, 8);
        this.totoalPrimaryAttribute = this.basePrimaryAttribute;
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.totoalPrimaryAttribute.getStrength() + 1;
        int newDexterity = this.totoalPrimaryAttribute.getDexterity() + 1;
        int newIntelligence = this.totoalPrimaryAttribute.getIntelligence() + 5;
        int newDamage = this.getDamage() + 5;
        int newLevel = this.getLevel() + 1;
        this.totoalPrimaryAttribute = new PrimaryAttribute(newStrength, newDexterity, newIntelligence);
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
