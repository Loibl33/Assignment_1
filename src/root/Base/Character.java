// Code by Philipp Loibl, 2022
// Character.java
//
// This class defines a character


package root.Base;

import root.Exceptions.ArmorNotSuitableForCharacterException;
import root.Exceptions.LevelTooLowForArmorException;
import root.Exceptions.LevelTooLowForWeaponException;
import root.Exceptions.WeaponNotSuitableForCharacterException;

import java.util.ArrayList;
import java.util.Arrays;

@lombok.Data
public abstract class Character {
    public PrimaryAttribute basePrimaryAttribute;
    public PrimaryAttribute totoalPrimaryAttribute;
    public Equipment equipment;
    int damage;
    String name;
    int level;
    int characterDps;

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
        totalAttr += this.totoalPrimaryAttribute.getStrength();
        totalAttr += this.totoalPrimaryAttribute.getDexterity();
        totalAttr += this.totoalPrimaryAttribute.getIntelligence();
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
            exceptions.clear();
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
                ", totoalPrimaryAttribute=" + totoalPrimaryAttribute +
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
                ", Strength=" + totoalPrimaryAttribute.getStrength() +
                ", Dexterity=" + totoalPrimaryAttribute.getDexterity() +
                ", Intelligence=" + totoalPrimaryAttribute.getIntelligence() +
                ", dps=" + characterDps +
                '}';
    }
}
