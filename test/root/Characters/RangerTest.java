package root.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangerTest {
    Ranger ranger;

    @BeforeEach
    void setUp() {
        ranger = new Ranger("John");
    }

    @Test
    void Ranger_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = ranger.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    @Test
    void Ranger_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class root.Characters.Ranger, damage=1, name='John', level=1, Strength=1, Dexterity=7, Intelligence=1, dps=1}";
        String isStats = ranger.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

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
