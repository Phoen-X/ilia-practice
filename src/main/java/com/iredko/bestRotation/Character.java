package com.iredko.bestRotation;

import com.vygulyarniy.CheckingChangeFile;
import sun.swing.SwingUtilities2;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class Character {
    //Список доступных заклинаний персонажа
    private ArrayList<Spell> abilities; //TODO молодец.

    public Character(ArrayList<Spell> spells) {
        abilities = spells;
    }

    public ArrayList<Spell> getAbilities() {
        return abilities;
    }

    public void go(Object o){}

}
