package root;

import root.Base.EquipAllowedForCharacter;
import root.Characters.Mage;
import root.Characters.Ranger;
import root.Weapons.Axe;
import root.Weapons.Bow;
import root.Weapons.Staff;

//todo: dps
//todo:  Exceptions


public class Main {

    public static void main(String[] args) throws Throwable {

        Mage Anna = new Mage("Anna");
        Anna.increaseLevel();
        System.out.println(Anna.getLevel());
        EquipAllowedForCharacter eafc = EquipAllowedForCharacter.getInstance();
        var a = eafc.get(Mage.class);
        System.out.println(a);
        System.out.println(Anna);
//
        var axe = new Axe("Axe1", 50, 2, 3);
        var staff = new Staff("Staff1", 50, 2, 5);
        try {
            Anna.equip(axe);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        Ranger sepp = new Ranger("Sepp");

        sepp.equip(new Bow("Bow1", 0, 5, 2));

        System.out.println(sepp);
    }


}
