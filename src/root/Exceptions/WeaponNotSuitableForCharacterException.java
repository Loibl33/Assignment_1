// Code by Philipp Loibl, 2022
// WeaponNotSuitableForCharacterException.java
//
// This class defines an exception that is thrown if a character tries to equip a weapon he
// is not allowed to


package root.Exceptions;

public class WeaponNotSuitableForCharacterException extends WeaponException {
    public WeaponNotSuitableForCharacterException() {
        super("Weapon not suitable for Character");
    }
}
