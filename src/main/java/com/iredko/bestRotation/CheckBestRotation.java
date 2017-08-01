package com.iredko.bestRotation;


import java.util.ArrayList;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class CheckBestRotation {
    //Результирующая ротация
    private String bestRotation = "";

    public static void main(String[] args) {
        //Создаем  заклинания,ложим их в лист в порядке уменьшения кд заклинания, создаем персонажа с именем и перечнем заклинаний
        Spell pyroblast = new Spell("Pyroblast", 6);
        Spell fireball = new Spell("Fireball", 3);
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(pyroblast);
        spells.add(fireball);
        Character mage = new Character(spells);
        CheckBestRotation checkBestRotation = new CheckBestRotation();
        checkBestRotation.checkBestRotation(mage, 60);
    }

    //Метод в котором происходит просчет ротации
    public void checkBestRotation(Character character, int time) {
        //Переменная  имитируящая текущее время
        int timeImitation = 0;
        GlobalCooldown gcd = new GlobalCooldown();
        ArrayList<Spell> spells = character.getAbilities();
        //Если текущее время меньше чем время расчета ротации продолжаем расчет
        while (timeImitation < time) {
            for (Spell spell : spells) {
                //Если Заклинание доступно и глобал кулдаут разрещает скатить спел, записуем заклинание в ротацию,
                //включаем глобал запрет, запрет каста текущего заклинани, и фиксируем на промежуток времени на который заклинание недоступно
                if (gcd.isGcd() && spell.isCanUse()) {
                    bestRotation = bestRotation + spell.getName()+" ";
                    gcd.setGcd(false);
                    spell.setCanUse(false);
                    spell.setCanUseTime(timeImitation+spell.getCooldown());
                }
            }
            //Проверяем все заблокированые умения на откат относительно текущего времени
            for(Spell spell: spells){
                if(!spell.isCanUse()) {
                    if (spell.getCanUseTime() < timeImitation) {
                        spell.setCanUse(true);
                    }
                }
            }
            //Добавляем одну секунду к текущему времени
            timeImitation++;
            //тк гкд=1сек делаем его доступным после добавления секунды к таймеру(имеет смысл писать гдето в сlass GlobalCooldown и дергать от
            //туда, нно тк расматриваемая ситуация простая оставим так.
            gcd.setGcd(true);
        }
        System.out.println(bestRotation);
    }
}
