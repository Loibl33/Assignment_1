package root.Base;

import root.Armors.Cloth;
import root.Armors.Leather;
import root.Armors.Mail;
import root.Armors.Plate;
import root.Characters.Mage;
import root.Characters.Ranger;
import root.Characters.Rogue;
import root.Characters.Warrior;
import root.Weapons.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipAllowedForCharacter extends HashMap<Class, ArrayList<Class>> {
    private static EquipAllowedForCharacter INSTANCE;

    private EquipAllowedForCharacter() {
        ArrayList<Class> Mage = new ArrayList<Class>();
        Mage.add(Staff.class);
        Mage.add(Wand.class);
        Mage.add(Cloth.class);

        ArrayList<Class> Ranger = new ArrayList<Class>();
        Ranger.add(Bow.class);
        Ranger.add(Leather.class);
        Ranger.add(Mail.class);

        ArrayList<Class> Rogue = new ArrayList<Class>();
        Rogue.add(Dagger.class);
        Rogue.add(Sword.class);
        Rogue.add(Leather.class);
        Rogue.add(Mail.class);

        ArrayList<Class> Warrior = new ArrayList<Class>();
        Warrior.add(Axe.class);
        Warrior.add(Hammer.class);
        Warrior.add(Sword.class);
        Warrior.add(Mail.class);
        Warrior.add(Plate.class);

        this.put(Mage.class, Mage);
        this.put(Ranger.class, Ranger);
        this.put(Rogue.class, Rogue);
        this.put(Warrior.class, Warrior);
    }

    public static EquipAllowedForCharacter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EquipAllowedForCharacter();
        }
        return INSTANCE;
    }
}
