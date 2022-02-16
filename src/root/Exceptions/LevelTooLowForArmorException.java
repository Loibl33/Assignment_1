package root.Exceptions;

public class LevelTooLowForArmorException extends ArmorException {
    public LevelTooLowForArmorException() {
        super("Character level too low for armor");
    }
}
