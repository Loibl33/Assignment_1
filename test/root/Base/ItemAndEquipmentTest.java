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

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Bill");
        axe = new Axe("Axe", 1, 3, 3);
        plate = new Plate("Plate", 1);
        bow = new Bow("Bow", 1, 5, 2);
        cloth = new Cloth("Cloth", 1);
    }

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

    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowWeaponNotSuitableForCharacterException() throws Throwable {
        Assertions.assertThrows(WeaponNotSuitableForCharacterException.class, () -> warrior.equip(bow));
    }

    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowArmorNotSuitableForCharacterException() throws Throwable {
        Assertions.assertThrows(ArmorNotSuitableForCharacterException.class, () -> warrior.equip(cloth));
    }

    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowLevelTooLowForWeaponException() throws Throwable {
        axe.setRequiredLevel(2);
        Assertions.assertThrows(LevelTooLowForWeaponException.class, () -> warrior.equip(axe));
    }

    @Test
    void CharacterEquip_CharacterAndItemsExist_ShouldThrowLevelTooLowForArmorException() throws Throwable {
        plate.setRequiredLevel(2);
        Assertions.assertThrows(LevelTooLowForArmorException.class, () -> warrior.equip(plate));
    }

    @Test
    void CharacterEquip_CharacterAndWeaponExist_ShouldReturnTrue() throws Throwable {
        boolean successfull = warrior.equip(axe);
        Assertions.assertEquals(true, successfull);
    }

    @Test
    void CharacterEquip_CharacterAndArmorExist_ShouldReturnTrue() throws Throwable {
        boolean successfull = warrior.equip(plate);
        Assertions.assertEquals(true, successfull);
    }

    @Test
    void CharacterCalculateDPS_CharacterExitsAndHasNoWeapon_ShouldReturnCorrectDPS() throws Throwable {
        int isDps = warrior.getCharacterDps();
        int shouldDps = 1 * (1 + (5 / 100));
        Assertions.assertEquals(shouldDps, isDps);
    }

    @Test
    void CharacterCalculateDPS_CharacterExitsLevel1AxeEquipped_ShouldReturnCorrectDPS() throws Throwable {
        warrior.equip(axe);
        int isDps = warrior.getCharacterDps();
        int shouldDps = (int) (7 * 1.1) * (1 + (5 / 100));
        Assertions.assertEquals(shouldDps, isDps);
    }

    @Test
    void CharacterCalculateDPS_CharacterExitsLevel1AxeEquippedPlateEquipped_ShouldReturnCorrectDPS() throws Throwable {
        warrior.equip(axe);
        warrior.equip(plate);
        int isDps = warrior.getCharacterDps();
        int shouldDps = (int) (7 * 1.1) * (1 + ((5 + 1) / 100));
        Assertions.assertEquals(shouldDps, isDps);
    }
}
