// Code by Philipp Loibl, 2022
// LevelTooLowForArmorException.java
//
// This class defines an exception that is thrown if a character tries to equip an armor which level
// requirements he does not meet


package root.Exceptions;

public class LevelTooLowForArmorException extends ArmorException {
    public LevelTooLowForArmorException() {
        super("Character level too low for armor");
    }
}
