package com.iredko.bestRotation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckBestRotationTest {
    private Spell fireball;
    private Spell pyroblast;

    @BeforeMethod
    public void setUp() throws Exception {
        pyroblast = new Spell("Pyroblast", 5);
        fireball = new Spell("Fireball", 3);
    }

    @Test
    public void generatesStatisticsOfSpellsUsage() throws Exception {
        CheckBestRotation rotationSimulator = new CheckBestRotation();
        Character player = new Character(new ArrayList<>(asList(fireball, pyroblast)));

        Map<Spell, Integer> statisticsFor10Seconds = rotationSimulator.checkBestRotation(player, 5);

        assertThat(statisticsFor10Seconds.get(fireball)).isEqualTo(2);
        assertThat(statisticsFor10Seconds.get(pyroblast)).isEqualTo(2);
    }

    @Test
    public void multipleCastsAreByGivenTimeAreRegistered() throws Exception {
        CheckBestRotation rotationSimulator = new CheckBestRotation();
        Character player = new Character(new ArrayList<>(asList(fireball, pyroblast)));

        Map<Spell, Integer> statisticsFor7Seconds = rotationSimulator.checkBestRotation(player, 4);

        assertThat(statisticsFor7Seconds.get(fireball)).isEqualTo(2); // касты в 1 и 4 секунду
        assertThat(statisticsFor7Seconds.get(pyroblast)).isEqualTo(1); // каст в 0 секунду. В 5 секунду
    }

    @Test
    public void gcdBlocksCastFor1Second() throws Exception {
        Spell testSpell = new Spell("1 sec cooldown spell", 1);
        Character player = new Character(new ArrayList<>(asList(testSpell)));

        Map<Spell, Integer> statistics = new CheckBestRotation().checkBestRotation(player, 2);

        assertThat(statistics.get(testSpell)).isEqualTo(3); // мы кастуем на 0 секунде и на 2й. 1я и 3я - гкд
    }
}