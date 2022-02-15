package root.Exceptions;

public class LevelTooLowForArmorException extends Exception {
    public LevelTooLowForArmorException() {
        super("Character level too low for armor");
    }
}
