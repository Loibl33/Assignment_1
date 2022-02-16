// Code by Philipp Loibl, 2022
// Item.java
//
// This is the base class for weapon and armor classes


package Base;

import lombok.Data;

@Data
public abstract class Item {
    private String name;
    private int requiredLevel;

    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
    }
}
