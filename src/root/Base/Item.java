// Code by Philipp Loibl, 2022
// Item.java
//
// This is the base class for weapon and armor classes


package root.Base;

import lombok.Data;

@Data
public abstract class Item {
    private String name;
    private int requiredLevel = 0;

    public Item(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
    }
}
