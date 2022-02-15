package root.Base;

import lombok.Data;

@Data
public class Weapon extends Item {

    int attackSpeed;
    private int damage;
    private int dps;


    public Weapon(String name, int requiredLevel, int damage, int attackSpeed) {
        super();
        this.damage = damage;

        this.attackSpeed = attackSpeed;
        this.dps = this.damage * this.attackSpeed;
    }

//    public Weapon() {
//
//    }


}
