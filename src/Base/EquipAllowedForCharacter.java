// Code by Philipp Loibl, 2022
// EquipAllowedForCharacter.java
//
// This class defines which type of character can equip which type of items


package Base;

import Armors.Cloth;
import Armors.Leather;
import Armors.Mail;
import Armors.Plate;
import Characters.Mage;
import Characters.Ranger;
import Characters.Rogue;
import Characters.Warrior;
import Weapons.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipAllowedForCharacter extends HashMap<Class, ArrayList<Class>> {
    private static EquipAllowedForCharacter INSTANCE;

    private EquipAllowedForCharacter() {
        ArrayList<Class> Mage = new ArrayList<>();
        Mage.add(Staff.class);
        Mage.add(Wand.class);
        Mage.add(Cloth.class);

        ArrayList<Class> Ranger = new ArrayList<>();
        Ranger.add(Bow.class);
        Ranger.add(Leather.class);
        Ranger.add(Mail.class);

        ArrayList<Class> Rogue = new ArrayList<>();
        Rogue.add(Dagger.class);
        Rogue.add(Sword.class);
        Rogue.add(Leather.class);
        Rogue.add(Mail.class);

        ArrayList<Class> Warrior = new ArrayList<>();
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
