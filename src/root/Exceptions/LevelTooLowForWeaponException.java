package root.Exceptions;

public class LevelTooLowForWeaponException extends Exception {
    public LevelTooLowForWeaponException() {
        super("Character level too low for weapon");
    }
}
