public class PrimaryAttribute{

    private int Strength;
    private int Dexterity;
    private int Intelligence;

    public PrimaryAttribute(int strength, int dexterity, int intelligence) {
        Strength = strength;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }

    public PrimaryAttribute() {
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PrimaryAttribute)) return false;
        if (!super.equals(object)) return false;
        PrimaryAttribute that = (PrimaryAttribute) object;
        return getStrength() == that.getStrength() &&
                getDexterity() == that.getDexterity() &&
                getIntelligence() == that.getIntelligence();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getStrength(), getDexterity(), getIntelligence());
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PrimaryAttribute{" +
                "Strength=" + Strength +
                ", Dexterity=" + Dexterity +
                ", Intelligence=" + Intelligence +
                '}';
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }
}
