package root.Exceptions;

public class LevelTooLowForWeaponException extends WeaponException {
    public LevelTooLowForWeaponException() {
        super("Character level too low for weapon");
    }
}
