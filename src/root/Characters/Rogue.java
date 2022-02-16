package root.Characters;

import root.Base.Character;
import root.Base.PrimaryAttribute;

public class Rogue extends Character {
    public Rogue(String name) {
        super(name);
        this.basePrimaryAttribute = new PrimaryAttribute(2, 6, 1);
        this.totoalPrimaryAttribute = this.basePrimaryAttribute;
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.totoalPrimaryAttribute.getStrength() + 1;
        int newDexterity = this.totoalPrimaryAttribute.getDexterity() + 4;
        int newIntelligence = this.totoalPrimaryAttribute.getIntelligence() + 1;
        int newDamage = this.getDamage() + 4;
        int newLevel = this.getLevel() + 1;
        this.totoalPrimaryAttribute = new PrimaryAttribute(newStrength, newDexterity, newIntelligence);
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
