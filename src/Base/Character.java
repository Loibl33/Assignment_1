// Code by Philipp Loibl, 2022
// Character.java
//
// This class defines a character


package Base;

import Exceptions.ArmorNotSuitableForCharacterException;
import Exceptions.LevelTooLowForArmorException;
import Exceptions.LevelTooLowForWeaponException;
import Exceptions.WeaponNotSuitableForCharacterException;

import java.util.ArrayList;
import java.util.Arrays;

@lombok.Data
public abstract class Character {
    private PrimaryAttribute basePrimaryAttribute;
    private PrimaryAttribute totalPrimaryAttribute;
    private Equipment equipment;
    private int damage;
    private String name;
    private int level;
    private int characterDps;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.equipment = new Equipment();
        this.damage = 1;
        this.characterDps = 1;
    }

    public int calcCharacterDps() {
        int totalAttr = 0;
        int weaponDps;
        totalAttr += this.totalPrimaryAttribute.getStrength();
        totalAttr += this.totalPrimaryAttribute.getDexterity();
        totalAttr += this.totalPrimaryAttribute.getIntelligence();
        try {
            weaponDps = ((Weapon) this.equipment.get(Slot.Weapon)).getDps();
        } catch (Exception exc) {
            weaponDps = 1;
        }
        this.characterDps = weaponDps * (1 + totalAttr / 100);
        return this.characterDps;
    }

    public abstract int increaseLevel();

    public boolean equip(Item item) throws Throwable {
        boolean successfull = false;
        ArrayList<Throwable> exceptions = new ArrayList<>();
        boolean isWeapon = true;
        boolean levelOK = false;
        if (this.level >= item.getRequiredLevel()) {
            levelOK = true;
        }
        boolean itemOK = EquipAllowedForCharacter.getInstance().get(this.getClass()).contains(item.getClass());
        if (item instanceof Armor) {
            isWeapon = false;
        }
        if (levelOK && itemOK) {
            successfull = true;
            addEquipment(item, isWeapon);
        } else {
            if (isWeapon) {
                if (!levelOK) {
                    exceptions.add(new LevelTooLowForWeaponException());
                }
                if (!itemOK) {
                    exceptions.add(new WeaponNotSuitableForCharacterException());
                }
            }
            if (!isWeapon) {
                if (!levelOK) {
                    exceptions.add(new LevelTooLowForArmorException());
                }
                if (!itemOK) {
                    exceptions.add(new ArmorNotSuitableForCharacterException());
                }
            }
            try {
                for (Throwable e : exceptions) {
                    //e.printStackTrace();
                    throw e;
                }
            } finally {
                exceptions.clear();
            }
        }
        calcCharacterDps();
        return successfull;
    }

    private void addEquipment(Item item, boolean isWeapon) {
        if (isWeapon) {
            this.equipment.put(Slot.Weapon, item);
        }
        if (!isWeapon) {
            Slot randomNonWeaponSlot = Arrays.stream(Slot.values()).filter(e -> !e.equals(Slot.Weapon)).findAny().get();
            this.equipment.put(randomNonWeaponSlot, item);
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "damage=" + damage +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", basePrimaryAttribute=" + basePrimaryAttribute +
                ", totoalPrimaryAttribute=" + totalPrimaryAttribute +
                ", equipment=" + equipment +
                ", dps=" + characterDps +
                '}';
    }

    public String stats() {
        return "Character{" +
                "Class=" + this.getClass() +
                ", damage=" + damage +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", Strength=" + totalPrimaryAttribute.getStrength() +
                ", Dexterity=" + totalPrimaryAttribute.getDexterity() +
                ", Intelligence=" + totalPrimaryAttribute.getIntelligence() +
                ", dps=" + characterDps +
                '}';
    }
}
