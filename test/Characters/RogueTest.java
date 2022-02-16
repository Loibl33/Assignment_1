package Characters;// Code by Philipp Loibl, 2022
// Characters.RogueTest.java
//
// This class tests the correct behaviour of rogues


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RogueTest {
    Rogue rogue;

    //Creates a new rogue before each test
    @BeforeEach
    void setUp() {
        rogue = new Rogue("Rogue1");
    }

    //Tests if the level of the rogue is one after creation
    @Test
    void Rogue_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = rogue.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    //Tests if all rogue properties are set up correctly during creation
    @Test
    void Rogue_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class Characters.Rogue, damage=1, name='Rogue1', level=1, Strength=2, Dexterity=6, Intelligence=1, dps=1}";
        String isStats = rogue.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

    //Tests if the properties get updated like specified during increaseLevel()
    @Test
    void increaseLevel_RogueExists_RogueLevelShouldBeIncreasedCorrectly() {
        rogue.increaseLevel();
        String shouldStats = "Character{Class=class Characters.Rogue, damage=5, name='Rogue1', level=2, Strength=3, Dexterity=10, Intelligence=2, dps=1}";
        String isStats = rogue.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }
}
