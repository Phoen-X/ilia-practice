package com.iredko.bestRotation;


/**
 * Created by ItsEasy on 01.08.2017.
 */
public class CheckBestRotation {

    private String bestRotation = "";

    public CheckBestRotation() {
    }

    public void checkBestRotation(Character character, int time) {
        int timeImitation = 0;
        GlobalCooldown gcd = new GlobalCooldown();
        Spell[] spells = character.getAbilities();
        while (timeImitation < time) {

            for (Spell spell : spells) {
                if (gcd.isGcd() && spell.isCanUse()) {
                    bestRotation = bestRotation + spell.getName()+" ";
                    gcd.setGcd(false);
                    spell.setCanUse(false);
                    spell.setCanUseTime(timeImitation+spell.getCooldown());
                }
            }


            for(Spell spell: spells){
                if(spell.getCanUseTime()<timeImitation){
                    spell.setCanUse(true);
                }
            }

            timeImitation++;
            gcd.setGcd(true);
        }
        System.out.println(bestRotation);
    }

    public static void main(String[] args) {
        Spell pyroblast = new Spell("Pyroblast", 6);
        Spell fireball = new Spell("Fireball", 3);
        Spell[] spells = {pyroblast, fireball};
        Character mage = new Character(spells);
        CheckBestRotation checkBestRotation = new CheckBestRotation();
        checkBestRotation.checkBestRotation(mage, 60);
    }
}
