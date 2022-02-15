package root.Base;

//todo calculate DPS function
//todo write test
//todo gitlab
//todo commit
//todo submit link
//todo exceptions richten: throw new e.newInstance() oder so


import root.Exceptions.ArmorNotSuitableForCharacterException;
import root.Exceptions.LevelTooLowForArmorException;
import root.Exceptions.LevelTooLowForWeaponException;
import root.Exceptions.WeaponNotSuitableForCharacterException;

import java.util.ArrayList;

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
        //this.characterDps = calcCharacterDps();
    }

    public int calcCharacterDps() {
        int totalAttr = 0;
        totalAttr += this.totoalPrimaryAttribute.getStrength();
        totalAttr += this.totoalPrimaryAttribute.getDexterity();
        totalAttr += this.totoalPrimaryAttribute.getIntelligence();
        this.characterDps = ((Weapon) this.equipment.get(Slot.Weapon)).getDps() * (1 + totalAttr / 100);
        return this.characterDps;
    }

//    public abstract int increaseDamage();

    public abstract int increaseLevel();

    public void equip(Item item) throws Throwable {

        ArrayList<Throwable> exceptions = new ArrayList<>();
        boolean isWeapon = true;
        Class c = Weapon.class;
        boolean levelOK = false;
        if (this.level >= item.getRequiredLevel()) {
            levelOK = true;
        }
        boolean itemOK = EquipAllowedForCharacter.getInstance().get(this.getClass()).contains(item.getClass());

        if (item instanceof Armor) {
            isWeapon = false;
            c = Armor.class;
        }


        if (levelOK && itemOK) {
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
    }

    private void addEquipment(Item item, boolean isWeapon) {
        if (isWeapon) {
            this.equipment.put(Slot.Weapon, item);
        }
        if (!isWeapon) {
            this.equipment.put(Slot.Body, item);
        }
    }


    //Todo: Function calc Dps: root.Base.Weapon-Dps * (1+TotalMainPrimAttr/100)
    //Todo: Function calc totalprimattr: bpa + sum(equip)
    //todo: function increaseLevel , done
    //Todo: constructor: level=1 ; name , done
    //todo: tostring: name, level, s,d,I,Dps, stat
    //todo: if no weapon: weapon-dps = 1


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
                "damage=" + damage +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", totoalPrimaryAttribute=" + totoalPrimaryAttribute +
                ", dps=" + characterDps +
                '}';
    }
}
