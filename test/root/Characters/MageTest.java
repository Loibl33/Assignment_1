package root.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {
    Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage("Anna");
    }

    @Test
    void Mage_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = mage.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    @Test
    void Mage_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class root.Characters.Mage, damage=1, name='Anna', level=1, Strength=1, Dexterity=1, Intelligence=8, dps=1}";
        String isStats = mage.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

    @Test
    void increaseLevel_MageExists_MageLevelShouldBeIncreasedCorrectly() {
        mage = new Mage("Anna");
        mage.increaseLevel();
        String shouldStats = "Character{Class=class root.Characters.Mage, damage=6, name='Anna', level=2, Strength=2, Dexterity=2, Intelligence=13, dps=1}";
        String isStats = mage.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }
}
