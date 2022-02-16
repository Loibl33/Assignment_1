package root.Exceptions;

public class WeaponNotSuitableForCharacterException extends WeaponException {
    public WeaponNotSuitableForCharacterException() {
        super("Weapon not suitable for Character");
    }
}
