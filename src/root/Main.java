package root;

import root.Base.EquipAllowedForCharacter;
import root.Characters.Mage;
import root.Characters.Ranger;
import root.Exceptions.LevelTooLowForArmorException;
import root.Exceptions.WeaponNotSuitableForCharacterException;
import root.Weapons.Axe;
import root.Weapons.Bow;

//todo: dps
//todo: equip , Exceptions


public class Main {

    public static void main(String[] args) throws WeaponNotSuitableForCharacterException, LevelTooLowForArmorException, InstantiationException, IllegalAccessException {

        Mage Anna = new Mage("Anna");
        Anna.increaseLevel();
        System.out.println(Anna.getLevel());
        EquipAllowedForCharacter eafc = EquipAllowedForCharacter.getInstance();
        var a = eafc.get(Mage.class);
        System.out.println(a);
        System.out.println(Anna);
//
        var axe = new Axe("Axe1", 0, 2, 3);
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
