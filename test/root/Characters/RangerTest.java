// Code by Philipp Loibl, 2022
// RangerTest.java
//
// This class tests the correct behaviour of rangers


package root.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangerTest {
    Ranger ranger;

    //Creates a new ranger before each test
    @BeforeEach
    void setUp() {
        ranger = new Ranger("John");
    }

    //Tests if the level of the ranger is one after creation
    @Test
    void Ranger_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = ranger.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    //Tests if all ranger properties are set up correctly during creation
    @Test
    void Ranger_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class root.Characters.Ranger, damage=1, name='John', level=1, Strength=1, Dexterity=7, Intelligence=1, dps=1}";
        String isStats = ranger.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

    //Tests if the properties get updated like specified during increaseLevel()
    @Test
    void increaseLevel_RangerExists_RangerLevelShouldBeIncreasedCorrectly() {
        ranger.increaseLevel();
        String shouldStats = "Character{Class=class root.Characters.Ranger, damage=6, name='John', level=2, Strength=2, Dexterity=12, Intelligence=2, dps=1}";
        String isStats = ranger.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }
}
