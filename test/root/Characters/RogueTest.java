package root.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RogueTest {
    Rogue rogue;

    @BeforeEach
    void setUp() {
        rogue = new Rogue("Rogue1");
    }

    @Test
    void Rogue_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = rogue.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    @Test
    void Rogue_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class root.Characters.Rogue, damage=1, name='Rogue1', level=1, Strength=2, Dexterity=6, Intelligence=1, dps=1}";
        String isStats = rogue.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

    @Test
    void increaseLevel_RogueExists_RogueLevelShouldBeIncreasedCorrectly() {
        rogue.increaseLevel();
        String shouldStats = "Character{Class=class root.Characters.Rogue, damage=5, name='Rogue1', level=2, Strength=3, Dexterity=10, Intelligence=2, dps=1}";
        String isStats = rogue.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }
}
