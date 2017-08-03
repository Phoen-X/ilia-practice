package com.iredko.bestRotation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class CheckBestRotation {
    //Результирующая ротация
    private String bestRotation = ""; // TODO почему она (ротация) в поле?

    public static void main(String[] args) {
        //Создаем  заклинания,ложим их в лист в порядке уменьшения кд заклинания, создаем персонажа с именем и перечнем заклинаний
        Spell pyroblast = new Spell("Pyroblast", 5);
        Spell fireball = new Spell("Fireball", 3);
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(pyroblast);
        spells.add(fireball);
        Character mage = new Character(spells);
        CheckBestRotation checkBestRotation = new CheckBestRotation();
        Map<Spell,Integer> m = checkBestRotation.checkBestRotation(mage, 4);
        System.out.println( m.get(fireball));
    }

    //Метод в котором происходит просчет ротации
    public Map<Spell,Integer> checkBestRotation(Character character, int time) { //TODO time должен прийти в каких единицах? Как я должен это понять?
        //Переменная  имитируящая текущее время
        int currentTime = 0;
        GlobalCooldown gcd = new GlobalCooldown();
        ArrayList<Spell> spells = character.getAbilities();
        Map<Spell,Integer> resultMap = new HashMap<>();

        for(currentTime=0;currentTime<=time;currentTime++){
            for(Spell spell:spells){
                if(!resultMap.containsKey(spell)) {
                    resultMap.put(spell,0);
                }
                if(spell.getCanUseTime()<=currentTime){
                    bestRotation = bestRotation + spell.getName() + " "; // TODO конкатенация строк в цикле
                    resultMap.put(spell,resultMap.getOrDefault(spell,0)+1);
                    spell.setCanUseTime(currentTime+spell.getCooldown());
                    gcd.setCanUseTime(currentTime+GlobalCooldown.getCooldownTime());
                }
            }
        }
        System.out.println(bestRotation);
        return resultMap;
    }
}
