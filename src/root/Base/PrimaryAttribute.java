package root.Base;

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
