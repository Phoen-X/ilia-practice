package com.iredko.bestRotation;

import java.util.ArrayList;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class Character {
    //Список доступных заклинаний персонажа
    private ArrayList<Spell> abilities; //TODO молодец.

    //TODO этот конструктор не нужен. Ты не хочешь создавать игрока без скилов. И даже если хочешь - передашь пустой список скилов
    public Character() {
    }

    public Character(ArrayList<Spell> spells) {
        abilities = spells;
    }

    public ArrayList<Spell> getAbilities() {
        return abilities;
    }
}
