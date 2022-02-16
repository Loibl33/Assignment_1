// Code by Philipp Loibl, 2022
// ArmorNotSuitableForCharacterException.java
//
// This class defines an exception that is thrown if a character tries to equip an armor he
// is not allowed to



package root.Exceptions;

public class ArmorNotSuitableForCharacterException extends ArmorException {
    public ArmorNotSuitableForCharacterException() {
        super("Armor not suitable for Character");
    }
}
