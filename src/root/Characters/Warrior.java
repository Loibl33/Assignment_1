package root.Characters;

import root.Base.Character;
import root.Base.PrimaryAttribute;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.basePrimaryAttribute = new PrimaryAttribute(5, 2, 1);
        this.totoalPrimaryAttribute = this.basePrimaryAttribute;
    }

    @Override
    public int increaseLevel() {
        int newStrength = this.totoalPrimaryAttribute.getStrength() + 3;
        int newDexterity = this.totoalPrimaryAttribute.getDexterity() + 2;
        int newIntelligence = this.totoalPrimaryAttribute.getIntelligence() + 1;
        int newDamage = this.getDamage() + 3;
        int newLevel = this.getLevel() + 1;
        this.totoalPrimaryAttribute = new PrimaryAttribute(newStrength, newDexterity, newIntelligence);
        this.setDamage(newDamage);
        this.setLevel(newLevel);
        return this.getLevel();
    }
}
