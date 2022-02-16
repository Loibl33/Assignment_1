// Code by Philipp Loibl, 2022
// LevelTooLowForWeaponException.java
//
// This class defines an exception that is thrown if a character tries to equip a weapon which level
// requirements he does not meet


package Exceptions;

public class LevelTooLowForWeaponException extends WeaponException {
    public LevelTooLowForWeaponException() {
        super("Character level too low for weapon");
    }
}
