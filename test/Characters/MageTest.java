package Characters;// Code by Philipp Loibl, 2022
// Characters.MageTest.java
//
// This class tests the correct behaviour of mages


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {
    Mage mage;

    //Creates a new mage before each test
    @BeforeEach
    void setUp() {
        mage = new Mage("Anna");
    }

    //Tests if the level of the mage is one after creation
    @Test
    void Mage_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = mage.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    //Tests if all mage properties are set up correctly during creation
    @Test
    void Mage_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class Characters.Mage, damage=1, name='Anna', level=1, Strength=1, Dexterity=1, Intelligence=8, dps=1}";
        String isStats = mage.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

    //Tests if the properties get updated like specified during increaseLevel()
    @Test
    void increaseLevel_MageExists_MageLevelShouldBeIncreasedCorrectly() {
        mage = new Mage("Anna");
        mage.increaseLevel();
        String shouldStats = "Character{Class=class Characters.Mage, damage=6, name='Anna', level=2, Strength=2, Dexterity=2, Intelligence=13, dps=1}";
        String isStats = mage.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }
}
