package root.Exceptions;

public class WeaponNotSuitableForCharacterException extends Exception {
    public WeaponNotSuitableForCharacterException() {
        super("Weapon not suitable for Character");
    }
}
