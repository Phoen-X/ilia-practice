package com.iredko.bestRotation;

/**
 * Created by ItsEasy on 01.08.2017.
 *
 */
public class GlobalCooldown {
    //Указывает на запрет со стороны глобал кд true - запрет отсутстувует
    private boolean gcd = true;

    public void setGcd(boolean gcd) {
        this.gcd = gcd;
    }

    public boolean isGcd() {
        return gcd;
    }
}
