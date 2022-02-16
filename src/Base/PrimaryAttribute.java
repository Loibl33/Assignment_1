// Code by Philipp Loibl, 2022
// PrimaryAttribute.java
//
// This class defines the primary attribute of character
// The primary attribute consists of strength, dexterity and intelligence



package Base;

import lombok.Data;

@Data
public class PrimaryAttribute {
    private int Strength;
    private int Dexterity;
    private int Intelligence;

    public PrimaryAttribute(int strength, int dexterity, int intelligence) {
        Strength = strength;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "PrimaryAttribute{" +
                "Strength=" + Strength +
                ", Dexterity=" + Dexterity +
                ", Intelligence=" + Intelligence +
                '}';
    }
}
