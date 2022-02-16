// Code by Philipp Loibl, 2022
// ItemAndEquipmentTest.java
//
// This class tests the correct behaviour of items and characters



package root.Base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import root.Armors.Cloth;
import root.Armors.Plate;
import root.Characters.Warrior;
import root.Exceptions.ArmorNotSuitableForCharacterException;
import root.Exceptions.LevelTooLowForArmorException;
import root.Exceptions.LevelTooLowForWeaponException;
import root.Exceptions.WeaponNotSuitableForCharacterException;
import root.Weapons.Axe;
import root.Weapons.Bow;

public class ItemAndEquipmentTest {
    Warrior warrior;
    Axe axe;
    Plate plate;
    Bow bow;
    Cloth cloth;

    //Sets up a warrior and various items
    @BeforeEach
    void setUp() {
        warrior = new Warrior("Bill");
        axe = new Axe("Axe", 1, 3, 3);
        plate = new Plate("Plate", 1);
        bow = new Bow("Bow", 1, 5, 2);
        cloth = new Cloth("Cloth", 1);
    }

    //Tests if a warrior can equip an axe, if required level is met
    @Test
    void CharacterEquip_CharacterAndItemsExist_EquipWarriorWithAxe() {
        try {
            warrior.equip(axe);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        String shouldString = "Character{damage=1, name='Bill', level=1, basePrimaryAttribute=PrimaryAttribute{Strength=5, Dexterity=2, Intelligence=1}, totoalPrimaryAttribute=PrimaryAttribute{Strength=5, Dexterity=2, Intelligence=1}, equipment={Weapon=Weapon(attackSpeed=3, damage=3, dps=9)}, dps=9}";
        String isString = warrior.toString();
        Assertions.assertEquals(shouldString, isString);
    }

    //Tests if a warrior can equip a plate, if required level is met
    @Test
    void CharacterEquip_CharacterAndItemsExist_EquipWarriorWithPlate() {
        try {
            warrior.equip(plate);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        String isString = warrior.toString();
        boolean successful = isString.contains("Item(name=Plate, requiredLevel=1)");
        Assertions.assertTrue(successful);
    }

    //Tests if correct exception is thrown if a warrior tries to equip a weapon he is not allowed to
    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowWeaponNotSuitableForCharacterException() {
        Assertions.assertThrows(WeaponNotSuitableForCharacterException.class, () -> warrior.equip(bow));
    }

    //Tests if correct exception is thrown if a warrior tries to equip an armor he is not allowed to
    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowArmorNotSuitableForCharacterException() {
        Assertions.assertThrows(ArmorNotSuitableForCharacterException.class, () -> warrior.equip(cloth));
    }

    //Tests if correct exception is thrown if a warrior tries to equip a weapon which
    //required level he does not meet
    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowLevelTooLowForWeaponException() {
        axe.setRequiredLevel(2);
        Assertions.assertThrows(LevelTooLowForWeaponException.class, () -> warrior.equip(axe));
    }

    //Tests if correct exception is thrown if a warrior tries to equip an armor which
    //required level he does not meet
    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowLevelTooLowForArmorException() {
        plate.setRequiredLevel(2);
        Assertions.assertThrows(LevelTooLowForArmorException.class, () -> warrior.equip(plate));
    }

    //Tests if return value is true if warrior successfully equips an axe
    @Test
    void CharacterEquip_CharacterAndWeaponExist_ShouldReturnTrue() throws Throwable {
        boolean successfull = warrior.equip(axe);
        Assertions.assertTrue(successfull);
    }

    //Tests if return value is true if warrior successfully equips a plate
    @Test
    void CharacterEquip_CharacterAndArmorExist_ShouldReturnTrue() throws Throwable {
        boolean successfull = warrior.equip(plate);
        Assertions.assertTrue(successfull);
    }

    //Tests if the dps of a warrior is calculated correctly, if he has level one and no items
    @Test
    void CharacterCalculateDPS_CharacterExitsAndHasNoWeapon_ShouldReturnCorrectDPS() {
        int isDps = warrior.getCharacterDps();
        int shouldDps = 1;
        Assertions.assertEquals(shouldDps, isDps);
    }

    //Tests if the dps of a warrior is calculated correctly, if he has level one and an axe
    @Test
    void CharacterCalculateDPS_CharacterExitsLevel1AxeEquipped_ShouldReturnCorrectDPS() throws Throwable {
        warrior.equip(axe);
        int isDps = warrior.getCharacterDps();
        int shouldDps = 9;
        Assertions.assertEquals(shouldDps, isDps);
    }

    @Test
    void CharacterCalculateDPS_CharacterExitsLevel1AxeEquippedPlateEquipped_ShouldReturnCorrectDPS() throws Throwable {
        warrior.equip(axe);
        warrior.equip(plate);
        int isDps = warrior.getCharacterDps();
        int shouldDps = 9;
        Assertions.assertEquals(shouldDps, isDps);
    }
}
