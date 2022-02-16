package root.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {
    Warrior warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Warrior1");
    }

    @Test
    void Warrior_NoConditions_LevelShouldBeOneAfterConstruction() {
        int shouldLevel = 1;
        int isLevel = warrior.getLevel();
        Assertions.assertEquals(shouldLevel, isLevel);
    }

    @Test
    void Warrior_NoConditions_PropertiesShouldBeSetCorrectly() {
        String shouldStats = "Character{Class=class root.Characters.Warrior, damage=1, name='Warrior1', level=1, Strength=5, Dexterity=2, Intelligence=1, dps=1}";
        String isStats = warrior.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }

    @Test
    void increaseLevel_WarriorExists_WarriorLevelShouldBeIncreasedCorrectly() {
        warrior.increaseLevel();
        String shouldStats = "Character{Class=class root.Characters.Warrior, damage=4, name='Warrior1', level=2, Strength=8, Dexterity=4, Intelligence=2, dps=1}";
        String isStats = warrior.stats();
        Assertions.assertAll(
                () -> assertEquals(shouldStats, isStats)
        );
    }
}
