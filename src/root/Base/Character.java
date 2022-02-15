package root.Base;

//todo calculate DPS function
//todo write test
//todo gitlab
//todo commit
//todo submit link


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
    int dps;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.equipment = new Equipment();
    }

//    public abstract int increaseDamage();

    public abstract int increaseLevel();

    public void equip(Item item) throws WeaponNotSuitableForCharacterException, LevelTooLowForArmorException, IllegalAccessException, InstantiationException {

        ArrayList<Class> exceptions = new ArrayList<>();
        boolean isWeapon = true;
        Class c = Weapon.class;
        boolean levelOK = (this.level >= item.getRequiredLevel());
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
                    exceptions.add(LevelTooLowForWeaponException.class);
                }
                if (!itemOK) {
                    exceptions.add(WeaponNotSuitableForCharacterException.class);
                }
            }

            if (!isWeapon) {
                if (!levelOK) {
                    exceptions.add(LevelTooLowForArmorException.class);
                }
                if (!itemOK) {
                    exceptions.add(ArmorNotSuitableForCharacterException.class);
                }
            }

            try {
                for (Class e : exceptions) {
                    e.newInstance();
                }
            } finally {
                exceptions.clear();
            }
            exceptions.clear();
        }


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
                ", dps=" + dps +
                '}';
    }

    public String stats() {
        return "Character{" +
                "damage=" + damage +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", totoalPrimaryAttribute=" + totoalPrimaryAttribute +
                ", dps=" + dps +
                '}';
    }
}
