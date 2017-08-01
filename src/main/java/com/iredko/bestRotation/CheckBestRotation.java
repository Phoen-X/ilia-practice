package com.iredko.bestRotation;


import java.util.ArrayList;

/**
 * Created by ItsEasy on 01.08.2017.
 */
public class CheckBestRotation {
    //Результирующая ротация
    private String bestRotation = ""; // TODO почему она (ротация) в поле?

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
    //TODO void метод печатающий в консоль это клево. Но желательно чтобы результатом была статистика какой скилл сколько раз скастили (см. тест)
    //TODO переход к тесту на класс - CTRL+SHIFT+T
    public void checkBestRotation(Character character, int time) { //TODO time должен прийти в каких единицах? Как я должен это понять?
        //Переменная  имитируящая текущее время
        int timeImitation = 0; //TODO ты сам в комменте пишешь что это текущее время. Назови ее "текущее время" :) "в секундах" естественно, или в чем ты там считаешь
        GlobalCooldown gcd = new GlobalCooldown();
        ArrayList<Spell> spells = character.getAbilities();

        //Если текущее время меньше чем время расчета ротации продолжаем расчет
        //TODO страшного ничего конечно, но цикл int timeImitation = 0; while( timeImitation < time); ....; timeImitation++;
        //TODO напоминает обычный фор ->   for(int timeImitation = 0; timeImitation < time; timeImitation++) {...}
        while (timeImitation < time) {
            for (Spell spell : spells) {
                //Если Заклинание доступно и глобал кулдаут разрещает скатить спел, записуем заклинание в ротацию,
                //включаем глобал запрет, запрет каста текущего заклинани, и фиксируем на промежуток времени на который заклинание недоступно
                if (gcd.isGcd() && spell.isCanUse()) {
                    bestRotation = bestRotation + spell.getName() + " "; // TODO конкатенация строк в цикле
                    gcd.setGcd(false); //TODO а что если убрать сеттер и вместо него сделать методы void blockCasting() / void unblockCasting() + boolean castingBlocked()? не будет ли тогда понятнее что происходит
                    spell.setCanUse(false);
                    spell.setCanUseTime(timeImitation + spell.getCooldown());
                }
            }
            //Проверяем все заблокированые умения на откат относительно текущего времени
            for (Spell spell : spells) {
                if (!spell.isCanUse()) {
                    if (spell.getCanUseTime() < timeImitation) {
                        spell.setCanUse(true);
                    }
                }
            }
            //Добавляем одну секунду к текущему времени
            timeImitation++;
            //тк гкд=1сек делаем его доступным после добавления секунды к таймеру(имеет смысл писать гдето в сlass GlobalCooldown и дергать от
            //туда, нно тк расматриваемая ситуация простая оставим так.
            gcd.setGcd(true);   //TODO gcd.unblockCasting
        }
        System.out.println(bestRotation);
    }
}
