package com.iredko.bestRotation;

import java.util.ArrayList;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class Character {

    private Spell[] abilities;

    public Character() {
    }

    public Character(Spell[] spells) {
        abilities = spells;
    }

    public Spell[] getAbilities() {
        return abilities;
    }
}
